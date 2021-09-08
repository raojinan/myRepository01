package com.itan.test;

import com.itan.domain.User;
import org.junit.Test;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/7/15 11:42
 */
public class StringTest {
    /**
     * 基本数据类型和引入数据类型比较 == 和equal
     * 基本数据类型：== 比较的是值是否相同
     * 引用数据类型 == 和equal 比较的是地址值是否相同，
     * 但是String，date，包装类用equal比较时，
     * 比较的这个类对象的实体内容是是否相同（因为包装类重写了equal方法改变了比较规则）
     */
    @Test
    public void test() {
        String s1 = new String("小");
        String s2 = new String("小");
        String a = "abc";
        String b = "abc";
        int a1 = 1;
        int a2 = 1;
        //true 如果比较的是基本数据类型变量：比较的是两个变量保存的数据是否相等。（不一定类型要相同）
        System.out.println(a1 == a2);
        //false  如果比较的是引用数据类型变量：比较的是两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
        System.out.println(s1 == (s2));
        //true String、Date、File、包装类、都重写了Object类的equals()方法，重写以后，比较的不是两个引用的地址是否相同，而是比较两个对象的“实体内容”是否相同。
        System.out.println(s1.equals(s2));
        User user = new User();
        User user1 = new User();

        user.setAge(1);
        user.setName("小强");

        user1.setName("小强");
        user1.setAge(1);
        // false 比较的是两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
        System.out.println(user.equals(user1));
        //false  这里==引用数据类型（类） 是 比较的是两个对象的地址值是否相同
        System.out.println(user == (user1));


    }

    /**
     * Sting 和StringBuffer和StringBuilder区别
     */
    @Test
    public void test01() {
        // String是不可而变字符序列，String 对象字符串在拼接的时候会在堆内存中创建一个新的对象，被拼接，拼接和拼接后的对象都会在内存中占用空间
        //简单的对字符串的修改却多次在堆内存开辟新的空间，效率低下且浪费内存空间，
        // StringBuffer和StringBuilder下字符串对象的修改只会修改其内容，不会因为修改而开辟新的内存空间
        String sr = "Hello";
        sr = sr + "word";
        //StringBuilder线程不安全，执行速度快，StringBuffer线程安全，执行速度相对慢
        // 多线程用StringBuffer
        StringBuffer stringBuffer = new StringBuffer("111");
        System.out.println(stringBuffer.append("222"));
        //将int 数据类型添加到可变字符串序列中
        System.out.println(stringBuffer.append(999));
        System.out.println(stringBuffer.append(true));

    }


}
