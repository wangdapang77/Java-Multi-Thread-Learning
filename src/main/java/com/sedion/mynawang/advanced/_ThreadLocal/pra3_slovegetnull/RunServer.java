package com.sedion.mynawang.advanced._threadlocal.pra3_slovegetnull;

/**
 * @auther mynawang
 * @create 2016-12-14 11:23
 */
public class RunServer {
    public static ThreadLocalExpand threadLocalExpand = new ThreadLocalExpand();

    public static void main(String[] args) {
        if (null == threadLocalExpand.get()) {
            System.out.println("没放过值");
            threadLocalExpand.set("设置值");
        }
        System.out.println(threadLocalExpand.get());
        System.out.println(threadLocalExpand.get());
    }

    /**
     * 以上案例说明main线程有自己的值
     */

}
