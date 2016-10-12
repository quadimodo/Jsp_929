package com.xyztech.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xyztech.jsp.bean.FoodtypeBean;

public class FoodtypeDao extends PublicConnection {
	//��ȡfoodtype ������
	public ArrayList<FoodtypeBean> selectfoodtype(){
		Connection con=connections("RestaurantOfficialWebsite");
		ResultSet rs=null;
		PreparedStatement pst=null;
		String sql="select * from foodtype";
		try {
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<FoodtypeBean> al=new ArrayList<FoodtypeBean>();
			while(rs.next()){
				FoodtypeBean typebean=new FoodtypeBean(rs.getInt(1), rs.getString(2));
				al.add(typebean);
			}
			return al;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			closeSql(con, pst, rs);
		}
		return null;
	}
}
