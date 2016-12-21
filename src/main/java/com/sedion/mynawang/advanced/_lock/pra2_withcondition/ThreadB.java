package com.sedion.mynawang.advanced._lock.pra2_withcondition;

/**
 * @auther mynawang
 * @create 2016-12-21 11:04
 */
public class ThreadB extends Thread {
    private MyServerIsOk myServerIsOk;

    public ThreadB(MyServerIsOk myServerIsOk) {
        this.myServerIsOk = myServerIsOk;
    }

    @Override
    public void run() {
        myServerIsOk.await();
    }
}
