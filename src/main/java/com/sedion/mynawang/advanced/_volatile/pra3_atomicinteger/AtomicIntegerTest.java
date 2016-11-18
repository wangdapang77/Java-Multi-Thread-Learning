package com.sedion.mynawang.advanced._volatile.pra3_atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用原子类进行i++，保证线程安全
 * @auther mynawang
 * @create 2016-11-18 11:05
 */
public class AtomicIntegerTest extends Thread{
   private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }
}

