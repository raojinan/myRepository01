package com.itan.thread;

/**
 * 实现Runnable接口来创建线程类target对象
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/9 18:14
 */
public class MyRunnable implements Runnable {
    Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 100; i++) {
                System.out.println("实现Runnable接口创建线程类");
            }
        }


    }
}
