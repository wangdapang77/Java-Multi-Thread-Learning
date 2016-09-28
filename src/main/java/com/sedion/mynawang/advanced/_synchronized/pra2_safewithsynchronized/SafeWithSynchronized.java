package com.sedion.mynawang.advanced._synchronized.pra2_safewithsynchronized;

/**
 * 实例（全局）变量线程安全保证
 * @auther mynawang
 * @create 2016-09-28 21:00
 */
public class SafeWithSynchronized {

    private int num = 0;

    /**
     * 非线程安全
     * 2个线程执行，当username为mynawang时，赋值给num为100，进入休眠
     * 此时username为其他的第二个线程进入，赋值给num为200，所以最后得到的num都为200
     */
    public void addNum1(String userName) {
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

    /**
     * 线程安全
     * 当第一个线程进入时方法加锁（其他方法无法调用），所以无论是username为mynawang或者other进入，
     * 只有等方法执行完成第二个线程才能进入方法，所以num打印也是按顺序执行的
     */
    public synchronized void addNum2(String userName) {
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
