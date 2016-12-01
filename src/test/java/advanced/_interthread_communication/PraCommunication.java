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
import com.sedion.mynawang.advanced._interthread_communication.pra5_producerwithconsumer.procons_pra1_value.ConsumerA;
import com.sedion.mynawang.advanced._interthread_communication.pra5_producerwithconsumer.procons_pra1_value.ProducerA;
import com.sedion.mynawang.advanced._interthread_communication.pra5_producerwithconsumer.procons_pra1_value.ThreadCA;
import com.sedion.mynawang.advanced._interthread_communication.pra5_producerwithconsumer.procons_pra1_value.ThreadPA;

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

    public void testPra4_1() {
        try {
            Object lockObj = new Object();
            com.sedion.mynawang.advanced._interthread_communication.pra4_waitwithinterrupt.ThreadA threadA =
                    new com.sedion.mynawang.advanced._interthread_communication.pra4_waitwithinterrupt.ThreadA(lockObj);
            threadA.start();
            Thread.sleep(5000);
            threadA.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testPra5_1() {
        String objStr = new String("");
        ProducerA producerA = new ProducerA(objStr);
        ConsumerA comsumerA = new ConsumerA(objStr);

        ThreadPA threadPA = new ThreadPA(producerA);
        ThreadCA threadCA = new ThreadCA(comsumerA);
        threadPA.start();
        threadCA.start();
    }


    public void testPra5_2() {
        String objStr = new String("");
        ProducerA producerA = new ProducerA(objStr);
        ConsumerA comsumerA = new ConsumerA(objStr);
        ThreadPA[] threadPAs = new ThreadPA[2];
        ThreadCA[] threadCAs = new ThreadCA[2];

        try {
            for (int i = 0; i < 2; i++) {
                threadPAs[i] = new ThreadPA(producerA);
                threadPAs[i].setName("生产者" + (i + 1));

                threadCAs[i] = new ThreadCA(comsumerA);
                threadCAs[i].setName("消费者" + (i + 1));

                threadPAs[i].start();
                threadCAs[i].start();
            }

            Thread.sleep(5000);

            Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
            Thread.currentThread().getThreadGroup().enumerate(threadArray);
            for (int i = 0; i < threadArray.length; i++) {
                System.out.println(threadArray[i].getName() + " " + threadArray[i].getState());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        PraCommunication praCommunication = new PraCommunication();
        praCommunication.testPra5_2();
    }



}
