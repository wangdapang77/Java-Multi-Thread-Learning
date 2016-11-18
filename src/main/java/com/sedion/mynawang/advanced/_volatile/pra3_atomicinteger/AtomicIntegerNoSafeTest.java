package com.sedion.mynawang.advanced._volatile.pra3_atomicinteger;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 使用原子类进行i++，保证线程安全
 * @auther mynawang
 * @create 2016-11-18 11:05
 */
public class AtomicIntegerNoSafeTest extends Thread{
   public static AtomicLong count = new AtomicLong();

    @Override
    public void run() {
        addNum2();
    }

    public void addNum() {
        System.out.println(Thread.currentThread().getName() + "加了100之后的值是：" + count.addAndGet(100));
        count.addAndGet(1);
    }

    synchronized public void addNum2() {
        System.out.println(Thread.currentThread().getName() + "加了100之后的值是：" + count.addAndGet(100));
        count.addAndGet(1);
    }


    /**
     * addNum方法调用执行后，打印顺序出错了，应该没加1次100后加1次1，出现这个问题是因为addAndGet方法是原子的，
     * 但是方法和方法之间的调用却不是原子的，解决这个问题必须要用同步。如addNum2方法解决方案
     */
}

