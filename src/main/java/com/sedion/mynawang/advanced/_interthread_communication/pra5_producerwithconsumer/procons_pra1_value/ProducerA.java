package com.sedion.mynawang.advanced._interthread_communication.pra5_producerwithconsumer.procons_pra1_value;

/**
 * 生产者
 * @auther mynawang
 * @create 2016-12-01 14:26
 */
public class ProducerA {
    private String objStr;

    public ProducerA(String objStr) {
        super();
        this.objStr = objStr;
    }

    public void setValue() {
        try {
            synchronized (objStr) {
                if (!ValueObj.value.equals("")) {
                    System.out.println("生产者 " + Thread.currentThread().getName() + "【waiting】了");
                    objStr.wait();
                }
                System.out.println("生产者 " + Thread.currentThread().getName() + "【runnable】了");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set的值是" + value);
                ValueObj.value = value;
                objStr.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
