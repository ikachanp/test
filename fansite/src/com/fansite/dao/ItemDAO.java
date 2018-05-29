package com.fansite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fansite.dto.ItemDTO;
import com.fansite.util.DBConnector;
public class ItemDAO {

	public ArrayList<ItemDTO> itemDTO(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnector();
		ArrayList<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();

		String sql = "SELECT * FROM item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){

				ItemDTO dto = new ItemDTO();
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemImagePath(rs.getString("item_image_path"));
				dto.setItemStock(rs.getString("item_stock"));
//				dto.setInsert_date(rs.getString("insert_date"));
				itemDTOList.add(dto);
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return itemDTOList;
	}
}
