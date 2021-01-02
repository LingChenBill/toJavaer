package com.lc.collections;

import lombok.extern.java.Log;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 通过从其他集合中减去一个集合的对象来获取新的集合.
 * @description:
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class Subtraction {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("A", "A", "A", "C", "B", "B");
        List<String> list2 = Arrays.asList("A", "A", "B", "B");

        log.info("List 1: " + list1);
        log.info("List 2: " + list2);
        // List1 - List2: [A, C].
        log.info("List1 - List2: " + CollectionUtils.subtract(list1, list2));
    }
}
