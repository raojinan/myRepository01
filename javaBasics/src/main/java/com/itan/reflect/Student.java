package com.itan.reflect;

import lombok.Getter;
import lombok.Setter;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/15 11:14
 */
@Setter
@Getter
public class Student {
    private String name;
    private String gender;
    private int age;

    public Student() {
    }


    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void sleep() {
        System.out.println("睡觉了。。。");
    }
    public void eat(String name) {
        System.out.println(name+"吃饱了");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
