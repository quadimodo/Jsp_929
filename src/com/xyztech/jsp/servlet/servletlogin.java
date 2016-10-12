package com.xyztech.jsp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyztech.jsp.bean.FoodtypeBean;
import com.xyztech.jsp.bean.UserBean;
import com.xyztech.jsp.dao.FoodtypeDao;
import com.xyztech.jsp.dao.LoginDataBase;

public class servletlogin extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6641272429836918309L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//获取用户名密码以及验证码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String idcode=request.getParameter("idcode");
		idcode.toLowerCase();
		String idcode_yzm=(String) request.getSession().getAttribute("identitycode");
		//验证验证码是否正确，不区分大小写
		boolean ideq=idcode.equals(idcode_yzm.toLowerCase());
		UserBean userbean=new LoginDataBase().checkLogin(username, password);
		
		if(userbean !=null&&ideq==true){
//			response.sendRedirect("index.html");
			//获取foodtype下拉菜单的值
			ArrayList<FoodtypeBean> typelist=new FoodtypeDao().selectfoodtype();
			request.setAttribute("beans", userbean);
			request.getSession().setAttribute("typelist", typelist);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			response.sendRedirect("login2.html");
		}
	}

}
