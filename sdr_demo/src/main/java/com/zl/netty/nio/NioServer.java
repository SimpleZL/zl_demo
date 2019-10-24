package com.zl.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-02-06
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        //Channel配置
        ServerSocketChannel acceptorSvr = ServerSocketChannel.open();
        // socket的基本设置
        acceptorSvr.socket().bind(new InetSocketAddress("127.0.0.1",8080));
        acceptorSvr.configureBlocking(false);
        Selector selector = Selector.open();
//        new Thread(new ReactorTask)
//        SelectionKey key = acceptorSvr.register(selector,SelectionKey.OP_ACCEPT,ioHandler);
     }
}
