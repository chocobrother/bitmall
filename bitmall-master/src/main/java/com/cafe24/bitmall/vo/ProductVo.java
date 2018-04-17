package com.cafe24.bitmall.vo;

public class ProductVo {

	private Long no;
	
	private Long cate_no;
	
	private String code;
	
	private String productName;
	
	private String company;
	
	private String price;
	
	private Long num;
	


	private String state;
	
	private String content;
	
	private String image;
	
	private String event;
	
	private String opt_no;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getCate_no() {
		return cate_no;
	}

	public void setCate_no(Long cate_no) {
		this.cate_no = cate_no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	//임의로 작성
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getOpt_no() {
		return opt_no;
	}

	public void setOpt_no(String opt_no) {
		this.opt_no = opt_no;
	}

	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", cate_no=" + cate_no + ", code=" + code + ", productName=" + productName
				+ ", company=" + company + ", price=" + price + ", state=" + state + ", content=" + content + ", image="
				+ image + ", event=" + event + ", opt_no=" + opt_no + "]";
	}


	
	
	
}
