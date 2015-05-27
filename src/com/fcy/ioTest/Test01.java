package com.fcy.ioTest;

import java.io.File;
import java.util.Arrays;

public class Test01 {
	
	public static void main(String[] args) {
		printName(new File("K:\\"));
		System.out.println(Arrays.toString(File.listRoots()));
	}
	
	
	public static void printName(File src){
		if(null == src || !src.exists()){
			return ;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()){
			for(File subFile : src.listFiles()){
				printName(subFile);
			}
		}
	}
	
}
