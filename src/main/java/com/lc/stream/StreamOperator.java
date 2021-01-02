package com.lc.stream;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 对Stream进行操作.
 * @description:
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class StreamOperator {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        Stream<Integer> strs = strings.stream().filter(string -> string.length() <= 6)
                .map(String::length)
                .sorted()
                .limit(3)
                .distinct();
        strs.forEach(System.out::println);
    }
}
