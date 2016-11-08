package com.sedion.mynawang.advanced._synchronized.pra3_twoobjtwolock;

/**
 * @auther mynawang
 * @create 2016-11-08 11:25
 */
public class ThreadA extends Thread {

    private TwoObjTwoLock twoObjTwoLock;

    public ThreadA(TwoObjTwoLock twoObjTwoLock) {
        super();
        this.twoObjTwoLock = twoObjTwoLock;
    }

    @Override
    public void run() {
        super.run();
        twoObjTwoLock.addNum("mynawang");
    }
}
