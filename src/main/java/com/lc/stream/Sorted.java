package com.lc.stream;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;

/**
 * Stream中的sorted方法.
 * @description: 用于对流进行排序.
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class Sorted {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().sorted().forEach(System.out::println);
    }
}
