package com.lc.variables;

/**
 * 变量.
 * @description:
 * @author: lingchen
 * @date: 2020/12/19
 */
public class Variables {

    /**
     * 类变量.
     */
    private static int a;

    /**
     * 成员变量.
     */
    private int b;

    /**
     * 局部变量(c和d).
     * @param c
     */
    public void test(int c) {
        int d;
    }
}
