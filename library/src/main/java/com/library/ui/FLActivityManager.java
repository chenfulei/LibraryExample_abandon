package com.library.ui;

import android.app.Activity;

import java.util.Stack;

/**
 * ��������activity
 * <p/>
 * Created by chen_fulei on 2015/7/17.
 */
public class FLActivityManager {

    private static FLActivityManager manager = null;

    //����activity�Ķ�ջ
    private Stack<FLBaseAct> flStack = new Stack<FLBaseAct>();

    public FLActivityManager() {

    }

    /**
     * ����ʵ����
     *
     * @return
     */
    public static FLActivityManager getInstance() {
        if (manager == null) {
            synchronized (FLActivityManager.class) {
                if (manager == null) {
                    manager = new FLActivityManager();
                }
            }
        }

        return manager;
    }

    /**
     * ��õ�ǰ��ջ����activity ����
     *
     * @return
     */
    public int getCount() {

        return flStack.size();
    }

    /**
     * ���activity����ջ��
     */
    public void add(FLBaseAct act) {
        if (flStack == null) {
            flStack = new Stack<>();
        }

        flStack.add(act);
    }

    /**
     * ��ͣ��ջ�����activity
     *
     * @return
     */
    public Activity stop() {
        if (flStack == null) {
            throw new NullPointerException("Activity Stack is null,Activity must extend HCACtivity");
        }

        if (flStack.isEmpty()) {
            return null;
        }

        return (Activity) flStack.lastElement();
    }

    /**
     * ������ǰ��activity (�ڶ�ջ���)
     */
    public void finish() {
        FLBaseAct act = flStack.lastElement();
        finish((Activity) act);
    }

    /**
     * ָ��������activity
     *
     * @param activity
     */
    public void finish(Activity activity) {
        if (activity != null) {
            flStack.remove(activity);

            activity = null;
        }
    }

    /**
     * ָ������activity
     *
     * @param cls
     */
    public void finish(Class<?> cls) {
        for (FLBaseAct act : flStack) {
            if (act.getClass().equals(cls)) {
                finish((Activity) act);
            }
        }
    }

    /**
     * ��������activity
     */
    public void finishAll() {
        for (int i = 0; i < flStack.size(); i++) {
            if (null != flStack.get(i)) {
                ((Activity) flStack.get(i)).finish();
            }
        }

        flStack.clear();
    }

    /**
     * ��������app
     */
    public void appExit() {
        try {
            finishAll();
            Runtime.getRuntime().exit(0);
        } catch (Exception e) {
            Runtime.getRuntime().exit(-1);
        }
    }

}
