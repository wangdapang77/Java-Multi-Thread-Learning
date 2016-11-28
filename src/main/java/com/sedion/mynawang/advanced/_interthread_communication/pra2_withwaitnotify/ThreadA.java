package com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify;


/**
 * @auther mynawang
 * @create 2016-11-24 14:47
 */
public class ThreadA extends Thread {

    private Object myObject;

    public ThreadA(Object myObject) {
        super();
        this.myObject = myObject;
    }

    @Override
    public void run() {
        try {
            synchronized (myObject) {
                if (MyList.size() != 5) {
                    System.out.println("等待开始：" + System.currentTimeMillis());
                    myObject.wait();
                    System.out.println("等待结束：" + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 关键字synchronized可以将任何一个Object对象作为同步对象来看待，而Java为每个Object都实现了wait()和notify()方法，
     * 它们必须用在被synchronized同步的Object的临界区内。通过调用wait()方法可以使出于临界区内的线程进入等待状态，同时
     * 释放被同步对象的锁。而notify操作可以唤醒一个因调用了wait操作而处于阻塞状态中的线程，使其进入就绪状态。被重新唤醒
     * 的线程会试图重新获取临界区的控制权，也就是锁，并继续执行临界区内wait之后的代码。如果发出notify操作时没有处于阻塞
     * 状态中的线程，那么该命令会被忽略。
     *
     * wait()方法可以使调用该方法的线程释放共享资源的锁，然后从运行状态退出。进入等待队列，直到被再次唤醒。
     *
     * notify()方法可以随机唤醒等待队列中等待同一共享资源的“一个”线程，并使该线程退出等待队列，进入可运行状态，也就是
     * notify()方法仅通知“一个”线程。
     *
     * notifyAll()方法可以使所有正在等待队列中等待同一共享资源的“全部”线程从等待状态退出，进入可运行状态。此时，优先级
     * 最高的那个线程最先执行，但也有可能是随机执行，因为这要取决于JVM虚拟机的实现。
     */

}
