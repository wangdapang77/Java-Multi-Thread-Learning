package com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify;

/**
 * @auther mynawang
 * @create 2016-11-24 16:59
 */
public class WaitWithSyn {

    public void useLockWait() {
        String myString = new String("test");

        try {
            System.out.println("syn上面");
            synchronized (myString) {
                System.out.println("syn第一行");
                myString.wait();
                System.out.println("wait下一行");
            }
            System.out.println("syn下一行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加同步锁synchronized后代码完整执行，但是线程一直处于等待，使用notify让线程继续执行下去（PraCommunication中testPra2_3方法）
     */

}
