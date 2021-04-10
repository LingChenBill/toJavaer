package com.lc.inoutstream;

import lombok.extern.java.Log;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 使用AIO实现文件的读取与写入.
 *
 * @description: AIO: Asynchronous I/O:异步非阻塞I/O模型.
 * @author: lingchen
 * @date: 2021/4/10
 */
@Log
public class AIOFileOperate {

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        // readFromFile();
        write2File();
    }

    /**
     * NIO读取文件.
     *
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void readFromFile() throws IOException, ExecutionException, InterruptedException {

        Path file = Paths.get("src/main/resources/test.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);

        ByteBuffer buffer = ByteBuffer.allocate(100_000);
        Future<Integer> result = channel.read(buffer, 0);

        while (!result.isDone()) {
            // 其它操作.
            ProfitCalculator.calculateTax();
        }

        Integer bytesRead = result.get();
        log.info("Bytes read[ " + bytesRead + " ]");
    }

    /**
     * AIO操作文件.
     * @throws IOException
     */
    static void write2File() throws IOException {
        Path file = Paths.get("/Users/zhuyangze/Documents/fork/java/toJavaer/src/main/resources/test004.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(file,
                StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {

            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println("Attachment: " + attachment + " " +
                        result + " bytes written.");
                System.out.println("CompletionHandler Thread ID: " + Thread.currentThread().getId());
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("Attachment: " + attachment + "failed with: ");
                exc.printStackTrace();
            }
        };

        log.info("Main Thread ID: " + Thread.currentThread().getId());
        fileChannel.write(ByteBuffer.wrap("Sample".getBytes()), 0, "First Write", handler);

        fileChannel.write(ByteBuffer.wrap("Box".getBytes()), 0, "Second Write", handler);
    }

}
