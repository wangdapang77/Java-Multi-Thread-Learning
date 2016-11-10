package com.sedion.mynawang.advanced._synchronized.pra6_lockin;

/**
 * 可重入锁支持在父子类继承的环境中
 * @auther mynawang
 * @create 2016-11-10 10:02
 */
public class SynLockInMain {

    private int i = 10;
    synchronized public void operateIMainMethod() {
        try {
            i--;
            System.out.println("main print i = " + i);
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
