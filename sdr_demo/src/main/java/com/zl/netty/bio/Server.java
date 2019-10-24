package com.zl.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-02-06
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Executor executor = Executors.newFixedThreadPool(1);
        while (true) {
            final Socket onceConnect = server.accept();
            executor.execute(new Runnable() {
                public void run() {
                    InputStream in = null;
                    try {
                        in = onceConnect.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    try {
                        System.out.println(reader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }
}
