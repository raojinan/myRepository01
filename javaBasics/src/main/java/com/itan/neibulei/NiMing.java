package com.itan.neibulei;

/**
 * 匿名内部类
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/9 23:00
 */
public class NiMing {
    //用匿名内部类创建新线程，new Runnable接口代表接口的子类对象同时省去子类对象名
    //Runnable子类对象作为target传入Thread对象中入参，线程对象start,开启线程，执行run内部的代码
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类线程");
            }
        }).start();
    }
}
