package com.kh.finalProject.place.model.vo;

import java.sql.Date;

public class Place {
	
	private int fieldNo;
	private String fieldName;
	private String fieldArea;
	private Date fieldDate;
	private int fieldCount;
	private int parking;
	private int matchGender;
	private String shoes;
	private String manager;
	private String matchLevel;
	private int matchPay;
	private int categotyNum;
	
	public Place() {};
	
	public Place(int fieldNo, String fieldName, String fieldArea, Date fieldDate, int fieldCount, int parking,
			int matchGender, String shoes, String manager, String matchLevel, int matchPay, int categotyNum) {
		super();
		this.fieldNo = fieldNo;
		this.fieldName = fieldName;
		this.fieldArea = fieldArea;
		this.fieldDate = fieldDate;
		this.fieldCount = fieldCount;
		this.parking = parking;
		this.matchGender = matchGender;
		this.shoes = shoes;
		this.manager = manager;
		this.matchLevel = matchLevel;
		this.matchPay = matchPay;
		this.categotyNum = categotyNum;
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
	public Date getFieldDate() {
		return fieldDate;
	}
	public void setFieldDate(Date fieldDate) {
		this.fieldDate = fieldDate;
	}
	public int getFieldCount() {
		return fieldCount;
	}
	public void setFieldCount(int fieldCount) {
		this.fieldCount = fieldCount;
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
	public int getMatchPay() {
		return matchPay;
	}
	public void setMatchPay(int matchPay) {
		this.matchPay = matchPay;
	}
	public int getCategotyNum() {
		return categotyNum;
	}
	public void setCategotyNum(int categotyNum) {
		this.categotyNum = categotyNum;
	}

	@Override
	public String toString() {
		return "Place [fieldNo=" + fieldNo + ", fieldName=" + fieldName + ", fieldArea=" + fieldArea + ", fieldDate="
				+ fieldDate + ", fieldCount=" + fieldCount + ", parking=" + parking + ", matchGender=" + matchGender
				+ ", shoes=" + shoes + ", manager=" + manager + ", matchLevel=" + matchLevel + ", matchPay=" + matchPay
				+ ", categotyNum=" + categotyNum + "]";
	}
	
	
	
}
