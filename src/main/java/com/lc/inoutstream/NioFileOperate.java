package com.lc.inoutstream;

import lombok.extern.java.Log;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 使用NIO实现文件的读取与写入.
 * @description: NIO:New I/O:同时支持阻塞与非阻塞模式.
 * @author: lingchen
 * @date: 2021/4/10
 */
@Log
public class NioFileOperate {

    public static void main(String[] args) {
        // readNIO();
        writeNIO();
    }

    /**
     * NIO读取文件.
     */
    static void readNIO() {

        String path = "src/main/resources/test.txt";
        FileInputStream fin = null;

        try {
            fin = new FileInputStream(new File(path));
            FileChannel channel = fin.getChannel();

            // 字节.
            int capacity = 100;
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            log.info("限制是: " + bf.limit() + "容量是: " + bf.capacity() + "位置是: " + bf.position());

            int length = -1;

            while ((length = channel.read(bf)) != -1) {
                // 读取后,将位置置为0,将limit置为容量,以备下次读入到字节缓冲中,从0开始存储.
                bf.clear();
                byte[] bytes = bf.array();
                System.out.write(bytes, 0, length);
                System.out.println();

                log.info("限制是: " + bf.limit() + "容量是: " + bf.capacity() + "位置是: " + bf.position());
            }

            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * NIO写入文件.
     */
    static void writeNIO() {

        String path = "src/main/resources/test003.txt";
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(new File(path));
            FileChannel channel = fos.getChannel();
            ByteBuffer src = Charset.forName("utf8").encode("你好,这是NIO写入文件");

            // 字节缓冲的容量和limit会随着数据长度变化,不是固定不变的.
            log.info("初始化容量和limit: " + src.capacity() + ", " + src.limit());

            int length = 0;

            while ((length = channel.write(src)) != 0) {
                // 这里不需要clear,将缓冲中的数据写入到通道中,第二次接着上一次的顺序往下读.
                log.info("写入长度: " + length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
