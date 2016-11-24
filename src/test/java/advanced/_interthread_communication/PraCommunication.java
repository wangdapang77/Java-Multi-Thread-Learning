package advanced._interthread_communication;

import com.sedion.mynawang.advanced._interthread_communication.pra1_nowaitnotify.MyList;
import com.sedion.mynawang.advanced._interthread_communication.pra1_nowaitnotify.ThreadA;
import com.sedion.mynawang.advanced._interthread_communication.pra1_nowaitnotify.ThreadB;

/**
 * @auther mynawang
 * @create 2016-11-24 15:42
 */
public class PraCommunication {

    public void testPra1_1() {
        try {
            MyList myList = new MyList();
            ThreadA threadA = new ThreadA(myList);
            threadA.setName("therad-A");
            threadA.start();
            ThreadB threadB = new ThreadB(myList);
            threadB.setName("thread-B");
            threadB.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            PraCommunication praCommunication = new PraCommunication();
            praCommunication.testPra1_1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
