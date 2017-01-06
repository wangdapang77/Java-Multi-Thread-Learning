package com.sedion.mynawang.advanced._lock.pra5_getmethod;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2017-01-05 14:52
 */
public class MyServerQueueLength {

    public ReentrantLock reentrantLock = new ReentrantLock();

    public void testMethod1() {
        try {
            reentrantLock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "进入方法");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * getQueueLength()作用是查询正等待获取此锁定的线程估计数，也就是等待lock释放锁的线程数
     * 比如有10个线程，1个线程先执行await或者sleep方法，那么在调用getQueueLength()方法后返回9
     *
     *
     * PraLock类中testPra5_2方法，启动10个线程调用testMethod1方法，但是某个线程获取到锁后一直休眠，
     * 其余9个线程等待获取锁，所以该方法打印的线程数为9
     */


}
