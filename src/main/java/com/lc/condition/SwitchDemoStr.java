package com.lc.condition;

import lombok.extern.java.Log;

/**
 * Switch对字符串支持的实现.
 * @description: switch对字符串类型进行比较的时候,
 *      实际上通过equals()和hashCode()方法来实现的.
 *      switch只支持一种数据类型,那就是整形,其他数据类型都是转换成整形之后再使用switch的.
 * @author: lingchen
 * @date: 2020/12/20
 */
@Log
public class SwitchDemoStr {

    public static void main(String[] args) {
        String a = "world";
        switch (a) {
            case "hello":
                log.info("hello");
                break;
            case "world":
                log.info("world");
                break;
            default:
                break;
        }
    }
}
