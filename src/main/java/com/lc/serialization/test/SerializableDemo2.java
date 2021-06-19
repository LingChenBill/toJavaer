package com.lc.serialization.test;

import com.lc.serialization.vo.UserExter;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * 一个类要想被序列化必须实现externalizable接口.
 * externalizable接口,要实现writeExternal与readExternal方法.
 * @author: lingchen
 * @date: 2021/6/19
 */
@Log
public class SerializableDemo2 {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {

        UserExter user = new UserExter();
        user.setName("hollis");
        user.setAge(23);

        log.info(user.toString());

        // 将对象写入到文件.
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/externalizable-tempfile"));
            oos.writeObject(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(oos);
        }

        // 从文件中读取数据到对象中.
        File file = new File("src/main/resources/externalizable-tempfile");
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            UserExter newUser = (UserExter) ois.readObject();
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
