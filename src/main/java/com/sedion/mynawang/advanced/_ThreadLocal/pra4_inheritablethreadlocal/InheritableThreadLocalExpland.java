package com.sedion.mynawang.advanced._threadlocal.pra4_inheritablethreadlocal;

import java.util.Date;

/**
 * InheritableThreadLocal可以让子线程从父线程中取值
 * @auther mynawang
 * @create 2016-12-14 21:27
 */
public class InheritableThreadLocalExpland extends InheritableThreadLocal {

    protected Object initialValue() {
        return new Date().getTime();
    }

    protected Object childValue(Object parentValue) {
        return parentValue + "子线程加值";
    }
}
