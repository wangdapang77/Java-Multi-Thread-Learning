package com.sedion.mynawang.advanced._lock.pra7_ismethod;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2017-01-06 14:14
 */
public class MyServerFair {

    private ReentrantLock lock;

    public MyServerFair(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void testMethod() {

        try {
            lock.lock();
            System.out.println("公平锁情况：" + lock.isFair());
        } finally {
            lock.unlock();
        }
    }


    /**
     * isFair()判断是不是公平锁
     * 查看ReentrantLock构造函数默认使用的是非公平锁
     *
     */
}
