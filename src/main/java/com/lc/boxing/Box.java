package com.lc.boxing;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本数据类型与对应的类-包装类.
 * @description:
 * @author: lingchen
 * @date: 2020/12/20
 */
@Log
public class Box {

    /**
     * byte -> Byte
     * boolean -> Boolean
     * short -> Short
     * char -> Character
     * int -> Integer
     * long -> Long
     * float -> Float
     * double -> Double
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // 把基本数据类型放入集合类中的时候,会进行自动装箱.
//            list.add(Integer.valueOf(i));
            list.add(i);
        }
        log.info(list.toString());

        // 包装类与基本数据类型进行比较运算,是先将包装类进行拆箱成基本数据类型,然后进行比较的.
        Integer a = 1;
        log.info(a == 1 ? "等于": "不等于");
        Boolean bool = false;
        log.info(bool ? "真" : "假");

        // 两个包装类型之间的运算,会被自动拆箱成基本类型进行.
        Integer i = 10;
        Integer j = 20;
        log.info(String.valueOf(i + j));

        // 三目运算符的语法规范,当第二,第三操作数分别为基本类型和对象时,其中的对象就会拆箱为基本数据类型进行操作.
        // 有可能为出现NPE空指针Bug.
        boolean flag = true;
        Integer i1 = 0;
        int j1 = 1;
        // Integer i1 = null;
        // Integer j1 = null;

        // i1.intValue()
        int k = flag ? i1 : j1;
        log.info(String.valueOf(k));
    }
}
