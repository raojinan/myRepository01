package com.itan.thread;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/9 17:18
 */
public class TestMyThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //开启新线程，在栈内存中开辟新的内存空间执行线程对象的run方法
        myThread.start();
        //方法二，实现Runnable接口来创建线程类
        //该Thread对象(threadRunnable)才是真正的线程对象
        MyRunnable myRunnable = new MyRunnable();
        Thread threadRunnable = new Thread(myRunnable);
        //主线要执行的内容
        threadRunnable.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("执行了主线程");
        }


    }
}
