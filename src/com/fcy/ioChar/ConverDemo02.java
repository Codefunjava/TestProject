package com.fcy.ioChar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ConverDemo02 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(new File("D:\\test\\HelloWorld.class")),"utf-8")
		);
		String info = null;
		while(null != (info = br.readLine())){
			System.out.println(info);
		}
		br.close();
	}
}
