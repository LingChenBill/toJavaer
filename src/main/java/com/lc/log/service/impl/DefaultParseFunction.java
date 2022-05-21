package com.lc.log.service.impl;

import com.lc.log.service.IParseFunction;

/**
 * @author: lingchen
 * @date: 2022/5/21
 */
public class DefaultParseFunction implements IParseFunction {
    @Override
    public String functionName() {
        return this.getClass().getName();
    }

    @Override
    public String apply(String value) {
        return null;
    }
}
