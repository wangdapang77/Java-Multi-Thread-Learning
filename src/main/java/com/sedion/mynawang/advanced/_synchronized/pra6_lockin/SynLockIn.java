package com.sedion.mynawang.advanced._synchronized.pra6_lockin;

/**
 * synchronized可重入锁
 * @auther mynawang
 * @create 2016-11-10 9:52
 */
public class SynLockIn {

    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }

    /**
     * 现象：
     * 当使用synchronized时，当一个线程得到一个对象的锁后，该线程再次请求此对象锁时是可以再次得到该对象的锁的。
     * synchronized方法/块的内部钓鱼网本类的其他synchronized方法/块时，是永远可以得到锁的。
     *
     * 可重入锁概念：
     * 自己可以再次获取自己的内部锁。比如有1条线程获得了某个对象的锁，此时这个对象锁还没有释放，
     * 当其再次想要获取这个对象的锁的时候还是可以获取的，如果不重入的话，会造成死锁。
     */

}
