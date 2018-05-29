package com.fansite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fansite.dao.ItemDAO;
import com.fansite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	ArrayList<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();

	public String execute() {
		String result = SUCCESS;

		ItemDAO dao = new ItemDAO();
		itemDTOList = dao.itemDTO();


		session.put("ItemInfo", itemDTOList);
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemDTO> getItemDTOList() {
		return itemDTOList;
	}

	public void setItemDTOList(ArrayList<ItemDTO> itemDTOList) {
		this.itemDTOList = itemDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}
