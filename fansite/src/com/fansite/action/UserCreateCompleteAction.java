package com.fansite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fansite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;
public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	private String username;
	private String sex;
	private String userpassword;
	public Map<String,Object>session;
	private  boolean sufferFlg;
	private boolean loginFlg;

	public String execute()throws SQLException{

		/**
		 * ユーザーを作成する
		 * ここでsqlに接続しデータを記述
		 *
		 */
		String result = null;
		UserCreateCompleteDAO dao = new UserCreateCompleteDAO();

		//sql内に既に同じユーザー名がないかを検索
		boolean a=dao.createUserConfirm(session.get("username").toString());
		if(a){

			//ユーザー名が被ったときのエラー表示用
			setSufferFlg(true);
			session.put("sufferFlg", sufferFlg);
			result = ERROR;
		}else{

			//なければ登録
			dao.createUser(session.get("username").toString(), session.get("sex").toString(), session.get("userpassword").toString());
			result = SUCCESS;

			//ログインフラグを立てる
			loginFlg = true;
			session.put("loginFlg", loginFlg);
		}

		return result;

	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserpassword() {
		return userpassword;
	}


	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}


	public boolean isLoginFlg() {
		return loginFlg;
	}


	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public String getUserName(){
		return username;
	}
	public String getSex(){
		return sex;
	}
	public String getUserPassword(){
		return userpassword;
	}
	public void setUserName(String username){
		this.username =username;
	}
	public void setSex(String sex){
		this.sex =sex;
	}
	public void setUserPassword(String userpassword){
		this.userpassword =userpassword;
	}
	public boolean getSufferFlg(){
		return sufferFlg;
	}
	public void setSufferFlg(boolean sufferFlg){
		this.sufferFlg= sufferFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public boolean setLoginFlg(){
		return loginFlg;
	}
}

