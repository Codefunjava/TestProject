package com.fcy.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMRead {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		builder = factory.newDocumentBuilder();
		Document doc = null;
		doc = builder.parse("d://test//dom_demo.xml");
		NodeList nl = doc.getElementsByTagName("linkman");
		int length = nl.getLength();
		for(int x = 0; x < length; x++){
			Element e = (Element) nl.item(x);
			System.out.println("姓名：" + e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
			System.out.println("邮箱：" + e.getElementsByTagName("email").item(0).getFirstChild().getNodeValue());
		}
	}
}
















