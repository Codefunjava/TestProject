package com.fcy.test;

import java.util.Arrays;


public class Test11{
	public static void re(int[] a){
		int middle=a.length/2;
		int l=a.length-1;
		int tmp=0;
		for(int i=0;i<middle;i++){
			tmp=a[i];
			a[i]=a[l];
			a[l]=tmp;
			l--;
			
		}
	}
	public static void main(String args[]) throws Exception{
		int a[]={1,2,3,4,5,6,7,8};
		re(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");//这是中文，这是中文
		}
		
	}
}
