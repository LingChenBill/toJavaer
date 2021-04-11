package com.lc.reflex;

import lombok.extern.java.Log;

/**
 * @description:
 * @author: lingchen
 * @date: 2021/4/10
 */
@Log
public class Orange implements fruit {

    @Override
    public void eat() {
        log.info("Orange");
    }
}
