package com.xyztech.jsp.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdCodeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置响应格式
		response.setContentType("image/jpeg");
		//设置宽高
		int width=150;
		int height=40;
		//创建画布
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//绘制工具
		Graphics gra=image.getGraphics();
		//绘制矩形
		gra.setColor(new Color(0x302726));
		//创建填充矩形
		gra.fillRect(0, 0, width, height);
		//创建矩形边框
//		gra.drawRect(10, 10, width, height);
		
		//从字符串中取值
		char zf[] ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random random=new Random();
		String identitycode="";
		for (int i=0;i<4;i++){
			String zfc=zf[random.nextInt(zf.length)]+"";
			identitycode+=zfc;
			//设置字符随机颜色
			gra.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			//设置字符字体
			gra.setFont(new Font("Segoe Print", Font.BOLD, 30));
			//设置字符位置
			gra.drawString(zfc, 10+30*i, 30+random.nextInt(10)*(Math.random()>0.5?1:-1));
		}
		
		//设置干扰线
		int[] xx=new int[10];
		int[] yy=new int[10];
		
		for(int i=0;i<2;i++){
			for (int j=0;j<10;j++){
				xx[j]=random.nextInt(150);
				yy[j]=random.nextInt(40);
			}
			gra.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			gra.drawPolyline(xx, yy, 10);	
		}
		//创建输出流
		OutputStream out=response.getOutputStream();
		//输出
		ImageIO.write(image, "jpeg", out);
		request.getSession().setAttribute("identitycode", identitycode);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
