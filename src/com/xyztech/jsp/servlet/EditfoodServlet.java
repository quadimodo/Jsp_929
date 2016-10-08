package com.xyztech.jsp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyztech.jsp.bean.FoodBean;
import com.xyztech.jsp.dao.FoodDao;

public class EditfoodServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 192880369536699277L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		int fid=Integer.parseInt(request.getParameter("fid"));
		FoodDao fooddao=new FoodDao();
		FoodBean foodbean=fooddao.selectfood(fid);
		request.getSession().setAttribute("foodbean", foodbean);
		response.sendRedirect("Menu/edit.jsp");
	}

}
