package com.lc.serialization.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 实现一个java.io.Serializable接口的类.
 *
 * @author: lingchen
 * @date: 2021/6/19
 */
@Data
public class User implements Serializable {

    /**
     * 姓名.
     */
    private String name;

    /**
     * 年龄.
     */
    private int age;

    @Override
    public String toString() {
        return "User { " +
                "name = '" + name + "\'" +
                ", age = " + age +
                " }";
    }
}
