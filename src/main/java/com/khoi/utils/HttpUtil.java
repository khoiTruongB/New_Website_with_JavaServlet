package com.khoi.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {

	private String value;

	public HttpUtil(String value) {
		this.value = value;
	}

	/**hàm map String từ hàm of sang một model bất kỳ*/
	public <T> T toModel(Class<T> tclass) {
		try {
			return new ObjectMapper().readValue(value, tclass);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/** hàm chuyển json thành string */
	public static HttpUtil of(BufferedReader br) {
		StringBuffer sb = new StringBuffer();
		try {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return new HttpUtil(sb.toString());
	}

}
