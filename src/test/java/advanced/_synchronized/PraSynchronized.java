package advanced._synchronized;

import com.sedion.mynawang.advanced._synchronized.pra1_safewithout.SafeWithNoSynchronized;
import com.sedion.mynawang.advanced._synchronized.pra1_safewithout.ThreadA;
import com.sedion.mynawang.advanced._synchronized.pra1_safewithout.ThreadB;
import com.sedion.mynawang.advanced._synchronized.pra2_safewithsynchronized.SafeWithSynchronized;
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




}
