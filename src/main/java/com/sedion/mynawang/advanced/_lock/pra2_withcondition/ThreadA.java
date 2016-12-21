package com.sedion.mynawang.advanced._lock.pra2_withcondition;

/**
 * @auther mynawang
 * @create 2016-12-21 11:04
 */
public class ThreadA extends Thread {
    private MyServerWithBug myServerWithBug;

    public ThreadA(MyServerWithBug myServerWithBug) {
        this.myServerWithBug = myServerWithBug;
    }

    @Override
    public void run() {
        myServerWithBug.await();
    }
}
