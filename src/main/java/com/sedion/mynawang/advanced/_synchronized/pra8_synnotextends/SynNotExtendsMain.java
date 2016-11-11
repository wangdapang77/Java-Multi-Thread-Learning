package com.sedion.mynawang.advanced._synchronized.pra8_synnotextends;

/**
 * @auther mynawang
 * @create 2016-11-11 14:02
 */
public class SynNotExtendsMain {

    synchronized public void service1() {
        try {
            System.out.println("int main 下一步 sleep begin threadName="
                + Thread.currentThread().getName() + " time="
                + System.currentTimeMillis());
            Thread.sleep(5000);

            System.out.println("int main 下一步 sleep end threadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
