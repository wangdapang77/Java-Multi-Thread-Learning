package com.sedion.mynawang.advanced._threadlocal.pra4_inheritablethreadlocal;

/**
 * @auther mynawang
 * @create 2016-12-14 21:31
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadA线程中取值=" + Tools.inheritableThreadLocalExpland.get());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
