package com.fansite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class UserCreateAction extends ActionSupport implements SessionAware{
	Map<String,Object>session;
	public String execute(){

		/**
		 * アカウント作成用のページへ
		 *
		 */
		System.out.println(session.get("loginFlg")+"です");//フラグ確認用

		return SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
}
}
