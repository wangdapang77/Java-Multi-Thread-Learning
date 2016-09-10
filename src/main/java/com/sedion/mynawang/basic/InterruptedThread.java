package com.sedion.mynawang.basic;

import com.sedion.mynawang.util.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断
 * @auther mynawang
 * @create 2016-09-10 9:35
 * 中断可以理解为线程的一个标识位属性，它表示一个运行中的线程是否被其他线程进行了中断操作。
 * 中断好比其他线程对该线程打了个招呼，其他线程通过调用该线程的interrup()方法对其进行中断操作。
 */
public class InterruptedThread {

    public static void main(String[] args) throws InterruptedException {
        // 初始化间断休眠线程
        Thread sleepThread = new Thread(new SleepRunner(), "sleppThread");
        sleepThread.setDaemon(true);

        // 初始化一直运行线程
        Thread busyThread = new Thread(new BusyRunner(), "busyThread");
        busyThread.setDaemon(true);

        // 运行线程
        sleepThread.start();
        busyThread.start();

        // 休眠5秒
        TimeUnit.SECONDS.sleep(5);

        // 中断线程
        sleepThread.interrupt();
        busyThread.interrupt();

        // 判断线程中断状态，不清除中断状态
        System.out.println("SleepThread interrupted is: " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is: " + busyThread.isInterrupted());

        // 防止线程立即结束
        SleepUtils.second(2);
    }

    // 间断休眠线程
    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    // 一直运行线程
    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true){}
        }
    }








    // 关于interrupt源码
    /**
     * Interrupts this thread.
     * @revised 6.0
     * @spec JSR-51
     * 中断线程
     */
    public void interrupt() {
        /*if (this != Thread.currentThread())
            checkAccess();
        synchronized (blockerLock) {
            Interruptible b = blocker;
            if (b != null) {
                interrupt0();
                b.interrupt(this);
                return;
            }
        }
        interrupt0();*/
    }


    /**
     * Tests whether the current thread has been interrupted.  The
     * <i>interrupted status</i> of the thread is cleared by this method.  In
     * other words, if this method were to be called twice in succession, the
     * second call would return false (unless the current thread were
     * interrupted again, after the first call had cleared its interrupted
     * status and before the second call had examined it).
     * @revised 6.0
     * 判断当前线程中断状态，并且清除中断状态
     */
    public static boolean interrupted() {

        // 判断当前线程中断状态，选择清除中断状态true
        // return currentThread().isInterrupted(true);

        // 忽略此处代码
        return  false;
    }

    /**
     * Tests whether this thread has been interrupted.  The <i>interrupted
     * status</i> of the thread is unaffected by this method.
     * @revised 6.0
     * 判断线程中断状态，不清除中断状态
     */
    public boolean isInterrupted() {
        return isInterrupted(false);
    }

    /**
     * 本地方法，设置线程状态中断
     */
    private native void interrupt0();

    /**
     * Returns a reference to the currently executing thread object.
     *
     * @return  the currently executing thread.
     * 本地方法，返回当前线程
     */
    public static native Thread currentThread();

    /**
     * Tests if some Thread has been interrupted.  The interrupted state
     * is reset or not based on the value of ClearInterrupted that is
     * passed.
     * 本地方法，判断线程中断状态，设置是否清除线程中断状态
     */
    private native boolean isInterrupted(boolean ClearInterrupted);













}
