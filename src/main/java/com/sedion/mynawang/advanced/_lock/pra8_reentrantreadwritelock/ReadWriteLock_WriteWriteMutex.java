package com.sedion.mynawang.advanced._lock.pra8_reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther mynawang
 * @create 2017-01-11 16:23
 */
public class ReadWriteLock_WriteWriteMutex {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("获得写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * 使用写锁代码的效果同一时间只允许一个线程执行lock()方法后面的代码
     */

}
