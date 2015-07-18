package com.fcy.test03;

import org.junit.Test;

public class Test04 {
	public char nextCharacter(char ch){
		int next = 0;
		if('Z' == ch){
			next = 65;
		}else{
		    next = ch + 1;
		}
		return (char)next;
	}
	
	@Test
	public void test(){
		System.out.println(nextCharacter('Z'));
		System.out.println((int)'z');
	}
	
}
