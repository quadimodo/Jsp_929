package com.xyztech.jsp.bean;

import java.io.Serializable;
import java.text.DecimalFormat;

public class FoodBean implements Serializable{
	private int fid;
	private Object foodtype;
	private Object picture;
	private String fname;
	private String fdetial;
	private double fprice;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public Object getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(FoodtypeBean foodtype) {
		this.foodtype = foodtype;
	}
	public Object getPicture() {
		return picture;
	}
	public void setPicture(PictureBean picture) {
		this.picture = picture;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFdetial() {
		return fdetial;
	}
	public void setFdetial(String fdetial) {
		this.fdetial = fdetial;
	}
	public String getFprice() {
		 DecimalFormat df = new DecimalFormat("#.00");
		return df.format(fprice);
	}
	public void setFprice(double fprice) {
		this.fprice = fprice;
	}
	public FoodBean( Object object, Object object2,
			String fname, String fdetial, double fprice) {
		super();
		this.foodtype = object;
		this.picture = object2;
		this.fname = fname;
		this.fdetial = fdetial;
		this.fprice = fprice;
	}
	public FoodBean(int fid, Object foodtype, Object picture, String fname,
			String fdetial, double fprice) {
		super();
		this.fid = fid;
		this.foodtype = foodtype;
		this.picture = picture;
		this.fname = fname;
		this.fdetial = fdetial;
		this.fprice = fprice;
	}
	public FoodBean() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}
