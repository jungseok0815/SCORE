package com.kh.finalProject.place.model.vo;

import java.util.Date;

public class Field {

	 private int fieldNo;
	 private String fieldName;
	 private String fieldArea;
	 private String fieldDate;
	 private Date fieldEnrollDate;
	 private int fieldCount;
	 private String fieldSize;
	 private int parking;
	 private int matchGender;
	 private String shoes;
	 private String manager;
	 private String matchLevel;
	 private String startTime;
	 private String endTime;
	 private int matchPay;
	 private int categoryNum;
	 
	 public Field () {}
	 
	public Field(int fieldNo, String fieldName, String fieldArea, String fieldDate, Date fieldEnrollDate,
			int fieldCount, String fieldSize, int parking, int matchGender, String shoes, String manager,
			String matchLevel, String startTime, String endTime, int matchPay, int categoryNum) {
		super();
		this.fieldNo = fieldNo;
		this.fieldName = fieldName;
		this.fieldArea = fieldArea;
		this.fieldDate = fieldDate;
		this.fieldEnrollDate = fieldEnrollDate;
		this.fieldCount = fieldCount;
		this.fieldSize = fieldSize;
		this.parking = parking;
		this.matchGender = matchGender;
		this.shoes = shoes;
		this.manager = manager;
		this.matchLevel = matchLevel;
		this.startTime = startTime;
		this.endTime = endTime;
		this.matchPay = matchPay;
		this.categoryNum = categoryNum;
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
	public String getFieldArea() {
		return fieldArea;
	}
	public void setFieldArea(String fieldArea) {
		this.fieldArea = fieldArea;
	}
	public String getFieldDate() {
		return fieldDate;
	}
	public void setFieldDate(String fieldDate) {
		this.fieldDate = fieldDate;
	}
	public Date getFieldEnrollDate() {
		return fieldEnrollDate;
	}
	public void setFieldEnrollDate(Date fieldEnrollDate) {
		this.fieldEnrollDate = fieldEnrollDate;
	}
	public int getFieldCount() {
		return fieldCount;
	}
	public void setFieldCount(int fieldCount) {
		this.fieldCount = fieldCount;
	}
	public String getFieldSize() {
		return fieldSize;
	}
	public void setFieldSize(String fieldSize) {
		this.fieldSize = fieldSize;
	}
	public int getParking() {
		return parking;
	}
	public void setParking(int parking) {
		this.parking = parking;
	}
	public int getMatchGender() {
		return matchGender;
	}
	public void setMatchGender(int matchGender) {
		this.matchGender = matchGender;
	}
	public String getShoes() {
		return shoes;
	}
	public void setShoes(String shoes) {
		this.shoes = shoes;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getMatchLevel() {
		return matchLevel;
	}
	public void setMatchLevel(String matchLevel) {
		this.matchLevel = matchLevel;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getMatchPay() {
		return matchPay;
	}
	public void setMatchPay(int matchPay) {
		this.matchPay = matchPay;
	}
	public int getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}
	@Override
	public String toString() {
		return "Field [fieldNo=" + fieldNo + ", fieldName=" + fieldName + ", fieldArea=" + fieldArea + ", fieldDate="
				+ fieldDate + ", fieldEnrollDate=" + fieldEnrollDate + ", fieldCount=" + fieldCount + ", fieldSize="
				+ fieldSize + ", parking=" + parking + ", matchGender=" + matchGender + ", shoes=" + shoes
				+ ", manager=" + manager + ", matchLevel=" + matchLevel + ", startTime=" + startTime + ", endTime="
				+ endTime + ", matchPay=" + matchPay + ", categoryNum=" + categoryNum + "]";
	}

	
	 
}
