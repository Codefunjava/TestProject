package com.fcy.ioTest;

import java.io.File;

public class CopyDir {
	public static void main(String[] args) {
		String srcPath = "";
		String destPath = "";
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		copyDir(src, dest);
	}
	
	public static void copyDir(File src, File dest){
		if(src.isDirectory()){
			dest = new File(dest,src.getName());
		}
		copyDirDetail(src, dest);
	}
	
	private static void copyDirDetail(File src, File dest) {
		if(src.isFile()){
		}
		
	}
}
