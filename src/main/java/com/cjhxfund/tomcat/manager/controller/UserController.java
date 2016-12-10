package com.cjhxfund.tomcat.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjhxfund.tomcat.manager.common.CommonBeans;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@RequestMapping(value="/user", method = RequestMethod.POST, produces = {"application/json;charset=utf-8" })
	@ResponseBody
	public String Login(@RequestBody String strJson){
		JSONObject jsonObj = JSONObject.fromObject(strJson);
		String userName = jsonObj.getString(CommonBeans.USER_NAME);
		String userPwd  = jsonObj.getString(CommonBeans.USER_PWD);
		
		if(isLogin(userName)){
			return "{}";
		}
		return Login(userName, userPwd);
	}
	
	private boolean isLogin(String UserName){
		if(null != CommonBeans.session.get(UserName)){
			return true;
		}
		return false;
	}
	
	private String Login(String UserName, String UserPwd){
		String userAdmin = (String) CommonBeans.sysProp.get(CommonBeans.USER_NAME);
		String userPwd = (String) CommonBeans.sysProp.get(CommonBeans.USER_PWD);
		
		if(UserName.equals(UserName) && UserPwd.equals(userPwd)){
			return CommonBeans.session.PutUser(UserName);
		}
		
		return "false";
	}
}
