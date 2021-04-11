package com.lc.enumeration;

/**
 * Enum枚举类型.
 *
 * @description: 一组固定的常量组成合法的类型.
 * @author: lingchen
 * @date: 2021/4/11
 */
public enum EnumSeason {
    // SPRING, SUMMER, AUTUMN, WINTER;

    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);

    private int code;

    private EnumSeason(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
