package com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall;

/**
 * @auther mynawang
 * @create 2016-11-29 10:35
 */
public class NotifyAllThread extends Thread {

    private Object lockObj;

    public NotifyAllThread(Object lockObj) {
        super();
        this.lockObj = lockObj;
    }

    @Override
    public void run() {
        synchronized (lockObj) {
            lockObj.notifyAll();
        }
    }
}
