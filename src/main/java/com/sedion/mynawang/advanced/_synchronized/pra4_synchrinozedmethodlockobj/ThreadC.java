package com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj;

/**
 * @auther mynawang
 * @create 2016-11-09 10:54
 */
public class ThreadC extends Thread{

    private MyObject myObject;

    public ThreadC(MyObject myObject) {
        super();
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodB();
    }
}
