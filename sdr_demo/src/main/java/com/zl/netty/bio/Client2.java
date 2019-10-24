package com.zl.netty.bio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-02-06
 */
public class Client2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1",8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
//        Thread.sleep(3000);
        out.println("好久没写这样的代码了2");
        socket.close();
    }
}
