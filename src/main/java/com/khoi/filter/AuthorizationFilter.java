package com.khoi.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import com.khoi.constant.SystemConstant;
import com.khoi.model.UserModel;
import com.khoi.utils.SessionUtil;

public class AuthorizationFilter implements Filter {
	
	
	private ServletContext context;
	
	//set filter
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//ép kiểu về http
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		String url = httpRequest.getRequestURI();
		if(url.startsWith("/quan-tri")) {
			//kiểm tra đăng nhập
			UserModel model = (UserModel)SessionUtil.getInstance().getValue(httpRequest, "userModel");
			if(model != null) {
				if(model.getRole().getCode().equals(SystemConstant.ADMIN)) {
					filterChain.doFilter(httpRequest, httpResponse);
				}else if(model.getRole().getCode().equals(SystemConstant.USER)) {
					httpResponse.sendRedirect(httpRequest.getContextPath()+"/dang-nhap?action=login&message=not_permission&alert=danger");
				}
			}else {
				httpResponse.sendRedirect(httpRequest.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
			}
		}else {
			filterChain.doFilter(httpRequest, httpResponse);
		}
	}
	
	@Override
	public void destroy() {
		
	}

}
