package com.fansite.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fansite.dao.CartDAO;
import com.fansite.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements SessionAware{
	private int id;
	private String username;
	public Map<String,Object>session;
	private ArrayList<CartDTO> cartDTOList = new ArrayList<CartDTO>();
	public String execute(){
		String result = SUCCESS;
		CartDAO dao = new CartDAO();
		System.out.println(id);
		dao.cartDelete(id);

		session.get("username");
		String completeFlg = "0";
		cartDTOList = dao.cartDTO(session.get("username").toString(),completeFlg);
		session.put("CartInfo", cartDTOList);
		return result;


	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<CartDTO> getCartDTOList() {
		return cartDTOList;
	}

	public void setCartDTOList(ArrayList<CartDTO> cartDTOList) {
		this.cartDTOList = cartDTOList;
	}


}
