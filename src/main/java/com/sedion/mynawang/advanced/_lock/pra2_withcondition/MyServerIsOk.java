package com.sedion.mynawang.advanced._lock.pra2_withcondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2016-12-21 11:02
 */
public class MyServerIsOk {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await() {
        try {
            lock.lock();
            System.out.println("开始进入等待");
            condition.await();
            System.out.println("等待执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("等待锁释放完成");
        }
    }


    /**
     * 以上代码可以完整执行，调整了MyServerWithBug里执行的bug，
     * 使当前执行任务的线程进入了等待WAITING状态
     *
     */
}
