package com.sedion.mynawang.advanced._interthread_communication.pra5_producerwithconsumer.procons_pra1_value;

/**
 * @auther mynawang
 * @create 2016-12-01 14:34
 */
public class ThreadPA extends Thread {

    private ProducerA producerA;

    public ThreadPA(ProducerA producerA) {
        super();
        this.producerA = producerA;
    }

    @Override
    public void run() {
        while (true) {
            producerA.setValue();
        }
    }
}
