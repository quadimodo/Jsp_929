package com.xyztech.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.xyztech.jsp.bean.FoodBean;



public class FoodDao extends PublicConnection {
	//显示所有菜品
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
	//增加菜品
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
	//删除菜品
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
	//根据fid查询菜品
	public FoodBean selectfood(int fid){
		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
		String sql="select fid,b.ftid,ppath,fname,fdetial,fprice from food as a,foodtype as b,picture as c where a.ftid=b.ftid and a.pid =c.pid and fid=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, fid);
			rs=pst.executeQuery();
			if(rs.next()){
				FoodBean foodbean=new FoodBean(rs.getInt(1), rs.getObject(2), rs.getObject(3), rs.getString(4), rs.getString(5),rs.getDouble(6));
				return foodbean;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeSql(con, pst, rs);
		}
		return null;
	}
	//修改菜品
	public void updatefood(FoodBean foodbean){

		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
		String sql="update food set ftid=?,pid=?,fname=?,fdetial=?,fprice=?  where fid=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setObject(1, foodbean.getFoodtype());
			pst.setObject(2, foodbean.getFprice());
			pst.setString(3, foodbean.getFname());
			pst.setString(4, foodbean.getFdetial());
			pst.setString(5,foodbean.getFprice());
			pst.setInt(6, foodbean.getFid());
			int i=pst.executeUpdate();
			if(i!=0){
				System.out.println("成功修改fid="+foodbean.getFid());
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeSql(con, pst, rs);
		}
	}
	//根据页面选择菜单
	public ArrayList<FoodBean> selectpagefood(int pagenum){
		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
		String sql="select top 8 fid,ftname,ppath,fname,fdetial,fprice from food as a,foodtype as b,picture as c where a.ftid=b.ftid and a.pid =c.pid and fid not in (select top  ((?-1)*8) fid from food )";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, pagenum);
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
	//返回菜品总行数
	public int selectcount(){
		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
		String sql="select COUNT(*) from food";
		try {
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeSql(con, pst, rs);
		}
		return -1;
	}
}
