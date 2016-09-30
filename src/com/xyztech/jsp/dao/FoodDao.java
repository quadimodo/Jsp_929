package com.xyztech.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xyztech.jsp.bean.FoodBean;


public class FoodDao extends PublicConnection {
	Connection con=connections("RestaurantOfficialWebsite");
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	public ArrayList<FoodBean> selectfood(){
		String sql="select fid,ftname,ppath,fname,fdetial,fprice from food as a,foodtype as b,picture as c where a.ftid=b.ftid and a.pid =c.pid";
		try {
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<FoodBean> al=new ArrayList<FoodBean>();
			while(rs.next()){
				FoodBean foodbean=new FoodBean(rs.getInt(1), rs.getObject(2), rs.getObject(3), rs.getString(4), rs.getString(5),rs.getDouble(6));
				al.add(foodbean);
			}
			return al;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeSql(con, pst, rs);
		}
		return null;
	}
	public void insertfood(FoodBean foodbean){
		//insert food values (2,5,'food20','甜不辣好好吃',111.00)
		String sql="insert food values (?,?,?,?,?)";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, foodbean.get);
			pst.setInt(2, pid);
			pst.setString(3, fname);
			pst.setString(4, fdetial);
			pst.setDouble(5, fprice);
			
			int i =pst.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeSql(con, pst, rs);
		}
		
	}
}
