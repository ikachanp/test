package com.kensaku.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kensaku.dto.ProductSearchDTO;
import com.kensaku.util.DBConnector;
public class ProductSearchDAO {

	//検索カテゴリ、ワード

	public ArrayList<ProductSearchDTO> productSearchDTO(int category,String search){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ProductSearchDTO> productSearchDTOList = new ArrayList<ProductSearchDTO>();

		//検索ワードを判定

		String sql = "SELECT * FROM product_info WHERE category_id = ? AND (product_name LIKE '%" + search + "%' OR product_name_kana LIKE '%" + search + "%' )";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, category);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ProductSearchDTO dto = new ProductSearchDTO();
				dto.setId(rs.getInt("id"));
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_name_kana(rs.getString("product_name_kana"));
				dto.setProduct_description(rs.getString("product_description"));
//				dto.setCategory_name(rs.getString("category_name"));
				dto.setPrice(rs.getInt("price"));
//				dto.setImage_file_path(rs.getString("image_file_path"));
//				dto.setImage_file_name(rs.getString("image_file_name"));
//				dto.setRelease_date(rs.getString("relese_date"));
//				dto.setStatus(rs.getInt("status"));
//				dto.setRegist_date(rs.getString("regist_date"));
//				dto.setUpdate_date(rs.getString("update_date"));

				productSearchDTOList.add(dto);	//Listにdtoを詰める
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productSearchDTOList;
 	}

	public ArrayList<ProductSearchDTO> productSearchDTO2(String search){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ProductSearchDTO> productSearchDTOList = new ArrayList<ProductSearchDTO>();

		//検索ワードを判定

		String sql = "SELECT * FROM product_info WHERE product_name LIKE '%" + search + "%' OR product_name_kana LIKE '%" + search + "%' ";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ProductSearchDTO dto = new ProductSearchDTO();
				dto.setId(rs.getInt("id"));
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_name_kana(rs.getString("product_name_kana"));
				dto.setProduct_description(rs.getString("product_description"));
//				dto.setCategory_name(rs.getString("category_name"));
				dto.setPrice(rs.getInt("price"));
//				dto.setImage_file_path(rs.getString("image_file_path"));
//				dto.setImage_file_name(rs.getString("image_file_name"));
//				dto.setRelease_date(rs.getString("relese_date"));
//				dto.setStatus(rs.getInt("status"));
//				dto.setRegist_date(rs.getString("regist_date"));
//				dto.setUpdate_date(rs.getString("update_date"));

				productSearchDTOList.add(dto);	//Listにdtoを詰める
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productSearchDTOList;
 	}
}
