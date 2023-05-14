package com.khoi.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khoi.constant.SystemConstant;
import com.khoi.model.NewsModel;
import com.khoi.paging.PageRequest;
import com.khoi.paging.Pageble;
import com.khoi.service.INewService;
import com.khoi.sort.Sorter;
import com.khoi.utils.FormUtil;

//urlPatterns cho phép tạo nhìu url
@WebServlet(urlPatterns = { "/quan-tri-new" })
public class NewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewService newService;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// sử lí việc trả ra data vs param	
//cách 1: truyền thống
//		NewsModel model = new NewsModel();
//		String pageStr = request.getParameter("page");
//		String maxpage = request.getParameter("maxPageItem");
//		
//		if(pageStr != null) {
//			model.setPage(Integer.parseInt(pageStr));
//		}else {
//			model.setPage(1);
//		}
//		
//		if(maxpage != null) {
//			model.setMaxPageItem(Integer.parseInt(maxpage));
//		}
//		
//		cách 2: tự động chuyển các param về các thành phần trong model
		
		NewsModel model = FormUtil.toModel(NewsModel.class, request);
		
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		
		//Integer offset = (model.getPage() - 1) * model.getMaxPageItem();
		
		model.setListRs(newService.findAll(pageble));
		model.setToltalItem(newService.getToltalItem());
		model.setToltalPage((int) Math.ceil((double) model.getToltalItem() / model.getMaxPageItem()));
		request.setAttribute(SystemConstant.Model, model);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(request, response);
	}

}