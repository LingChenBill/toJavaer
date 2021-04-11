package com.lc.reflex;

import java.io.*;
import java.util.Properties;

/**
 * 使用反射机制并结合属性文件的工厂模式(即IoC).
 * @description:
 * @author: lingchen
 * @date: 2021/4/11
 */
public class IoCFactory {

    public static void main(String[] args) throws IOException {
        // 获取属性文件.
        Properties pro = init.getPro();

        fruit f = IoC2Factory.getInstance(pro.getProperty("orange"));
        if (f != null) {
            f.eat();
        }
    }
}

/**
 * 操作属性文件类.
 */
class init {
    public static Properties getPro() throws IOException {
        Properties pro = new Properties();
        File f = new File("src/main/resources/fruit.properties");

        if (f.exists()) {
            pro.load(new FileInputStream(f));
        } else {
            pro.setProperty("apple", "com.lc.reflex.Apple");
            pro.setProperty("orange", "com.lc.reflex.Orange");
            pro.store(new FileOutputStream(f), "FRUIT CLASS");
        }

        return pro;
    }
}

/**
 * 反射类.
 */
class IoC2Factory {
    public static fruit getInstance(String className) {
        fruit f = null;

        try {
            f = (fruit)Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return f;
    }
}