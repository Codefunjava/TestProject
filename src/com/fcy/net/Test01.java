package com.fcy.net;

import java.net.InetAddress;

public class Test01 {
	public static void main(String[] args) throws Exception {
		InetAddress locAdd = null;
		InetAddress remAdd = null;
		locAdd = InetAddress.getLocalHost();
		remAdd = InetAddress.getByName("www.baidu.com");
		System.out.println("本机ip: "+locAdd.getHostAddress());
		System.out.println("百度ip: "+remAdd.getHostAddress());
		System.out.println("本机是否可达："+locAdd.isReachable(5000));
	}
}
