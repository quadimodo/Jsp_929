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
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO �Զ����ɵķ������
		//����������
		//��servletrequest תΪhttpservletrequest
		HttpServletRequest servletResuest=(HttpServletRequest) request;
		//��ȡ�����ʽget����post
		String sendformat =servletResuest.getMethod().toLowerCase();
		if(sendformat.equals("get")){
			request=new HttpServletRequestWrapper(servletResuest){
				@Override
				public String getParameter(String name) {
					// TODO �Զ����ɵķ������
					try {
						return new String(super.getParameter(name).getBytes("ISO-8859-1"), codeFormat);
					} catch (UnsupportedEncodingException e) {
						// TODO �Զ����ɵ� catch ��
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
		// TODO �Զ����ɵķ������
		//��ȡxml��������Ϣ
		codeFormat=filterConfig.getInitParameter("CodeFormat");
	}
		
}
