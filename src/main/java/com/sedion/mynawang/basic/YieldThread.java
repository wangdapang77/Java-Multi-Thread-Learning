package com.sedion.mynawang.basic;

/**
 * 放弃当前线程cpu资源，让给其他任务去占用cpu执行时间
 * @auther mynawang
 * @create 2016-09-20 15:16
 */
public class YieldThread {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        try {
            Mythread mythread = new Mythread();
            mythread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   static class Mythread extends Thread {
        @Override
        public void run() {
            long beginTime = System.currentTimeMillis();
            int count = 0;
            // 注释yield本机执行总用时：16858毫秒
            // 不注释yield本机执行总用时：17611毫秒
            for (int i = 0; i < 5000000; i++) {
                //Thread.yield();
                count = count + (i + 1);
                System.out.println(i);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("总用时：" + (endTime - beginTime) + "毫秒");
        }
    }

}
