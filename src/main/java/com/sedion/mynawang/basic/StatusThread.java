package com.sedion.mynawang.basic;

import com.sedion.mynawang.util.SleepUtils;

/**
 * 线程状态
 * @auther mynawang
 * @create 2016-09-05 22:11
 * NEW          ：初始状态，线程被构建，但是还没有调用start()方法
 * RUNNABLE     ：运行状态，Java线程将操作系统中的就绪(READY)和运行(RUNNING)两种状态笼统地称作“运行中”
 * BLOCKED      ：阻塞状态，表示线程阻塞于锁
 * WAITING      ：等待状态，表示线程进入等待状态，进入该状态表示当前线程需要等待其他线程做出一些特定动作（通知或中断）
 * TIME_WAITING ：超时等待状态，该状态不同于WAITING，它是可以在指定的时间自行返回的
 * TERMINATED   ：终止状态，表示当前线程已经执行完毕
 */
public class StatusThread {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread" ).start();
        new Thread(new Waiting(), "WaitingThread").start();

        // 使用两个Blocked线程，一个获取锁成功，另一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();

        /**
         * Jprofiler查看运行结果：
         * TimeWaitingThread：Waiting
         * WaitingThread    : Waiting
         * BlockedThread-1  ：Waiting
         * BlockedThread-2  ：Blocked
         *
         * 100秒后
         * TimeWaitingThread：Waiting
         * WaitingThread    : Waiting
         * BlockedThread-1  ：结束
         * BlockedThread-2  ：Waiting
         *
         * 再100秒后
         * TimeWaitingThread：Waiting
         * WaitingThread    : Waiting
         * BlockedThread-1  ：结束
         * BlockedThread-2  ：结束
         *
         */



    }

    // 不断地进行休眠
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    // 在Waiting.class实例上等待
    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 该线程在Blocked.class实例上加锁后，不会释放该锁
    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                SleepUtils.second(100);
            }
        }
    }

    /**
     * 1.NEW（初始状态）------------------Thread.start()-------------------------> 运行(RUNNABLE【RUNNING && READY】)
     *
     * 2.RUNNABLE(运行状态)---------------Thread.sleep(long)---------------------> TIME_WAITING(等待超时状态)
     * 3.RUNNABLE(运行状态)---------------Object.wait(long)----------------------> TIME_WAITING(等待超时状态)
     * 4.RUNNABLE(运行状态)---------------Thread.join(long)----------------------> TIME_WAITING(等待超时状态)
     * 5.RUNNABLE(运行状态)---------------LockSupport.parkNanos()----------------> TIME_WAITING(等待超时状态)
     * 6.RUNNABLE(运行状态)---------------LockSupport.parkUntil()----------------> TIME_WAITING(等待超时状态)
     *
     * 7.TIME_WAITING(等待超时状态)-------Object.notify()------------------------> RUNNABLE(运行状态)
     * 8.TIME_WAITING(等待超时状态)-------Object.notifyAll()---------------------> RUNNABLE(运行状态)
     * 9.TIME_WAITING(等待超时状态)-------LockSupport.unpark()-------------------> RUNNABLE(运行状态)
     *
     * 10.RUNNABLE(运行状态)--------------等待进入synchronized方法---------------> BLOCKED(阻塞状态)
     * 11.RUNNABLE(运行状态)--------------等待进入synchronized块-----------------> BLOCKED(阻塞状态)
     *
     * 12.BLOCKED(阻塞状态)---------------获取到锁-------------------------------> RUNNABLE(运行状态)
     *
     * 13.RUNNABLE(运行状态)--------------Object.wait()--------------------------> WAITING(等待状态)
     * 14.RUNNABLE(运行状态)--------------Object.join()--------------------------> WAITING(等待状态)
     * 15.RUNNABLE(运行状态)--------------LockSupport.park()---------------------> WAITING(等待状态)
     *
     * 16.WAITING(等待状态)---------------Object.notify()------------------------> RUNNABLE(运行状态)
     * 17.WAITING(等待状态)---------------Object.notifyAll()---------------------> RUNNABLE(运行状态)
     * 18.WAITING(等待状态)---------------LockSupport.unpark(Thread)-------------> RUNNABLE(运行状态)
     *
     * 19.RUNNABLE(运行状态)--------------执行完成-------------------------------> TERMINATED(终止状态)
     *
     *
     */



}
