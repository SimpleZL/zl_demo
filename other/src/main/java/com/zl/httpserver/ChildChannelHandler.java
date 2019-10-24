package com.zl.httpserver;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-11-08
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast((ChannelHandler) new TimeServerHandler());
    }
}
