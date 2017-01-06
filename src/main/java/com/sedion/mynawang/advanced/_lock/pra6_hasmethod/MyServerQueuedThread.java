package com.sedion.mynawang.advanced._lock.pra6_hasmethod;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2017-01-06 10:48
 */
public class MyServerQueuedThread {

    public ReentrantLock lock = new ReentrantLock();
    public Condition newCondition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    /**
     * hasQueuedThread(Thread thread)的作用是查询指定线程是否正在等待获取锁
     *
     * hasQueuedThreads()的作用是是否有线程正在等待获取锁
     *
     *
     * PraLock类中的testPra6_1方法threadA获得了锁，所以没在等待获取锁，所以为false
     * 而threadB正在等待获取锁
     */
}
