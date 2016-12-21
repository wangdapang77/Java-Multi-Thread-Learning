package advanced._lock;

import com.sedion.mynawang.advanced._lock.pra1_reentranlock.MyServer;
import com.sedion.mynawang.advanced._lock.pra1_reentranlock.MyThread;
import com.sedion.mynawang.advanced._lock.pra2_withcondition.*;

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

    public static void main(String[] args) {
        PraLock praLock = new PraLock();
        praLock.testPra2_3();
    }
}
