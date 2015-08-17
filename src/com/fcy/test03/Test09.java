package com.fcy.test03;

public class Test09 {
	public static void main(String[] args) {
		System.out.println(EnumTest09.getStrByKey(1));
		System.out.println(EnumTest09.getStrByKey(2));
		System.out.println(EnumTest09.getStrByKey(3));
		System.out.println(EnumTest09.ONE.ordinal());
	}
}


enum EnumTest09{
	ONE(1, "one"),
	TWO(2, "two"),
	THREE(3, "three");
	
	private int i;
	private String str;
	
	private EnumTest09(int i, String str) {
		this.i = i;
		this.str = str;
	}
	
	public int getI(){
		return this.i;
	}
	
	public String getStr() {
		return this.str;
	}
	
	public static String getStrByKey(int key){
		String str = "";
		for(EnumTest09 en : values()) {
			if(en.getI() == key){
				str = en.getStr();
			}
		}
		return str;
	}
	
}
