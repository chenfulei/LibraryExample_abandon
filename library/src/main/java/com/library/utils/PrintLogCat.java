package com.library.utils;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��ӡlogCat��ǰӦ��������Ϣ�������ڵ�ǰӦ�û����logcat.txt�ļ���
 * <p/>
 * Created by chen_fulei on 2015/7/17.
 */
public class PrintLogCat {
    private static volatile PrintLogCat printLogCat = null;

    private static String PATH_LOGCAT; // �����·��
    private int mPid;//��ǰӦ�����н���id
    private String file_path;
    private LogDumper mLogDumper = null;

    /**
     * ���췽��
     */
    public PrintLogCat(Context mContext) {
        init(mContext);

        mPid = android.os.Process.myPid();
    }

    public static PrintLogCat getInstance(Context mContext) {
        if (printLogCat == null) {
            synchronized (PrintLogCat.class) {
                if (printLogCat == null) {
                    printLogCat = new PrintLogCat(mContext);
                }
            }
        }

        return printLogCat;
    }

    /**
     * �ļ���С
     *
     * @param fileSize
     * @return
     */
    private static double getSize(long fileSize) {
        return fileSize / (1024 * 1024);

    }

    public static String getFileName() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String data = format.format(new Date(System.currentTimeMillis()));
        return data;
    }

    /**
     * ��õ�ǰʱ��
     *
     * @return
     */
    public static String getDateEN() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = format.format(new Date(System.currentTimeMillis()));
        return data;
    }

    /**
     * ��ʼ��
     */
    private void init(Context mContext) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {// ���ȱ��浽SD����

            PATH_LOGCAT = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "LogCat";
        } else {// ���SD�������ڣ��ͱ��浽��Ӧ�õ�Ŀ¼��

            PATH_LOGCAT = mContext.getFilesDir().getAbsolutePath() + File.separator + "LogCat";
        }

        File file = new File(PATH_LOGCAT);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * ����ִ��logcat��ӡ����
     */
    public void start() {
        if (mLogDumper == null) {
            mLogDumper = new LogDumper(String.valueOf(mPid), PATH_LOGCAT);
        }

        mLogDumper.start();
    }

    /**
     * ������ӡlogcat
     */
    public void stop() {
        if (mLogDumper != null) {
            mLogDumper.stopLogs();
            mLogDumper = null;
        }
    }

    public String getFilepath() {
        return file_path;
    }

    /**
     * �첽ִ�д�ӡ
     */
    private class LogDumper extends Thread {
        String cmds = null;
        private Process logcatProc;
        private BufferedReader mReader = null;
        private boolean mRunning = true;
        private String mPID;
        private FileOutputStream out = null;
        private File file;

        public LogDumper(String pid, String dir) {
            this.mPID = pid;

            try {
                file = new File(dir, "logCat" + ".txt");
                out = new FileOutputStream(file);

                file_path = dir + "/logCat" + ".txt";
            } catch (Exception e) {
                Debug.Log(e);
            }

            cmds = "logcat *:e *:i | grep \"(" + mPID + ")\"";
        }

        /**
         * ������ӡlogcat
         */
        public void stopLogs() {
            mRunning = false;
        }

        @Override
        public void run() {
            try {
                logcatProc = Runtime.getRuntime().exec(cmds);

                mReader = new BufferedReader(new InputStreamReader(
                        logcatProc.getInputStream()), 1024);
                String line = null;
                while (mRunning && (line = mReader.readLine()) != null) {
                    if (!mRunning) {
                        break;
                    }
                    if (line.length() == 0) {
                        continue;
                    }

                    //����4mʱ���±���
                    if (getSize(file.length()) > 4) {
                        file.delete();
                        file.createNewFile();
                        out.close();
                        out = new FileOutputStream(file);
                    }
                    if (out != null && line.contains(mPID)) {
                        out.write((getDateEN() + "  " + line + "\n").getBytes());
                    }
                }

            } catch (Exception e) {
                Debug.Log(e);
            } finally {
                if (logcatProc != null) {
                    logcatProc.destroy();
                    logcatProc = null;
                }
                if (mReader != null) {
                    try {
                        mReader.close();
                        mReader = null;
                    } catch (IOException e) {
                        Debug.Log(e);
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        Debug.Log(e);
                    }
                    out = null;
                }
            }
        }
    }

}
