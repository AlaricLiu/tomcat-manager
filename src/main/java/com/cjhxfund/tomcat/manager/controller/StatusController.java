package com.cjhxfund.tomcat.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class StatusController {
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public String Restart(){
		return "";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public String Start(){
		return "";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public String QueryStatus(){
		return "";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public String QueryStatusList(){
		return "";
	}
}
