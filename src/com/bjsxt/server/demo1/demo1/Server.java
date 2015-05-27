package com.bjsxt.server.demo1.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������������������
 * @author Administrator
 *
 */
public class Server {
	private ServerSocket server;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Server server = new Server();
		server.start();
		
		
	}
	/**
	 * ��������
	 */
	public void start(){		
		try {
			server = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	/**
	 * ���տͻ���
	 */
	private void receive(){
		try {
			Socket client =server.accept();
			StringBuilder sb =new StringBuilder();
			String msg =null;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			while((msg=br.readLine()).length()>0){
				sb.append(msg);
				sb.append("\r\n");
				
			}
			//���տͻ��˵�������Ϣ
			String requestInfo =sb.toString().trim();		
			System.out.println(requestInfo);
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	/**
	 * ���ŷ�����
	 */
	public void stop(){
		
	}
	
	
}
