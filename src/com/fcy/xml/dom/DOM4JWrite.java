package com.fcy.xml.dom;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class DOM4JWrite {
	public static void main(String[] args) throws Exception{
		Document doc = DocumentHelper.createDocument();
		Element addresslist = doc.addElement("addresslist");
		//-------第一个linkman结点------
		Element linkman = addresslist.addElement("linkman");
		Element name = linkman.addElement("name");
		Element email = linkman.addElement("email");
		name.setText("张三");
		email.setText("zhangsan@sina.com");
		//-------第二个linkman结点---------
		Element linkman2 = addresslist.addElement("linkman");
		Element name2 = linkman2.addElement("name");
		Element email2 = linkman2.addElement("email");
		name2.setText("李四");
		email2.setText("lisi@sina.com");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		XMLWriter writer = new XMLWriter(new FileOutputStream(new File("d://test/dom4j_output.xml")), format);
		writer.write(doc);
		writer.close();
		
		
		
		
	}
}
