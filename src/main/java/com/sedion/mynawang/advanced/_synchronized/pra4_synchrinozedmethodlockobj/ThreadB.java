package com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj;

/**
 * @auther mynawang
 * @create 2016-11-09 10:55
 */
public class ThreadB extends Thread{

    private MyObject myObject;

    public ThreadB(MyObject myObject) {
        super();
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodA();
    }
}
