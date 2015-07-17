package com.library.ui;

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


}
