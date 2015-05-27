package com.bjsxt.server.demo1.demo1;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��װrequest
 * @author Administrator
 *
 */
public class Request {
	//����ʽ
	private String method;
	//������Դ
	private String url;
	//�������
	private Map<String,List<String>> parameterMapValues;
	
	//�ڲ�
	public static final String CRLF="\r\n";
	private InputStream is;
	private String requestInfo;
	
	public Request(){
		method ="";
		url ="";
		parameterMapValues=new HashMap<String,List<String>>();
		requestInfo="";
	}
	public Request(InputStream is){
		this();
		this.is=is;
		try {
			byte[] data = new byte[20480];
			int len = is.read(data);
			requestInfo = new String(data, 0, len);
		} catch (Exception e) {
			return ;
		}
		//����������Ϣ
		parseRequestInfo();
	}
	/**
	 * ����������Ϣ
	 */
	private void parseRequestInfo(){
		if(null==requestInfo ||(requestInfo=requestInfo.trim()).equals("")){
			return ;
		}		
		/**
		 * =====================================
		 * ����Ϣ�����зֽ�� :����ʽ    ����·��   �������(get���ܴ���)
		 *   ��:GET /index.html?name=123&pwd=5456 HTTP/1.1
		 * 
		 * ���Ϊpost��ʽ��������������� ���������
		 * 
		 * ˼·:
		 * 1)����ʽ :�ҳ���һ��/  ��ȡ����
		 * 2)������Դ:�ҳ���һ��/   HTTP/ 
		 * =====================================
		 */
		String paramString =""; //����������� 
		
		//1����ȡ����ʽ
		String firstLine =requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idx =requestInfo.indexOf("/"); // /��λ��
		this.method=firstLine.substring(0, idx).trim();
		String urlStr =firstLine.substring(idx,firstLine.indexOf("HTTP/")).trim();
		if(this.method.equalsIgnoreCase("post")){
			this.url=urlStr;		
			paramString=requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
			
		}else if(this.method.equalsIgnoreCase("get")){
			if(urlStr.contains("?")){ //�Ƿ���ڲ���
				String[] urlArray=urlStr.split("\\?");
				this.url=urlArray[0];
				paramString=urlArray[1];//����������� 
			}else{
				this.url=urlStr;			
			}
		}
		
	
		//2�������������װ��Map��
	}
	
	
	
	
	
}
