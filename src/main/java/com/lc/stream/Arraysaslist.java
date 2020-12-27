package com.lc.stream;


import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的创建.
 * @description: Stream的特点
 *               无存储, 为函数式编程而行, 惰式执行, 可消费性.
 * @author: lingchen
 * @date: 2020/12/27
 */
@Log
public class Arraysaslist {

    public static void main(String[] args) {

        // 通过已有的集合来创建流.
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        Stream<String> stream = strings.stream();

        // Stream: java.util.stream.ReferencePipeline$Head@4617c264
        log.info("Stream: " + stream);

        // 通过Stream创建流.
        Stream<String> stream1 = Stream.of("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        // Stream: java.util.stream.ReferencePipeline$Head@3f99bd52
        log.info("Stream: " + stream1);

        // Filter.
        // filter方法用于通过设置的条件过滤出元素.(过滤掉空字符串)
        List<String> strings2 = Arrays.asList("Hollis", "", "HollisChuang", "H", "hollis");
        strings2.stream().filter(str -> !str.isEmpty()).forEach(System.out::println);
        // strings2.stream().filter(string -> !string.isEmpty()).forEach(log::info);


    }

}
