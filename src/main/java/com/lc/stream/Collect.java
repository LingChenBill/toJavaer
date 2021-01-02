package com.lc.stream;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * collect是一个归约操作.
 * @description: 可以接受各种做法作为参数,将流中的元素累积成一个汇总结果.
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class Collect {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        strings = strings.stream().filter(string -> string.startsWith("Hollis")).collect(Collectors.toList());
        // System.out.println(strings);
        log.info(strings.toString());
    }
}
