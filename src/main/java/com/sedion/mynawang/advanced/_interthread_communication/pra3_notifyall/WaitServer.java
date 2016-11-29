package com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall;

/**
 * @auther mynawang
 * @create 2016-11-29 10:32
 */
public class WaitServer {

    public void  testMethod(Object lockObj) {
        try {
            synchronized (lockObj) {
                System.out.println("开始等待，线程名称：" + Thread.currentThread().getName());
                lockObj.wait();
                System.out.println("等待结束，线程名称：" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 如PraCommunication中方法testPra3_1，notify()仅唤醒一个线程
     *
     * 而如testPra3_2中，NotifyMoreThread多次调用notify，唤醒了全部waiting中的线程
     *
     * 多次调用notify()方法不能保证系统中仅有的几个线程会被唤醒，唤醒所有线程需要使用notifyAll(),如testPra3_3
     *
     */


}
