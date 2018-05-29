package com.fansite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fansite.dao.MyPageLoginDAO;
import com.fansite.dto.MyPageLoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	ArrayList<MyPageLoginDTO> myPageLoginList = new ArrayList<MyPageLoginDTO>();

	public String execute() throws SQLException{
		String result = null;
		MyPageLoginDAO dao = new MyPageLoginDAO();

		/**
		 * マイページでは購入済み商品を表示する
		 * MyPageActionはログイン以外でマイページに飛ぶ
		 * また、ログイン時のみボタンが表示される
		 */


		/**
		 * データベース内の購入情報を参照する
		 * 情報はList内にdto形式で保存
		 */
		if((Boolean) session.get("loginFlg")){
			String completeFlg = "1";
			myPageLoginList = dao.myPageLoginDTO(session.get("username").toString(), completeFlg);
			session.put("itemInfo", myPageLoginList);
			result = SUCCESS;
		}else{
			result = ERROR;
		}
		return result;
	}
@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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

