package com.sedion.mynawang.basic;

/**
 * 停止线程（过期）
 * @auther mynawang
 * @create 2016-09-12 13:49
 */
public class StopThread {

    public static void main(String[] args) {
        test1();
    }

    // 使用抛出异常的方式中断线程，防止方法内部分代码在中断时会执行完
    private static void test1() {
        try {
            Mythread mythread = new Mythread();
            mythread.start();
            Thread.sleep(200);
            mythread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main InterruptedException");
            e.printStackTrace();
        }
        System.out.println("end");
    }

    static class Mythread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 500000; i++) {
                    if (this.interrupted()) {
                        System.out.println("已经是停止状态了，我要退出了");
                        // break;
                        throw new InterruptedException();
                    }
                    System.out.println("i=" + (i + 1));
                }
                // 【使用break结束for循环】此处若mythread.interrupt();执行后还是会继续执行
                // 【使用throw new InterruptedException()结束for循环】此处不会继续执行
                System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止");
            } catch (InterruptedException e) {
                System.out.println("Mythread下的run方法捕获异常");
                e.printStackTrace();
            }
        }
    }



}
