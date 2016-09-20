package com.sedion.mynawang.basic;

/**
 * 暂停线程（过期）
 * @auther mynawang
 * @create 2016-09-12 13:51
 */
public class SuspendThread {


    public static void main(String[] args) throws InterruptedException {
        //test1();

        //test2();

        //test3();

        test4();
    }

    // Thread的暂停使用（suspend()、resume()）
    private static void test1() throws InterruptedException {
        Mythread mythread = new Mythread();
        mythread.start();
        Thread.sleep(5000);

        mythread.suspend();
        System.out.println("A= " + System.currentTimeMillis() + " i=" + mythread.getI());
        Thread.sleep(5000);
        System.out.println("A= " + System.currentTimeMillis() + " i=" + mythread.getI());

        mythread.resume();
        Thread.sleep(5000);

        mythread.suspend();
        System.out.println("B= " + System.currentTimeMillis() + " i=" + mythread.getI());
        Thread.sleep(5000);
        System.out.println("B= " + System.currentTimeMillis() + " i=" + mythread.getI());

    }

    static class Mythread extends Thread {
        private long i = 0;

        public long getI() {
            return i;
        }

        public void setI(long i) {
            this.i = i;
        }

        @Override
        public void run() {
            while (true) {
                i++;
            }
        }
    }

    // suspend独占锁1
    private static void test2() throws InterruptedException {
        final SynchronizedObject synchronizedObject = new SynchronizedObject();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                synchronizedObject.printString();
            }
        };
        thread1.setName("a");
        thread1.start();
        Thread.sleep(1000);

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("thread2启动了，但是进入不了printString()方法！只打印一个begin");
                System.out.println("printString方法被a线程锁定并且永远suspend暂停了");
                synchronizedObject.printString();
            }
        };
        thread2.start();
    }

    static class SynchronizedObject {
        public synchronized void printString() {
            System.out.println("begin");
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("a线程永远suspend了");
                Thread.currentThread().suspend();
            }
            System.out.println("end");
        }
    }

    // 独占锁（println方法加了同步锁） println方法一直处于暂停状态，无法打印
    private static void test3() throws InterruptedException {
        Mythread2 mythread2 = new Mythread2();
        mythread2.start();
        Thread.sleep(1000);
        mythread2.suspend();
        System.out.println("main end");
    }

    static class Mythread2 extends Thread {
        private long i = 0;
        @Override
        public void run() {
            while (true) {
                i++;
                System.out.println(i);
            }
        }
    }

    // suspend resume暂停方法不同步
    private static void test4() throws InterruptedException {
        final MyObject myObject = new MyObject();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                // 只赋值了a，aa未被赋值
                myObject.setValue("a", "aa");
            }
        };
        thread1.setName("a");
        thread1.start();
        Thread.sleep(500);

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                myObject.printUsernamePassword();
            }
        };
        thread2.start();
    }

    static class MyObject {
        private String username = "1";
        private String password = "1L";
        public void setValue(String u, String p) {
            this.username = u;
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("停止a线程");
                // 执行到这步即停止
                Thread.currentThread().suspend();
            }
            this.password = p;
        }
        public void printUsernamePassword() {
            System.out.println(username + " " + password);
        }
    }






}


