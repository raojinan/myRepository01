package com.itan.shejimoshi.proxy;

/**
 * 静态代理
 * 代理类对象：实现一个接口（这个接口也是委托者实现的接口，重写接口方法+包含委托者的对象(创建实例对象，调出委托者方法)
 * 在重写接口方法上增强方法，同时又调用委托者方法达到对方法的增强和避免对委托者源码的改造
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/13 16:22
 */
public class ProxySellTickets implements SellTickets {
    private SellTicketsImpl sellTickets;

    @Override
    public void sell() {
        if (sellTickets == null) {
            sellTickets = new SellTicketsImpl();
        }
        System.out.println("卖票前先验证用户是不是黄牛");
        sellTickets.sell();

    }

    @Override
    public void money() {

    }

    @Override
    public void sendMessage(String name) {
        sellTickets.sendMessage(name);
    }
}
