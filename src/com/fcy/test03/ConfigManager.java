package com.fcy.test03;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {
	private static final String PFILE=System.getProperty("user.dir")+File.separator+"config.properties";
	private File m_file=null;
	private long m_lastModifiedTime =0;
	private Properties m_props=null;
	private static ConfigManager m_instance=new ConfigManager();
	
	private ConfigManager(){
		m_file=new File(PFILE);
		m_lastModifiedTime=m_file.lastModified();
		if(m_lastModifiedTime==0){
			System.err.println(PFILE+"file not exist");
		}
		m_props=new Properties();
		try{
			m_props.load(new FileInputStream(PFILE));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	synchronized public static ConfigManager getInstance(){
		return m_instance;
	}
	
	final public Object getConfigItem(String name,Object defaultVal){
		long newTime = m_file.lastModified();
		if(newTime==0){
			if(m_lastModifiedTime==0){
				System.err.println(PFILE+"file not exist!");
			}else{
				System.out.println(PFILE+"file was deleted!");
			}
		}else if(newTime>m_lastModifiedTime){
			m_props.clear();
			try{
				m_props.load(new FileInputStream(PFILE));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		m_lastModifiedTime=newTime;
		Object val=m_props.getProperty(name);
		if(val==null){
			return defaultVal;
		}else{
			return  val;
		}
	}
	
	public static void main(String[] args) {
		ConfigManager cm =ConfigManager.getInstance();
		System.out.println(cm.getConfigItem("a","x"));
		System.out.println(cm.getConfigItem("p","x"));
		System.out.println(cm.getConfigItem("DBDRIVER","x"));
		System.out.println(cm.getConfigItem("DBURL","x"));
	}
	
}
