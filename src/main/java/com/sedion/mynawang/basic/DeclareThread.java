package com.sedion.mynawang.basic;

import java.util.concurrent.Callable;

/**
 * 声明线程
 *
 * @auther mynawang
 * @create 2016-10-10 14:56
 */
public class DeclareThread {


    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("thread-" + i + getName());
            }
        }
    }


    class  MyThread2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("runnable" + i + Thread.currentThread().getName());
            }
        }
    }

    class MyThread3 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return null;
        }
    }




}
