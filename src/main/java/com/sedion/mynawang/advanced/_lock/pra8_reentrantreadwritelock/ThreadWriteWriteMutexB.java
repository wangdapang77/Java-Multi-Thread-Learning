package com.sedion.mynawang.advanced._lock.pra8_reentrantreadwritelock;

/**
 * @auther mynawang
 * @create 2017-01-11 16:26
 */
public class ThreadWriteWriteMutexB extends Thread{

    private ReadWriteLock_WriteWriteMutex readWriteLock_writeWriteMutex;

    public ThreadWriteWriteMutexB(ReadWriteLock_WriteWriteMutex readWriteLock_writeWriteMutex) {
        super();
        this.readWriteLock_writeWriteMutex = readWriteLock_writeWriteMutex;
    }

    @Override
    public void run() {
        readWriteLock_writeWriteMutex.write();
    }
}
