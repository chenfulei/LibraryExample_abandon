package com.library.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * �Զ���һЩ��ʾ
 * Created by chen_fulei on 2015/7/27.
 */
public class FLHintUtil {

    /**
     * ��ʾ
     *
     * @param mContext
     * @param message  ��ʾ����
     */
    public static void toast(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

}
