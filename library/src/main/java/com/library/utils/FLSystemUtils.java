package com.library.utils;

/**
 * �Զ���һЩ����
 * <p/>
 * Created by chen_fulei on 2015/7/17.
 */
public class FLSystemUtils {


    /**
     * �Ƚ�����ʱ����Ƿ��ڼ��ʱ����
     *
     * @param one
     * @param two
     * @param space ���ʱ��
     * @return �ڼ��ʱ���ڷ���false ���򷵻�true
     */
    public static boolean compareTimes(long one, long two, long space) {
        return Math.abs(one - two) > space;
    }

    /**
     * ���ε��֮���ʱ��
     *
     * @param lastClickTime
     * @param space         ���ʱ��
     * @return �ڼ��ʱ���ڷ���false ���򷵻�true
     */
    public static boolean isFastDoubleClick(long lastClickTime, long space) {
        return compareTimes(System.currentTimeMillis(), lastClickTime, space);
    }

}
