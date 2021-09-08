package com.itan.springAOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/16 15:28
 */
@Aspect
@Component
public class MyAspect {
    /**
     * 定义需要拦截的东西，这里介绍两个常用的表达式：一个是使用 execution()，另一个是使用 annotation()。
     * 1.以 execution(* com.mutest.controller..*.*(..))) 表达式为例：
     * 第一个 * 号的位置：表示返回值类型，* 表示所有类型。
     * 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，在本例中指 com.mutest.controller包、子包下所有类的方法。
     * 第二个 * 号的位置：表示类名，* 表示所有类。
     * *(..)：这个星号表示方法名，* 表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
     * 2.annotation() 方式是针对某个注解来定义切点，比如我们对具有 @PostMapping 注解的方法做切面，可以如下定义切面,也可以
     * 自定义注解
     */

    @Before("execution(* com.itan.springAOP..AopController.save(..))")
    public void pointCut() {
        System.out.println("执行了execution的拦截方法");
    }

    //切入点的方法:所有被PostMapping注解修饰的方法都会被advice通知
    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void checkPrivilege() {
        System.out.println("get请求权限校验了");
    }

    @Before("@annotation(com.itan.springAOP.PermissionAnnotation)")
    public void checkPrivilege01() {
        System.out.println("PermissionAnnotation注解方法校验了");
    }





  /*  //切点通知的执行时间
    @Before("checkPrivilege()")
    public void adviceTime() {
        System.out.println("get请求权限校验了");
l
    }*/
}
