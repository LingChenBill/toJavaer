package com.lc.enumeration.singleton;

/**
 * 双重校验锁实现单例.
 *
 * @description: 需要考虑线程安全问题.
 *               缺点:无法解决反序列化会破坏单例的问题.
 * @author: lingchen
 * @date: 2021/4/11
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton () {}

    /**
     * 实现单例.
     * @return
     */
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
