package com.sedion.mynawang.advanced._lock.pra1_reentranlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther mynawang
 * @create 2016-12-20 16:04
 */
public class MyServer {
    
    private Lock lock = new ReentrantLock();
    
    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
        }
        lock.unlock();
    }


    /**
     * 当前线程打印完毕之后将锁释放，其他线程才可以继续打印。
     * 线程打印的数据是分组打印，因为当前线程已经持有锁，
     * 但线程之间打印的顺序是随机的（也就是哪个线程占有锁是随机的）。
     *
     *
     * 调用lock.lock代码的线程持有了“对象监视器”，其他线程只有等待锁被释放时再次争抢。
     * 效果和使用synchronized关键字一样，线程之间还是顺序执行的。
     */
}
