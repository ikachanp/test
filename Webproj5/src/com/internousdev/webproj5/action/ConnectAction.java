package com.internousdev.webproj5.action;

import com.internousdev.webproj5.dao.ConnectDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ConnectAction extends ActionSupport{
	public String execute(){
		String ret = ERROR;
		ConnectDAO dao = new ConnectDAO();
		if(dao.select()){
			ret = SUCCESS;
		}
		return ret;
	}
}
