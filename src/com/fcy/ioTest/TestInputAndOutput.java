package com.fcy.ioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestInputAndOutput {
	public static void main(String[] args) {
		String src = "D:\\test\\毕业实习报告格式.doc";
		String dest = "D:\\test\\HelloWorld3.pdf";
		try {
			copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void copyFile(String srcFilePath, String destFilePath) throws IOException {
		File src = new File(srcFilePath);
		File dest = new File(destFilePath);
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest,true);
		byte[] b = new byte[1024];
		int len = 0;
		while(-1 != (len = (is.read(b)))){
			os.write(b, 0, len);
		}
		os.flush();
		if(null != os){
			os.close();
		}

		if(null != is){
			is.close();
		}
	}
}
