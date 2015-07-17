package com.library.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.library.constants.FLConstants;
import com.library.utils.Debug;

/**
 * 所有activity 入口
 * <p/>
 * Created by chen_fulei on 2015/7/17.
 */
public abstract class FLActivity extends FLFragmentActivity {

    public Activity activity;

    protected Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activity = this;
        FLActivityManager.getInstance().add(this);

        initHandler();
        Debug.Log(getClass().getName(), "onCreate");
        super.onCreate(savedInstanceState);
    }

    /**
     * 初始化Handler
     */
    private void initHandler() {
        mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                onHeadler(msg);
                super.handleMessage(msg);
            }
        };
    }

    /**
     * 处理消息结果
     *
     * @param msg
     */
    protected abstract void onHeadler(Message msg);

    @Override
    protected void onResume() {
        Debug.Log(getClass().getName(), "onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Debug.Log(getClass().getName(), "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Debug.Log(getClass().getName(), "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Debug.Log(getClass().getName(), "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Debug.Log(getClass().getName(), "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        mHandler = null;

        if (FLConstants.isAnim) {
            if ("left".equals(FLConstants.isAnimDirection)) {


            } else if ("right".equals(FLConstants.isAnimDirection)) {


            }
        }

    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void skipActivity(Activity activity, Class<?> cls) {

    }

    @Override
    public void skipActivity(Activity activity, Class<?> cls, Intent intent) {

    }

    @Override
    public void skipActivity(Activity activity, Class<?> cls, Bundle bundle) {

    }

    @Override
    public void showActivity(Activity activity, Class<?> cls) {

    }

    @Override
    public void showActivity(Activity activity, Class<?> cls, Intent intent) {

    }

    @Override
    public void showActivity(Activity activity, Class<?> cls, Bundle bundle) {

    }

    /**
     * 是否启用动画切换
     */
    @Override
    public void setIsAnim(boolean isAnim) {
        FLConstants.isAnim = isAnim;
    }
}
