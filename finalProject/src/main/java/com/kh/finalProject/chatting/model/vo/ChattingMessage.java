package com.kh.finalProject.chatting.model.vo;

import java.sql.Date;

public class ChattingMessage {
	private int messageNo;
	private String messageText;
	private int roomNo;
	private int userNo;
	private String memberChangeName;
	private String userName;
	private String semdDate;
	


	public ChattingMessage() {
		super();
	}


	public ChattingMessage(int messageNo, String messageText, int roomNo, int userNo) {
		super();
		this.messageNo = messageNo;
		this.messageText = messageText;
		this.roomNo = roomNo;
		this.userNo = userNo;
	}
	
	
	
	public ChattingMessage(int messageNo, String messageText, int roomNo, int userNo, String memberChangeName,
			String userName) {
		super();
		this.messageNo = messageNo;
		this.messageText = messageText;
		this.roomNo = roomNo;
		this.userNo = userNo;
		this.memberChangeName = memberChangeName;
		this.userName = userName;
	}


	public ChattingMessage(int messageNo, String messageText, int roomNo, int userNo, String memberChangeName,
			String userName, String semdDate) {
		super();
		this.messageNo = messageNo;
		this.messageText = messageText;
		this.roomNo = roomNo;
		this.userNo = userNo;
		this.memberChangeName = memberChangeName;
		this.userName = userName;
		this.semdDate = semdDate;
	}


	public String getSemdDate() {
		return semdDate;
	}


	public void setSemdDate(String semdDate) {
		this.semdDate = semdDate;
	}


	public String getMemberChangeName() {
		return memberChangeName;
	}


	public void setMemberChangeName(String memberChangeName) {
		this.memberChangeName = memberChangeName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getMessageNo() {
		return messageNo;
	}


	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}


	public String getMessageText() {
		return messageText;
	}


	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}


	public int getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	@Override
	public String toString() {
		return "ChattingMessage [messageNo=" + messageNo + ", messageText=" + messageText + ", roomNo=" + roomNo
				+ ", userNo=" + userNo + "]";
	}


	

}
