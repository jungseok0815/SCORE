package com.kh.finalProject.member.model.vo;

import java.sql.Date;

public class MessageAuth {
	private int authNum;
	private String phone;
	private String sendDate;
	
	public MessageAuth(int authNum, String phone, String sendDate) {
		super();
		this.authNum = authNum;
		this.phone = phone;
		this.sendDate = sendDate;
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
