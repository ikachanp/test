package com.fansite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fansite.util.DBConnector;
import com.fansite.util.DateUtil;

public class UserCreateCompleteDAO {

	private DateUtil dateUtil = new DateUtil();

	public void createUser(String username, String sex, String userpassword) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnector();
		String sql = "INSERT INTO login_user_info(user_name,sex,user_password,insert_date) VALUES(?,?,?,?) ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, sex);
			ps.setString(3, userpassword);
			ps.setString(4, dateUtil.getDate());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean createUserConfirm(String username){
		DBConnector db = new DBConnector();
		Connection con = db.getConnector();
		boolean result = false;
		String sql="SELECT * FROM login_user_info WHERE user_name = ? ";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				result = true;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{

			try{
			con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	public DateUtil getDateUtil() {
		return dateUtil;
	}

	public void setDateUtil(DateUtil dateUtil) {
		this.dateUtil = dateUtil;
	}
}
