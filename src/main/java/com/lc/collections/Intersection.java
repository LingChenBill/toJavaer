package com.lc.collections;

import lombok.extern.java.Log;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 获取两个集合(交集)之间的公共对象.
 * @description:
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class Intersection {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("A", "A", "A", "C", "B", "B");
        List<String> list2 = Arrays.asList("A", "A", "B", "B");

        log.info("List 1: " + list1);
        log.info("List 2: " + list2);
        // Commons Objects of List 1 and List 2: [A, A, B, B].
        log.info("Commons Objects of List 1 and List 2: " + CollectionUtils.intersection(list1, list2));
    }
}
