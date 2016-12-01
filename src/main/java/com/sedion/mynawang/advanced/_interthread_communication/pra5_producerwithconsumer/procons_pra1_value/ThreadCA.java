package com.sedion.mynawang.advanced._interthread_communication.pra5_producerwithconsumer.procons_pra1_value;

/**
 * @auther mynawang
 * @create 2016-12-01 14:35
 */
public class ThreadCA extends Thread {
    private ConsumerA comsumerA;

    public ThreadCA(ConsumerA comsumerA) {
        super();
        this.comsumerA = comsumerA;
    }

    @Override
    public void run() {
        while (true) {
            comsumerA.getValue();
        }
    }
}
