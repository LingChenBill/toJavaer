package com.lc.collections;

import lombok.extern.java.Log;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.map.LinkedMap;

/**
 * OrderedMap是新接口,用于保留添加元素的顺序. LinkedMap和ListOrderedMap是两个可用的实现.
 * @description: 支持Map的迭代器,并允许在Map中向前或者向后迭代两个方向.
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class OrderedMapOperator {

    public static void main(String[] args) {

        OrderedMap<String, String> map = new LinkedMap<>();
        map.put("One", "1");
        map.put("Two", "2");
        map.put("Three", "3");

        log.info(map.firstKey());
        log.info(map.nextKey("One"));
        log.info(map.nextKey("Two"));
    }
}
