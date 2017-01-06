package com.sedion.mynawang.advanced._lock.pra5_getmethod;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2017-01-05 14:52
 */
public class MyServerHoldCount {

    private ReentrantLock reentrantLock = new ReentrantLock();

    public void testMethod1() {
        try {
            reentrantLock.lock();
            System.out.println("testMethod1 getHoldCount=" + reentrantLock.getHoldCount());
            testMethod2();
        } finally {
            reentrantLock.unlock();
        }
    }


    public void testMethod2() {
        try {
            reentrantLock.lock();
            System.out.println("testMethod2 getHoldCount=" + reentrantLock.getHoldCount());
        } finally {
            reentrantLock.unlock();
        }
    }


    /**
     * getHoldCount()作用是查询当前线程保持此锁定的个数，就是调用lock()方法的次数
     */


}
