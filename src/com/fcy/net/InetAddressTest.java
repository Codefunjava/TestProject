package com.fcy.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.baidu.com");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("D:/baidu.html"))));
		String msg = null;
		while((msg = br.readLine()) != null){
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
