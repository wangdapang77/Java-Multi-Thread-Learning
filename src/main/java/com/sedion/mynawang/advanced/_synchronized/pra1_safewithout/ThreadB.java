package com.sedion.mynawang.advanced._synchronized.pra1_safewithout;

import net.sourceforge.groboutils.junit.v1.TestRunnable;

/**
 * @auther mynawang
 * @create 2016-09-28 16:58
 */
public class ThreadB extends TestRunnable {
    private  SafeWithNoSynchronized safeWithNoSynchronized;

    public ThreadB(SafeWithNoSynchronized safeWithNoSynchronized) {
        this.safeWithNoSynchronized = safeWithNoSynchronized;
    }

    @Override
    public void runTest() throws Throwable {
        safeWithNoSynchronized.addNum("mynawang2");
    }
}
