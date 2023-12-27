package com.kh.finalProject.place.model.vo;

import java.sql.Date;

public class PlaceReview {
	private int reviewNo;
	private String categoryNum;
	private int fieldNo;
	private String userNo;
	private int resNo;
	private String fieldArea;
	private int reviewCount;
	private String reviewContent;
	private Date reviewEnrollDate;
	private int starRating;
	private String fieldReviewStatus;
	private String userName;
	private String fieldName;
	
	
	public PlaceReview () {}


	public PlaceReview(int reviewNo, String categoryNum, int fieldNo, String userNo, int resNo, String fieldArea,
			int reviewCount, String reviewContent, Date reviewEnrollDate, int starRating, String fieldReviewStatus,
			String userName, String fieldName) {
		super();
		this.reviewNo = reviewNo;
		this.categoryNum = categoryNum;
		this.fieldNo = fieldNo;
		this.userNo = userNo;
		this.resNo = resNo;
		this.fieldArea = fieldArea;
		this.reviewCount = reviewCount;
		this.reviewContent = reviewContent;
		this.reviewEnrollDate = reviewEnrollDate;
		this.starRating = starRating;
		this.fieldReviewStatus = fieldReviewStatus;
		this.userName = userName;
		this.fieldName = fieldName;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getCategoryNum() {
		return categoryNum;
	}


	public void setCategoryNum(String categoryNum) {
		this.categoryNum = categoryNum;
	}


	public int getFieldNo() {
		return fieldNo;
	}


	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}


	public String getUserNo() {
		return userNo;
	}


	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}


	public int getResNo() {
		return resNo;
	}


	public void setResNo(int resNo) {
		this.resNo = resNo;
	}


	public String getFieldArea() {
		return fieldArea;
	}


	public void setFieldArea(String fieldArea) {
		this.fieldArea = fieldArea;
	}


	public int getReviewCount() {
		return reviewCount;
	}


	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}


	public String getReviewContent() {
		return reviewContent;
	}


	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}


	public Date getReviewEnrollDate() {
		return reviewEnrollDate;
	}


	public void setReviewEnrollDate(Date reviewEnrollDate) {
		this.reviewEnrollDate = reviewEnrollDate;
	}


	public int getStarRating() {
		return starRating;
	}


	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}


	public String getFieldReviewStatus() {
		return fieldReviewStatus;
	}


	public void setFieldReviewStatus(String fieldReviewStatus) {
		this.fieldReviewStatus = fieldReviewStatus;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	@Override
	public String toString() {
		return "PlaceReview [reviewNo=" + reviewNo + ", categoryNum=" + categoryNum + ", fieldNo=" + fieldNo
				+ ", userNo=" + userNo + ", resNo=" + resNo + ", fieldArea=" + fieldArea + ", reviewCount="
				+ reviewCount + ", reviewContent=" + reviewContent + ", reviewEnrollDate=" + reviewEnrollDate
				+ ", starRating=" + starRating + ", fieldReviewStatus=" + fieldReviewStatus + ", userName=" + userName
				+ ", fieldName=" + fieldName + "]";
	}


	
}
