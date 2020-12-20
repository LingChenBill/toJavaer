package com.lc.condition;

import lombok.extern.java.Log;

/**
 * Switch对整形支持的实现.
 * @description: switch对int的判断是直接比较整数的值.
 * @author: lingchen
 * @date: 2020/12/20
 */
@Log
public class SwitchDemoInt {

    public static void main(String[] args) {
        int a = 5;
        switch (a) {
            case 1:
                log.info(String.valueOf(1));
                break;
            case 5:
                log.info(String.valueOf(5));
                break;
            default:
                break;
        }
    }
}
