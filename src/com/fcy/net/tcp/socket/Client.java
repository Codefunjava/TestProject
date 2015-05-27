package com.fcy.net.tcp.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 1.创建客户端，必须指定服务器端 + 端口
 * 2.接收客户端连接
 * 
 *
 */
public class Client {
	public static void main(String[] args) throws Exception, IOException {
		Socket client = new Socket("localhost", 8888);
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String echo = br.readLine();
		System.out.println(echo);
	}
}
