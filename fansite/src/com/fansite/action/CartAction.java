package com.fansite.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fansite.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;


public class CartAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private int itemId;
	private String itemName;
	private String itemPrice;
	private String totalCount;
	private String itemImagePath;
	private ArrayList<CartDTO> cartDTOList = new ArrayList<CartDTO>();


	@SuppressWarnings("unchecked")


	public String execute(){

		String result = ERROR;
		int count = Integer.parseInt(totalCount);
		int price = Integer.parseInt(itemPrice);

		int total = count * price ;

		String totalPrice = Integer.valueOf(total).toString();

		if(session.containsKey("cartDTOList")){
			cartDTOList = (ArrayList<CartDTO>) session.get("cartDTOList");
		}

		if((Boolean)session.get("loginFlg")){

			CartDTO dto = new CartDTO();
			dto.setId(itemId);
			dto.setItemName(itemName);
			dto.setTotalPrice(totalPrice);
			dto.setTotalCount(totalCount);
			dto.setItemImagePath(itemImagePath);
			cartDTOList.add(dto);
			result = SUCCESS;
		}
		session.put("cartDTOList", cartDTOList);
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCount() {
		return totalCount;
	}

	public void setItemCount(String itemCount) {
		this.totalCount = itemCount;
	}

	public ArrayList<CartDTO> getCartDTOList() {
		return cartDTOList;
	}

	public void setCartDTOList(ArrayList<CartDTO> cartDTOList) {
		this.cartDTOList = cartDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
