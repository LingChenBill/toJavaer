package com.lc.log.service.impl;

import com.lc.log.config.ParseFunctionFactory;
import com.lc.log.service.IFunctionService;
import com.lc.log.service.IParseFunction;

/**
 * 就是根据传入的函数名称functionName找到
 * 对应的IParseFunction，然后把参数传入到IParseFunction的apply方法上最后返回函数的值.
 * @author: lingchen
 * @date: 2022/5/20
 */
public class DefaultFunctionServiceImpl implements IFunctionService {

    private final ParseFunctionFactory parseFunctionFactory;

    public DefaultFunctionServiceImpl(ParseFunctionFactory parseFunctionFactory) {
        this.parseFunctionFactory = parseFunctionFactory;
    }

    @Override
    public String apply(String functionName, String value) {
        IParseFunction function = parseFunctionFactory.getFunction(functionName);
        if (function == null) {
            return value;
        }

        return function.apply(value);
    }

    @Override
    public boolean beforeFunction(String functionName) {
        return parseFunctionFactory.isBeforeFunction(functionName);
    }
}
