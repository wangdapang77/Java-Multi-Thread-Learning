package com.sedion.mynawang.advanced._synchronized.pra7_throwexceptionnolock;

/**
 * 出现异常的锁被自动释放
 * @auther mynawang
 * @create 2016-11-10 10:48
 */
public class ExceptionMethod {

    synchronized public void service1() {
        if ("a".equals(Thread.currentThread().getName())) {
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                + " run beginTime=" + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if ("0.123456".equals(("" + Math.random()).substring(0, 8))) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName()
                        + " run exceptionTime=" + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread B run Time=" + System.currentTimeMillis());
        }
    }


    /**
     * 上述代码中，线程a出现异常并释放锁，线程b进入方法正常打印
     */


}
