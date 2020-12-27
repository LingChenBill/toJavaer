package com.lc.hashmap;

import lombok.extern.java.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Hashmap中的size和capacity之间的区别.
 * @description: capacity:最多可以装多少元素.默认为16
 *               size: 已经装了多少元素.
 * @author: lingchen
 * @date: 2020/12/27
 */
@Log
public class Capacity {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        Map<String, String> map = new HashMap<String, String>();
        map.put("hollis", "hollischuang");

        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        log.info("capacity: " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        // Class com.lc.hashmap.Capacity can not access a member of class java.util.HashMap with modifiers "transient"
        size.setAccessible(true);
        log.info("size: " + size.get(map));

    }
}
