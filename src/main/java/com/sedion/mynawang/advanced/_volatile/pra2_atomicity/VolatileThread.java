package com.sedion.mynawang.advanced._volatile.pra2_atomicity;

/**
 * @auther mynawang
 * @create 2016-11-18 10:20
 */
public class VolatileThread extends Thread{
    volatile public static int count;

    private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}
