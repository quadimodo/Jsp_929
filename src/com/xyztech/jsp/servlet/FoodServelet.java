package com.xyztech.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyztech.jsp.bean.FoodBean;
import com.xyztech.jsp.dao.FoodDao;

public class FoodServelet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2380406384999965479L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset:utf-8");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset:utf-8");
		ArrayList<FoodBean> al=new FoodDao().selectfood();
		request.getSession().setAttribute("food", al);
//		request.getRequestDispatcher("Menu/index.jsp").forward(request, response);
		response.sendRedirect("Menu/index.jsp");
	}

}
