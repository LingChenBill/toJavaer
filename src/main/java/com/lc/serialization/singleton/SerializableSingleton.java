package com.lc.serialization.singleton;

import java.io.*;

/**
 * 测试单例是否破坏序列与反序列.
 * 序列化会通过反射调用无参数的构造方法创建一个新的对象.
 *
 * @author: lingchen
 * @date: 2021/6/19
 */
public class SerializableSingleton {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("src/main/resources/serializableSingleton-temp"));

        // 写入对象到文件.
        oos.writeObject(Singleton.getSingleton());

        // 读取文件内容到对象.
        File file = new File("src/main/resources/serializableSingleton-temp");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton newSingleton = (Singleton) ois.readObject();

        // 判断是否是同一个对象. false.
        // Singleton类中有readResolve方法可以防止序列化/反序列化破坏单例模式. true.
        System.out.println(newSingleton == Singleton.getSingleton());
    }
}
