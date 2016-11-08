package com.sedion.mynawang.advanced._synchronized.pra3_twoobjtwolock;

/**
 * synchronized取得的锁是对象锁，而不是把一段代码或方法（函数）当作锁，
 * 所以哪个线程先执行带synchronized关键字的方法，哪个线程就持有该方法所属对象的锁Lock，
 * 那么其他线程只能呈等待状态，前提是多个线程访问的是同一个对象。
 *
 * 但如果多个线程访问多个对象，则JVM会创建多个锁，在PraSynchronized执行代码中创建了
 * 2个TwoObjTwoLock，所以会产生出2个锁，打印的结果是交叉的而不是同步的
 * @auther mynawang
 * @create 2016-11-08 11:16
 */
public class TwoObjTwoLock {

    private int num = 0;

    public synchronized void addNum(String userName) {
        try {
            if ("mynawang".equals(userName)) {
                num = 100;
                System.out.println("mynawang set over");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("other set over");
            }
            System.out.println(userName + " num=" + num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
