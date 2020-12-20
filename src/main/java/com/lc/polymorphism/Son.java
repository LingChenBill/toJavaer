package com.lc.polymorphism;

import lombok.extern.java.Log;

/**
 * 多态-子类.
 * @description:
 * @author: lingchen
 * @date: 2020/12/19
 */
@Log
public class Son extends Parent {

    @Override
    public void call() {
        log.info("I'm son");
    }
}
