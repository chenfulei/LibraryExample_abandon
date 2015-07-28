package com.library.callback;

/**
 * ajax 回调处理程序核心类
 * The core class of ajax callback handler.
 * <p/>
 * Created by chen_fulei on 2015/7/28.
 */
public abstract class AbstractAjaxCallback<T, K> implements Runnable {


    /**
     * 获取自身对象
     *
     * @return
     */
    private K self() {

        return (K) this;
    }


    /**
     * 线程执行（内部使用）
     */
    @Override
    public void run() {

    }
}
