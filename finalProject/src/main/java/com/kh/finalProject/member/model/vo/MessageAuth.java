package com.kh.finalProject.member.model.vo;

import java.sql.Date;

public class MessageAuth {
	private int authNum;
	private String phone;
	private String sendDate;
	private String userName;
	
	public MessageAuth(int authNum, String phone, String sendDate) {
		super();
		this.authNum = authNum;
		this.phone = phone;
		this.sendDate = sendDate;
	}


	
	public MessageAuth(int authNum, String phone, String sendDate, String userName) {
		super();
		this.authNum = authNum;
		this.phone = phone;
		this.sendDate = sendDate;
		this.userName = userName;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public MessageAuth() {
		super();
	}
	
	
	public MessageAuth(int authNum, String phone) {
		super();
		this.authNum = authNum;
		this.phone = phone;
	}
	


	public String getSendDate() {
		return sendDate;
	}


	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}


	public int getAuthNum() {
		return authNum;
	}
	public void setAuthNum(int authNum) {
		this.authNum = authNum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "MessageAuth [authNum=" + authNum + ", phone=" + phone + "]";
	}
	
	

}
