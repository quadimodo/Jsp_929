package com.xyztech.jsp.servlet;

import java.io.IOException;
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
		FoodDao fooddao=new FoodDao();
		int currentpage=Integer.parseInt(request.getParameter("currentpage"));
		ArrayList<FoodBean> al=fooddao.selectpagefood(currentpage);
		//总行数
		int totalnum=fooddao.selectcount();
		//总页数totalpage=(totalnum-1)/8+1
		int totalpage=(totalnum-1)/8+1;
		if(currentpage<=totalpage&&currentpage>0){
			request.getSession().setAttribute("food", al);
			request.getSession().setAttribute("totalnum", totalnum);
			request.getSession().setAttribute("totalpage", totalpage);
			request.getSession().setAttribute("currentpage", currentpage);
//			request.getRequestDispatcher("Menu/index.jsp").forward(request, response);
		
		}
		response.sendRedirect("Menu/index.jsp");
	}

}
