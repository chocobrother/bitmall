package com.cafe24.bitmall.vo;

public class CartVo {

	
	private Long cart_no;
	
	private Long user_no;
	
	private Long product_no;
	
	private Long cartPrice;
	
	private String productName;
	
	private String image;

	private Long num;
	
	public Long getCart_no() {
		return cart_no;
	}

	public void setCart_no(Long cart_no) {
		this.cart_no = cart_no;
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

	public Long getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(Long cartPrice) {
		this.cartPrice = cartPrice;
	}

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "CartVo [cart_no=" + cart_no + ", user_no=" + user_no + ", product_no=" + product_no + ", cartPrice="
				+ cartPrice + ", productName=" + productName + ", image=" + image + ", num=" + num + "]";
	}

	
	

	
	
	
}
