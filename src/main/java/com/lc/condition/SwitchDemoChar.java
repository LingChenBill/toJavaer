package com.lc.condition;

import lombok.extern.java.Log;

/**
 * Switch对字符型支持的实现.
 * @description: switch对char类型进行比较的时候,实际上比较的是ascii码,编译时会把char型变量转换成对应的int型变量.
 * @author: lingchen
 * @date: 2020/12/20
 */
@Log
public class SwitchDemoChar {

    public static void main(String[] args) {
        char a = 'b';
        switch (a) {
            case 'a':
                log.info("a");
                break;
            case 'b':
                log.info("b");
                break;
            default:
                break;
        }
    }
}
