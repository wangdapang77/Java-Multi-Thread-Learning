package com.sedion.mynawang.advanced._threadlocal.pra3_slovegetnull;

/**
 * @auther mynawang
 * @create 2016-12-14 11:17
 */
public class ThreadLocalExpand extends ThreadLocal{

    protected Object initialValue() {
        return "默认值，第一次get的值";
    }
}
