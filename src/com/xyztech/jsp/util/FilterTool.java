package com.xyztech.jsp.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class FilterTool implements Filter {
	String codeFormat;
	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO 自动生成的方法存根
		//操作过滤器
		//将servletrequest 转为httpservletrequest
		HttpServletRequest servletResuest=(HttpServletRequest) request;
		//获取编码格式get或者post
		String sendformat =servletResuest.getMethod().toLowerCase();
		if(sendformat.equals("get")){
			request=new HttpServletRequestWrapper(servletResuest){
				@Override
				public String getParameter(String name) {
					// TODO 自动生成的方法存根
					try {
						return new String(super.getParameter(name).getBytes("ISO-8859-1"), codeFormat);
					} catch (UnsupportedEncodingException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					return null;
				}
			};
		}else {
			request.setCharacterEncoding(codeFormat);
			response.setCharacterEncoding(codeFormat);
		}
		
		chain.doFilter(request, response);
		}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO 自动生成的方法存根
		//获取xml的配置信息
		codeFormat=filterConfig.getInitParameter("CodeFormat");
	}
		
}
