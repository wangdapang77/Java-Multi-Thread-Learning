package com.sedion.mynawang.advanced._threadpool.pra1_threadpool4ways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程化的线程池（容量为1的缓冲池）（它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行）
 * @auther mynawang
 * @create 2016-12-30 15:01
 */
public class SingleThreadExecutor {

    private void testSingleThreadExecutor() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
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
        SingleThreadExecutor singleThreadExecutor = new SingleThreadExecutor();
        singleThreadExecutor.testSingleThreadExecutor();
    }
}
