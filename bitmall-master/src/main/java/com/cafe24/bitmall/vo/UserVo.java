package com.cafe24.bitmall.vo;

public class UserVo {

	private Long count;
	
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	private Long no;
	
	private String grade;
	
	private String name;
	
	private String tel;
	
	private String phone;
	
	private String id;
	
	private String passwd;
	
	private String birth;
	
	private String zip;
	
	private String addr;
	
	private String email;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", grade=" + grade + ", name=" + name + ", tel=" + tel + ", phone=" + phone
				+ ", id=" + id + ", passwd=" + passwd + ", birth=" + birth + ", zip=" + zip + ", addr=" + addr
				+ ", email=" + email + "]";
	}
	
	
	

}
