package com.fcy.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 客户端
 * 1.创建服务器 + 端口
 * 2.准备数据
 * 3.封装成包(发送地点及端口)
 * 4.发送数据
 * 5.释放
 */
public class MyClient {
	public static void main(String[] args) throws Exception {
		DatagramSocket client = new DatagramSocket(6666);
		String msg = "udp编程";
		byte[] data = msg.getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost",8888));
		client.send(packet);
		client.close();
	}
}

















