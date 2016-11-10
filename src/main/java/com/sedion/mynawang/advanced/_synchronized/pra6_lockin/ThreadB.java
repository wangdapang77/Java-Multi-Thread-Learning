package com.sedion.mynawang.advanced._synchronized.pra6_lockin;

/**
 * @auther mynawang
 * @create 2016-11-10 10:08
 */
public class ThreadB extends Thread{
    @Override
    public void run() {
        SynLockInSub synLockInSub = new SynLockInSub();
        synLockInSub.operateISubMethod();
    }
}
