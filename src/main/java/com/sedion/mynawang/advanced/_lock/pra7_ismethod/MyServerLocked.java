package com.sedion.mynawang.advanced._lock.pra7_ismethod;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2017-01-06 15:05
 */
public class MyServerLocked {

    private ReentrantLock lock;

    public MyServerLocked(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void testMethod1() {
        try {
            System.out.println(lock.isLocked());
            lock.lock();
            System.out.println(lock.isLocked());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void testMethod2() {
        System.out.println("method2判断： " + lock.isLocked());
    }

    /**
     * isLock()是判断是否有任意线程保持锁定了对象
     */

}
