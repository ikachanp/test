package com.fansite.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fansite.dao.CartDAO;
import com.fansite.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private ArrayList<CartDTO> cartDTOList = new ArrayList<CartDTO>();
	public String execute(){
		CartDAO dao = new CartDAO();
		String completeFlg = "0";
		cartDTOList= dao.cartDTO(session.get("username").toString(), completeFlg);
		session.put("ItemInfo", cartDTOList);
		return SUCCESS;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<CartDTO> getCartDTOList() {
		return cartDTOList;
	}
	public void setCartDTOList(ArrayList<CartDTO> cartDTOList) {
		this.cartDTOList = cartDTOList;
	}

}
