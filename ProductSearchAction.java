package com.kensaku.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.kensaku.dao.ProductSearchDAO;
import com.kensaku.dto.ProductSearchDTO;
import com.opensymphony.xwork2.ActionSupport;
public class ProductSearchAction extends ActionSupport implements SessionAware{

	//検索カテゴリ、ワード
	private String category = "0";
	private String search = "";
	private String errorMessage = null;

	public Map<String,Object>session;
	ArrayList<ProductSearchDTO> productSearchDTOList = new ArrayList<ProductSearchDTO>();

	public String execute(){
		String result = SUCCESS;

		//データベースからの検索内容
		ProductSearchDAO dao = new ProductSearchDAO();
		productSearchDTOList = dao.productSearchDTO(category, search);

		//1ページ9つ表示なのでproductSearchListを9つ詰めの幾つかに分ける必要あり

		ArrayList<ArrayList<ProductSearchDTO>> mainList = new ArrayList<ArrayList<ProductSearchDTO>>();










		return result;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<ProductSearchDTO> getProductSearchDTOList() {
		return productSearchDTOList;
	}
	public void setProductSearchDTOList(ArrayList<ProductSearchDTO> productSearchDTOList) {
		this.productSearchDTOList = productSearchDTOList;
	}

}
