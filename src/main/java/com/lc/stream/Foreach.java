package com.lc.stream;

import java.util.Random;

/**
 * 迭代流中的每个数据.
 * @description:
 * @author: lingchen
 * @date: 2021/1/2
 */
public class Foreach {

    public static void main(String[] args) {

        // 输出10个随机数.
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }
}
