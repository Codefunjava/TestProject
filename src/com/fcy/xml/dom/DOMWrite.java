package com.fcy.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMWrite {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		Element addresslist = doc.createElement("addresslist");
		Element linkman = doc.createElement("linkman");
		Element name = doc.createElement("name");
		Element email = doc.createElement("email");
		name.appendChild(doc.createTextNode("张三"));
		email.appendChild(doc.createTextNode("zhangsan@sina.com"));
		linkman.appendChild(name);
		linkman.appendChild(email);
		addresslist.appendChild(linkman);
		doc.appendChild(addresslist);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.ENCODING, "GBK");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("d://test/output.xml"));
		t.transform(source, result);
		
		
		
	}
}
