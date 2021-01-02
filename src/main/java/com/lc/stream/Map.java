package com.lc.stream;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;

/**
 * Stream流中Map的使用.
 * @description: map方法用于映射每个元素到对应的结果.
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class Map {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().map(i -> i * i).forEach(System.out::println);

        // limit.
        log.info("limit返回Stream的前面的n个元素: ");
        numbers.stream().limit(4).map(i -> i * i).forEach(System.out::println);

        // skip.
        log.info("skip扔掉Stream的前面的n个元素: ");
        numbers.stream().skip(4).map(i -> i * i).forEach(System.out::println);

    }
}
