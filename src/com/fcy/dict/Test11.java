package com.fcy.dict;

import java.util.Arrays;

public class Test11 {
	public static void main(String[] args) {
		int[] ints={3,4,3,2,-1,3,3,3};
		int j=judge(ints);
		if(j==-1){
			System.out.println("No dominator");
		}else{
			System.out.println("Thre dominator is:"+ints[j]);
		}
	}
	
	public static int judge(int[] ints){
		Arrays.sort(ints);
		int counter=1;
		for(int i=0;i<(ints.length-1);i++){
			if(ints[i]==ints[i+1]){
				counter++;
				if(((double)counter)/ints.length>0.5){
					return i;
				}
			}else{
				counter=1;
			}
		}
		return -1;
	}
	
}
