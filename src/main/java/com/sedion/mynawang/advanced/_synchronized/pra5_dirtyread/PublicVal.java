package com.sedion.mynawang.advanced._synchronized.pra5_dirtyread;

/**
 * synchronized防止脏读
 * @auther mynawang
 * @create 2016-11-09 15:18
 */
public class PublicVal {

    public String userName = "MYNAWANG";

    public String userPwd = "MYNAWANG_PWD";

    public synchronized void setVal(String userName, String userPwd) {
        try {
            this.userName = userName;
            Thread.sleep(5000);
            this.userPwd = userPwd;
            System.out.println("setVal method thread name = " +
                Thread.currentThread().getName() + " userName = " +
                userName + " userPwd = " + userPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getVal() {
        System.out.println("getVal method thread name = " +
                Thread.currentThread().getName() + " userName = " +
                userName + " userPwd = " + userPwd);
    }

    public synchronized void getVal2() {
        System.out.println("getVal method thread name = " +
                Thread.currentThread().getName() + " userName = " +
                userName + " userPwd = " + userPwd);
    }


    /**
     * 总结：
     * 当A线程调用anyObject对象加了synchronized关键字的X方法时，A线程就获得了X方法锁，
     * 更准确地讲，是获得了对象的锁，所以其他线程必须等A线程执行完毕才可以调用X方法，
     * 但B线程可以所以调用其他的非synchronized同步方法
     *
     * 当A线程调用anyObject对象加了synchronized关键字的X方法时，A线程就获得了X方法所
     * 在方法的对象锁，所以其他线程必须等A线程执行完毕才可以调用X方法，而B线程如果调
     * 用声明了synchronized关键字的非X方法时，必须等A线程将X方法执行完，也就是释放对
     * 象锁后才可以调用。这时A线程已经执行了一个完整的任务，上述情况中userName和userPwd
     * 两个实例变量被同时赋值，不存在脏读的情况。
     */



}
