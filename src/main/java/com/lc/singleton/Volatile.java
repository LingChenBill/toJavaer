package com.lc.singleton;

/**
 * volatile.
 * @description: volatile不能保持原子性.
 * @author: lingchen
 * @date: 2020/12/20
 */
public class Volatile {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }
}
