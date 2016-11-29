package com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall;

/**
 * @auther mynawang
 * @create 2016-11-29 10:36
 */
public class ThreadB extends Thread {

    private Object lockObj;

    public ThreadB(Object lockObj) {
        super();
        this.lockObj = lockObj;
    }

    @Override
    public void run() {
        WaitServer waitServer = new WaitServer();
        waitServer.testMethod(lockObj);
    }
}
