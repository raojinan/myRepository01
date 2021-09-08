package com.itan.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/3 11:29
 */
public class ListTest {
    @Test
    public void  test01(){
        /**
         * list集合是有序的集合，元素可以重复，有索引
         */
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(0,"0元素");
        arrayList.add(1,"01元素");
        arrayList.add(2,"02元素");
        arrayList.add(3,"03元素");
        arrayList.add(4,"04元素");
        System.out.println(arrayList.get(2));
        arrayList.remove(1);
        System.out.println(arrayList.get(2));
        //--------------------------------------------------
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(0,"零元素");
        linkedList.add(1,"零元素");
        linkedList.add(2,"二元素");
        System.out.println(linkedList.get(2));


    }
}
