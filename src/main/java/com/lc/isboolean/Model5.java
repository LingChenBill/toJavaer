package com.lc.isboolean;

import java.util.StringJoiner;

/**
 * 在定义一个成员变量的时候到底是使用包装类型还是使用基本数据类型呢?
 *
 * @description:
 * @author: lingchen
 * @date: 2020/12/24
 */
public class Model5 {

    /**
     * 定义一个Boolean类型的success成员变量.
     */
    private Boolean success;

    /**
     * 定义一个boolean类型的failure成员变量.
     */
    private boolean failure;

    @Override
    public String toString() {
        return new StringJoiner(", ", Model5.class.getSimpleName() + "[", "]")
                .add("success=" + success)
                .add("failure=" + failure)
                .toString();
    }
}
