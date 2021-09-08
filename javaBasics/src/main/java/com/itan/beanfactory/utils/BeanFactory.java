package com.itan.beanfactory.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {

    public static Object getById(String id) {
        try {
            //创建SaxReader对象
            SAXReader saxReader = new SAXReader();
            //读取配置文件applicationContext.xml
            Document document = saxReader.read(BeanFactory.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
            //使用xpath语句获取id对应的bean标签
            Element element = (Element) document.selectSingleNode("//bean[@id='" + id + "']");
            //解析bean标签对应的属性值
            String id1 = element.attributeValue("id");
            System.out.println(id1);
            String className = element.attributeValue("class");
            System.out.println(className);
            //反射生成对象
            Object obj = Class.forName(className).newInstance();
            //返回
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
