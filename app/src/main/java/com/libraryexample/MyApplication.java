package com.libraryexample;

import android.app.Application;

import com.library.CrashHandler;

/**
 * Created by chen_fulei on 2015/7/27.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //ȫ���쳣����
        CrashHandler.getInstance().init(this, MainActivity.class);


    }
}
