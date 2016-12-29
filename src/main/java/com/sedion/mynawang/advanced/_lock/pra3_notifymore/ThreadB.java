package com.sedion.mynawang.advanced._lock.pra3_notifymore;

/**
 * @auther mynawang
 * @create 2016-12-29 17:54
 */
public class ThreadB extends Thread{
    private MyServer myServer;

    public ThreadB(MyServer myServer) {
        this.myServer = myServer;
    }

    @Override
    public void run() {
        myServer.awaitB();
    }
}
