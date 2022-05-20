package com.lc.log.service;

/**
 * @author: lingchen
 * @date: 2022/5/20
 */
public interface IParseFunction {

    /**
     * executeBefore函数代表了自定义函数是否在业务代码执行之前解析,
     * 上面提到的查询修改之前的内容.
     * @return
     */
    default boolean executeBefore() {
        return false;
    }

    String functionName();

    String apply(String value);
}
