package com.xyztech.jsp.bean;

public class FoodtypeBean {
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
