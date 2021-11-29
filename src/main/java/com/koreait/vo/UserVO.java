package com.koreait.vo;

public class UserVO {
	
	private String id;
	private String pw;
	
	public UserVO() {;}
	
	public UserVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + "]";
	}
	
}
