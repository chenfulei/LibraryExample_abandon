package com.library.ui;

import java.util.Stack;

/**
 * 管理所有activity
 * <p/>
 * Created by chen_fulei on 2015/7/17.
 */
public class FLActivityManager {

    private static FLActivityManager manager = null;

    //管理activity的堆栈
    private Stack<FLBaseAct> flStack = new Stack<FLBaseAct>();

    public FLActivityManager() {

    }

    /**
     * 单例实例化
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
     * 获得当前堆栈里面activity 个数
     *
     * @return
     */
    public int getCount() {

        return flStack.size();
    }


}
