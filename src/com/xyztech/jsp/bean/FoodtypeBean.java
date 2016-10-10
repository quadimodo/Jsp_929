package com.xyztech.jsp.bean;

import java.io.Serializable;

public class FoodtypeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8081148394328306808L;
	private int ftid;
	private String ftname;
	public int getFtid() {
		return ftid;
	}
	public void setFtid(int ftid) {
		this.ftid = ftid;
	}
	public String getFtname() {
		return ftname;
	}
	public void setFtname(String ftname) {
		this.ftname = ftname;
	}
	public FoodtypeBean(int ftid, String ftname) {
		super();
		this.ftid = ftid;
		this.ftname = ftname;
	}
	public FoodtypeBean() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}
