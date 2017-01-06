package com.sedion.mynawang.advanced._lock.pra5_getmethod;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2017-01-06 10:19
 */
public class MyServerWaitQueueLength {

    private ReentrantLock lock= new ReentrantLock();
    private Condition newCondition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            newCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("释放锁了");
        }
    }

    public void nofityMethod() {
        try {
            lock.lock();
            System.out.println("signal前有" + lock.getWaitQueueLength(newCondition) + "个线程正在等待newCondition");
            newCondition.signal();
            System.out.println("signal后有" + lock.getWaitQueueLength(newCondition) + "个线程正在等待newCondition");
            newCondition.signalAll();
            System.out.println("signalAll后有" + lock.getWaitQueueLength(newCondition) + "个线程正在等待newCondition");
        } finally {
            lock.unlock();
        }
    }


    /**
     * getWaitQueueLength(Condition condition)的作用是返回等待与此锁定相关的给定条件Condition的线程估计数
     *
     * 比如10个线程，每个线程都执行了同一个conditionA对象的await方法，则调用getWaitQueueLength(Condition condition)
     * 方法时返回的值为10，当执行一次signal后，再调用getWaitQueueLength(Condition condition)方法时返回的值是9，依此类推
     */

}
