package com.itan.beanfactory.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory02 {

    private static Map<String, Object> beansMap;

    static {
        try {
            beansMap = new HashMap<String, Object>(2);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(BeanFactory02.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
            List<Element> elements = document.selectNodes("//bean");
            for (Element element : elements) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                Object obj = Class.forName(className).newInstance();
                beansMap.put(id,obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getById(String id) {
        return beansMap.get(id);
    }
}
