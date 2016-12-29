package com.sedion.mynawang.advanced._lock.pra3_notifymore;

/**
 * @auther mynawang
 * @create 2016-12-29 17:49
 */
public class ThreadA extends Thread {

    private MyServer myServer;

    public ThreadA(MyServer myServer) {
        this.myServer = myServer;
    }

    @Override
    public void run() {
        myServer.awaitA();
    }
}
