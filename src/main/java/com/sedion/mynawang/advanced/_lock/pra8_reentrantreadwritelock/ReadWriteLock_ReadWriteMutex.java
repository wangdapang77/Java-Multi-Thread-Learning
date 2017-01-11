package com.sedion.mynawang.advanced._lock.pra8_reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther mynawang
 * @create 2017-01-11 16:23
 */
public class ReadWriteLock_ReadWriteMutex {

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
     * "读写"操作是互斥的，而且"写读"操作也是互斥的。只要出现"写操作"的过程，就是互斥的
     */

}
