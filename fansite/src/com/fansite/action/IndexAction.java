package com.fansite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements SessionAware{
	private boolean loginFlg;
	public Map<String,Object>session;

	public String execute(){

		/**
		 * ログインフラグの作成
		 * 初期値はfalse
		 */
		loginFlg = false;
		session.put("loginFlg", loginFlg);
		return SUCCESS;

	}
	public boolean getLoginFlg(){
		return loginFlg;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
}
}
