package com.lc.hashmap;

import com.google.common.collect.Maps;
import lombok.extern.java.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * HashMap的扩容条件.
 * @description: 当HashMap中的元素个数(size)超过临界值(threshold)时就会自动扩容.
 *               在HashMap中,threshold = loadFactory * capacity.
 * @author: lingchen
 * @date: 2020/12/27
 */
@Log
public class Threshold {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        // Map<String, String> map = new HashMap<>();
        // 当明确知道HashMap中元素中的个数的时候,可以把默认容量设置成expectedSize / 0.75F + 1.0F
        // guava依赖.
        Map<String, String> map = Maps.newHashMapWithExpectedSize(10);

        map.put("hollis1", "hollischuang");
        map.put("hollis2", "hollischuang");
        map.put("hollis3", "hollischuang");
        map.put("hollis4", "hollischuang");
        map.put("hollis5", "hollischuang");
        map.put("hollis6", "hollischuang");
        map.put("hollis7", "hollischuang");
        map.put("hollis8", "hollischuang");
        map.put("hollis9", "hollischuang");
        map.put("hollis10", "hollischuang");
        map.put("hollis11", "hollischuang");
        map.put("hollis12", "hollischuang");

        Class<? extends Map> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        log.info("capacity: " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        log.info("size: " + size.get(map));

        Field threshold = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);
        log.info("threshold: " + threshold.get(map));

        Field loadFactor = mapType.getDeclaredField("loadFactor");
        loadFactor.setAccessible(true);
        log.info("loadFactor: " + loadFactor.get(map));

        // 当Map中元素个数超过loadFactor * capacity的值时,会触发扩容.
        map.put("hollis13", "hollischuang");

        capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        log.info("capacity: " + capacity.invoke(map));

        size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        log.info("size: " + size.get(map));

        threshold = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);
        log.info("threshold: " + threshold.get(map));

        loadFactor = mapType.getDeclaredField("loadFactor");
        loadFactor.setAccessible(true);
        log.info("loadFactor: " + loadFactor.get(map));
    }
}
