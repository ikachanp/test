package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.MyPageDTO;
import com.internousdev.template.util.DBConnector;

public class MyPageDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private MyPageDTO dto = new MyPageDTO();

	public MyPageDTO getMyPageUserInfo(String item_transaction_id, String user_master_id) throws SQLException{
		String sql = "SELECT it.item_name,ub.total_price,ub.total_count,ub.pay FROM user_buy_item_transaction ub "
				+ "LEFT JOIN item_info_transaction it ON ub.item_transaction_id = it.id WHERE ub.item_transaction_id "
				+ "= ?AND ub.user_master_id = ?ORDER BY ub.insert_date DESC";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				con.close();
		}
		return dto;
	}
	public int buyItemHistoryDelete(String item_transaction,String user_master_id)throws SQLException{
		String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id =  ? AND user_master_id = ? ";
		PreparedStatement ps;
		int result = 0;

		try{
			ps =con.prepareStatement(sql);
			ps.setString(1, item_transaction);
			ps.setString(2, user_master_id);

			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
}
