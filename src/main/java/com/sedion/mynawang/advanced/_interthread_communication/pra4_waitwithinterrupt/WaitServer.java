package com.sedion.mynawang.advanced._interthread_communication.pra4_waitwithinterrupt;

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
            System.out.println("出现异常，因为wait状态的线程被interrupt了！");
        }
    }


    /**
     * testPra4_1中当线程wait()状态时，调用线程对象的interrupt()方法会出现InterruptedException异常。
     *
     * 总结：
     * 1、执行完同步代码块就会释放对象的锁
     * 2、在执行同步代码块的过程中，遇到异常而导致线程终止，锁也会被释放
     * 3、在执行同步代码块过程中，执行了锁所属对象的wait()方法，这个线程会释放对象锁，而此线程对象会进入线程等待池中等待被唤醒
     */


}
