package com.internousdev.webproj5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj5.dto.LoginDTO;
import com.internousdev.webproj5.util.DBConnector;

public class LoginDAO {
	public String username;
	public String password;
	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public List<LoginDTO> select(String username,String password) {
	String sql = "select * from users where user_name=? and password=? ";
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			LoginDTO dto = new LoginDTO();
			dto.setPassword(rs.getString("password"));
			dto.setUserName(rs.getString("user_name"));
			loginDTOList.add(dto);
		}
		if(loginDTOList.size() <= 0){
			LoginDTO dto = new LoginDTO();
			dto.setUserName("なし");
			dto.setPassword("なし");
			loginDTOList.add(dto);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return loginDTOList;
	}
}
