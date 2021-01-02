package com.lc.collections;

import lombok.extern.java.Log;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * JDK Map接口很难迭代.
 * @description: Map迭代要在EntryKey和KeySet对象上完成.
 *               MapIterator提供了对Map的简单迭代.
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class MapIteratorOperator {

    public static void main(String[] args) {

        IterableMap<String, String> map = new HashedMap<>();
        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");
        map.put("4", "Four");
        map.put("5", "Five");

        MapIterator<String, String> iterator = map.mapIterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = iterator.getValue();
            log.info("key: " + key);
            log.info("Value: " + value);
            iterator.setValue(value + "_");
        }

        // {3=Three_, 5=Five_, 2=Two_, 4=Four_, 1=One_}.
        log.info(map.toString());

    }
}
