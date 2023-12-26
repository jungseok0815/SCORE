package com.kh.finalProject.place.model.vo;

public class ReviewImg {
	private int reviewImgNo;
	private String reviewUrl;
	private String reviewOriginName;
	private String reviewChangeName;
	private String deleteReviewImg;
	private int reviewNo;
	
	public ReviewImg () {}

	public ReviewImg(int reviewImgNo, String reviewUrl, String reviewOriginName, String reviewChangeName,
			String deleteReviewImg, int reviewNo) {
		super();
		this.reviewImgNo = reviewImgNo;
		this.reviewUrl = reviewUrl;
		this.reviewOriginName = reviewOriginName;
		this.reviewChangeName = reviewChangeName;
		this.deleteReviewImg = deleteReviewImg;
		this.reviewNo = reviewNo;
	}

	public int getReviewImgNo() {
		return reviewImgNo;
	}

	public void setReviewImgNo(int reviewImgNo) {
		this.reviewImgNo = reviewImgNo;
	}

	public String getReviewUrl() {
		return reviewUrl;
	}

	public void setReviewUrl(String reviewUrl) {
		this.reviewUrl = reviewUrl;
	}

	public String getReviewOriginName() {
		return reviewOriginName;
	}

	public void setReviewOriginName(String reviewOriginName) {
		this.reviewOriginName = reviewOriginName;
	}

	public String getReviewChangeName() {
		return reviewChangeName;
	}

	public void setReviewChangeName(String reviewChangeName) {
		this.reviewChangeName = reviewChangeName;
	}

	public String getDeleteReviewImg() {
		return deleteReviewImg;
	}

	public void setDeleteReviewImg(String deleteReviewImg) {
		this.deleteReviewImg = deleteReviewImg;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	@Override
	public String toString() {
		return "ReviewImg [reviewImgNo=" + reviewImgNo + ", reviewUrl=" + reviewUrl + ", reviewOriginName="
				+ reviewOriginName + ", reviewChangeName=" + reviewChangeName + ", deleteReviewImg=" + deleteReviewImg
				+ ", reviewNo=" + reviewNo + "]";
	}
	
	
}


