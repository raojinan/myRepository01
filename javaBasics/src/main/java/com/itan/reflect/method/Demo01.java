package com.itan.reflect.method;

import com.itan.reflect.Student;

import java.lang.reflect.Method;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/15 11:20
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //Class类对象
        Class<Student> studentClass = Student.class;
        //创建一个Student实例对象
        Student student = studentClass.newInstance();
        //从字节码对象中获取一个成员方法对象(根据方法名字，利用反射机制，从字节码文件对象中获取成员方法对象)
        Method sleep = studentClass.getMethod("sleep");

        /**
         * 成员方法对象 Method sleep调用invoke方法执行方法,
         * 入参是：方法所在类的对象，和方法需要的具体参数
         * 1.Object invoke(Object obj, Object... args)
         *   如果obj=null，则表示该方法是静态方法
         */
        sleep.invoke(student);
        Method eat = studentClass.getMethod("eat", String.class);
        eat.invoke(student, "小强");


    }
}
