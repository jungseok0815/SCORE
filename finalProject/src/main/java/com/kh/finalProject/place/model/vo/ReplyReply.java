package com.kh.finalProject.place.model.vo;

import java.sql.Date;

public class ReplyReply {
	private int replyReplyNo;
	private String replyReplyContent;
	private Date replyReplyDate;
	private int userNo;
	private int replyNo;
	private String userName;
	
	public ReplyReply() {
		super();
	}
	public ReplyReply(int replyReplyNo, String replyReplyContent, Date replyReplyDate, int userNo, int replyNo) {
		super();
		this.replyReplyNo = replyReplyNo;
		this.replyReplyContent = replyReplyContent;
		this.replyReplyDate = replyReplyDate;
		this.userNo = userNo;
		this.replyNo = replyNo;
	}
	
	
	
	public ReplyReply(int replyReplyNo, String replyReplyContent, Date replyReplyDate, int userNo, int replyNo,
			String userName) {
		super();
		this.replyReplyNo = replyReplyNo;
		this.replyReplyContent = replyReplyContent;
		this.replyReplyDate = replyReplyDate;
		this.userNo = userNo;
		this.replyNo = replyNo;
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getReplyReplyNo() {
		return replyReplyNo;
	}
	public void setReplyReplyNo(int replyReplyNo) {
		this.replyReplyNo = replyReplyNo;
	}
	public String getReplyReplyContent() {
		return replyReplyContent;
	}
	public void setReplyReplyContent(String replyReplyContent) {
		this.replyReplyContent = replyReplyContent;
	}
	public Date getReplyReplyDate() {
		return replyReplyDate;
	}
	public void setReplyReplyDate(Date replyReplyDate) {
		this.replyReplyDate = replyReplyDate;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	@Override
	public String toString() {
		return "ReplyReply [replyReplyNo=" + replyReplyNo + ", replyReplyContent=" + replyReplyContent
				+ ", replyReplyDate=" + replyReplyDate + ", userNo=" + userNo + ", replyNo=" + replyNo + "]";
	}
	
}

