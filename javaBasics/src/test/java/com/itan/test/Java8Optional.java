package com.itan.test;

import org.junit.Test;

import java.util.Optional;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/8 22:21
 */
public class Java8Optional {

    /**
     * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
     * Optional 类的引入很好的解决空指针异常。
     * Optional.of(T t)：创建一个 Optional 实例
     * Optional.empty(T t)：创建一个空的 Optional 实例
     * Optional.ofNullable(T t)：若 t 不为 null，创建 Optional 实例，否则空实例
     * map(Function f)：如果有值对其处理，并返回处理后的 Optional，否则返回 Optional.empty()
     * flatmap(Function mapper)：与 map 相似，要求返回值必须是 Optional
     */
    @Test
    public void test01() {


    }

    /**
     * isPresent()：判断是否包含某值,为null返回false，不为null返回true
     */
    @Test
    public void test02() {
        Optional<String> op = Optional.ofNullable(new String("123"));
        if (op.isPresent()) {
            System.out.println(op.get());
        }
        Optional<Object> op2 = Optional.ofNullable(null);
        if (op2.isPresent()) {

        }else {
            System.out.println("op2是null");
        }
    }

    /**
     *   orElse(T t)：如果调用对象包含值，返回该值，否则返回 t
     *   orElseGet(Supplier s)：如果调用对象包含值，返回该值，否则返回 s 获取的值
     */
    @Test
    public void test03(){
        Optional<String> op = Optional.ofNullable(new String("123"));
        Optional<String> op1 = Optional.ofNullable(null);
        System.out.println(op.orElse("1"));
        System.out.println(op1.orElse("1"));


    }
}
