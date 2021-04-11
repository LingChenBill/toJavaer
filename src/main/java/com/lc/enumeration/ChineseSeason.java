package com.lc.enumeration;

import lombok.extern.java.Log;

/**
 * int型枚举操作.
 *
 * @description: 会有类型不安全的问题.缺乏程序可读性.
 * @author: lingchen
 * @date: 2021/4/11
 */
@Log
public class ChineseSeason {

    public static void main(String[] args) {
        // 春天.正常数据.
        log.info(getChineseSeason(Season.SPRING));
        // 异常数据.
        log.info(getChineseSeason(5));
    }

    /**
     * 获取季节.
     *
     * @param season
     * @return
     */
    private static String getChineseSeason(int season) {
        StringBuffer result = new StringBuffer();
        switch (season) {
            case Season.SPRING:
                result.append("春天");
                break;
            case Season.SUMMER:
                result.append("夏天");
                break;
            case Season.AUTUMN:
                result.append("秋天");
                break;
            case Season.WINTER:
                result.append("冬天");
                break;
            default:
                result.append("地球没有季节");
                break;
        }

        return result.toString();
    }
}
