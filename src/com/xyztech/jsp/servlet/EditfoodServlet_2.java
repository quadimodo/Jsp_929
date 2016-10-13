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
		//��food�˵��޸Ĺ������ݽ��бȶԣ�����Ѿ��޸ģ����ϴ�������
		int ftid=Integer.valueOf(request.getParameter("ftid"));
		String pname=request.getParameter("pname");
		String ppath=request.getParameter("ppath");
		int pdisplay=Integer.valueOf(request.getParameter("pdisplay"));
		//��ȡsession�е�fid
		FoodBean fb= (FoodBean) request.getSession().getAttribute("foodbean");
		int fid=fb.getFid();
		String fname=request.getParameter("fname");
		String fdetial=request.getParameter("fdetial");
		double fprice=Double.parseDouble(request.getParameter("fprice"));
		
		//��pictureװ��picturebean�����ж����ݿ��Ƿ���ڵ�ǰͼƬ����������ھʹ���
		PictureDao picturedao=new PictureDao();
		PictureBean picturebean=new PictureBean(pname,ppath,pdisplay);
		if(picturedao.selectbyppath(ppath)==null){
			picturedao.insertpicture(picturebean);			
		}
		
		//��foodbean�е�Ԫ�ش��룬�޸����е�ֵ
		//����ɹ�������̨��ʾfid �޸ĳɹ�
		FoodBean fb_1=new FoodBean(fid, ftid, pname, fname, fdetial, fprice);
		FoodDao fooddao=new FoodDao();
		fooddao.updatefood(fb_1);
		response.sendRedirect("Menu/index.jsp");
	}

}
