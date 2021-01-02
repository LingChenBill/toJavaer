package com.lc.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Stream中的distinct.
 * @description: 用来去重.
 * @author: lingchen
 * @date: 2021/1/2
 */
public class Distinct {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().distinct().forEach(System.out::println);
    }
}
