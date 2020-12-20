package com.lc.overriding;

import lombok.extern.java.Log;

/**
 * 重写.
 * @description: 重写指的是在Java的子类与父类中有两个名称,参数列表都相同的方法的情况.
 *      重载:函数或者方法有同样的名称,但是参数列表不相同的情形.
 * @author: lingchen
 * @date: 2020/12/19
 */
@Log
public class Dog {

    public void bark() {
        log.info("woof...");
    }

    /**
     * 重载bark方法.
     * @param num
     */
    public void bark(int num) {
        for (int i = 0; i < num; i++) {
            log.info("woof...");
        }
    }
}
