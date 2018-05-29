package com.fansite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

//import com.fansite.dto.UserCreateDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private String username;
	private String sex;
	private String userpassword;
	private boolean error;

	public String execute(){

		/**
		 * ユーザーを作成する
		 * 情報を判別しsqlへ記述準備
		 * コメント部分は実装せず
		 * ログイン情報はsession内のusernameのみで判別
		 */

		String result =null;
//		UserCreateDTO userCreateDTO = new UserCreateDTO();

		//アカウント作成条件はユーザー名に＠が含まれパスワードが8文字以上
		if( !(username.equals(""))&& !(userpassword.equals(""))){
			if(username.contains("@")){
				if(userpassword.length()>=8 && userpassword.length()<=16){
//					userCreateDTO.setUsername(username);
//					userCreateDTO.setUserpassword(userpassword);
//					userCreateDTO.setSex(sex);
//					session.put("userInfo", userCreateDTO);
					session.put("username", username);
					session.put("userpassword", userpassword);
					session.put("sex", sex);
					result = SUCCESS;
				}
			}
		}else{
			//エラー時はjspにて表示
			setError(true);
			result = ERROR;
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getUsername() {
		return username;
	}

	public String getUsename(){
		return username;
	}
	public String getSex(){
		return sex;
	}
	public String getUserpassword(){
		return userpassword;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public void setUserpassword(String userpassword){
		this.userpassword=userpassword;
	}

@Override
	public void setSession(Map<String, Object>session) {
		this.session = session;
	}
	public boolean getError(){
		return error;
	}
	public void setError(boolean error){
		this.error=error;
	}
}