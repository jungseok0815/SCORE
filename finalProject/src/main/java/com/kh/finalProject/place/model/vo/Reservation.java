package com.kh.finalProject.place.model.vo;

import java.sql.Date;

public class Reservation {
	private int resNo;
	private Date resDate;
	private int resUserNo;
	private int fieldNo;
	
	private String fieldName; //경기장 이름
	private String fieldDate; //경기 날짜
	private String startTime; //경기 시작 시간
	private int categoryNum; //운동 카테고리 1축구 2야구 3농구
	
	public Reservation() {}

	public Reservation(int resNo, Date resDate, int resUserNo, int fieldNo, String fieldName, String fieldDate,
			String startTime, int categoryNum) {
		super();
		this.resNo = resNo;
		this.resDate = resDate;
		this.resUserNo = resUserNo;
		this.fieldNo = fieldNo;
		this.fieldName = fieldName;
		this.fieldDate = fieldDate;
		this.startTime = startTime;
		this.categoryNum = categoryNum;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

	public int getResUserNo() {
		return resUserNo;
	}

	public void setResUserNo(int resUserNo) {
		this.resUserNo = resUserNo;
	}

	public int getFieldNo() {
		return fieldNo;
	}

	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldDate() {
		return fieldDate;
	}

	public void setFieldDate(String fieldDate) {
		this.fieldDate = fieldDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	@Override
	public String toString() {
		return "Reservation [resNo=" + resNo + ", resDate=" + resDate + ", resUserNo=" + resUserNo + ", fieldNo="
				+ fieldNo + ", fieldName=" + fieldName + ", fieldDate=" + fieldDate + ", startTime=" + startTime
				+ ", categoryNum=" + categoryNum + "]";
	}
	
	
}
