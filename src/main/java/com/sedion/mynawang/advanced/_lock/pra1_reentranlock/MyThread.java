package com.sedion.mynawang.advanced._lock.pra1_reentranlock;

/**
 * @auther mynawang
 * @create 2016-12-20 16:06
 */
public class MyThread extends Thread {
    private MyServer myServer;

    public MyThread(MyServer myServer) {
        this.myServer = myServer;
    }

    @Override
    public void run() {
        myServer.testMethod();
    }
}
