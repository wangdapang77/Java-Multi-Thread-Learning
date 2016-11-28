package com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify;

/**
 * @auther mynawang
 * @create 2016-11-24 16:51
 */
public class BugUseWait {

    public void testBugUse() {
        try {
            String myString = new String("test");
            myString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * wait使线程暂停运行
     *
     * 执行此段代码报异常：Exception in thread "main" java.lang.IllegalMonitorStateException
     * 出现异常是因为没有“对象监视器”，也就是没有同步加锁
     *
     *
     * 方法wait()是使当前执行代码的线程进行等待，wait()方法是Object类的方法，该方法用来将当前线程置入“预执行队列”中，
     * 并且在wait()所在的代码处停止执行，知道接到通知或被中断为止。调用wait()之前，线程必须获得该对象的对象级别锁，即
     * 只能在同步方法或同步块中调用wait()方法。在执行wait()方法后，当前线程释放锁。在从wait()返回前，线程与其他线程竞
     * 争重新获得锁。
     *
     * 如果调用wait()时没有持有适当的锁，则抛出IllegalMonitorStateException，是RuntimeException的一个子类
     *
     */

}
