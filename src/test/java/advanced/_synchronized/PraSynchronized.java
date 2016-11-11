package advanced._synchronized;

import com.sedion.mynawang.advanced._synchronized.pra1_safewithout.SafeWithNoSynchronized;
import com.sedion.mynawang.advanced._synchronized.pra1_safewithout.ThreadA;
import com.sedion.mynawang.advanced._synchronized.pra1_safewithout.ThreadB;
import com.sedion.mynawang.advanced._synchronized.pra2_safewithsynchronized.SafeWithSynchronized;
import com.sedion.mynawang.advanced._synchronized.pra3_twoobjtwolock.TwoObjTwoLock;
import com.sedion.mynawang.advanced._synchronized.pra4_synchrinozedmethodlockobj.MyObject;
import com.sedion.mynawang.advanced._synchronized.pra5_dirtyread.PublicVal;
import com.sedion.mynawang.advanced._synchronized.pra7_throwexceptionnolock.ExceptionMethod;
import com.sedion.mynawang.advanced._synchronized.pra8_synnotextends.SynNotExtendsSub;
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

    /**
     * pra5_dirtyread
     * 打印结果
     * getVal method thread name = main userName = TEST userPwd = MYNAWANG_PWD
     * setVal method thread name = Thread-0 userName = TEST userPwd = TEST_PWD
     * userPwd未被更新，出现脏读
     */
    public void testPra5_1() {
        try {
            PublicVal publicVal = new PublicVal();
            com.sedion.mynawang.advanced._synchronized.pra5_dirtyread.ThreadA threadA =
                    new com.sedion.mynawang.advanced._synchronized.pra5_dirtyread.ThreadA(publicVal);
            threadA.start();
            Thread.sleep(200);
            publicVal.getVal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * pra5_dirtyread
     * 打印结果
     * setVal method thread name = Thread-0 userName = TEST userPwd = TEST_PWD
     * getVal method thread name = main userName = TEST userPwd = TEST_PWD
     *
     * 加了synchronized后的方法，getVal和setVal2将按顺序执行
     */
    public void testPra5_2() {
        try {
            PublicVal publicVal = new PublicVal();
            com.sedion.mynawang.advanced._synchronized.pra5_dirtyread.ThreadA threadA =
                    new com.sedion.mynawang.advanced._synchronized.pra5_dirtyread.ThreadA(publicVal);
            threadA.start();
            Thread.sleep(200);
            publicVal.getVal2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * pra6_lockin
     * 打印结果
     * service1
     * service2
     * service3
     */
    public void testPra6_1() {
        com.sedion.mynawang.advanced._synchronized.pra6_lockin.ThreadA threadA =
                new com.sedion.mynawang.advanced._synchronized.pra6_lockin.ThreadA();
        threadA.start();
    }

    /**
     * pra6_lockin
     */
    public void testPra6_2() {
        com.sedion.mynawang.advanced._synchronized.pra6_lockin.ThreadB threadB =
                new com.sedion.mynawang.advanced._synchronized.pra6_lockin.ThreadB();
        threadB.start();
    }

    /**
     * pra7_throwexceptionnolock
     */
    public void testPra7() {
        try {
            ExceptionMethod exceptionMethod = new ExceptionMethod();
            com.sedion.mynawang.advanced._synchronized.pra7_throwexceptionnolock.ThreadA threadA =
                    new com.sedion.mynawang.advanced._synchronized.pra7_throwexceptionnolock.ThreadA(exceptionMethod);
            threadA.setName("a");
            threadA.start();
            Thread.sleep(500);

            com.sedion.mynawang.advanced._synchronized.pra7_throwexceptionnolock.ThreadB threadB =
                    new com.sedion.mynawang.advanced._synchronized.pra7_throwexceptionnolock.ThreadB(exceptionMethod);
            threadB.setName("b");
            threadB.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * pra8_synnotextends
     * 非同步调用
     */
    public void testPra8_1() {
        SynNotExtendsSub synNotExtendsSub = new SynNotExtendsSub();
        com.sedion.mynawang.advanced._synchronized.pra8_synnotextends.ThreadA threadA =
                new com.sedion.mynawang.advanced._synchronized.pra8_synnotextends.ThreadA(synNotExtendsSub);
        threadA.setName("Thread-A");
        threadA.start();

        com.sedion.mynawang.advanced._synchronized.pra8_synnotextends.ThreadB threadB =
                new com.sedion.mynawang.advanced._synchronized.pra8_synnotextends.ThreadB(synNotExtendsSub);
        threadB.setName("Thread-B");
        threadB.start();
    }

    /**
     * pra8_synnotextends
     * 同步调用
     */
    public void testPra8_2() {
        SynNotExtendsSub synNotExtendsSub = new SynNotExtendsSub();
        com.sedion.mynawang.advanced._synchronized.pra8_synnotextends.ThreadC threadC =
                new com.sedion.mynawang.advanced._synchronized.pra8_synnotextends.ThreadC(synNotExtendsSub);
        threadC.setName("Thread-C");
        threadC.start();

        com.sedion.mynawang.advanced._synchronized.pra8_synnotextends.ThreadD threadD =
                new com.sedion.mynawang.advanced._synchronized.pra8_synnotextends.ThreadD(synNotExtendsSub);
        threadD.setName("Thread-D");
        threadD.start();
    }

    public static void main(String[] args) {
        PraSynchronized praSynchronized = new PraSynchronized();
        praSynchronized.testPra8_2();
    }


}
