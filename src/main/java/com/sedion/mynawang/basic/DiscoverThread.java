package com.sedion.mynawang.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @auther mynawang
 * @create 2016-09-05 9:45
 */
public class DiscoverThread {

    public static void main(String[] args) {
        // 获取Java线程管理Bean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }


    /*
     * 打印信息：
    [8]JDWP Command Reader
    [7]JDWP Event Helper Thread
    [6]JDWP Transport Listener: dt_socket
    [5]Attach Listener
    [4]Signal Dispatcher
    [3]Finalizer
    [2]Reference Handler
    [1]main
    */
}
