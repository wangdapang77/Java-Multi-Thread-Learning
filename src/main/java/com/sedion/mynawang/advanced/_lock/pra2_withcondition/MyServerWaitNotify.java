package com.sedion.mynawang.advanced._lock.pra2_withcondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2016-12-21 11:02
 */
public class MyServerWaitNotify {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await() {
        try {
            lock.lock();
            System.out.println(" await时间为：" + System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void signal() {
        try {
            lock.lock();
            System.out.println(" signal时间为：" + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Object类中的wait()方法相当于Condition类中的await()方法
     * Object类中的wait(long timeout)方法相当于Condition类中的await(long time, TimeUnit unit)方法
     * Object类中的notify()方法相当于Condition类中的signal()方法
     * Object类中的notifyAll()方法相当于Condition类中的signalAll()方法
     */


}
