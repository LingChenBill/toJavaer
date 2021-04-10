package com.lc.inoutstream;

import lombok.extern.java.Log;

import java.io.*;

/**
 * 字节流转换成字符流.
 * @description: OutputStreamWriter 是字符流通向字节流的桥梁.
 *               InputStreamReader 是字节流通向字符流的桥梁.
 * @author: lingchen
 * @date: 2021/4/10
 */
@Log
public class Input2Stream {

    public static void main(String[] args) throws IOException {

        File f = new File("src/main/resources/test.txt");

        InputStreamReader inr = new InputStreamReader(new FileInputStream(f), "UTF-8");
        char[] buf = new char[1024];
        int len = inr.read(buf);
        log.info(new String(buf, 0, len));

        inr.close();
    }
}
