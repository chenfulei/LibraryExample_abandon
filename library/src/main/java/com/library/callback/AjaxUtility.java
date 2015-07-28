package com.library.callback;

import com.library.utils.Debug;

import java.io.Closeable;

/**
 * ajax ��������й�������
 * <p/>
 * Created by chen_fulei on 2015/7/28.
 */
public class AjaxUtility {

    /**
     * �ر�
     *
     * @param closeable
     */
    public static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception e) {
            Debug.Log(e);
        }
    }

}
