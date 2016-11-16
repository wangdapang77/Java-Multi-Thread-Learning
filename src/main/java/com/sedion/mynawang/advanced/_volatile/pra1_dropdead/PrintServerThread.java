package com.sedion.mynawang.advanced._volatile.pra1_dropdead;

/**
 * 解决同步死循环
 * @auther mynawang
 * @create 2016-11-16 14:56
 */
public class PrintServerThread implements Runnable{

    private boolean isContinuePrint = true;

    private boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean isContinuePrint) {
        this.isContinuePrint = isContinuePrint;
    }

    public void printMethod() {
        try {
            while (isContinuePrint == true) {
                System.out.println("run printMethod threadName = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printMethod();
    }


    /**
     * 当testPra1_2执行在-server服务器模式中的64bit的JVM上时，会出现死循环，使用volatile关键字避免这个问题
     */
}
