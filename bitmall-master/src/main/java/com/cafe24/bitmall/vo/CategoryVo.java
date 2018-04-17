package com.cafe24.bitmall.vo;

public class CategoryVo {

	private Long cate_no;
	
	private String posttype;
	
	private Long user_no;

	public Long getCate_no() {
		return cate_no;
	}

	public void setCate_no(Long cate_no) {
		this.cate_no = cate_no;
	}

	public String getPosttype() {
		return posttype;
	}

	public void setPosttype(String posttype) {
		this.posttype = posttype;
	}

	public Long getUser_no() {
		return user_no;
	}

	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "CategoryVo [cate_no=" + cate_no + ", posttype=" + posttype + ", user_no=" + user_no + "]";
	}
	
	
	
	
}
