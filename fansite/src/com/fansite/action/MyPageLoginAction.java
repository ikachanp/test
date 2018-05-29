package com.fansite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fansite.dao.MyPageLoginDAO;
import com.fansite.dto.MyPageLoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageLoginAction extends ActionSupport implements SessionAware{
	private String username;
	private String userpassword;
	public Map<String,Object>session;
	ArrayList<MyPageLoginDTO> myPageLoginList = new ArrayList<MyPageLoginDTO>();

	public String execute()throws SQLException{
		/**
		 * マイページでは購入済み商品を表示する
		 * MyPageLoginActionはログイン時のみ使用する
		 * 追記：仕様変更にて商品の購入作業をsessionのみに
		 * カート追加から購入完了までをsessionで行うようにした
		 * そのため購入状況を確認するcompleteFlgは購入情報確認での意味を失った
		 */


		/**
		 * データベース内のユーザー情報を参照する
		 *
		 */
		String result = ERROR;
		MyPageLoginDAO dao = new MyPageLoginDAO();
		boolean check = dao.userLogin(username, userpassword);
		String completeFlg = "1";
		myPageLoginList = dao.myPageLoginDTO(username, completeFlg);
		if(check){
			session.put("username", username);
			boolean loginFlg = true;
			session.put("loginFlg", loginFlg);
			result = SUCCESS;
		}
		return result;
	}


@Override
public void setSession(Map<String, Object> session) {
	this.session = session;
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


public ArrayList<MyPageLoginDTO> getMyPageLoginList() {
	return myPageLoginList;
}


public void setMyPageLoginList(ArrayList<MyPageLoginDTO> myPageLoginList) {
	this.myPageLoginList = myPageLoginList;
}


public Map<String, Object> getSession() {
	return session;
}

}
