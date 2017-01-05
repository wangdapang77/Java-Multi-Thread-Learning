package com.sedion.mynawang.advanced._threadlocal.pra1_discoverthreadlocal;

/**
 * @auther mynawang
 * @create 2016-12-14 10:40
 */
public class Pra1_DiscoverThreadLocal {

    public static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        if (null == threadLocal.get()) {
            System.out.println("没有放过值");
            threadLocal.set("设置了值");
        }
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());
    }


    /**
     * 变量值的共享可以使用public static变量的形式，所有的线程都使用同一个public static变量。

     * 如果想实现每一个线程都有自己的共享变量，JDK中提供类ThreadLocal可以解决这个需求
     *
     * 类ThreadLocal主要解决的就是每个线程绑定自己的值，可以将ThreadLocal类比喻成全局存放数据的盒子，
     * 盒子中可以存储每个线程的私有数据。
     *
     *
     * 上面执行的代码中，第一次调用t1对象的get()方法时返回的值是null，通过调用set()方法赋值后顺利取出值并打印到
     * 控制台上。类ThreadLocal解决的是变量在不同线程间的隔离性，也就是不同线程拥有自己的值，不同线程中的值是可以放
     * 入ThreadLocal类中进行保存的。
     */

}
