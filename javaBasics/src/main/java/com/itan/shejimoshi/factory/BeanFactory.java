package com.itan.shejimoshi.factory;

import com.itan.domain.Consumer;
import com.itan.domain.User;

import java.util.ResourceBundle;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/17 21:55
 */
public class BeanFactory {

    public static Object getBean(String key) {

          /*public static Object getBean(String className){
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }*/

        //解析beans.properties,根据key获取全限定名
        //获取项目中名字为beans.properties的文件
        ResourceBundle bundle = ResourceBundle.getBundle("beans");
        //获取文件中配置的key文件的路劲(例如：userService；userService=com.itan.travel.service.impl.UserServiceImpl)
        String className = bundle.getString(key);
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
