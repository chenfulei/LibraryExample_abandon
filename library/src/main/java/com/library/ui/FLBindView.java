package com.library.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ��ע�ⷽʽ�󶨿ؼ�
 * Created by chen_fulei on 2015/7/17.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FLBindView {
    int id();

    boolean click() default false;
}
