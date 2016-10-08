package com.xyztech.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xyztech.jsp.bean.FoodBean;
import com.xyztech.jsp.bean.PictureBean;


public class FoodDao extends PublicConnection {
	public ArrayList<FoodBean> selectfood(){
		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
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
		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
		//insert food values (2,5,'food20','甜不辣好好吃',111.00)
		String sql="insert food values (?,?,?,?,?)";
		try {
			pst=con.prepareStatement(sql);
			pst.setObject(1, foodbean.getFoodtype());
			pst.setObject(2,foodbean.getPicture());
			pst.setString(3, foodbean.getFname());
			pst.setString(4, foodbean.getFdetial());
			pst.setString(5, foodbean.getFprice());
			int i =pst.executeUpdate();
			if(i!=0){
				System.out.println("成功添加fid="+foodbean.getFid());
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeSql(con, pst, rs);
		}
	}
	public void deletefood(int fid){
		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
		String sql="delete food where fid=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, fid);
			int i=pst.executeUpdate();
			if(i!=0){
				System.out.println("成功删除pid="+fid);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeSql(con, pst, rs);
		}
	}
	
}
