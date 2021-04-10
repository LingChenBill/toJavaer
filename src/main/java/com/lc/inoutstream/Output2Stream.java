package com.lc.inoutstream;

import java.io.*;

/**
 * 字符流转成字节流.
 * @description: OutputStreamWriter 是字符流通向字节流的桥梁.
 *               InputStreamReader 是字节流通向字符流的桥梁.
 * @author: lingchen
 * @date: 2021/4/10
 */
public class Output2Stream {

    public static void main(String[] args) throws IOException {
        File f = new File("src/main/resources/test001.txt");

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");

        osw.write("我是字符流转换成字节流输出的");

        osw.close();
    }
}
