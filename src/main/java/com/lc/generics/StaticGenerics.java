package com.lc.generics;

import lombok.extern.java.Log;

/**
 * 当泛型内包含静态变量.
 *
 * @description: 由于经过类型擦除, 所有的泛型类实例都关联到同一份字节码上, 泛型类的所有静态变量是共享的.
 * @author: lingchen
 * @date: 2021/4/12
 */
@Log
public class StaticGenerics {

    public static void main(String[] args) {
        GT<Integer> gti = new GT<Integer>();
        gti.var = 1;

        GT<String> gts = new GT<String>();
        gts.var = 2;

        // gti.var: 2
        log.info("gti.var: " + gti.var);
    }
}

class GT<T> {

    public static int var = 0;

    public void nothing(T x) {
    }
}
