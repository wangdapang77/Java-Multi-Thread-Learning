package advanced._volatile;

import com.sedion.mynawang.advanced._volatile.pra1_dropdead.PrintServer;
import com.sedion.mynawang.advanced._volatile.pra1_dropdead.PrintServerThread;
import com.sedion.mynawang.advanced._volatile.pra1_dropdead.PrintServerVolatile;
import com.sedion.mynawang.advanced._volatile.pra2_atomicity.VolatileThread;
import com.sedion.mynawang.advanced._volatile.pra2_atomicity.VolatileThreadSyn;
import com.sedion.mynawang.advanced._volatile.pra3_atomicinteger.AtomicIntegerNoSafeTest;
import com.sedion.mynawang.advanced._volatile.pra3_atomicinteger.AtomicIntegerTest;

/**
 * Volatile 测试用例
 * @auther mynawang
 * @create 2016-11-16 14:59
 */
public class PraVolatile {

    public void testPra1_1() {
        PrintServer printServer = new PrintServer();
        printServer.printMethod();
        System.out.println("停止打印 stopThread = " + Thread.currentThread().getName());
        printServer.setContinuePrint(false);
    }

    public void testPra1_2() {
        PrintServerThread printServer = new PrintServerThread();
        new Thread(printServer).start();
        System.out.println("停止打印 stopThread = " + Thread.currentThread().getName());
        printServer.setContinuePrint(false);
    }

    public void testPra1_3() {
        PrintServerVolatile printServer = new PrintServerVolatile();
        printServer.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printServer.setContinuePrint(false);

        System.out.println("赋值isContinuePrint为false");
    }


    public void testPra2_1() {
        VolatileThread[] threadsArray = new VolatileThread[100];
        for (int i = 0; i < 100; i++) {
            threadsArray[i] = new VolatileThread();
        }

        for (int i = 0; i < 100; i++) {
            threadsArray[i].start();
        }
    }

    public void testPra2_2() {
        VolatileThreadSyn[] threadsArray = new VolatileThreadSyn[100];
        for (int i = 0; i < 100; i++) {
            threadsArray[i] = new VolatileThreadSyn();
        }

        for (int i = 0; i < 100; i++) {
            threadsArray[i].start();
        }
    }

    public void testPra3_1() {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        Thread thread1 = new Thread(atomicIntegerTest);
        thread1.start();

        Thread thread2 = new Thread(atomicIntegerTest);
        thread2.start();

        Thread thread3 = new Thread(atomicIntegerTest);
        thread3.start();

        Thread thread4 = new Thread(atomicIntegerTest);
        thread4.start();

        Thread thread5 = new Thread(atomicIntegerTest);
        thread5.start();
    }

    public void testPra3_2() {
        AtomicIntegerNoSafeTest atomicIntegerNoSafeTest = new AtomicIntegerNoSafeTest();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(atomicIntegerNoSafeTest);
            threads[i].start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicIntegerNoSafeTest.count.get());
    }


    public static void main(String[] args) {
        PraVolatile praVolatile = new PraVolatile();
        praVolatile.testPra3_2();
    }



}
