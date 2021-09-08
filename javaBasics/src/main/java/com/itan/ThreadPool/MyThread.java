package com.itan.ThreadPool;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/11 9:53
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("多线程执行资源");
    }
}
