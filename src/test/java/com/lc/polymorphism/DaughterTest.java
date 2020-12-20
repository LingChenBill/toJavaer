package com.lc.polymorphism;

/**
 * 多态的测试类.
 * @description:
 * @author: lingchen
 * @date: 2020/12/19
 */
public class DaughterTest {

    public static void main(String[] args) {
        Parent p = new Son();
        p.call();

        Parent p1 = new Daughter();
        p1.call();
    }

}