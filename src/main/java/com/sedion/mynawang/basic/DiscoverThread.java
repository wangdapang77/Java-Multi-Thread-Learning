package com.sedion.mynawang.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 初识线程
 * @auther mynawang
 * @create 2016-09-05 9:45
 * 一个java程序的运行不仅仅是main()方法的运行，而是main线程和多个其他线程的同时运行。
 */
public class DiscoverThread {

    public static void main(String[] args) {
        // 获取Java线程管理Bean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
           // System.out.println(threadInfo.toString());
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }

    /*
     * Debug打印信息：
    [8]JDWP Command Reader
    // JDWP是通讯交互协议，它定义了调试器和被调试程序之间传递信息的格式。
    [7]JDWP Event Helper Thread
    // 该线程是一个Java Debugger的监听器线程，负责受理客户端的debug请求。通常习惯将它的监听端口设置为8787
    [6]JDWP Transport Listener: dt_socket

    // Attach Listener 线程是负责接收到外部的命令，而对该命令进行执行的并且把结果返回给发送者。
    [5]Attach Listener
    // Attach Listener接收外部的命令后交给Singal Dispatcher线程进行分发到各个不同的模块处理命令并且返回处理结果。
    [4]Signal Dispatcher
    // 主要用于垃圾收集前，调用对象的finalize()方法
    [3]Finalizer
    // JVM在创建main线程后就创建Reference Handler线程，其优先级最高，为10，它主要用于处理引用对象本身（软引用、弱引用、虚引用）的垃圾回收问题。
    [2]Reference Handler
    // main线程，用户程序入口
    [1]main
    */
}
