package com.lc.integer;

import lombok.extern.java.Log;

/**
 * 整形数据溢出.
 * @description:
 * @author: lingchen
 * @date: 2020/12/20
 */
@Log
public class MaxValue {

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        int k = i + j;

        // i (2147483647) + j(2147483647) = k(-2)
        // 溢出的时候,并不会抛出异常,也不会有任何提示.
        log.info("i (" + i + ") + j(" + j + ") = k(" + k + ")");
    }
}
