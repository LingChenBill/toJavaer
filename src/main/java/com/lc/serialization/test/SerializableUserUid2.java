package com.lc.serialization.test;

import com.lc.serialization.vo.UserExter;
import com.lc.serialization.vo.UserUid;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * 测试Serializable的serialVersionUID属性.
 * 将
 *
 * java.io.InvalidClassException: com.lc.serialization.vo.UserUid;
 * local class incompatible: stream classdesc serialVersionUID = 1,
 * local class serialVersionUID = 2
 * @author: lingchen
 * @date: 2021/6/19
 */
@Log
public class SerializableUserUid2 {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {

        // 从文件中读取数据到对象中.
        File file = new File("src/main/resources/serialVersionUID-tempfile");
        ObjectInputStream ois = null;

        try {

            // UserUid 1l -> 2l.
            // java.io.InvalidClassException: com.lc.serialization.vo.UserUid;
            // local class incompatible: stream classdesc serialVersionUID = 1,
            // local class serialVersionUID = 2

            ois = new ObjectInputStream(new FileInputStream(file));
            UserUid newUser = (UserUid) ois.readObject();
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
