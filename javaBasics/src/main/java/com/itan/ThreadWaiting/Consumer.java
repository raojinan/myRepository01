package com.itan.ThreadWaiting;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/10 16:42
 */
public class Consumer extends Thread {
    //BaoZi类属性，是为了入参对象锁，使得两个线程对象锁都是一致的
    private BaoZi baoZi;

    public Consumer(String name, BaoZi baoZi) {
        super(name);
        this.baoZi = baoZi;

    }

    //消费者线程吃包子的执行体
    @Override
    public void run() {
        //如果没有包子先等待包子铺做包子
        while (true) {


            synchronized (baoZi) {
                if (baoZi.baoStatus == false) {
                    try {
                        System.out.println("1.没包子吃，等待包子");
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //吃包子
                System.out.println("2.消费者吃包子");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi.setBaoStatus(false);
                //吃完包子告诉包子铺包子吃完了
                baoZi.notify();

            }
        }


    }


}
