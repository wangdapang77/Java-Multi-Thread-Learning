package com.sedion.mynawang.advanced._synchronized.pra1_safewithout;

/**
 * 不用synchronized时保持线程安全
 * @auther mynawang
 * @create 2016-09-28 16:01
 */
public class SafeWithNoSynchronized {
    /**
     * 非线程安全：
     * 在多个线程对同一个对象中的实例变量进行并发访问时发生，产生的后果就是“脏读”，取到的数据其实是被更改过的。
     * 不提供数据访问保护，有可能出现多个线程先后更改数据造成所得到的数据是脏数据
     */

    /**
     * 线程安全：
     * 获得的实例变量的值是经过同步处理的，不会出现脏读的现象。
     * 采用了加锁机制，当一个线程访问该类的某个数据时，进行保护，其他线程不能进行访问知道该线程读取完，
     * 其他线程才可使用，不会出现数据不一致或者数据污染。
     */

    public void addNum(String userName) {
        try {
            int num = 0;
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
