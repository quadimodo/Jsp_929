package com.xyztech.jsp.bean;

import java.io.Serializable;

public class PictureBean implements Serializable {
	private int pid;
	private String pname;
	private String ppath;
	private int pdisplay;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPpath() {
		return ppath;
	}
	public void setPpath(String ppath) {
		this.ppath = ppath;
	}
	public int getPdisplay() {
		return pdisplay;
	}
	public void setPdisplay(int pdisplay) {
		this.pdisplay = pdisplay;
	}
	public PictureBean( String pname, String ppath, int pdisplay) {
		super();
		this.pname = pname;
		this.ppath = ppath;
		this.pdisplay = pdisplay;
	}
	public PictureBean() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	
}
