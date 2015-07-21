package com.library.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.library.utils.FLSystemUtils;

/**
 * Fragment ��v4��
 * Created by chen_fulei on 2015/7/20.
 */
public abstract class FLFrameFragment extends Fragment implements View.OnClickListener, FLBroadcast, FLSkipActivity {

    public static long lastClickTime = 0; // ��¼�ؼ������ʱ��
    public static long space = 500; // �ؼ����֮����ʱ�� 300����
    private View view;

    //��ʼ��View
    protected abstract View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflaterView(inflater, container, savedInstanceState);
        FLAnnotate.init(this);

        //��ʼ������
        initData();
        //��ʼ���ؼ�
        initWidget(view);

        //ע��㲥
        registerBroadcast();

        return view;
    }

    @Override
    public View getView() {
        return view;
    }

    /**
     * ��ʼ������
     */
    protected void initData() {
    }

    /**
     * ��ʼ�����棬��Ƕ�����ⲿHCActivityʱ����ʼ���ⲿ�Ŀؼ�����ʹ��@HCBindView���а󶨿ؼ�
     *
     * @param parentView
     */
    protected void initWidget(View parentView) {
    }

    /**
     * �ؼ����
     *
     * @param v
     */
    protected void widgetClick(View v) {
    }

    /**
     * ����View���ʵ�ֵط�
     */
    @Override
    public void onClick(View v) {
        if (FLSystemUtils.isFastDoubleClick(lastClickTime, space)) {
            lastClickTime = System.currentTimeMillis();
            widgetClick(v);
        }
    }

    @Override
    public void registerBroadcast() {
    }

    @Override
    public void unRegisterBroadcast() {
    }

    @Override
    public void onDestroy() {
        //ע���㲥
        unRegisterBroadcast();
        super.onDestroy();
    }
}
