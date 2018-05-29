package com.fansite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class ItemInfoAction extends ActionSupport implements SessionAware{
	public int itemId;
	public Map<String,Object>session;
	public String execute(){
		System.out.println(itemId);
		session.put("itemNumber", itemId);
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
