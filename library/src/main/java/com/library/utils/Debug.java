package com.library.utils;

import android.util.Log;

/**
 * ȫ�ֵ�debug����
 * <p/>
 * Created by chen_fulei on 2015/7/17.
 */
public class Debug {

    private static boolean DEBUG = true;

    /**
     * ����debug����
     *
     * @param enable
     */
    public static void setEnableDebug(boolean enable) {
        DEBUG = enable;
    }

    /**
     * Ĭ�ϴ�ӡlogcat  Info
     *
     * @param message logcat ��Ϣ
     */
    public static void Log(String message) {
        Log("", message);
    }

    public static void Log(String tag, String message) {
        if (DEBUG) {
            Log.i(tag, message);
        }
    }

    /**
     * ��ӡ�쳣������Ϣ
     *
     * @param e
     */
    public static void Log(Throwable e) {
        LogE(Log.getStackTraceString(e));
    }

    public static void Log(String tag, Throwable e) {
        LogE(tag, Log.getStackTraceString(e));
    }

    /**
     * ��ӡ������Ϣ Error
     *
     * @param message
     */
    public static void LogE(String message) {
        LogE("", message);
    }

    public static void LogE(String tag, String message) {
        if (DEBUG) {
            Log.e(tag, message);
        }
    }

    /**
     * ��ӡwrong logcat
     *
     * @param message
     */
    public static void LogW(String message) {
        LogW("", message);
    }

    public static void LogW(String tag, String message) {
        if (DEBUG) {
            Log.w(tag, message);
        }
    }
}
