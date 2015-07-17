package com.library.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.library.utils.Debug;

import java.lang.reflect.Field;

/**
 * ��ע�ⷽʽ�󶨿ؼ�
 * Created by chen_fulei on 2015/7/17.
 */
public class FLAnnotate {

    /**
     * activity ��ʼ��
     *
     * @param activity
     */
    public static void init(Activity activity) {
        init(activity, activity.getWindow().getDecorView());
    }

    /**
     * Fragment ��ʼ��
     *
     * @param fragment
     */
    public static void init(Fragment fragment) {
        init(fragment, fragment.getView());
    }

    /**
     * View ��ʼ��
     *
     * @param view
     */
    public static void init(View view) {
        Context mContext = view.getContext();

        if (mContext instanceof Activity) {
            init((Activity) mContext);
        } else {
            Debug.LogE("view must into Activity");
            throw new RuntimeException("view must into Activity");
        }
    }

    /**
     * �󶨸�activity�����пؼ�
     *
     * @param obj
     * @param v
     */
    private static void init(Object obj, View v) {
        // ͨ�������ȡ��ȫ�����ԣ�������ֶο�����һ���ࣨ��̬���ֶλ�ʵ���ֶ�
        Field[] fields = obj.getClass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                // ����BindView���͵�ע������
                FLBindView bindView = field.getAnnotation(FLBindView.class);
                if (bindView != null) {

                    int viewId = bindView.id();
                    boolean isClick = bindView.click();

                    try {
                        field.setAccessible(true);
                        if (isClick) {
                            v.findViewById(viewId).setOnClickListener((View.OnClickListener) obj);
                        }
                        // ��currentClass��field��ֵΪsourceView.findViewById(viewId)
                        field.set(obj, v.findViewById(viewId));
                    } catch (Exception e) {
                        Debug.Log(e);
                    }
                }
            }
        }
    }

}
