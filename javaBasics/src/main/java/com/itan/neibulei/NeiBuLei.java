package com.itan.neibulei;

/**
 * 内部类可以直接访问外部类的成员，包括私有成员。
 * 外部类要访问内部类的成员，必须要建立内部类的对象
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/9 22:46
 */
public class NeiBuLei {
    public static void main(String[] args) {
        //创建外部类
        Person person = new Person();
        //创建内部类对象
        Person.Heart heart = person.new Heart();
        //调用内部类的方法
        heart.jump();
        //调用外部类方法
        person.setLive(false);
        heart.jump();



    }
}
