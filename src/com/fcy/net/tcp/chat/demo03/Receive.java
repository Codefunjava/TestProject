package com.fcy.net.tcp.chat.demo03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * �����߳� 
 * @author Administrator
 *
 */
public class Receive implements Runnable {
	//������
	private  DataInputStream dis ;
	//�̱߳�ʶ
	private boolean isRunning = true;
	public Receive() {
	}
	public Receive(Socket client){
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			isRunning =false;
			CloseUtil.closeAll(dis);
		}
	}
	/**
	 * ��������
	 * @return
	 */
	public String  receive(){
		String msg ="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
			isRunning =false;
			CloseUtil.closeAll(dis);
		}
		return msg;
	}
	@Override
	public void run() {
		//�߳���
		while(isRunning){
			System.out.println(receive());
		}
	}
}
