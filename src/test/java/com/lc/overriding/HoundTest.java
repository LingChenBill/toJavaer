package com.lc.overriding;

/**
 * 重写测试.
 * @description: 动态多态性.
 * @author: lingchen
 * @date: 2020/12/19
 */
public class HoundTest {

    public static void main(String[] args) {
        Dog dog = new Hound();
        dog.bark();
        dog.bark(2);
    }
}