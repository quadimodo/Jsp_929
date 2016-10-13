package com.xyztech.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyztech.jsp.bean.FoodBean;
import com.xyztech.jsp.bean.PictureBean;
import com.xyztech.jsp.dao.FoodDao;
import com.xyztech.jsp.dao.PictureDao;

public class EditfoodServlet_2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//对food菜单修改过的内容进行比对，如果已经修改，则上传服务器
		int ftid=Integer.valueOf(request.getParameter("ftid"));
		String pname=request.getParameter("pname");
		String ppath=request.getParameter("ppath");
		int pdisplay=Integer.valueOf(request.getParameter("pdisplay"));
		//获取session中的fid
		FoodBean fb= (FoodBean) request.getSession().getAttribute("foodbean");
		int fid=fb.getFid();
		String fname=request.getParameter("fname");
		String fdetial=request.getParameter("fdetial");
		double fprice=Double.parseDouble(request.getParameter("fprice"));
		
		//将picture装入picturebean，先判断数据库是否存在当前图片，如果不存在就创建
		PictureDao picturedao=new PictureDao();
		PictureBean picturebean=new PictureBean(pname,ppath,pdisplay);
		if(picturedao.selectbyppath(ppath)==null){
			picturedao.insertpicture(picturebean);			
		}
		
		//讲foodbean中的元素传入，修改其中的值
		//如果成功，控制台显示fid 修改成功
		FoodBean fb_1=new FoodBean(fid, ftid, pname, fname, fdetial, fprice);
		FoodDao fooddao=new FoodDao();
		fooddao.updatefood(fb_1);
		response.sendRedirect("Menu/index.jsp");
	}

}
