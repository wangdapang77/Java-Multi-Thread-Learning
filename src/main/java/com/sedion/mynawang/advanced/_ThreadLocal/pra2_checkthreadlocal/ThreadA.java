package com.sedion.mynawang.advanced._threadlocal.pra2_checkthreadlocal;

import java.util.Date;

/**
 * @auther mynawang
 * @create 2016-12-14 11:08
 */
public class ThreadA extends Thread{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                if (null == Tools.threadLocal.get()) {
                    Tools.threadLocal.set(new Date());
                }
                System.out.println("ThreadA: " + Tools.threadLocal.get().getTime());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
