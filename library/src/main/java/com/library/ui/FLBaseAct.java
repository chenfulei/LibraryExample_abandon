package com.library.ui;

import android.view.View;

/**
 * �涨activity��ʼ���Ľӿ�(�����ö�ջ������activity)
 * <p/>
 * Created by chen_fulei on 2015/7/17.
 */
public interface FLBaseAct {

    /**
     * ����layout
     */
    void setRootView();

    /**
     * ��ʼ���ؼ�
     */
    void initWidget();

    /**
     * ��ʼ������
     */
    void initData();

    /**
     * ���߳��г�ʼ������ (����е�����)
     */
//    void initDataFromThread();

    /**
     * �����ؼ���� (OnClick())
     *
     * @param v
     */
    void widgetClick(View v);

}
