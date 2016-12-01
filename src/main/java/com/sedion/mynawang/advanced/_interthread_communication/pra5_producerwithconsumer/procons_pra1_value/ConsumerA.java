package com.sedion.mynawang.advanced._interthread_communication.pra5_producerwithconsumer.procons_pra1_value;

/**
 * 消费者
 * @auther mynawang
 * @create 2016-12-01 14:31
 */
public class ConsumerA {

    private String objStr;

    public ConsumerA(String objStr) {
        super();
        this.objStr = objStr;
    }

    public void getValue() {
        try {
            synchronized (objStr) {
                if (ValueObj.value.equals("")) {
                    System.out.println("消费者 " + Thread.currentThread().getName() + "【waiting】了");
                    objStr.wait();
                }
                System.out.println("消费者 " + Thread.currentThread().getName() + "【runnable】了");
                System.out.println("get的值是" + ValueObj.value);
                ValueObj.value = "";
                objStr.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 如 PraCommunication中testPra5_1的测试
     *
     * 1个生产者和1个消费者进行数据的交互，在控制台中打印的日志get和set是交替运行的。
     *
     * 但如果设计出多个生产者和多个消费者，那么在运行的过程中很有可能出现“假死”情况，所有的线程都呈waiting等待状态
     *
     *
     * 如 PraCommunication中testPra5_2的测试
     * 打印信息中，假死状态的进程中所有线程都是waiting状态
     * 代码中通过wait/notify进行通信了，但不保证notify唤醒的是异类，也许是同类，比如“生产者”唤醒“生产者”，
     * 或“消费者”唤醒“消费者”这种情况发生。
     * 如果按这种情况运行的比率积少成多，就会导致所有的线程都不能继续运行下去，大家都在等待，都呈waiting状态，
     * 程序最后也就呈“假死”状态，不能继续运行下去。
     * 可将producer和consumer中的notify改为notifyAll，则不光通知同类线程，也包括异类，保证程序一直运行下去
     *
     */
}
