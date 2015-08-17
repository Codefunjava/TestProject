package com.fcy.test03;

import com.common.utils.HttpUtils;



public class Test10 {
	public static void main(String[] args) throws Exception {
		String url = "http://www.tuling123.com/openapi/api?key=4cd8b60cfda1862bd5efb63eb2400e15&userid=1&info=%E6%96%B0%E9%97%BB";
		String result = HttpUtils.callServer(url);
		System.out.println(result);
	}
}
