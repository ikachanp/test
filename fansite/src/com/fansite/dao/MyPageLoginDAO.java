package com.fansite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fansite.dto.MyPageLoginDTO;
import com.fansite.util.DBConnector;
public class MyPageLoginDAO {
	private String username;
	private String userpassword;

	public boolean userLogin(String username,String userpassword){
		boolean result =false;
		DBConnector db = new DBConnector();
		Connection con = db.getConnector();
		String sql = "SELECT * FROM login_user_info WHERE user_name =? AND user_password = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, userpassword);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println(username);
				System.out.println(userpassword);
				result = true;
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
			return result;
	}

	public ArrayList<MyPageLoginDTO> myPageLoginDTO(String username,String completeFlg) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnector();
		ArrayList<MyPageLoginDTO> myPageLoginDTO = new ArrayList<MyPageLoginDTO>();
		String sql = "SELECT  ibt.id,iit.item_name,ibt.total_price,ibt.total_count FROM item_buy_transaction ibt LEFT JOIN item_info_transaction iit ON ibt.item_transaction_id = iit.item_id WHERE ibt.user_master_id = ? AND ibt.buy_complete_Flg = ? ";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, completeFlg);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){

				MyPageLoginDTO dto = new MyPageLoginDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setTotalPrice(rs.getString("total_price"));
				myPageLoginDTO.add(dto);
			}
			}catch(SQLException e){
				e.printStackTrace();

			}finally{
				con.close();
			}
		return myPageLoginDTO;
		}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}


}
