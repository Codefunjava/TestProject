package com.fcy.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

public class TestCharset {
	public static void main(String[] args) {
		SortedMap<String, Charset> all = Charset.availableCharsets();
		Iterator<Map.Entry<String, Charset>> iter = all.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<String, Charset> me = iter.next();
			System.out.println(me.getKey() + "--->" + me.getValue());
		}
	}
}

















