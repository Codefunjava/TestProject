package com.fcy.net.tcp.chat.demo02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ͻ���: ��������+��������
 * д�����ݣ������
 * ��ȡ���ݣ�������
 * 
    ������ ������� ��ͬһ���߳��� Ӧ�� ���������˴˶���
    
    
    
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Client {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",9999);
		new Thread(new Send(client)).start(); //һ��·��
		new Thread(new Receive(client)).start(); //һ��·��
		
	}

}
