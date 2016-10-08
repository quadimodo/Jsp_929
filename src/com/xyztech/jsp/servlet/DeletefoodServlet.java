package com.xyztech.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyztech.jsp.dao.FoodDao;

public class DeletefoodServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9095803449230585739L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		int fid=Integer.parseInt(request.getParameter("fid"));
		new FoodDao().deletefood(fid);
		response.sendRedirect("FoodServelet");
	}

}
