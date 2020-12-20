package com.lc.singleton;

import lombok.extern.java.Log;

/**
 * volatile测试原子性.
 * @description:
 * @author: lingchen
 * @date: 2020/12/20
 */
@Log
public class VolatileTest {

    public static void main(String[] args) {
        final Volatile test = new Volatile();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        test.increase();
                    }
                }
            }.start();
        }

        while(Thread.activeCount() > 1)
            Thread.yield();

        log.info("test.inc: " + test.inc);
    }
}