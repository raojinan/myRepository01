package com.itan.thread;

/**
 * 无限等待的线程状态Demon
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/10 15:40
 */
public class WaitingBlocked {
    public static Object object = new Object();

    public static void main(String[] args) {
        /**
         * 主线程开启，线程a.start开启新线程，获取锁对象，调用锁对象的waite方法，a线程进入无限等待状态，等待唤醒
         * 线程b也开启了线程处于runnable状态，获取同样的锁对象，执行完线程执行体代码，调用锁对象的notify,激活无限等待状态的线程a
         */

        //线程a
        new Thread(new Runnable() {
            @Override
            public void run() {

                    synchronized (object) {
                        try {
                            System.out.println("执行wait方法a线程进入无限等待状态");
                            object.wait();
                            System.out.println("线程a获取锁，苏醒过来，代码执行了");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


            }

        }).start();

        //线程b
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程b等待10秒");
                    Thread.sleep(10000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object) {
                    System.out.println("线程b获取到锁对象，执行了线程执行体");
                    object.notifyAll();
                    System.out.println("调用notify对象，释放锁对象");
                }

            }
        }).start();
    }
}
