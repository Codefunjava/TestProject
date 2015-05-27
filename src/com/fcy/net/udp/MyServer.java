package com.fcy.net.udp;

/**
 * 服务端
 * 1.创建服务器 + 端口
 * 2.准备接收容器
 * 3.封装成包
 * 4.接受数据
 * 5.分析数据
 * 6.释放
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyServer {
	public static void main(String[] args) throws Exception {
		DatagramSocket server = new DatagramSocket(8888);
		byte[] container = new byte[1024];
		DatagramPacket packet= new DatagramPacket(container, container.length);
		server.receive(packet);
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println("接收内容为：" + new String(data, 0, len));
		server.close();
	}
}
	


















