package com.sedion.mynawang.advanced._synchronized.pra3_twoobjtwolock;

/**
 * @auther mynawang
 * @create 2016-11-08 11:25
 */
public class ThreadB extends Thread {

    private TwoObjTwoLock twoObjTwoLock;

    public ThreadB(TwoObjTwoLock twoObjTwoLock) {
        super();
        this.twoObjTwoLock = twoObjTwoLock;
    }

    @Override
    public void run() {
        super.run();
        twoObjTwoLock.addNum("mynawang2");
    }
}
