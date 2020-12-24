package com.lc.isboolean;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * 该如何定一个布尔类型的成员变量.
 *
 * @description: 基本类型自动生成的getter和setter方法, 名称都是isXXX()和setXXX()形式的.
 *               包装类型自动生成的getter和setter方法,名称都是getXXX()和setXXX()形式的.
 *               POJO类中布尔类型的变量,都不要加is,否则部分框架解析会引起序列化错误.
 * @author: lingchen
 * @date: 2020/12/24
 */
public class Model3 implements Serializable {

    private boolean isSuccess;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    // public String getHollis() {
    //     return "hollischuang";
    // }

    @Override
    public String toString() {
        return new StringJoiner(", ", Model3.class.getSimpleName() + "[", "]")
                .add("isSuccess=" + isSuccess)
                .toString();
    }
}
