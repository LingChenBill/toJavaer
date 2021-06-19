package com.lc.serialization.test;

import com.lc.serialization.vo.User;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * 一个类要想被序列化必须实现Serializable接口.
 *
 * @author: lingchen
 * @date: 2021/6/19
 */
@Log
public class SerializableDemo1 {

    public static void main(String[] args) {

        User user = new User();
        user.setName("hollis");
        user.setAge(23);

        log.info(user.toString());

        // 将对象写入到文件.
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/serializable-tempfile"));
            oos.writeObject(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(oos);
        }

        // 从文件中读取数据到对象中.
        File file = new File("src/main/resources/serializable-tempfile");
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User) ois.readObject();
            log.info(newUser.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ois);

            try {
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
