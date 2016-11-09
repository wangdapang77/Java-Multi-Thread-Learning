package com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj;

/**
 * synchronized方法与锁对象
 * @auther mynawang
 * @create 2016-11-09 10:52
 */
public class MyObject {

    public void methodA() {
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        try {
            System.out.println("begin methodB threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodC() {
        try {
            System.out.println("begin methodC threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * testPra4_1
     * ThreadA和ThreadB调用methodA，methodA为非同步的，所以执行是无序的
     *
     * testPra4_2
     * ThreadC和ThreadD调用methodB，methodB方法前加了synchronized，为同步的，所以是排队运行的，打印是有序的
     * 只有共享资源的读写访问需要同步化
     *
     * testPra4_3
     * ThreadA调用methodA，ThreadC调用methodB，两个线程调用不同的方法，虽然ThreadC持有了MyObject对象的锁，但ThreadA
     * 完全可以异步调用非synchronized类型的方法
     *
     * testPra4_4
     * ThreadC调用methodB，ThreadE调用methodC，两个线程调用不同的synchronized方法，打印的结果是有序的
     *
     * 结论：
     * 1.A线程先持有Object对象的Lock锁，B线程可以以异步的方式调用Object对象中的非synchronized类型的方法。
     * 2.A线程先持有Object对象的Lock锁，B线程如果在这时调用Object对象中的synchronized类型的方法则需等待，也就是同步。
     */

}
