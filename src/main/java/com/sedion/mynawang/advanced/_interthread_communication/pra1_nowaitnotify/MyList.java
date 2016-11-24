package com.sedion.mynawang.advanced._interthread_communication.pra1_nowaitnotify;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther mynawang
 * @create 2016-11-24 14:46
 */
public class MyList {

    private List list = new ArrayList();

    public void add() {
        list.add("mynawang");
    }

    public int size() {
        return list.size();
    }

    /**
     * ThreadA和ThreadB实现了线程间的通信，但是比较大的问题是ThreadB使用while语句轮询来检测list.size，很浪费cpu资源
     *
     * 调整轮询，时间间隔小会更浪费cpu，轮询时间间隔小，由于ThreadA的执行，可能会取不到想要的数据
     */


}
