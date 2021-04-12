package com.lc.generics;

import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Java编译器处理泛型的过程.
 *
 * @description: 1.Code specialization:在实例化一个泛型类或泛型方法时都产生一份新的目标代码.
 *                 代码膨胀:code bloat
 *               2.Code sharing: 对每个泛型类只生成唯一的一份代码,该泛型类的所有实例都映射到这份目标代码上,
 *                               在需要的时候执行类型检查和类型转换.
 *                 类型擦除:type erasue
 *                        a) 将所有的泛型参数用其最左边界(最顶级的父类型)类型替换.
 *                        b) 移除所有类型参数.
 * @author: lingchen
 * @date: 2021/4/12
 */
@Log
public class MapGenerics {

    public static void main(String[] args) {

        // 反编译时,程序又变回了Java泛型出现之前的写法,泛型类型都变回了原生类型.
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "hollis");
        map.put("age", "22");

        log.info(map.get("name"));
        log.info(map.get("age"));
    }
}
