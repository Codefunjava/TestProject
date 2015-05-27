package com.fcy.ioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream {
	public static void main(String[] args) {
		
		File f = new File("D:\\test\\HelloWorld.java");
		InputStream is = null;
		byte car[] = new byte[1024];
		int len = 0;
		try {
			is = new FileInputStream(f);
			while(-1 != (len = is.read(car))){
				String info = new String(car, 0, len, "utf-8");
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != is){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
