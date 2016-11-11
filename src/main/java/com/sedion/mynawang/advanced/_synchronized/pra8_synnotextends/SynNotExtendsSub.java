package com.sedion.mynawang.advanced._synchronized.pra8_synnotextends;

/**
 * @auther mynawang
 * @create 2016-11-11 14:02
 */
public class SynNotExtendsSub extends SynNotExtendsMain{

    /**
     * 非同步调用
     */
    public void service1() {
        try {
            System.out.println("int sub 下一步 sleep begin threadName="
                + Thread.currentThread().getName() + " time="
                + System.currentTimeMillis());
            Thread.sleep(5000);

            System.out.println("int sub 下一步 sleep end threadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 会同步调用
     */
    synchronized public void service2() {
        try {
            System.out.println("int sub 下一步 sleep begin threadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
            Thread.sleep(5000);

            System.out.println("int sub 下一步 sleep end threadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
