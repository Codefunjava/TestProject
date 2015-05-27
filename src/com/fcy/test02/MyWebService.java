package com.fcy.test02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebService {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9999);
		while(true){
			Socket s = ss.accept();
			System.out.println("在9999上等待连接。。。");
			OutputStream os = s.getOutputStream();
			BufferedReader br = new BufferedReader(new FileReader("d:\\hello.html"));
			String buf="";
			while((buf=br.readLine())!=null){
				os.write(buf.getBytes());
			}
			br.close();
			os.close();
			s.close();
		}
	}
}
