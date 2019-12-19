package com.zl.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-18
 */
public class IOMain {
    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel serverSock = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(5000));
        //为异步操作指定CompletionHandler回调函数
        serverSock.accept(serverSock, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {
            @Override
            public void completed(AsynchronousSocketChannel sockChannel, AsynchronousServerSocketChannel serverSock) {
                serverSock.accept(serverSock, this);
                // 另外一个 write（sock，CompletionHandler{}）
                sayHelloWorld(sockChannel, Charset.defaultCharset().encode
                        ("Hello World!"));
            }

            /**
             * Invoked when an operation fails.
             *
             * @param exc        The exception to indicate why the I/O operation failed
             * @param attachment
             */
            @Override
            public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {

            }

            private void sayHelloWorld(AsynchronousSocketChannel sockChannel, ByteBuffer encode) {
            }
            // 省略其他路径处理方法...
        });
    }
}
