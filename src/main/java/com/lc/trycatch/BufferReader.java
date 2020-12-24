package com.lc.trycatch;

import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * 关闭资源的常用方式就是在finally块里释放.即调用close方法.
 * @description:
 * @author: lingchen
 * @date: 2020/12/24
 */
@Log
public class BufferReader {

    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("/test0001.xml"));
            while ((line = br.readLine()) != null) {
                log.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                // handle exception.
                ex.printStackTrace();
            }
        }
    }
}
