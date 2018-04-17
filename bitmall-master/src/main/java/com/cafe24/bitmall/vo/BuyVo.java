package com.cafe24.bitmall.vo;

public class BuyVo {

	
	private Long no;
	
	private String orderday;
	
	private String orderName;
	
	private String orderphone;
	
	private String orderEmail;
	
	private String orderAddr;
	
	private String totalprice;
	
	private String pay;
	
	private String card;
	
	private String account;
	
	private String halbu;
	
	private Long user_no;
	
	
	//주문조회 위해 임의로 만든 필드임.
	private String productName;
	
	private Long product_no;
	
	private Long num;
	
	
	
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOrderday() {
		return orderday;
	}

	public void setOrderday(String orderday) {
		this.orderday = orderday;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderphone() {
		return orderphone;
	}

	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}

	public String getOrderEmail() {
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}


	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}



	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}
	

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getHalbu() {
		return halbu;
	}

	public void setHalbu(String halbu) {
		this.halbu = halbu;
	}

	public Long getUser_no() {
		return user_no;
	}

	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}

	public Long getProduct_no() {
		return product_no;
	}

	public void setProduct_no(Long product_no) {
		this.product_no = product_no;
	}

	@Override
	public String toString() {
		return "BuyVo [no=" + no + ", orderday=" + orderday + ", orderName=" + orderName + ", orderphone=" + orderphone
				+ ", orderEmail=" + orderEmail + ", orderAddr=" + orderAddr + ", totalprice=" + totalprice + ", pay="
				+ pay + ", card=" + card + ", account=" + account + ", halbu=" + halbu + ", user_no=" + user_no
				+ ", productName=" + productName + ", product_no=" + product_no + ", num=" + num + "]";
	}


	
	
	
	
	
	
	
	
	
}
