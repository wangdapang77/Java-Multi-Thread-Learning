package com.sedion.mynawang.advanced._lock.pra8_reentrantreadwritelock;

/**
 * @auther mynawang
 * @create 2017-01-11 16:09
 */
public class ThreadReadReadShareB extends Thread{

    private ReadWriteLock_ReadReadShare readWriteLock_readReadShare;

    public ThreadReadReadShareB(ReadWriteLock_ReadReadShare readWriteLock_readReadShare) {
        super();
        this.readWriteLock_readReadShare = readWriteLock_readReadShare;
    }

    public void run() {
        readWriteLock_readReadShare.read();
    }
}
