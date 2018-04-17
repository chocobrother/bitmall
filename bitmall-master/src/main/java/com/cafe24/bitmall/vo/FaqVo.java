package com.cafe24.bitmall.vo;

public class FaqVo {

	private Long no;
	
	private String qa_title;
	
	private String qa_content;
	
	private Long user_no;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getQa_title() {
		return qa_title;
	}

	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}

	public String getQa_content() {
		return qa_content;
	}

	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}

	public Long getUser_no() {
		return user_no;
	}

	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "FaqVo [no=" + no + ", qa_title=" + qa_title + ", qa_content=" + qa_content + ", user_no=" + user_no
				+ "]";
	}
	
	
	
	
	
}
