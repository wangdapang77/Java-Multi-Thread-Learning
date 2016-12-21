package com.sedion.mynawang.advanced._lock.pra2_withcondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2016-12-21 11:02
 */
public class MyServerWithBug {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await() {
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关键字synchronized于wait()、notify()/notifyAll()方法相结合可以实现等待/通知模式
     *
     * Lock中使用ReentrantLock和Condition也可以实现同样的功能。
     * 使用Condition类可以实现多路通知功能，更加灵活。
     * 在Lock对象中创建多个Condition(对象监视器)实例，线程对象可以注册在知道的Condition中，从而可以有选择性地进行线程通知
     * 在使用notify()/notifyAll()方法进行通知时，被通知的线程是JVM随机选择的。
     * 因此，相比这个功能，Condition的有选择性的通知更加灵活，也是Condition类中默认提供的。
     *
     *
     *
     * 以上代码执行报错，显示为监视器出错，解决办法是必须在condition.await()
     * 方法调用之前调用lock.lock()代码获得同步监视器，类似wait中必须使用synchronized
     */
}
