package com.sedion.mynawang.advanced._interthread_communication.pra1_nowaitnotify;

/**
 * @auther mynawang
 * @create 2016-11-24 14:47
 */
public class ThreadA extends Thread {

    private MyList myList;

    public ThreadA(MyList myList) {
        super();
        this.myList = myList;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                myList.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
