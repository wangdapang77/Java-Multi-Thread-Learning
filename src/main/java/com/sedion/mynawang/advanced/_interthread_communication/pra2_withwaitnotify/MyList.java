package com.sedion.mynawang.advanced._interthread_communication.pra2_withwaitnotify;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther mynawang
 * @create 2016-11-24 14:46
 */
public class MyList {

    private static List list = new ArrayList();

    public static void add() {
        list.add("mynawang");
    }

    public static int size() {
        return list.size();
    }



}
