package com.lc.inoutstream;

import com.lc.inoutstream.dto.User;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * 使用BIO实现文件的读取与写入.
 * @description: BIO: Blocking I/O:同步阻塞I/O模式.
 * @author: lingchen
 * @date: 2021/4/10
 */
@Log
public class BioFileOperate {

    public static void main(String[] args) {

        // 初始化对象.
        User user = new User();
        user.setName("hollis");
        user.setAge(23);
        log.info(user.toString());

        // 写入到文件.
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/test002.txt"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(oos);
        }

        // 从文件中读取对象.
        File file = new File("src/main/resources/test002.txt");
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User) ois.readObject();
            log.info(newUser.toString());
        } catch (IOException | ClassNotFoundException e) {
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
