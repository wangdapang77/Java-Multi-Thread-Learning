package com.sedion.mynawang.advanced._threadpool.pra1_threadpool4ways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存线程池（如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程）
 * @auther mynawang
 * @create 2016-12-30 14:27
 */
public class CachedThreadPool {

    private void testCachedThreadPool() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
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
        CachedThreadPool cachedThreadPool = new CachedThreadPool();
        cachedThreadPool.testCachedThreadPool();
    }

}
