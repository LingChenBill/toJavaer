package com.lc.overriding;

import lombok.extern.java.Log;

/**
 * 重写.
 * @description:
 * @author: lingchen
 * @date: 2020/12/19
 */
@Log
public class Hound extends Dog {

    public void sniff() {
        log.info("sniff...");
    }

    @Override
    public void bark() {
        log.info("bowl...");
    }
}
