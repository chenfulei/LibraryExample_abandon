package com.library.callback;

/**
 * ajax �ص�������������
 * The core class of ajax callback handler.
 * <p/>
 * Created by chen_fulei on 2015/7/28.
 */
public abstract class AbstractAjaxCallback<T, K> implements Runnable {


    /**
     * ��ȡ�������
     *
     * @return
     */
    private K self() {

        return (K) this;
    }


    /**
     * �߳�ִ�У��ڲ�ʹ�ã�
     */
    @Override
    public void run() {

    }
}
