package com.sedion.mynawang.advanced._lock.pra3_notifymore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2016-12-29 17:37
 */
public class MyServer {

    private Lock lock = new ReentrantLock();

    public Condition conditionA = lock.newCondition();

    public Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA时间为：" + System.currentTimeMillis()
                    + " ThreadName=" + ThreadB.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA时间为：" + System.currentTimeMillis()
                    + " ThreadName=" + ThreadB.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB时间为：" + System.currentTimeMillis()
                    + " ThreadName=" + ThreadB.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB时间为：" + System.currentTimeMillis()
                    + " ThreadName=" + ThreadB.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signalAll_A时间为：" + System.currentTimeMillis()
                        + " ThreadName=" + ThreadB.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signalAll_B时间为：" + System.currentTimeMillis()
                    + " ThreadName=" + ThreadB.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }

    }


    /**
     * 当使用condition.signalAll()方法时会唤醒所有lock形式wait的线程，此效果与
     * _interthread_communication的pra3_notifyall的效果类似。
     *
     * 上述代码演示的是对指定线程的唤醒，signalAll_A()唤醒的是conditionA下等待的线程
     * signalAll_B()唤醒的是conditionB下等待的线程，所以当遇到需要指定线程唤醒的需求时可以考虑使用该方式进行编码
     *
     */
}
