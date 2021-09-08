package com.itan.shejimoshi.proxy.cglib;

/**
 * 委托类，被代理类，真实的对象
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/13 16:20
 */
public class SellTicketsImpl03 {


    public void sell() {
        System.out.println("卖出足球票");
    }


    public void money() {
        System.out.println("足球票扣费成功");

    }


    public void sendMessage(String name) {
        System.out.println("尊敬的" + name + "先生/女生，你的足球票已经购买成功，请按时到场观看，谢谢！！");
    }


}
