package com.lc.collections;

import lombok.extern.java.Log;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 检查列表是否是另一个列表的一部分.
 * @description: CollectionUtils.isSubCollection
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class Inclusion {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("A", "A", "A", "C", "B", "B");
        List<String> list2 = Arrays.asList("A", "A", "B", "B");
        log.info("List 1: " + list1);
        log.info("List 2: " + list2);

        log.info("Is List 2 contained in List 1: " + CollectionUtils.isSubCollection(list2, list1));

    }
}
