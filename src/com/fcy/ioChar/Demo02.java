package com.fcy.ioChar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02 {
	public static void main(String[] args) {
		File f = new File("D:\\test\\test2.txt");
		Writer w = null;
		try {
			w = new FileWriter(f);
			String str = "这是要写入的。。。";
			w.write(str);
			w.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != null){
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
	}
}
