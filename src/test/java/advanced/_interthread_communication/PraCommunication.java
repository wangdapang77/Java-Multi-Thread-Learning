package advanced._interthread_communication;

import com.sedion.mynawang.advanced._interthread_communication.pra1_nowaitnotify.MyList;
import com.sedion.mynawang.advanced._interthread_communication.pra1_nowaitnotify.ThreadA;
import com.sedion.mynawang.advanced._interthread_communication.pra1_nowaitnotify.ThreadB;
import com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify.BugUseWait;
import com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify.WaitWithSyn;
import com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.NotifyAllThread;
import com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.NotifyMoreThread;
import com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.NotifyOneThread;
import com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadC;

/**
 * @auther mynawang
 * @create 2016-11-24 15:42
 */
public class PraCommunication {

    public void testPra1_1() {
        MyList myList = new MyList();
        ThreadA threadA = new ThreadA(myList);
        threadA.setName("therad-A");
        threadA.start();
        ThreadB threadB = new ThreadB(myList);
        threadB.setName("thread-B");
        threadB.start();
    }

    public void testPra2_1() {
        BugUseWait bugUseWait = new BugUseWait();
        bugUseWait.testBugUse();
    }

    public void testPra2_2() {
        WaitWithSyn waitWithLock = new WaitWithSyn();
        waitWithLock.useLockWait();
    }

    public void testPra2_3() {
        try {
            Object object = new Object();
            com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify.ThreadA threadA =
                    new com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify.ThreadA(object);
            threadA.start();
            Thread.sleep(50);
            com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify.ThreadB threadB =
                    new com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify.ThreadB(object);
            threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testPra3_1() {
        Object lock = new Object();
        com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadA threadA =
                new com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadA(lock);
        threadA.start();

        com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadB threadB =
                new com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadB(lock);
        threadB.start();

        ThreadC threadC = new ThreadC(lock);
        threadC.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        NotifyOneThread notifyOneThread = new NotifyOneThread(lock);
        notifyOneThread.start();
    }

    public void testPra3_2() {
        Object lock = new Object();
        com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadA threadA =
                new com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadA(lock);
        threadA.start();

        com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadB threadB =
                new com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadB(lock);
        threadB.start();

        ThreadC threadC = new ThreadC(lock);
        threadC.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        NotifyMoreThread notifyMoreThread = new NotifyMoreThread(lock);
        notifyMoreThread.start();
    }

    public void testPra3_3() {
        Object lock = new Object();
        com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadA threadA =
                new com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadA(lock);
        threadA.start();

        com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadB threadB =
                new com.sedion.mynawang.advanced._interthread_communication.pra3_notifyall.ThreadB(lock);
        threadB.start();

        ThreadC threadC = new ThreadC(lock);
        threadC.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        NotifyAllThread notifyAllThread = new NotifyAllThread(lock);
        notifyAllThread.start();
    }

    public static void main(String[] args) {
        PraCommunication praCommunication = new PraCommunication();
        praCommunication.testPra3_3();
    }



}
