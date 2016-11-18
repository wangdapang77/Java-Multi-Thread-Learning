package advanced._volatile;

import com.sedion.mynawang.advanced._volatile.pra1_dropdead.PrintServer;
import com.sedion.mynawang.advanced._volatile.pra1_dropdead.PrintServerThread;
import com.sedion.mynawang.advanced._volatile.pra1_dropdead.PrintServerVolatile;
import com.sedion.mynawang.advanced._volatile.pra2_atomicity.VolatileThread;
import com.sedion.mynawang.advanced._volatile.pra2_atomicity.VolatileThreadSyn;

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


    public static void main(String[] args) {
        PraVolatile praVolatile = new PraVolatile();
        praVolatile.testPra2_2();
    }



}
