package com.sedion.mynawang.advanced._lock.pra2_withcondition;

/**
 * @auther mynawang
 * @create 2016-12-21 11:04
 */
public class ThreadC extends Thread {
    private MyServerWaitNotify myServerWaitNotify;

    public ThreadC(MyServerWaitNotify myServerWaitNotify) {
        this.myServerWaitNotify = myServerWaitNotify;
    }

    @Override
    public void run() {
        myServerWaitNotify.await();
    }
}
