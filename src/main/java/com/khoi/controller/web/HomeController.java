package com.khoi.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khoi.model.NewsModel;
import com.khoi.service.ICategoryService;
import com.khoi.service.INewService;

//urlPatterns cho tạo nhìu url
@WebServlet(urlPatterns = { "/trang-chu" })
public class HomeController extends HttpServlet {

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newService;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NewsModel newsModel = new NewsModel();
		newsModel.setTitle("bài 8");
		newsModel.setContent("bài 5");
		newsModel.setCategoryId(1l);

		newService.save(newsModel);
		request.setAttribute("categorys", categoryService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}

	protected void dopost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
