package com.sedion.mynawang.basic;

import org.junit.Test;

/**
 * 停止线程（过期）
 * @auther mynawang
 * @create 2016-09-12 13:49
 */
public class StopThread {

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    // 使用抛出异常的方式中断线程，防止方法内部分代码在中断时会执行完【推荐使用】
    private static void test1() {
        try {
            Mythread mythread = new Mythread();
            mythread.start();
            Thread.sleep(200);
            mythread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main InterruptedException");
            e.printStackTrace();
        }
        System.out.println("end");
    }

    static class Mythread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 500000; i++) {
                    if (this.interrupted()) {
                        System.out.println("已经是停止状态了，我要退出了");
                        // break;
                        throw new InterruptedException();
                    }
                    System.out.println("i=" + (i + 1));
                }
                // 【使用break结束for循环】此处若mythread.interrupt();执行后还是会继续执行
                // 【使用throw new InterruptedException()结束for循环】此处不会继续执行
                System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止");
            } catch (InterruptedException e) {
                System.out.println("Mythread下的run方法捕获异常");
                e.printStackTrace();
            }
        }
    }

    // 如果在sleep状态下停止该线程，会进入catch语句，并且清除线程的中断状态，变为false
    // 先执行Thread.sleep(200000);再执行mythread2.interrupt(); 或者先后顺序相反，都是会进入catch报异常
    private static void test2() {
        try {
            Mythread2 mythread2 = new Mythread2();
            mythread2.start();
           // mythread2.sleep(200);
            mythread2.interrupt();
        } catch (Exception e) { //InterruptedException
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }

    static class Mythread2 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                System.out.println("run begin");
                Thread.sleep(200000);
                System.out.println("run end");
            } catch (InterruptedException e) {
                System.out.println("在沉睡中被停止！进入catch！" + this.isInterrupted());
                e.printStackTrace();
            }
        }
    }

    // stop（过期）方法暴力停止线程
    private static void test3() {
        try {
            Mythread3 mythread3 = new Mythread3();
            mythread3.start();
            mythread3.sleep(8000);
            mythread3.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Mythread3 extends Thread {
        private int i = 0;
        @Override
        public void run() {
            try {
                while (true) {
                    i++;
                    System.out.println("i=" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    // stop和java.lang.ThreadDeath异常
    // stop方法如果强制让线程停止则有可能使一些清理性的工作得不到完成；
    // 或者对一些锁定的对象进行解锁导致数据不一致的情况产生
    @Test
    public void test4() {
        Mythread4 mythread4 = new Mythread4();
        mythread4.start();
    }

    static class Mythread4 extends Thread {
        @Override
        public void run() {
            try {
                this.stop();
            } catch (ThreadDeath e) {
                System.out.println("进入了catch()方法！");
                e.printStackTrace();
            }
        }
    }

    // stop释放锁导致数据不一致，以下功能执行后打印的username和userpwd不同步
    @Test
    public void test5() {
        try {
            SynchronizedObject synchronizedObject = new SynchronizedObject();
            Mythread6 mythread6 = new Mythread6(synchronizedObject);
            mythread6.start();
            Thread.sleep(500);
            mythread6.stop();
            System.out.println(synchronizedObject.getUserName() + " " + synchronizedObject.getUserPwd());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class SynchronizedObject {
        private String userName = "mynawang";
        private String userPwd = "mynawang-pwd";

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPwd() {
            return userPwd;
        }

        public void setUserPwd(String userPwd) {
            this.userPwd = userPwd;
        }

        public void printString(String userName, String userPwd) {
            try {
                this.userName = userName;
                Thread.sleep(100000);
                this.userPwd = userPwd;
                System.out.println("执行完了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Mythread6 extends Thread {
        private SynchronizedObject synchronizedObject;

        public Mythread6(SynchronizedObject synchronizedObject) {
            super();
            this.synchronizedObject = synchronizedObject;
        }

        public void run() {
            synchronizedObject.printString("mynawang2", "mynawang2-pwd");
        }
    }

    // 使用return停止线程
    @Test
    public void test7() {
        try {
            Mythread7 mythread7 = new Mythread7();
            mythread7.start();
            Thread.sleep(2000);
            mythread7.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Mythread7 extends Thread {
        @Override
        public void run() {
            while (true) {
                if (this.isInterrupted()) {
                    System.out.println("停止了！");
                    return;
                }
                System.out.println("timer=" + System.currentTimeMillis());
            }
        }
    }




}
