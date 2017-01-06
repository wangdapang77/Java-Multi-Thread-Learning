package com.sedion.mynawang.advanced._lock.pra4_fairnofair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2017-01-05 14:22
 */
public class MyServer {

    private ReentrantLock lock;

    public MyServer(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }

    public void testMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "获得锁定");
        } finally {
            lock.unlock();
        }
    }


    /**
     * 当isFair为true时，打印的结果是有序的状态，也就是先运行的线程先获取锁
     * 而当isFair为false时，打印结果为无序的状态，也就是先运行的线程不一定是先获取锁
     * 具体例子在PraLock中的testPra4_1和testPra4_2
     *
     *
     * 锁Lock分为“公平锁”和“非公平锁”。
     *
     * 公平锁表示线程获取锁的顺序是按照线程枷锁的顺序来分配的，即先来先得的FIFO先进先出顺序
     *
     * 非公平锁就是一种获取锁的抢占机制，是随机获得锁的，和公平锁不一样的就是先来的不一定先得到锁，
     * 这个方式可能造成某些线程一直拿不到锁，结果就不公平了
     *
     */

}
