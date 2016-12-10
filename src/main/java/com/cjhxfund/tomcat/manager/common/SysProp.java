package com.cjhxfund.tomcat.manager.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class SysProp extends HashMap{
	/*init this hashmap with properties*/
	public void init() throws IOException{
		init(CommonBeans.FILE_NAME);
	}
	
	@SuppressWarnings("unchecked")
	public void init(String strPath) throws IOException{
		Properties prop = new Properties();
		FileInputStream inputStream = null;
		try{
			 inputStream = new FileInputStream(strPath);
		
			 prop.load(inputStream);
			 this.put(CommonBeans.USER_NAME, prop.getProperty(CommonBeans.USER_NAME));
			 this.put(CommonBeans.USER_PWD, prop.getProperty(CommonBeans.USER_PWD));
			 
		}catch(FileNotFoundException fileEx){
			fileEx.printStackTrace();
		}catch(IOException ioEx){
			ioEx.printStackTrace();
		}finally{
			if(null != inputStream){
				inputStream.close();
			}
		}
	}
}
