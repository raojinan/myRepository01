package com.itan.shejimoshi.proxy;

/**
 * 委托类，被代理类，真实的对象
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/13 16:20
 */
public class SellTicketsImpl02 implements SellTickets {


    @Override
    public void sell() {
        System.out.println("卖出电影票");
    }

    @Override
    public void money() {
        System.out.println("电影票扣费成功");

    }

    @Override
    public void sendMessage(String name) {
        System.out.println("尊敬的" + name + "先生/女生，你的电影票已经购买成功，请按时观影，谢谢！！");
    }


}
