package com.lc.failfast;

import lombok.extern.java.Log;

/**
 * fail-fast:快速失效系统通常设计用于停止正常操作,而不是试图继续可以存在缺陷的过程.
 * @description: 快速失败模块的职责是检测错误,然后让系统的下一个最高级别处理错误.
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class FailFast {

    public static void main(String[] args) {

        log.info(String.valueOf(divide(4, 2)));

    }

    /**
     * fail-fast: 在做系统设计的时候先考虑异常情况,一旦发生异常,直接停止并上报.
     * @param divisor
     * @param dividend
     * @return
     */
    public static int divide(int divisor, int dividend) {
        // fail-fast理念的实际应用.
        if (dividend == 0) {
            throw new RuntimeException("dividend can't be null.");
        }

        return divisor / dividend;
    }
}
