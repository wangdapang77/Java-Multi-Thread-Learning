package com.sedion.mynawang.basic;

import com.sedion.mynawang.util.SleepUtils;

/**
 * Daemon（守护）线程
 * @auther mynawang
 * @create 2016-09-06 22:14
 * Daemon线程是一种支持型线程，因为它主要被用作程序中后台调度以及支持性工作，比如垃圾回收线程就是一个很称职的守护者
 * Daemon线程需要在启动线程之前设置，不能在启动线程之后设置
 */
public class DaemonThread {

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("Daemon Thread finally run");
            }
        }
    }


    /**
     * main线程是非守护线程，启动线程DaemonRunner之后，随着main线程执行完毕而终止，
     * 此时Java虚拟机中没有非守护线程，虚拟机需要退出。Java虚拟机中的所有Daemon线程都需要立即终止，
     * 所以DaemonRunner会立即终止。所以finally代码块没有执行
     * ****所以在构建Daemon线程的时候，不能依靠finally块中的内容来确保执行关闭或者清理资源的逻辑。****
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunnner");
        thread.setDaemon(true);
        thread.start();
    }


}
