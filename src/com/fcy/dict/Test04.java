package com.fcy.dict;

import java.util.Arrays;
import java.util.List;

public class Test04 {
	static int count=0;
	public static void main(String[] args) {
		String s="1223";
		String s2="1232";
		int t=1 & 0;
		System.out.println(t);
		int index[]=new int[s.length()];
		for(int i=0;i<s2.length();i++){
			index[i]=s2.indexOf(s2.charAt(i));
		}
		pailie(s,"");
	}
	
	static void pailie(String s,String p){
		if(s.length()<1){
			count++;
		}else{
			int index[]=new int[s.length()];
			for(int i=0;i<s.length();i++){
				index[i]=s.indexOf(s.charAt(i));
			}
			for(int i=0;i<s.length();i++){
				if(i==index[i]){
					pailie(s.substring(1),p+s.substring(0,1));
				}
				s=s.substring(1)+s.substring(0,1);
			}
		}
	}
	
}
