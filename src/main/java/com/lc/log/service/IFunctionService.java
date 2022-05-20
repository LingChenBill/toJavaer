package com.lc.log.service;

/**
 * @author: lingchen
 * @date: 2022/5/20
 */
public interface IFunctionService {
    public String apply(String functionName, String value);

    public boolean beforeFunction(String functionName);
}
