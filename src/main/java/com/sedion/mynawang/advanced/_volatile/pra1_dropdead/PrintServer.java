package com.sedion.mynawang.advanced._volatile.pra1_dropdead;

/**
 * 死循环
 * @auther mynawang
 * @create 2016-11-16 14:56
 */
public class PrintServer {

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

    /**
     * 此处在testPra1_1中执行一直打印不停下来，是因为main线程一直在while循环中，
     * 代码为同步执行，所以后面设置isContinuePrint为false的程序都不能执行
     */

}
