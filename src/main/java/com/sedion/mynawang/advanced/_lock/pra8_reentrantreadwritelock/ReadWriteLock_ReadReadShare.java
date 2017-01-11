package com.sedion.mynawang.advanced._lock.pra8_reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther mynawang
 * @create 2017-01-11 15:59
 */
public class ReadWriteLock_ReadReadShare {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("获得读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * 读读共享
     * PraLock中的testPra8_1方法两个线程几乎同时进入lock()方法后面的代码。
     * 说明在此使用了lock.readLock()读锁可以提高程序运行效率，允许多个线程同时执行lock()方法后面的代码
     */

}
