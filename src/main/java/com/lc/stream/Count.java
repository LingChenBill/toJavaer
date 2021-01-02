package com.lc.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 统计流中的元素个数.
 * @description:
 * @author: lingchen
 * @date: 2021/1/2
 */
public class Count {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        System.out.println(strings.stream().count());
    }
}
