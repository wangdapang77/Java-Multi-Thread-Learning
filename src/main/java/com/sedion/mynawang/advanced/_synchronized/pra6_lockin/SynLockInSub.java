package com.sedion.mynawang.advanced._synchronized.pra6_lockin;

/**
 * @auther mynawang
 * @create 2016-11-10 10:02
 */
public class SynLockInSub extends SynLockInMain{
    private int i = 10;
    synchronized public void operateISubMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i = " + i);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
