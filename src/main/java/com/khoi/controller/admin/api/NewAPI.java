package com.khoi.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.khoi.model.NewsModel;
import com.khoi.service.INewService;
import com.khoi.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewService newService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		//set font tiếng việt cho server
		request.setCharacterEncoding("utf-8");
		//set kiểu dữ liệu khi trả về cho client
		response.setContentType("application/json");
		
		// map từ json đến các fleld của model
		NewsModel newsModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		newsModel = newService.save(newsModel);
		//trả data về dạng json
		mapper.writeValue(response.getOutputStream(), newsModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
//
//	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//	}
}
