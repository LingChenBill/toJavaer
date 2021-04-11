package com.lc.enumeration;

import lombok.extern.java.Log;

/**
 * 使用Enum枚举类型.
 *
 * @description:
 * @author: lingchen
 * @date: 2021/4/11
 */
@Log
public class UseEnumSeason {

    public static void main(String[] args) {
        for (EnumSeason s : EnumSeason.values()) {
            log.info(getChineseEnumSeason(s));
        }

        // 编译不通过,保证了数据类型安全.
        // log.info(getChineseEnumSeason(5));
    }

    /**
     * 获取Enum枚举季节数据.
     *
     * @param season
     * @return
     */
    public static String getChineseEnumSeason(EnumSeason season) {
        StringBuffer result = new StringBuffer();

        switch (season) {
            case SPRING:
                result.append("[中文: 春天,枚举常量: " + season.name() + ", 数据: " + season.getCode() + "]");
                break;
            case SUMMER:
                result.append("[中文: 夏天,枚举常量: " + season.name() + ", 数据: " + season.getCode() + "]");
                break;
            case AUTUMN:
                result.append("[中文: 秋天,枚举常量: " + season.name() + ", 数据: " + season.getCode() + "]");
                break;
            case WINTER:
                result.append("[中文: 冬天,枚举常量: " + season.name() + ", 数据: " + season.getCode() + "]");
                break;
            default:
                result.append("地球上没有的季节: " + season.name());
                break;
        }

        return result.toString();
    }
}
