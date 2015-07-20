package com.library.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * ����activity ��ת
 * <p/>
 * Created by chen_fulei on 2015/7/17.
 */
public interface FLSkipActivity {

    /**
     * activit ��ת ��finish ��ǰactivity��
     *
     * @param activity ��ǰactivity
     * @param cls      ��һ��activity
     */
    void skipActivity(Activity activity, Class<?> cls);

    /**
     * activity ��ת (finish ��ǰactivity)
     *
     * @param activity ��ǰactivity
     * @param intent   ������
     */
    void skipActivity(Activity activity, Intent intent);

    /**
     * activity ��ת (finish ��ǰactivity)
     *
     * @param activity ��ǰactivity
     * @param cls      ��һ��activity
     * @param bundle   ������
     */
    void skipActivity(Activity activity, Class<?> cls, Bundle bundle);

    /**
     * activity ��ת ��û��finish ��ǰ��
     *
     * @param activity ��ǰactivity
     * @param cls      next activity
     */
    void showActivity(Activity activity, Class<?> cls);

    /**
     * activity ��ת ��û��finish ��ǰ��
     *
     * @param activity ��ǰactivity
     * @param cls      next activity
     * @param intent   params
     */
    void showActivity(Activity activity, Intent intent);

    /**
     * activity ��ת ��û��finish ��ǰ��
     *
     * @param activity ��ǰactivity
     * @param bundle   params
     */
    void showActivity(Activity activity, Class<?> cls, Bundle bundle);

    /**
     * �Ƿ����������л�
     *
     * @param isAnim params
     */
    void setIsAnim(boolean isAnim);
}
