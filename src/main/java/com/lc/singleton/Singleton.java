package com.lc.singleton;

/**
 * 单例.
 * @description: 使用双重锁校验的形式来实现单例.
 * @author: lingchen
 * @date: 2020/12/20
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {}

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
}
