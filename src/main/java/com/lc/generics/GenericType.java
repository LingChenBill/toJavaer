package com.lc.generics;

import lombok.extern.java.Log;

import java.util.List;

/**
 * 泛型遇到重载.
 * @description: 当泛型遇到重载时,编译不通过的.
 *               List<String> 和 List<Integer>在编译之后都被擦除了.变成了一样的原生类型List.
 *               擦除动作导致这两个方法的特征签名变得一模一样了.
 * @author: lingchen
 * @date: 2021/4/12
 */
@Log
public class GenericType {

    public static void method(List<String> list) {
        log.info("invoke method(List<String> list)");
    }

    // public static void method(List<Integer> list) {
    //     log.info("invoke method(List<Integer> list)");
    // }
}
