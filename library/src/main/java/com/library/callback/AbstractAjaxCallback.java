package com.library.callback;

import android.app.Activity;

import com.library.constants.FLConstants;

import org.apache.http.client.methods.HttpUriRequest;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * ajax �ص�������������
 * The core class of ajax callback handler.
 * <p/>
 * Created by chen_fulei on 2015/7/28.
 */
public abstract class AbstractAjaxCallback<T, K> implements Runnable {

    private static int NET_TIMEOUT = 30000; //Ĭ����������ʱʱ��(����)
    private static String AGENT = null; // Ĭ�������������
    private static int NETWORK_POOL = 6;// �̳߳�������߳���
    private static boolean GZIP = true; // Ĭ�����ݴ��
    private static boolean REUSE_CLIENT = true;
    private static boolean SIMULATE_ERROR = false; //ģ���������
    /**
     * ���þ�̬��ת������ ���ת��������״̬�ģ����������״̬����Ҫʹ��AjaxCallback.transformer�� AjaxUtility.transformer
     * ת����״̬ѡ��1. Native 2. instance transformer() 3. static setTransformer()
     */
    private static Transformer st;
    protected AccountHandle ah;
    private Class<T> type; //���ص�class
    private Reference<Object> whandler; //��java��ָ����ָ��
    private Object handler; //����
    private String callback; // �������ķ���
    private WeakReference<Object> progress; // ����Object��������
    private Transformer transformer;
    private WeakReference<Activity> act;
    private int method = FLConstants.METHOD_DETECT;
    private HttpUriRequest request;

    /**
     * ������������ʱʱ��
     *
     * @param timeout
     */
    public static void setTimeout(int timeout) {
        NET_TIMEOUT = timeout;
    }

    /**
     * �����������
     *
     * @param agent
     */
    public static void setAgent(String agent) {
        AGENT = agent;
    }

    /**
     * ����ѹ�����
     *
     * @param gZip
     */
    public static void setGZip(boolean gZip) {
        GZIP = gZip;
    }

    /**
     * ����ģ���������
     *
     * @param error
     */
    public static void setSimulateError(boolean error) {
        SIMULATE_ERROR = error;
    }

    /**
     * ����ת����
     *
     * @param transformer Ĭ��ת������ԭʼ����ת����ָ��������
     */
    public static void setTransformer(Transformer transformer) {
        st = transformer;
    }

    /**
     * ��ȡ�������
     *
     * @return
     */
    private K self() {

        return (K) this;
    }

    /**
     * ���
     */
    private void clear() {
        whandler = null;
        handler = null;
        progress = null;
        request = null;
        transformer = null;
        ah = null;
        act = null;
    }

    /**
     * ��ȡ���ص�class ����
     * Gets the ajax response type.
     *
     * @return
     */
    public Class<T> getType() {
        return type;
    }

    /**
     * ������������һ���ص��������ʹ�����������,����㲻ϣ��ajax�ص�����������������ռ���
     *
     * @param handler
     * @param callback
     * @return
     */
    public K weakHandler(Object handler, String callback) {
        this.whandler = new WeakReference<Object>(handler);
        this.callback = callback;
        this.handler = null;
        return self();
    }



    /**
     * �߳�ִ�У��ڲ�ʹ�ã�
     */
    @Override
    public void run() {

    }
}
