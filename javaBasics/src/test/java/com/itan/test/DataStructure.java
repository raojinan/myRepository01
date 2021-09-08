package com.itan.test;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/7/26 17:48
 * 数据结构
 */
public class DataStructure {
    //list:元素可以重复，保证元素顺序，有下标
    @Test
    public void test01() {
        /**
         * list集合是有序的集合，元素可以重复，有索引,通过索引查询删除元素，其中常用
         * 的实现类有Arraylist和LinkedList ，
         * Arraylist：线程不安全，底层是数组的数据结构，所以查询快增删慢
         * LinkedList:线程不安全，底层是链表数据结构。所以增删快查询
         */
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(0, "0元素");
        arrayList.add(1, "01元素");
        arrayList.add(2, "02元素");
        arrayList.add(3, "03元素");
        arrayList.add(4, "04元素");
        System.out.println(arrayList.get(2));
        arrayList.remove(1);
        // System.out.println(arrayList.get(2));
        //--------------------------------------------------
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(0, "零元素");
        linkedList.add(1, "零元素");
        linkedList.add(2, "二元素");
        //System.out.println(linkedList.get(2));
        for (String s : linkedList) {
            System.out.println(s);
        }


    }

    //set：保证对象唯一
    @Test
    public void test02() {
        /**
         * set：不能保存重复的元素,主要的实现类是，HashSet,LinkedHashset,TreeSet
         * hashSet:底层是哈希表，保证对象唯一(原因在于使用对象的hashCode和equal方法)，不能保证迭代顺序,线程不安全
         * LinkedSet:底层使用哈希表+链表，保证对象唯一，可以保证存取顺序 线程不安全
         * TreeSet:  底层是二叉树结构，可以对存放对象从小到大排序，保证对象唯一(底层实现了comparable接口)，线程不安全
         */
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("set0元素");
        hashSet.add("set1元素");
        //同一个元素会被覆盖
        hashSet.add("set2元素");
        hashSet.add("set2元素");
        hashSet.remove("set2元素");
        //没有下标的可以用迭代器把元素遍历出来
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            String nextSet = iterator.next();
            System.out.println(nextSet);
        }


    }

    /**
     * Map双列集合：保存对应关系的数据，所以key是唯一的，value可以重复，主要的实现类：HashMap,TreeMap,HashTable
     * HashTable线程安全
     */

    @Test
    public void dataHasMap() {
        //HashMap
        HashMap<java.lang.String, java.lang.String> nameHasMap = new HashMap<>();
        nameHasMap.put("1", "小强");
        nameHasMap.put("2", "小强");
        nameHasMap.put("3", "小红");
        nameHasMap.put("4", "小红");
        nameHasMap.put("5", "小红");
        nameHasMap.put("6", "小红");
        nameHasMap.put("7", "小红");
        nameHasMap.put("8", "小红");
        nameHasMap.put("9", "小红");
        nameHasMap.put("10", "小红");
        nameHasMap.put("11", "小红");
        nameHasMap.put("重地", "小与");
        nameHasMap.put("通话", "检索技术");
     /*
        nameHasMap.put("12", "小红");
        nameHasMap.put("13", "小红");
        nameHasMap.put("14", "小红");
        nameHasMap.put("15", "小红");


        System.out.println("通话".hashCode());*/
        System.out.println("重地".hashCode());
        try {
            Class<?> mapType = nameHasMap.getClass();
            Method capacity = mapType.getDeclaredMethod("capacity");
            capacity.setAccessible(true);
            //打印hashmap的容量和
            System.out.println("capacity : " + capacity.invoke(nameHasMap) + "    size : " + nameHasMap.size());

        } catch (Exception e) {
            System.out.println(e);
        }

        //get方法
        String s = nameHasMap.get("11");
        System.out.println(s);


    }


    /**
     * Java hashCode() 方法 返回对象的哈希码值，
     * String  同一个字符内容的哈希码值相同，
     * Integer 值就是它的哈希码值
     * hashCode() 方法用于返回字符串的哈希码。字符串对象的哈希码根据以下公式计算：
     * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
     */
    @Test
    public void testHashCode() {
        String stringName = new String("你好");
        //String stringName1 = new String("你好");
        //int int1 = new Integer(1).hashCode();
        //int int2 = new Integer(1).hashCode();
        int i = stringName.hashCode();
        //int i1 = stringName1.hashCode();
        System.out.println(i);
        // System.out.println(i1);
        //System.out.println(int1);
        //System.out.println(int2);

    }
    //位移
    @Test
    public void testWeiyi() {
        int a=16;
        System.out.println(a << 1);



    }


}
