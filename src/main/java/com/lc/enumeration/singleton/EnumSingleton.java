package com.lc.enumeration.singleton;

/**
 * 使用枚举实现单例.
 *
 * @description: 使用枚举就不需要解决线程安全问题.
 *               枚举在实现单例时,底层还是做了线程安全的保证的.
 *               当一个Java类第一次被真正使用到的时候静态资源被初始化,JAVA类的加载和初始化过程都是线程安全的.
 *               enum继承了Enum类.枚举类型不能被继承.
 * @author: lingchen
 * @date: 2021/4/11
 */
public enum EnumSingleton {
    INSTANCE;

    public void whateverMethod() {

    }
}
