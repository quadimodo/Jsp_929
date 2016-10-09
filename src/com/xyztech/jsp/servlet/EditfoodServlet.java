package com.xyztech.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyztech.jsp.bean.FoodBean;
import com.xyztech.jsp.bean.PictureBean;
import com.xyztech.jsp.dao.FoodDao;
import com.xyztech.jsp.dao.PictureDao;

public class EditfoodServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 192880369536699277L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		int fid=Integer.parseInt(request.getParameter("fid"));
		FoodDao fooddao=new FoodDao();
		PictureDao picturedao=new PictureDao();
		FoodBean foodbean=fooddao.selectfood(fid);
		PictureBean picturebean=picturedao.selectPictureBean((String)foodbean.getPicture());
		request.getSession().setAttribute("foodbean", foodbean);
		request.getSession().setAttribute("picturebean", picturebean);
		response.sendRedirect("Menu/edit.jsp");
	}

}
