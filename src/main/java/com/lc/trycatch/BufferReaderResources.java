package com.lc.trycatch;

import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 关闭资源的常用方式就是在finally块里释放.即调用close方法.
 * @description: Java7开始之后, 使用try-with-resources语句来打开关闭文件.优雅如斯.
 * @author: lingchen
 * @date: 2020/12/24
 */
@Log
public class BufferReaderResources {

    public static void main(String[] args) {

        // 使用try-with-resources语句.
        try (BufferedReader br = new BufferedReader(new FileReader("test0001.xml"))){
            String line;
            while ((line = br.readLine()) != null) {
                log.info(line);
            }
        } catch (IOException e) {
            // handle exception.
        }
    }
}
