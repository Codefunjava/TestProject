package com.fcy.xml.dom;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JRead {
	public static void main(String[] args) throws Exception {
		File file = new File("d://test/dom4j_output.xml");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(file);
		Element root = doc.getRootElement();
		Iterator<Element> iter = root.elementIterator();
		while(iter.hasNext()){
			Element linkman =  iter.next();
			System.out.println("姓名：" + linkman.elementText("name"));
			System.out.println("邮件：" + linkman.elementText("email"));
		}
	}
}
