package com.khoi.utils;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
/**Hàm tự động get key word trong pram và tự map về các thành phần trong model*/
public class FormUtil {
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> tClass, HttpServletRequest request) {
		T object = null;
		try {
			
			object = tClass.newInstance();
			//BeanUtils dùng để may các key và value trên param
			BeanUtils.populate(object, request.getParameterMap());
			
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return object;
	}
}
