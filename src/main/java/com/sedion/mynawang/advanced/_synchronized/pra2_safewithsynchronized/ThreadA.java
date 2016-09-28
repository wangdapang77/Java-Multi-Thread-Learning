package com.sedion.mynawang.advanced._synchronized.pra2_safewithsynchronized;

import net.sourceforge.groboutils.junit.v1.TestRunnable;

/**
 * @auther mynawang
 * @create 2016-09-28 16:58
 */
public class ThreadA extends TestRunnable {
    private  SafeWithSynchronized safeWithSynchronized;

    public ThreadA(SafeWithSynchronized safeWithSynchronized) {
        this.safeWithSynchronized = safeWithSynchronized;
    }

    @Override
    public void runTest() throws Throwable {
        safeWithSynchronized.addNum1("mynawang");
    }
}
