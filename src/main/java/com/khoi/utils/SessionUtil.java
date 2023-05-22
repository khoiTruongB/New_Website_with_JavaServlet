package com.khoi.utils;

import javax.servlet.http.HttpServletRequest;

//dùng để duy trì thông tin người dùng
public class SessionUtil {
	
	private static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		if(sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		
		return sessionUtil;
	}
	
	/**hàm duy trì thông tin người dùng*/
	public void putValue(HttpServletRequest request, String key, Object value) {
		//getSession(): lấy Session
		//setAttribute(key, value): put Session có key và value
		request.getSession().setAttribute(key, value);
	}
	
	/**hàm lấy thông tin người dùng*/
	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	/**hàm thoát hệ thống*/
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
}
