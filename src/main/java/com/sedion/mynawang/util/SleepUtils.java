package com.sedion.mynawang.util;

import java.util.concurrent.TimeUnit;

/**
 * 休眠工具
 * @auther mynawang
 * @create 2016-09-05 22:25
 */
public class SleepUtils {
    // 休眠相应的时间
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
