package com.sedion.mynawang.advanced._synchronized.pra5_dirtyread;

/**
 * @auther mynawang
 * @create 2016-11-09 15:32
 */
public class ThreadA extends Thread{

    public PublicVal publicVal;

    public ThreadA(PublicVal publicVal) {
        super();
        this.publicVal = publicVal;
    }

    @Override
    public void run() {
        super.run();
        publicVal.setVal("TEST","TEST_PWD");
    }
}
