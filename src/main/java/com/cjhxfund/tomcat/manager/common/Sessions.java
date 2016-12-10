package com.cjhxfund.tomcat.manager.common;

import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

/*线程安全的Hashmap来管理session*/
public class Sessions extends ConcurrentHashMap<String, Object>{
	
	public String PutUser(String User){
		String strRst = null;
		strRst = GernateSession(User);
		/*先查有么有，可以用这个函数实现原子get and set*/
		return this.putIfAbsent(User, strRst).toString();
	}
	
	private String GernateSession(String User){
		byte[] btUser = User.getBytes();
		return UUID.nameUUIDFromBytes(btUser).toString();
	}
	
}
