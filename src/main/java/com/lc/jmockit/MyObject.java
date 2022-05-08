package com.lc.jmockit;

/**
 * @author: lingchen
 * @date: 2022/5/8
 */
public class MyObject {

    // 对象私有属性.
    private String name = "name_init";

    public String getName() {
        return name;
    }

    // 静态私有属性.
    private static String className = "Class3Mocked_init";

    public static String getClassName() {
        return className;
    }

    public String hello(String name) {
        return "Hello " + name;
    }

    // 静态方法.
    public static int getDouble(int num) {
        return num * 2;
    }

    // 方法中有私有方法调用.
    public String getTripleString(int num) {
        int retNumber = multiply3(num);
        return String.valueOf(retNumber);
    }

    private int multiply3(int num) {
        return num * 3;
    }

}
