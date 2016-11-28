package com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify;


/**
 * @auther mynawang
 * @create 2016-11-24 14:47
 */
public class ThreadB extends Thread {

    private Object myObject;

    public ThreadB(Object myObject) {
        super();
        this.myObject = myObject;
    }

    @Override
    public void run() {
        try {
            synchronized (myObject) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        myObject.notify();
                        System.out.println("等待结束通知已发出");
                    }
                    System.out.println("添加了" + (i + 1) + "个元素！");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
