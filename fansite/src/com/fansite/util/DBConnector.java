package com.fansite.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private String drivername="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost/fansite";
	private String user="root";
	private String password="mysql";
	public Connection getConnector(){
		Connection con = null;
		try{
			Class.forName(drivername);
			con = DriverManager.getConnection(url,user,password);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return con;
	}
}
