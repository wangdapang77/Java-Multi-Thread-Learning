package advanced._synchronized;

import com.sedion.mynawang.advanced._synchronized.pra1_safewithout.SafeWithNoSynchronized;
import com.sedion.mynawang.advanced._synchronized.pra1_safewithout.ThreadA;
import com.sedion.mynawang.advanced._synchronized.pra1_safewithout.ThreadB;
import com.sedion.mynawang.advanced._synchronized.pra2_safewithsynchronized.SafeWithSynchronized;
import com.sedion.mynawang.advanced._synchronized.pra3_twoobjtwolock.TwoObjTwoLock;
import com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.MyObject;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;
import org.junit.Test;

/**
 * synchronized测试用例
 * @auther mynawang
 * @create 2016-09-28 16:41
 */

public class PraSynchronized {

    /**
     * par1_safewithout
     * 打印结果：
     * mynawang set over
     * other set over
     * mynawang2 num=200
     * mynawang num=100
     */
    @Test
    public void testPra1() {
        try {
            TestRunnable[] testRunnables = new TestRunnable[2];
            SafeWithNoSynchronized safeWithNoSynchronized = new SafeWithNoSynchronized();
            testRunnables[0] = new ThreadA(safeWithNoSynchronized);
            testRunnables[1] = new ThreadB(safeWithNoSynchronized);
            MultiThreadedTestRunner multiThreadedTestRunner = new MultiThreadedTestRunner(testRunnables);
            multiThreadedTestRunner.runTestRunnables();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * pra2_safewithsynchronized_1
     * 打印结果：
     * mynawang set over
     * other set over
     * mynawang2 num=200
     * mynawang num=200
     */
    @Test
    public void testPra2_1() {
        try {
            TestRunnable[] testRunnables = new TestRunnable[2];
            SafeWithSynchronized safeWithSynchronized = new SafeWithSynchronized();
            testRunnables[0] = new com.sedion.mynawang.advanced._synchronized.pra2_safewithsynchronized.ThreadA(safeWithSynchronized);
            testRunnables[1] = new com.sedion.mynawang.advanced._synchronized.pra2_safewithsynchronized.ThreadB(safeWithSynchronized);
            MultiThreadedTestRunner multiThreadedTestRunner = new MultiThreadedTestRunner(testRunnables);
            multiThreadedTestRunner.runTestRunnables();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * pra2_safewithsynchronized_2
     * 打印结果：
     * mynawang set over
     * other set over
     * mynawang num=200
     * mynawang2 num=200
     */
    @Test
    public void testPra2_2() {
        try {
            TestRunnable[] testRunnables = new TestRunnable[2];
            SafeWithSynchronized safeWithSynchronized = new SafeWithSynchronized();
            testRunnables[0] = new com.sedion.mynawang.advanced._synchronized.pra2_safewithsynchronized.ThreadC(safeWithSynchronized);
            testRunnables[1] = new com.sedion.mynawang.advanced._synchronized.pra2_safewithsynchronized.ThreadD(safeWithSynchronized);
            MultiThreadedTestRunner multiThreadedTestRunner = new MultiThreadedTestRunner(testRunnables);
            multiThreadedTestRunner.runTestRunnables();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * pra3_twoobjtwolock
     * 打印结果：
     * mynawang set over
     * other set over
     * mynawang2 num=200
     * mynawang num=100
     */
    public void testPra3() {
        try {
            TwoObjTwoLock twoObjTwoLock1 = new TwoObjTwoLock();
            TwoObjTwoLock twoObjTwoLock2 = new TwoObjTwoLock();
            com.sedion.mynawang.advanced._synchronized.pra3_twoobjtwolock.ThreadA threadA = new com.sedion.mynawang.advanced._synchronized.pra3_twoobjtwolock.ThreadA(twoObjTwoLock1);
            threadA.start();
            com.sedion.mynawang.advanced._synchronized.pra3_twoobjtwolock.ThreadB threadB = new com.sedion.mynawang.advanced._synchronized.pra3_twoobjtwolock.ThreadB(twoObjTwoLock2);
            threadB.start();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * pra4_synchrinozedmethodlockobj
     * 打印结果交叉执行
     * begin methodA threadName=Thread-A
     * begin methodA threadName=Thread-B
     * Thread-Bend
     * Thread-Aend
     */
    public void testPra4_1() {
        MyObject myObject = new MyObject();
        com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadA threadA =
                new com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadA(myObject);
        threadA.setName("Thread-A");
        com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadB threadB =
                new com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadB(myObject);
        threadB.setName("Thread-B");
        threadA.start();
        threadB.start();
    }

    /**
     * pra4_synchrinozedmethodlockobj
     * 打印结果按顺序执行
     * begin methodB threadName=Thread-C
     * Thread-Cend
     * begin methodB threadName=Thread-D
     * Thread-Dend
     *
     */
    public void testPra4_2() {
        MyObject myObject = new MyObject();
        com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadC threadC =
                new com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadC(myObject);
        threadC.setName("Thread-C");
        com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadD threadD =
                new com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadD(myObject);
        threadD.setName("Thread-D");
        threadC.start();
        threadD.start();
    }

    /**
     * pra4_synchrinozedmethodlockobj
     * 打印结果交叉执行
     * begin methodA threadName=Thread-A
     * begin methodB threadName=Thread-C
     * Thread-Cend
     * Thread-Aend
     */
    public void testPra4_3() {
        MyObject myObject = new MyObject();
        com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadA threadA =
                new com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadA(myObject);
        threadA.setName("Thread-A");
        com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadC threadC =
                new com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadC(myObject);
        threadC.setName("Thread-C");
        threadA.start();
        threadC.start();
    }

    /**
     * pra4_synchrinozedmethodlockobj
     * 打印结果按顺序执行
     * begin methodB threadName=Thread-C
     * Thread-Cend
     * begin methodC threadName=Thread-E
     * Thread-Eend
     */
    public void testPra4_4() {
        MyObject myObject = new MyObject();
        com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadC threadC =
                new com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadC(myObject);
        threadC.setName("Thread-C");
        com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadE threadE =
                new com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.ThreadE(myObject);
        threadE.setName("Thread-E");
        threadC.start();
        threadE.start();
    }

    public static void main(String[] args) {
        PraSynchronized praSynchronized = new PraSynchronized();
        praSynchronized.testPra4_4();
    }


}
