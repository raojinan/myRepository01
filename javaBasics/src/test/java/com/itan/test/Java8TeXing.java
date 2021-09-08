package com.itan.test;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java8新特性
 * 1.Lambda 表达式
 * 2.Optional 类
 * 3.日期时间 API
 * 4.Stream API
 *https://www.cnblogs.com/liuxiaozhi23/p/10880147.html
 * @author raojinan
 * @version 1.0
 * @date 2021/8/8 11:52
 */
public class Java8TeXing {
    /**
     * lambda表达式
     */
    @Test
    public void test01() {


    }


    @Test
    public void test02() {




    }

    /**
     * 日期时间 API,之前的date是线程不安全；
     * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
     * 1.Local(本地) − 简化了日期时间的处理，没有时区的问题。
     * 2.Zoned(时区) − 通过制定的时区处理日期时间。
     * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作
     */
    @Test
    public void test03() {
        //表示日期的LocalDate
        //表示时间的LocalTime
        //表示日期时间的LocalDateTime
        //获取当前日期,只含年月日 固定格式 yyyy-MM-dd    2018-05-04
        LocalDate today = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime now = LocalDateTime.now();
        System.out.println(today);
        System.out.println(localTime);
        System.out.println(now);


    }

    @Test
    public void test031() {


    }

    /**
     * Stream API
     * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据
     * 这种风格将要处理的元素集合看作一种流，流在管道中传输，并且可以在管道的节点上进行处理，比如筛选，排序，聚合等。
     * 流的转换：
     * 1.filter方法；过滤转换，此方法会产生一个新的流，流中包含符合某些特定条件的元素
     * 2.limit方法：
     * 3.skip方法，
     * 4.sorted（排序）方法和distinct(去重)
     */
    @Test
    public void test04() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        /*strings.stream().filter();
        strings.stream().sorted()
        strings.stream().collect()*/
    }

    /**
     * filter ,过滤转换
     */
    @Test
    public void test05() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        List<Integer> integerList = arrayList.stream().filter(integer -> integer >= 3).collect(Collectors.toList());
        System.out.println(integerList);


    }

    @Test
    public void test06() {
        List<Integer> myList = Lists.newArrayList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        //limit(n)方法会返回一个包含n个元素的新的流（若总长小于n则返回原始流）
        List<Integer> afterLimit = myList.stream().limit(5).collect(Collectors.toList());
        System.out.println("afterLimit:" + afterLimit);
        //skip(n)方法正好相反，它会丢弃掉前面的n个元素
        List<Integer> afterSkip = myList.stream().skip(4).collect(Collectors.toList());
        System.out.println("afterSkip：" + afterSkip);

    }

    /**
     * 1.distinct方法会根据原始流中的元素返回一个具有相同顺序、去除了重复元素的流，这个操作显然是需要记住之前读取的元素。
     * 2.sorted方法是需要遍历整个流的，并在产生任何元素之前对它进行排序。
     */

    @Test
    public void test07() {
        List<Integer> myList = Lists.newArrayList();
        myList.add(1);
        myList.add(31);
        myList.add(7);
        myList.add(10);
        myList.add(199);
        myList.add(7);
        //去重
        List<Integer> collectDistinct = myList.stream().distinct().collect(Collectors.toList());
        System.out.println(collectDistinct);
        //不去重排序
        List<Integer> integerList = myList.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(integerList);
        //去重排序
        List<Integer> paiXun = myList.stream().distinct().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(paiXun);


    }

    /**
     * 聚合操作:流的转换就是将流过滤，排序等，集合便是将流聚合为一个值，以便在程序中使用。聚合操作是终止操作。
     * 1.max方法和min方法，分别返回流中最大值和最小值
     * 2.findFirst方法返回非空集合中的第一个值，它通常与filter方法结合起来使用。
     * 3.findAny方法可以在集合中只要找到任何一个所匹配的元素，就返回，此方法在对流并行执行时十分有效（任何片段中发现第一个匹配元素都会结束计算，串行流中和findFirst返回一样)
     * 4.anyMatch方法可以判定集合中是否还有匹配的元素。返回结果是一个boolean类型值。
     */
    @Test
    public void test08() {
        List<Integer> hearList = Lists.newArrayList();
        hearList.add(15);
        hearList.add(32);
        hearList.add(5);
        hearList.add(232);
        hearList.add(56);
        hearList.add(29);
        hearList.add(94);
        Integer maxItem = hearList.stream().max(Integer::compareTo).get();
        Integer minItem = hearList.stream().min(Integer::compareTo).get();
        System.out.println("max:" + maxItem + "，min:" + minItem);
        //符合条件的非空集合的第一个
        Integer first = hearList.stream().filter(i -> i > 100).findFirst().get();
        //在集合中只要找到任何一个所匹配的元素，就返回，此方法在对流并行执行时十分有效
        Integer anyItem = hearList.parallelStream().filter(i -> i > 100).findAny().get();
        //anyMatch方法,可以判定集合中是否还有匹配的元素。返回结果是一个boolean类型值
        boolean isHas = hearList.parallelStream().anyMatch(i -> i > 100);
        //


    }

    /**
     * 收集聚合：分别收集流的总和、平均值、最大值或者最小值
     */
    @Test
    public void test09() {
        List<Integer> hereList = Lists.newArrayList();
        hereList.add(15);
        hereList.add(32);
        hereList.add(5);
        hereList.add(232);
        hereList.add(56);
        hereList.add(29);
        hereList.add(104);

        //总和、平均值，最大值，最小值
        int sum = hereList.stream().collect(Collectors.summingInt(Integer::intValue));
        Double ave = hereList.stream().collect(Collectors.averagingInt(Integer::intValue));
        Integer max = hereList.stream().collect(Collectors.maxBy(Integer::compare)).get();
        Integer min = hereList.stream().collect(Collectors.minBy(Integer::compare)).get();
        System.out.println("sum:" + sum + ",ave:" + ave + ",max:" + max + ",min:" + min);

    }

    /**
     * 映射:map/flatMap映射 把 Stream中 的每一个元素，映射成另外一个元素。
     */
    @Test
    public void test10() {
        List<String> list = Arrays.asList("a", "b", "c");
        //把list流中的元素按照变成大写规则映射形成含有新元素的集合
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
        List<String> stringList = list.stream()
                .map((str) -> str.toUpperCase()).collect(Collectors.toList());


    }


}
