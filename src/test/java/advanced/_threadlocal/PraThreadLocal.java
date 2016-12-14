package advanced._threadlocal;

import com.sedion.mynawang.advanced._threadlocal.pra2_checkthreadlocal.ThreadA;
import com.sedion.mynawang.advanced._threadlocal.pra2_checkthreadlocal.ThreadB;

/**
 * @auther mynawang
 * @create 2016-12-14 11:08
 */
public class PraThreadLocal {

    public void testPra2() {
        try {
            ThreadA threadA = new ThreadA();
            threadA.start();
            Thread.sleep(1000);
            ThreadB threadB = new ThreadB();
            threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        PraThreadLocal praThreadLocal = new PraThreadLocal();
        praThreadLocal.testPra2();
    }

}
