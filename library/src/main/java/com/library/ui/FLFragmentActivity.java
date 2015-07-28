package com.library.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.library.R;
import com.library.constants.FLConstants;
import com.library.utils.Debug;
import com.library.utils.FLSystemUtils;

/**
 * activity�̳� ����дactivity���
 * <p/>
 * Created by chen_fulei on 2015/7/16.
 */
public abstract class FLFragmentActivity extends FragmentActivity implements View.OnClickListener, FLBroadcast, FLBaseAct, FLSkipActivity {

    public static long lastClickTime = 0; // ��¼�ؼ������ʱ��
    public static long space = 500; // �ؼ����֮����ʱ�� 300����

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRootView(); // ��ʼ��layout

        FLAnnotate.init(this); // ��ʼ��ע���

        initData();
        initWidget();

        //ע��㲥
        registerBroadcast();
    }

    /**
     * ��ʼ������
     */
    @Override
    public void initData() {
    }

    /**
     * ��ʼ���ؼ�
     */
    @Override
    public void initWidget() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //ע���㲥
        unRegisterBroadcast();
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

    /**
     * ע��㲥
     */
    @Override
    public void registerBroadcast() {
    }

    /**
     * ע���㲥
     */
    @Override
    public void unRegisterBroadcast() {
    }

    /**
     * fragment��ʱ���л� (ÿ���л���Ҫˢ��)
     *
     * @param resView
     * @param flFragment
     */
    public void changeFragment(int resView, FLFragment flFragment) {
        try {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            if (FLConstants.isAnim) {
                transaction.setCustomAnimations(R.anim.slide_in_fade, R.anim.slide_out_fade);
            }

            transaction.replace(resView, flFragment).commitAllowingStateLoss();
        } catch (Exception e) {
            Debug.Log(e);
        }
    }

    public void AddFragment(int resView, FLFragment flFragment) {
        try {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            if (FLConstants.isAnim) {
                transaction.setCustomAnimations(R.anim.slide_in_fade, R.anim.slide_out_fade);
            }

            transaction.add(resView, flFragment).commit();
        } catch (Exception e) {
            Debug.Log(e);
        }
    }

    /**
     * fragment�໥�л�������ˢ��
     *
     * @param resView
     * @param currentFragment
     * @param nextFragment
     */
    public void changeFragment(int resView, FLFragment currentFragment, FLFragment nextFragment) {
        try {
            if (nextFragment == null && currentFragment != null) {
                changeFragment(resView, currentFragment);
                return;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (currentFragment != nextFragment) {
                //�ж��Ƿ�added
                if (!nextFragment.isAdded()) {
                    // ���ص�ǰ��fragment��add��һ����Activity��
                    if (FLConstants.isAnim) {
                        transaction.setCustomAnimations(R.anim.slide_in_fade, R.anim.slide_out_fade);
                    }

                    transaction.hide(currentFragment).add(resView, nextFragment).commit();
                } else {
                    // ���ص�ǰ��fragment����ʾ��һ��
                    transaction.hide(currentFragment).show(nextFragment).commit();
                }

                currentFragment = nextFragment;
            }
        } catch (Exception e) {
            Debug.Log(e);
        }
    }

}
