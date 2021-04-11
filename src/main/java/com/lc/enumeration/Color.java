package com.lc.enumeration;

import lombok.extern.java.Log;

/**
 * 向枚举中添加新方法.
 *
 * @description:
 * @author: lingchen
 * @date: 2021/4/11
 */
@Log
public enum Color implements Behaviour {

    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    // 成员变量.
    private String name;

    private int index;

    // 构造方法.
    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    /**
     * 覆盖方法.
     * @return
     */
    @Override
    public String toString() {
        return this.index + "_" + this.name;
    }

    // 普通方法.
    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.index == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * 实现的接口方法.
     */
    @Override
    public void print() {
        log.info(this.index + "_" + this.name);
    }

    @Override
    public String getInfo() {
        return this.name;
    }
}
