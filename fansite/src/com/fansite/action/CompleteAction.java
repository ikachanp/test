package com.fansite.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fansite.dao.CartDAO;
import com.fansite.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CompleteAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private ArrayList<CartDTO> cartDTOList = new ArrayList<CartDTO>();

	@SuppressWarnings("unchecked")

	public String execute(){

		CartDTO dto = new CartDTO();
		CartDAO dao = new CartDAO();
		cartDTOList = (ArrayList<CartDTO>)session.get("cartDTOList");

		String completeFlg = "1";

		for(int i =0;i < cartDTOList.size();i++){
			dto = cartDTOList.get(i);
			
			dao.complete(dto.getId(),dto.getTotalPrice(),dto.getTotalCount(),session.get("username").toString(),completeFlg);
		}
		return SUCCESS;



	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
