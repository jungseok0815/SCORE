package com.kh.finalProject.place.model.vo;

import java.sql.Date;

public class Reply {
	public int replyNo;
	public String replyWriter;
	public String replyContent;
	public Date replyDate;
	public int userNo;
	public int fieldNo;
	
	public Reply() {}

	public Reply(int replyNo, String replyWriter, String replyContent, Date replyDate, int userNo, int fieldNo) {
		super();
		this.replyNo = replyNo;
		this.replyWriter = replyWriter;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.userNo = userNo;
		this.fieldNo = fieldNo;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getFieldNo() {
		return fieldNo;
	}

	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyWriter=" + replyWriter + ", replyContent=" + replyContent
				+ ", replyDate=" + replyDate + ", userNo=" + userNo + ", fieldNo=" + fieldNo + "]";
	}

	
}
