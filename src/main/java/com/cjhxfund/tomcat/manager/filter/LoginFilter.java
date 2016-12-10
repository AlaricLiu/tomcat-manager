package com.cjhxfund.tomcat.manager.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSONObject;

public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		ServletInputStream inputStream = arg0.getInputStream();
		StringBuilder strBuffer = new StringBuilder();
		String strTmp = null;
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			
			while(null != (strTmp = reader.readLine())){
				strBuffer.append(strTmp);
			}
			/*得到username 和 session做验证，如验证不通过则拦截*/
			strTmp = strBuffer.toString();
			JSONObject jsonObj = JSONObject.fromObject(strTmp);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
