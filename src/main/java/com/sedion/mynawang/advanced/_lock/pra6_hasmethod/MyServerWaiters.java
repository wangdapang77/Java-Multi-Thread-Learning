package com.sedion.mynawang.advanced._lock.pra6_hasmethod;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2017-01-06 11:03
 */
public class MyServerWaiters {

    private ReentrantLock lock = new ReentrantLock();
    private Condition newCondition = lock.newCondition();
    public void waitMethod() {
        try {
            lock.lock();
            newCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            lock.lock();
            System.out.println(
                    "有没有线程正在等待newCondition? " + lock.hasWaiters(newCondition) +
                    " 线程数是多少? " + lock.getWaitQueueLength(newCondition));
            newCondition.signal();
        } finally {
            lock.unlock();
        }
    }


    /**
     * hasWaiters(Condition condition)的作用是查询是否有线程condtion条件下正在等待锁
     */

}
