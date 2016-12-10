package com.cjhxfund.tomcat.manager.common;

import java.io.IOException;

public class CommonBeans {
	public final static String USER_NAME="username";
	public final static String USER_PWD="userpwd";
	public final static String FILE_NAME="sys.conf";
	
	public static SysProp sysProp = new SysProp();
	
	public static Sessions session = new Sessions();
	
	{
		try {
			sysProp.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
