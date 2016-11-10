package com.sedion.mynawang.advanced._synchronized.pra6_lockin;

/**
 * @auther mynawang
 * @create 2016-11-10 9:57
 */
public class ThreadA extends Thread{
    @Override
    public void run() {
        SynLockIn synLockIn = new SynLockIn();
        synLockIn.service1();
    }
}
