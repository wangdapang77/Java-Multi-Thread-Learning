package com.sedion.mynawang.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 线程优先级（决定使用处理器资源的多少）
 * @auther mynawang
 * @create 2016-09-05 21:23
 * java线程中通过一个整型成员变量priority来控制优先级，优先级范围从1-10，
 * 在线程构建的时候可以通过setPriority(int)方法来修改优先级，默认优先级是5，
 * 优先级高的线程分配时间片的数量要多于优先级低的线程。
 */
public class PriorityThread {

    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < 10; i++) {
            // i小于5，优先级为1，大于5优先级为10
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            // 设置优先级
            Job job = new Job(priority);
            jobs.add(job);

            Thread thread = new Thread(job, "Thread: " + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        for (Job job : jobs) {
            System.out.println("Job Priority: " + job.priority + ", Count: " + job.jobCount);
        }
    }

    static class Job implements Runnable {
        private int priority;
        private long jobCount;
        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }


    /**
     * 线程优先级不能作为程序正确性的依赖，因为操作系统可以完全不用理会Java线程对于优先级的设定。
     */

}
