package com.sedion.mynawang.advanced._threadlocal.pra4_inheritablethreadlocal;

/**
 * @auther mynawang
 * @create 2016-12-14 21:33
 */
public class RunServer {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("        在main线程中取值：" + Tools.inheritableThreadLocalExpland.get());
                Thread.sleep(1000);
            }
            Thread.sleep(5000);
            ThreadA threadA = new ThreadA();
            threadA.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 当注释InheritableThreadLocalExpland类中的childValue方法,打印如下：
     *
     *
             在main线程中取值：1481722602598
             在main线程中取值：1481722602598
             在main线程中取值：1481722602598
             在main线程中取值：1481722602598
             在main线程中取值：1481722602598
             在main线程中取值：1481722602598
             在main线程中取值：1481722602598
             在main线程中取值：1481722602598
             在main线程中取值：1481722602598
             在main线程中取值：1481722602598
     ThreadA线程中取值=1481722602598
     ThreadA线程中取值=1481722602598
     ThreadA线程中取值=1481722602598
     ThreadA线程中取值=1481722602598
     ThreadA线程中取值=1481722602598
     ThreadA线程中取值=1481722602598
     ThreadA线程中取值=1481722602598
     ThreadA线程中取值=1481722602598
     ThreadA线程中取值=1481722602598
     ThreadA线程中取值=1481722602598

     可以让ThreadA子线程从父线程（Main）中取得值1481722602598


     当恢复InheritableThreadLocalExpland类中的childValue方法,打印如下：

             在main线程中取值：1481722770566
             在main线程中取值：1481722770566
             在main线程中取值：1481722770566
             在main线程中取值：1481722770566
             在main线程中取值：1481722770566
             在main线程中取值：1481722770566
             在main线程中取值：1481722770566
             在main线程中取值：1481722770566
             在main线程中取值：1481722770566
             在main线程中取值：1481722770566
     ThreadA线程中取值=1481722770566子线程加值
     ThreadA线程中取值=1481722770566子线程加值
     ThreadA线程中取值=1481722770566子线程加值
     ThreadA线程中取值=1481722770566子线程加值
     ThreadA线程中取值=1481722770566子线程加值
     ThreadA线程中取值=1481722770566子线程加值
     ThreadA线程中取值=1481722770566子线程加值
     ThreadA线程中取值=1481722770566子线程加值
     ThreadA线程中取值=1481722770566子线程加值
     ThreadA线程中取值=1481722770566子线程加值

     InheritableThreadLocal类中的childValue方法为protected的
     所以InheritableThreadLocalExpland类中的childValue方法直接覆盖了父类方法
     子线程ThreadA得到的是childValue

     注意：如果子线程在取得值的同时，主线程将InheritableThreadLocal中的值进行更改，那么子线程取得的值还是旧值
     */


}
