package com.fansite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport implements SessionAware{
	Map<String,Object>session;
		public String execute(){

			/**
			 * ログインページはログインしていれば表示されない
			 * 追記：仕様変更でそもそもログイン中はボタンが表示されない
			 */
			String result = ERROR;

			System.out.println(session.get("loginFlg")+"です");//フラグ確認用

			if((Boolean)session.get("loginFlg")){
				result = SUCCESS;
			}
			return result;
		}

@Override
public void setSession(Map<String, Object> session) {
	this.session = session;
	}
}
