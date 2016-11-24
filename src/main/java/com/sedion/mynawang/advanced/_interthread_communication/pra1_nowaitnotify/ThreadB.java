package com.sedion.mynawang.advanced._interthread_communication.pra1_nowaitnotify;

/**
 * @auther mynawang
 * @create 2016-11-24 14:47
 */
public class ThreadB extends Thread {

    private MyList myList;

    private int listSize;
    public ThreadB(MyList myList) {
        super();
        this.myList = myList;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(myList.size());
                if (myList.size() == 5) {
                    System.out.println("==5了，线程b要退出了！");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
