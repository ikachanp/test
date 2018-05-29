package com.internousdev.webproj5.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.webproj5.util.DBConnector;

public class ConnectDAO {
	DBConnector db =new DBConnector();
	Connection con = db.getConnection();

	String sql = "select * from users ";
	public boolean select(){
		boolean ret = false;
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ret = true;
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}
}
