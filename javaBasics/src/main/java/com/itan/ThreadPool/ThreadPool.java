package com.itan.ThreadPool;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/10 22:21
 */
public class ThreadPool {

    public static void main(String[] args) {
        /**
         * 1.corePoolSize（必需）：核心线程数。默认情况下，核心线程会一直存活，但是当将 allowCoreThreadTimeout 设置为 true 时，核心线程也会超时回收。
         * 2.maximumPoolSize（必需）：线程池所能容纳的最大线程数。当活跃线程数达到该数值后，后续的新任务将会阻塞
         * 3.keepAliveTime（必需）：线程闲置超时时长。如果超过该时长，非核心线程就会被回收。如果将 allowCoreThreadTimeout 设置为 true 时，核心线程也会超时回收
         * 4.unit（必需）：指定 keepAliveTime 参数的时间单位。常用的有：TimeUnit.MILLISECONDS（毫秒）、TimeUnit.SECONDS（秒）、TimeUnit.MINUTES（分）。
         * 5.workQueue（必需）：任务队列。通过线程池的 execute() 方法提交的 Runnable对象将存储在该参数中。其采用阻塞队列实现。
         * 当核心线程数达到最大时，新任务会放在队列中排队等待执行(任务队列可选)
         * 6.threadFactory（可选）：线程工厂。用于指定为线程池创建新线程的方式。
         * 7.handler（可选）：拒绝策略。当达到最大线程数时需要执行的饱和策略。
         * https://blog.csdn.net/u013541140/article/details/95225769?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162907902216780265444377%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=162907902216780265444377&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-95225769.ecpm_v1_rank_v29&utm_term=%E7%BA%BF%E7%A8%8B%E6%B1%A0&spm=1018.2226.3001.4187
         */
        //任务队列
        LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue();
        //线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8, 1, TimeUnit.SECONDS, linkedTransferQueue);
        MyThread myThread = new MyThread();
        //向线程池提交任务
        threadPoolExecutor.execute(myThread);
        threadPoolExecutor.execute(myThread);
        threadPoolExecutor.execute(myThread);
        threadPoolExecutor.execute(myThread);


    }
}
