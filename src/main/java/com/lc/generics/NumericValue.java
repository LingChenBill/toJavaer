package com.lc.generics;

/**
 * 泛型接口-实现接口.
 *
 * @description:
 * @author: lingchen
 * @date: 2021/4/12
 */
public final class NumericValue implements Comparable<NumericValue> {

    private byte value;

    public NumericValue(byte value) {
        this.value = value;
    }

    @Override
    public int compareTo(NumericValue that) {
        return this.value - that.value;
    }
}
