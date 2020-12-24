package com.lc.trycatch;

import lombok.extern.java.Log;

/**
 * 测试try中的return语句.finally中的值修改是否有变化.
 * @description: return前执行的finally块内,对数据的修改效果对于引用类型和值类型会不同.
 * @author: lingchen
 * @date: 2020/12/24
 */
@Log
public class ReturnFinally {

    public static void main(String[] args) {
        // 0
        log.info(String.valueOf(f()));
        // 1
        log.info(String.valueOf(f1()[0]));
    }

    static int f() {
        int ret = 0;
        try {
            return ret;
        } finally {
            ret++;
            log.info("int f()的finally执行.");
        }
    }

    static int[] f1() {
        int[] ret = new int[]{0};
        try {
            return ret;
        } finally {
            ret[0]++;
            log.info("int[] f1()的finally执行.");
        }
    }
}
