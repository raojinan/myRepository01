package com.itan.thread;

/**
 * 自定义线程类
 *1.该线程继承Thread类线程类，重写了run方法，run方法里面就是我们自定义该线程需要执行的内容
 *2.程序需要执行该线程，需要在主线程下创建该线程对象（new 该自定义线程类），调用对象的start方法，就会在
 * 主线程下开启新的线程
 * @author raojinan
 * @version 1.0
 * @date 2021/8/9 16:46
 */
public class MyThread extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("执行了自定义线程");
        }

    }



}
