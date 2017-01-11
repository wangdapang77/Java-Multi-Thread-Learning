package com.sedion.mynawang.advanced._lock.pra8_reentrantreadwritelock;

/**
 * @auther mynawang
 * @create 2017-01-11 16:09
 */
public class ThreadReadReadShareA extends Thread{

    private ReadWriteLock_ReadReadShare readWriteLock_readReadShare;

    public ThreadReadReadShareA(ReadWriteLock_ReadReadShare readWriteLock_readReadShare) {
        super();
        this.readWriteLock_readReadShare = readWriteLock_readReadShare;
    }

    public void run() {
        readWriteLock_readReadShare.read();
    }
}
