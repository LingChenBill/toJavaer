package com.lc.isboolean;

import lombok.extern.java.Log;

/**
 * 包装类型和基本数据类型的成员变量测试.
 * @description:
 * @author: lingchen
 * @date: 2020/12/24
 */
@Log
public class Model5Test {

    public static void main(String[] args) {
        Model5 model5 = new Model5();
        // default model: Model5[success=null, failure=false]
        log.info("default model: " + model5);
    }
}