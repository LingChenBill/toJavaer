package com.lc.serialization.list;

import lombok.extern.java.Log;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList的序列化.
 *
 * @author: lingchen
 * @date: 2021/6/19
 */
@Log
public class SerializableArrayList {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("world");
        strList.add("hollis");
        strList.add("chuang");

        log.info(strList.toString());

        // 存储ArrayList至文件.
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("src/main/resources/stringList-temp"));
        oos.writeObject(strList);

        IOUtils.close(oos);

        // 读取文件内容到对象.
        File file = new File("src/main/resources/stringList-temp");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        List<String> newStrList = (List<String>) ois.readObject();

        IOUtils.close(ois);
        if (file.exists()) {
            file.delete();
        }

        log.info("new StringList: " + newStrList);
    }

}
