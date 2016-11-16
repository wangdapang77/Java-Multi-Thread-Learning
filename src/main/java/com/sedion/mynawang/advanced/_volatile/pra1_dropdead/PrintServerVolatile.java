package com.sedion.mynawang.advanced._volatile.pra1_dropdead;

/**
 * volatile解决异步死循环
 * @auther mynawang
 * @create 2016-11-16 14:56
 */
public class PrintServerVolatile extends Thread{

    volatile private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean isContinuePrint) {
        this.isContinuePrint = isContinuePrint;
    }

    public void printMethod() {
        try {
            while (isContinuePrint == true) {
                System.out.println("run printMethod threadName = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
            System.out.println("线程被停止了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printMethod();
    }


    /**
     * 对实例变量添加volatile关键字后，死循环问题解决
     *
     * 在启动PrintServerVolatile线程时，实例变量private boolean isContinuePrint = true;
     * 存在于公共栈堆及线程的私有堆栈中。在JVM被设置为-server模式时为了线程的运行效率，
     * 线程一直在私有堆栈中取得isContinuePrint的值为true。而代码printServer.setContinuePrint(false)；
     * 虽然执行，更新的却是公共堆栈中的isContinuePrint变量值为false，所以一直是死循环状态。
     *
     *
     *线程的私有堆栈：

                线 程 主 体
                |         /\
                |         |
             线程写入     |
                |     线程读取
                |         |
                \/        |
                工 作 内 存
                |         /\
                |         |
            写入主内存    |
                |     数据读取该
                |         |
                \/        |
                主   内   存

     以上问题为私有堆栈(工 作 内 存)中的值和公共堆栈(主   内   存)中的值不同步造成的，解决此问题，
     可以使用volatie关键字，主要作用是当线程访问isContinuePrint变量时，强制性从公共堆栈中进行取值


    读取公共内存
                 线 程 主 体
                 |         /\
                |           |
               |     volatile变量读取
              |               |
             |                 |
            |                   |
            |   工 作 内 存     |
            |                   |
             |                 |
              |               |
        volatile变量写入     |
                |           |
                \/         |
                 主   内   存


        使用volatile关键字增加了实例变量在多个线程之间的可见性。但是volatile关键字的缺点是不支持原子性
     */


    /**
     * synchronized和volatile比较：
     * 1.关键字volatile是线程同步的轻量级实现，所以volatile性能肯定比synchronized要好，
     * 而且volatile只能修饰于变量，而synchronized可以修饰方法，以及代码块。随着JDK新版本的发布，
     * synchronized关键字在执行效率上得到很大的提升，在开发中使用synchronized关键字的比率还是比较大的
     *
     * 2.多线程访问volatile不会发生阻塞，而synchronized会出现阻塞
     *
     * 3.volatile能保证数据的可见性，但不能保证原子性；而synchronized可以保证原子性，也可以间接保证可见性，
     * 因为它会将私有内存和公共内存中的数据做同步。
     *
     * 4.关键字volatile解决的是变量在多线程之间的可见性；而synchronized关键字解决的是多个线程之间访问资源的同步性
     */

}
