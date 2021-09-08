package com.itan.ThreadWaiting;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/10 16:42
 */
public class BaoZiPu extends Thread {
    private BaoZi baoZi;

    //包子铺构造方法
    public BaoZiPu(String name, BaoZi baoZi) {
        //子类可在自己的构造方法中使用super（）来调用父类的构造方法
        super(name);
        this.baoZi = baoZi;
    }

    //生产包子线程的执行体
    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                //如果有包子
                if (baoZi.baoStatus == true) {

                    //如果包子铺有包子，包子铺不做包子，等待吃货把包子吃完
                    try {
                        System.out.println("3.包子充足不做包子");
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

                try {
                    //如果没有包子就生产包子
                    baoZi.setPi("冰皮包子");
                    System.out.println("1.包子铺正在做包子");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi.setBaoStatus(true);
                //告诉吃包子线程可以吃了，别等了
                System.out.println("2.包子做好了");
                baoZi.notify();
            }
        }

    }
}
