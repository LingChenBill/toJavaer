package com.lc.autotype.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lc.autotype.vo.Apple;
import com.lc.autotype.vo.Store;

import java.math.BigDecimal;

/**
 * FastJson的序列化测试.
 * v1.2.72之后的版本就修复了autoType漏洞.
 *
 * @author: lingchen
 * @date: 2021/6/19
 */
public class FastJsonTest {

    public static void main(String[] args) {

        Store store = new Store();
        store.setName("Hollis");
        Apple apple = new Apple();
        apple.setPrice(new BigDecimal(0.5));
        store.setFruit(apple);
        System.out.println("store: " + store);

        // 设置safeMode.
        // com.alibaba.fastjson.JSONException: safeMode not support autoType
        // ParserConfig.getGlobalInstance().setSafeMode(true);

        // JSON.toJSONString进行序列化.
        // toJsonString: {"fruit":{"price":0.5},"name":"Hollis"}
        // String jsonString = JSON.toJSONString(store);
        // System.out.println("toJsonString: " + jsonString);

        // SerializerFeature.WriteClassName标记每个属性的类型.
        String jsonString = JSON.toJSONString(store, SerializerFeature.WriteClassName);
        System.out.println("toJsonString: " + jsonString);

        // 这个fruit的类型到底是什么?能否反序列化成Apple.
        // parseObject: Store(name=Hollis, fruit={})
        Store newStore = JSON.parseObject(jsonString, Store.class);
        System.out.println("parseObject: " + newStore);

        // java.lang.ClassCastException
        Apple newApple = (Apple) newStore.getFruit();
        System.out.println("getFruit: " + newApple);

        // Fruit newFruit = newStore.getFruit();
        // System.out.println("getFruit: " + newFruit);
    }
}
