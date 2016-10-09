package com.xyztech.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xyztech.jsp.bean.PictureBean;

public class PictureDao extends PublicConnection {
	//����ͼƬ
	public void insertpicture(PictureBean picturebean){
		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
		//insert picture values (88,'images\88.jpg',0)
		String sql="insert picture values (?,?,?)";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, picturebean.getPname());
			pst.setString(2,picturebean.getPpath());
			pst.setInt(3, picturebean.getPdisplay());
			int i =pst.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			closeSql(con, pst, rs);
		}
	}
	//����ͼƬ·����ѯpid
	public int selectpid(PictureBean picturebean){
		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
		String sql="select pid from picture where ppath=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, picturebean.getPpath());
			rs=pst.executeQuery();
			if(rs.next()){
				return rs.getInt("pid");
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			PublicConnection.closeSql(con, pst, rs);
		}
		return 0;
	}
	//����pid��ѯpicturebean
	public PictureBean selectPictureBean(String  ppath){
		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
		String sql="select * from picture where ppath=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, ppath);
			rs=pst.executeQuery();
			if(rs.next()){
				int pid=rs.getInt("pid");
				String pname=rs.getString("pname");
//				String ppath=rs.getString("ppath");
				int pdisplay=Integer.parseInt(rs.getString("pdisplay"));
				PictureBean pb=new PictureBean(pid,pname,ppath,pdisplay);
				return pb;
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			PublicConnection.closeSql(con, pst, rs);
		}
		return null;
	}
}
