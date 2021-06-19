package com.lc.serialization.test;

import com.lc.serialization.vo.UserExter;
import com.lc.serialization.vo.UserUid;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * 测试Serializable的serialVersionUID属性.
 *
 * @author: lingchen
 * @date: 2021/6/19
 */
@Log
public class SerializableUserUid {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {

        UserUid user = new UserUid();
        user.setName("hollis");

        log.info(user.toString());

        // 将对象写入到文件.
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/serialVersionUID-tempfile"));
            oos.writeObject(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(oos);
        }
    }
}
