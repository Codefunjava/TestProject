package com.fcy.ioChar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo01 {
	public static void main(String[] args) {
		File src = new File("D:\\test\\test.txt");
		Reader reader = null ;
		try {
			reader = new FileReader(src);
			char[] c = new char[5];
			int len = 0;
			while(-1 != (len = reader.read(c))){
				String s = new String(c,0,len);
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
