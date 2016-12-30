package com.sedion.mynawang.advanced._threadpool.pra1_threadpool4ways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定长线程池（可控制线程最大并发数，超出的线程会在队列中等待）
 * @auther mynawang
 * @create 2016-12-30 14:27
 */
public class FixedThreadPool {

    private void testFixedThreadPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("第" + taskId + "次任务的第" + j + "次执行任务");
                    }
                }
            });
        }
        // 任务执行完毕，关闭线程池
        threadPool.shutdown();
    }

    public static void main(String[] args) {
        FixedThreadPool fixedThreadPool = new FixedThreadPool();
        fixedThreadPool.testFixedThreadPool();
    }

}
