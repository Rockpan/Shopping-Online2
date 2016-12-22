package com.hill.entity;

public class StoreDetail {
	 private int  sellerDetailId;
	 private String storeName;
	 private String sellerRealName;
	 private String sellerIdCard;
	 private String sellerPhone;
	 private String sellerAddress;
	public int getSellerDetailId() {
		return sellerDetailId;
	}
	public void setSellerDetailId(int sellerDetailId) {
		this.sellerDetailId = sellerDetailId;
	}
	
	public String getSellerIdCard() {
		return sellerIdCard;
	}
	public void setSellerIdCard(String sellerIdCard) {
		this.sellerIdCard = sellerIdCard;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getSellerRealName() {
		return sellerRealName;
	}
	public void setSellerRealName(String sellerRealName) {
		this.sellerRealName = sellerRealName;
	}
	 
}
