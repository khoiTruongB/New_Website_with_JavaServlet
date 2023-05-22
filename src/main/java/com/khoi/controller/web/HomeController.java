package com.khoi.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khoi.model.UserModel;
import com.khoi.service.ICategoryService;
import com.khoi.service.IUserService;
import com.khoi.utils.FormUtil;
import com.khoi.utils.SessionUtil;

//urlPatterns cho tạo nhìu url
@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat" })
public class HomeController extends HttpServlet {

	@Inject // giúp tạo đối tượng một lần duy nhất mà ko tạo nhiều là là agument của servlet weo
	private ICategoryService categoryService;

//	@Inject
//	private INewService newService;

	@Inject
	private IUserService userService;

	private static final long serialVersionUID = 1L;

	// get data từ file các file .properties
	ResourceBundle bundle = ResourceBundle.getBundle("message");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");

		if (message != null && alert != null) {
			request.setAttribute("message", bundle.getString(message));
			request.setAttribute("alert", alert);
		}

		if (action != null && action.equals("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "userModel");
			// response.sendRedirect: chuyển tới controller có tên /trang-chu
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		} else {
			// request.setAttribute("categorys", categoryService.findAll());
			// RequestDispatcher: trả về view
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action != null && action.equals("login")) {

			UserModel userModel = FormUtil.toModel(UserModel.class, request);
			userModel = userService.findByUserNameAndPassWordAndStatus(userModel.getUsername(), userModel.getPassword(), 1);
			if (userModel != null) {
				SessionUtil.getInstance().putValue(request, "userModel", userModel);
				// sử lí phân quyền
				if (userModel.getRole().getCode().equals("USER")) {

					response.sendRedirect(request.getContextPath() + "/trang-chu");

				} else if (userModel.getRole().getCode().equals("ADMIN")) {

					response.sendRedirect(request.getContextPath() + "/quan-tri/home");

				}

			} else {
				response.sendRedirect(
						request.getContextPath() + "/dang-nhap?action=login&message=errol_login&alert=danger");
			}
		}

	}

}
