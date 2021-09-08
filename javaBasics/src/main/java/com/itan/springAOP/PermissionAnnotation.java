package com.itan.springAOP;

import java.lang.annotation.*;

/**
 * 自定义注解（）
 * 1.元注解：@Target指明此注解用在哪个位置，如果不写默认可以用在任何位置上
 * TYPE：用在类,接口上
 * FIELD：用在成员变量上
 * METHOD：用在方法上
 * PARAMETER：用在参数上
 * CONSTRUCTOR：用在构造方法上
 * LOCAL_VARIABLE：用在局部变量上
 * 2.元注解：@Retention定义注解生命周期
 * SOURCE：注解只存在于Java源代码中，编译生成的字节码文件中就不存在了
 * CLASS：注解存在于Java源代码、编译以后的字节码文件中，运行的时候内存中没有，默认值
 * RUNTIME：注解存在于Java源代码中、编译以后的字节码文件中、运行时内存中，程序可以通过反射获取该注解
 * @author raojinan
 * @version 1.0
 * @date 2021/8/17 10:27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionAnnotation {

}
