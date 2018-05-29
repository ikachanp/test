package com.fansite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fansite.dto.CartDTO;
import com.fansite.util.DBConnector;
import com.fansite.util.DateUtil;



public class CartDAO {
	DateUtil date =new DateUtil();
	public void cartIn(int itemId,String totalPrice,String itemCount,String userid){
		DBConnector db = new DBConnector();
		Connection con = db.getConnector();
		String sql = "INSERT INTO item_buy_transaction (item_transaction_id,total_price,total_count,user_master_id,buy_complete_Flg,insert_date) VALUES (?,?,?,?,?,?)";

		String completeFlg= "0";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setString(2, totalPrice);
			ps.setString(3, itemCount);
			ps.setString(4, userid);
			ps.setString(5, completeFlg);
			ps.setString(6, date.getDate());
			int result = ps.executeUpdate();
			System.out.println(result);
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public ArrayList<CartDTO> cartDTO(String username,String completeFlg){
		DBConnector db = new DBConnector();
		Connection con = db.getConnector();
		ArrayList<CartDTO> cartDTOList = new ArrayList<CartDTO>();

		String sql = "SELECT iit.item_name,iit.item_image_path,ibt.total_price,ibt.total_count,ibt.id FROM item_buy_transaction ibt LEFT JOIN item_info_transaction iit ON ibt.item_transaction_id = iit.item_id  WHERE ibt.user_master_id = ? AND ibt.buy_complete_Flg = ? ";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, completeFlg);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				CartDTO dto = new CartDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemImagePath(rs.getString("item_image_path"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				cartDTOList.add(dto);
				System.out.println(rs.getInt("id"));
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return cartDTOList;
	}

	public void cartDelete(int id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnector();
		String sql = "DELETE FROM item_buy_transaction WHERE id=? ";
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void complete(int itemId,String totalPrice,String totalCount,String userId,String completeFlg){
		DBConnector db = new DBConnector();
		Connection con = db.getConnector();
		String sql = "INSERT INTO item_buy_transaction (item_transaction_id,total_price,total_count,user_master_id,buy_complete_Flg,insert_date) VALUES (?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setString(2, totalPrice);
			ps.setString(3, totalCount);
			ps.setString(4, userId);
			ps.setString(5, completeFlg);
			ps.setString(6, date.getDate());
			ps.execute();

			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
}
