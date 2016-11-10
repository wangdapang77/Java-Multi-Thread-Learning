package com.sedion.mynawang.advanced._synchronized.pra7_throwexceptionnolock;

/**
 * @auther mynawang
 * @create 2016-11-10 11:31
 */
public class ThreadA extends Thread{

    private ExceptionMethod exceptionMethod;

    public ThreadA(ExceptionMethod exceptionMethod) {
        super();
        this.exceptionMethod = exceptionMethod;
    }

    @Override
    public void run() {
        exceptionMethod.service1();
    }
}
