package com.fcy.ioTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream {
	public static void main(String[] args) {
		File file = new File("D:\\test\\test.txt");
		OutputStream os = null;
		try {
			os = new FileOutputStream(file, true);
			String s = "这是个好想法！\r\n";
			byte b[] = s.getBytes();
			os.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != os){
				try{
					os.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}
