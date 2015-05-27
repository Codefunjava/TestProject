package com.fcy.net.tcp.socket;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.创建服务器，指定端口 
 * 2.接收客户端连接
 * 3.发送数据 + 接收数据
 * 
 */
public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		System.out.println("一个客户端建立连接");
		String msg = "欢迎使用";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();
		bw.flush();
	}
}








