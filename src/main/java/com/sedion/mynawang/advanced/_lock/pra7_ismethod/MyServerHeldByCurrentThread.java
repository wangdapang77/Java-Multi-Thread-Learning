package com.sedion.mynawang.advanced._lock.pra7_ismethod;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2017-01-06 14:58
 */
public class MyServerHeldByCurrentThread {

    private ReentrantLock lock;

    public MyServerHeldByCurrentThread(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void testMethod() {
        try {
            System.out.println("lock之前判断HeldByCurrentThread： " + lock.isHeldByCurrentThread());
            lock.lock();
            System.out.println("lock之后判断HeldByCurrentThread： " + lock.isHeldByCurrentThread());
        } finally {
            lock.unlock();
            System.out.println("lock解锁判断HeldByCurrentThread： " + lock.isHeldByCurrentThread());
        }

    }

    /**
     * isHeldByCurrentThread()作用是判断当前线程是否任然持有锁
     */
}
