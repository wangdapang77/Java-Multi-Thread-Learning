package advanced._lock;

import com.sedion.mynawang.advanced._lock.pra1_reentranlock.MyServer;
import com.sedion.mynawang.advanced._lock.pra1_reentranlock.MyThread;
import com.sedion.mynawang.advanced._lock.pra2_withcondition.*;
import com.sedion.mynawang.advanced._lock.pra2_withcondition.ThreadA;
import com.sedion.mynawang.advanced._lock.pra2_withcondition.ThreadB;
import com.sedion.mynawang.advanced._lock.pra5_getmethod.MyServerHoldCount;
import com.sedion.mynawang.advanced._lock.pra5_getmethod.MyServerQueueLength;
import com.sedion.mynawang.advanced._lock.pra5_getmethod.MyServerWaitQueueLength;
import com.sedion.mynawang.advanced._lock.pra6_hasmethod.MyServerQueuedThread;
import com.sedion.mynawang.advanced._lock.pra6_hasmethod.MyServerWaiters;
import com.sedion.mynawang.advanced._lock.pra7_ismethod.MyServerFair;
import com.sedion.mynawang.advanced._lock.pra7_ismethod.MyServerHeldByCurrentThread;
import com.sedion.mynawang.advanced._lock.pra7_ismethod.MyServerLocked;
import com.sedion.mynawang.advanced._lock.pra8_reentrantreadwritelock.*;

/**
 * @auther mynawang
 * @create 2016-12-20 16:07
 */
public class PraLock {

    public void testPra1() {
        MyServer myServer = new MyServer();
        MyThread myThread1 = new MyThread(myServer);
        MyThread myThread2 = new MyThread(myServer);
        MyThread myThread3 = new MyThread(myServer);
        MyThread myThread4 = new MyThread(myServer);
        MyThread myThread5 = new MyThread(myServer);

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
    }


    public void testPra2_1() {
        MyServerWithBug myServerWithBug = new MyServerWithBug();
        ThreadA threadA = new ThreadA(myServerWithBug);
        threadA.start();
    }

    public void testPra2_2() {
        MyServerIsOk myServerIsOk = new MyServerIsOk();
        ThreadB threadB = new ThreadB(myServerIsOk);
        threadB.start();
    }

    public void testPra2_3() {
        try {
            MyServerWaitNotify myServerWaitNotify = new MyServerWaitNotify();
            ThreadC threadC = new ThreadC(myServerWaitNotify);
            threadC.start();
            Thread.sleep(3000);
            myServerWaitNotify.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testPra3() {
        com.sedion.mynawang.advanced._lock.pra3_notifymore.MyServer myServer =
                new com.sedion.mynawang.advanced._lock.pra3_notifymore.MyServer();
        com.sedion.mynawang.advanced._lock.pra3_notifymore.ThreadA threadA =
                new com.sedion.mynawang.advanced._lock.pra3_notifymore.ThreadA(myServer);
        threadA.setName("threadA");
        threadA.start();

        com.sedion.mynawang.advanced._lock.pra3_notifymore.ThreadB threadB =
                new com.sedion.mynawang.advanced._lock.pra3_notifymore.ThreadB(myServer);
        threadB.setName("threadB");
        threadB.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myServer.signalAll_A();
    }

    public void testPra4_1() {
        final com.sedion.mynawang.advanced._lock.pra4_fairnofair.MyServer myServer =
                new com.sedion.mynawang.advanced._lock.pra4_fairnofair.MyServer(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("********线程" + Thread.currentThread().getName() + "运行了");
                myServer.testMethod();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }

    public void testPra4_2() {
        final com.sedion.mynawang.advanced._lock.pra4_fairnofair.MyServer myServer =
                new com.sedion.mynawang.advanced._lock.pra4_fairnofair.MyServer(false);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("********线程" + Thread.currentThread().getName() + "运行了");
                myServer.testMethod();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }


    public void testPra5_1() {
        MyServerHoldCount myServer = new MyServerHoldCount();
        myServer.testMethod1();
    }

    public void testPra5_2() {
        final MyServerQueueLength myServerQueueLength = new MyServerQueueLength();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myServerQueueLength.testMethod1();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程数： " + myServerQueueLength.reentrantLock.getQueueLength());

    }


    public void testPra5_3() {
        final MyServerWaitQueueLength myServerWaitQueueLength = new MyServerWaitQueueLength();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myServerWaitQueueLength.waitMethod();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myServerWaitQueueLength.nofityMethod();

    }


    public void testPra6_1() {
        final MyServerQueuedThread myServerQueuedThread = new MyServerQueuedThread();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myServerQueuedThread.waitMethod();
            }
        };
        try {
            Thread threadA = new Thread(runnable);
            threadA.start();
            Thread.sleep(500);

            Thread threadB = new Thread(runnable);
            threadB.start();
            Thread.sleep(500);

            System.out.println(myServerQueuedThread.lock.hasQueuedThread(threadA));
            System.out.println(myServerQueuedThread.lock.hasQueuedThread(threadB));
            System.out.println(myServerQueuedThread.lock.hasQueuedThreads());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testPra6_2() {
        final MyServerWaiters myServerWaiters = new MyServerWaiters();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myServerWaiters.waitMethod();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myServerWaiters.notifyMethod();
    }


    public void testPra7_1() {
        final MyServerFair myServerFair = new MyServerFair(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myServerFair.testMethod();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        final MyServerFair myServerFair1 = new MyServerFair(false);
        runnable = new Runnable() {
            @Override
            public void run() {
                myServerFair1.testMethod();
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();
    }

    public void testPra7_2() {
        final MyServerHeldByCurrentThread myServerHeldByCurrentThread =
                new MyServerHeldByCurrentThread(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myServerHeldByCurrentThread.testMethod();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }

    public void testPra7_3() {
        final MyServerLocked myServerLocked = new MyServerLocked(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myServerLocked.testMethod1();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();


        runnable = new Runnable() {
            @Override
            public void run() {
                myServerLocked.testMethod2();
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();

    }


    public void testPra8_1() {
        ReadWriteLock_ReadReadShare readWriteLock_readReadShare = new ReadWriteLock_ReadReadShare();
        ThreadReadReadShareA readReadShareThreadA = new ThreadReadReadShareA(readWriteLock_readReadShare);
        readReadShareThreadA.setName("readreadshareA");

        ThreadReadReadShareB readReadShareThreadB = new ThreadReadReadShareB(readWriteLock_readReadShare);
        readReadShareThreadB.setName("readreadshareB");

        readReadShareThreadA.start();
        readReadShareThreadB.start();
    }

    public void testPra8_2() {
        ReadWriteLock_WriteWriteMutex readWriteLock_writeWriteMutex = new ReadWriteLock_WriteWriteMutex();

        ThreadWriteWriteMutexA writeWriteMutexThreadA = new ThreadWriteWriteMutexA(readWriteLock_writeWriteMutex);
        writeWriteMutexThreadA.setName("writewriteMutexA");

        ThreadWriteWriteMutexB writeWriteMutexThreadB = new ThreadWriteWriteMutexB(readWriteLock_writeWriteMutex);
        writeWriteMutexThreadB.setName("writewriteMutexB");

        writeWriteMutexThreadA.start();
        writeWriteMutexThreadB.start();
    }

    public void testPra8_3() {

        ReadWriteLock_ReadWriteMutex readWriteLock_readWriteMutex = new ReadWriteLock_ReadWriteMutex();

        ThreadReadWriteMutexA threadReadWriteMutexA = new ThreadReadWriteMutexA(readWriteLock_readWriteMutex);
        threadReadWriteMutexA.setName("readwriteMutxA");

        ThreadReadWriteMutexB threadReadWriteMutexB = new ThreadReadWriteMutexB(readWriteLock_readWriteMutex);
        threadReadWriteMutexB.setName("readwriteMutxB");

        threadReadWriteMutexA.start();
        threadReadWriteMutexB.start();

    }


    public static void main(String[] args) {
        PraLock praLock = new PraLock();
        praLock.testPra8_3();
    }
}
