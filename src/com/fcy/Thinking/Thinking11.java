package com.fcy.Thinking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Thinking11 {
	
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		Map<Integer,Float> map = new HashMap<Integer,Float>();
		System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
	}
}
