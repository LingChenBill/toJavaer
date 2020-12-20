package com.lc.integercache;

import lombok.extern.java.Log;

/**
 * 自动拆装箱与缓存.
 * @description:
 * @author: lingchen
 * @date: 2020/12/20
 */
@Log
public class IntegerCache {

    /**
     * Java中的缓存机制,如果数字在-128至127之间时,会直接使用缓存中的对象,而不是重新创建一个对象.
     * @param args
     */
    public static void main(String[] args) {
        Integer integer1 = 127;
        Integer integer2 = 127;
        if (integer1 == integer2) {
            log.info("integer1 == integer2");
        } else {
            log.info("integer1 != integer2");
        }

        Integer integer3 = 300;
        Integer integer4 = 300;
        if (integer3 == integer4) {
            log.info("integer3 == integer4");
        } else {
            log.info("integer3 != integer4");
        }

        // 信息: integer1 == integer2
        // 信息: integer3 != integer4
    }
}
