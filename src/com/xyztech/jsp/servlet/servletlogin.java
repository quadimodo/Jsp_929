package com.xyztech.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyztech.jsp.bean.UserBean;
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserBean userbean=new LoginDataBase().checkLogin(username, password);
		if(userbean !=null){
//			response.sendRedirect("index.html");
			request.setAttribute("beans", userbean);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.html");
		}
	}

}
