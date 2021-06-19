package com.lc.serialization.singleton;

import java.io.Serializable;

/**
 * 使用双重校验锁方式来实现单例.
 *
 * @author: lingchen
 * @date: 2021/6/19
 */
public class Singleton implements Serializable {

    private volatile static Singleton singleton;

    private Singleton () {}

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 只要在Singleton类中定义readResolve就可以解决序列与反序列破坏单例问题.
     *
     * @return
     */
    private Object readResolve() {
        return singleton;
    }
}
