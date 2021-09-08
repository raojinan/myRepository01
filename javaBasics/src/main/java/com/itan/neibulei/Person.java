package com.itan.neibulei;

import lombok.Getter;
import lombok.Setter;

/**
 * 内部类：描述一类事物时还包含其它对象
 * 内部类可以直接访问外部类的成员，包括私有成员。
 * 外部类要访问内部类的成员，必须要建立内部类的对象
 * @author raojinan
 * @version 1.0
 * @date 2021/8/9 22:49
 */
@Getter
@Setter
public class Person {
    private boolean live = true;

    class Heart{
        public void jump(){

            if (live){
                System.out.println("活着");
            }else {
                System.out.println("挂了");
            }
            //内部类可以调用外部类方法
            find();

        }

    }

    public void find(){
        System.out.println("外部类方法");
    }
}
