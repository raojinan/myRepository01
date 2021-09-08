package com.itan.ThreadWaiting;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/10 16:43
 */
public class Test {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        BaoZiPu baoZiPu = new BaoZiPu("包子铺", baoZi);
        Consumer consumer = new Consumer("消费者", baoZi);

        consumer.start();
        baoZiPu.start();


    }
}
