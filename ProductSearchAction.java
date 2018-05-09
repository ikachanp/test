package com.kensaku.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.kensaku.dao.ProductSearchDAO;
import com.kensaku.dto.ProductSearchDTO;
import com.opensymphony.xwork2.ActionSupport;
public class ProductSearchAction extends ActionSupport implements SessionAware{

	//検索カテゴリ、ワード
	private int category;
	private String search;
	private String errorMessage;

	public Map<String,Object>session;
	ArrayList<ProductSearchDTO> productSearchDTOList = new ArrayList<ProductSearchDTO>();

	public String execute(){
		String result = SUCCESS;
		System.out.println(category);
		System.out.println(search);
		//データベースからの検索内容
		ProductSearchDAO dao = new ProductSearchDAO();
		productSearchDTOList = dao.productSearchDTO(category, search);
		if(productSearchDTOList.size()==0){
			errorMessage = "検索結果がありません";
			session.put("productSearchList",productSearchDTOList);
		}else{
			session.put("productSearchList",productSearchDTOList);
		}

		System.out.println(productSearchDTOList.size());


		return result;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
