package com.xyztech.jsp.dao;

import java.sql.*;

import com.xyztech.jsp.bean.UserBean;

public class LoginDataBase extends PublicConnection {
	Connection con=connections("RestaurantOfficialWebsite");
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	public UserBean checkLogin(String username,String password){
		String sql="select  *  from [user] where uname=? and upassword=? ";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs=pst.executeQuery();
			if(rs.next()){
				UserBean userbean=new UserBean(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8));
				return userbean;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			closeSql(con, pst, rs);
		}
		
		return null;
	}
}
