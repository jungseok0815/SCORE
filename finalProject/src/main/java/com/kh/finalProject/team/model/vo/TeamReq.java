package com.kh.finalProject.team.model.vo;

public class TeamReq {

	private int reqNo;
	private String reqStatus;
	private int reqUserNo;
	private int offerNo;
	private String reqContent;
	private String userName;
	private String gender;
	private int userLevel;
	private String city;
	private int userBirth;
	private String memberChangeName;
	
	public TeamReq() {}

//	public TeamReq(int reqNo, String reqStatus, int reqUserNo, int offerNo, String reqContent) {
//		super();
//		this.reqNo = reqNo;
//		this.reqStatus = reqStatus;
//		this.reqUserNo = reqUserNo;
//		this.offerNo = offerNo;
//		this.reqContent = reqContent;
//	}

	
	public TeamReq(int reqNo, String reqStatus, int reqUserNo, int offerNo, String reqContent, String userName,
		String gender, int userLevel, String city, int userBirth, String memberChangeName) {
	super();
	this.reqNo = reqNo;
	this.reqStatus = reqStatus;
	this.reqUserNo = reqUserNo;
	this.offerNo = offerNo;
	this.reqContent = reqContent;
	this.userName = userName;
	this.gender = gender;
	this.userLevel = userLevel;
	this.city = city;
	this.userBirth = userBirth;
	this.memberChangeName = memberChangeName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(int userBirth) {
		this.userBirth = userBirth;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public int getReqUserNo() {
		return reqUserNo;
	}

	public void setReqUserNo(int reqUserNo) {
		this.reqUserNo = reqUserNo;
	}

	public int getOfferNo() {
		return offerNo;
	}

	public void setOfferNo(int offerNo) {
		this.offerNo = offerNo;
	}

	public String getReqContent() {
		return reqContent;
	}

	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}

	@Override
	public String toString() {
		return "TeamReq [reqNo=" + reqNo + ", reqStatus=" + reqStatus + ", reqUserNo=" + reqUserNo + ", offerNo="
				+ offerNo + ", reqContent=" + reqContent + ", userName=" + userName + ", gender=" + gender
				+ ", userLevel=" + userLevel + ", city=" + city + ", userBirth=" + userBirth + ", memberChangeName="
				+ memberChangeName + "]";
	}

}
