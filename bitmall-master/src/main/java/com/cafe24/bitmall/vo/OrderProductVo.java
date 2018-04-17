package com.cafe24.bitmall.vo;

public class OrderProductVo {

	
	private Long product_no;
	
	private Long order_no;

	private Long num;
	
	
	public Long getProduct_no() {
		return product_no;
	}

	public void setProduct_no(Long product_no) {
		this.product_no = product_no;
	}

	public Long getOrder_no() {
		return order_no;
	}

	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "OrderProductVo [product_no=" + product_no + ", order_no=" + order_no + ", num=" + num + "]";
	}

	
	
	

	
	
	
	
	
	
}
