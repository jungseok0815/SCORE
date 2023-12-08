package com.kh.finalProject.team.model.vo;

public class TeamOffer {

// ---------------- 구인글 컬럼 ---------------	
	private int offerNo;
	private String offerTitle;
	private String offerContent;
	private String offerGender;
	private String offerLevel;
	private int offerAge;
	private int offerCount;
	private int userNo;
	private int teamNo;
	private String teamName;
	private String activityAtea;
	private String offerStatus;

	public TeamOffer() {}

	public TeamOffer(int offerNo, String offerTitle, String offerContent, String offerGender, String offerLevel,
			int offerAge, int offerCount, int userNo, int teamNo, String teamName, String activityAtea,
			String offerStatus) {
		super();
		this.offerNo = offerNo;
		this.offerTitle = offerTitle;
		this.offerContent = offerContent;
		this.offerGender = offerGender;
		this.offerLevel = offerLevel;
		this.offerAge = offerAge;
		this.offerCount = offerCount;
		this.userNo = userNo;
		this.teamNo = teamNo;
		this.teamName = teamName;
		this.activityAtea = activityAtea;
		this.offerStatus = offerStatus;
	}

	public int getOfferNo() {
		return offerNo;
	}

	public void setOfferNo(int offerNo) {
		this.offerNo = offerNo;
	}

	public String getOfferTitle() {
		return offerTitle;
	}

	public void setOfferTitle(String offerTitle) {
		this.offerTitle = offerTitle;
	}

	public String getOfferContent() {
		return offerContent;
	}

	public void setOfferContent(String offerContent) {
		this.offerContent = offerContent;
	}

	public String getOfferGender() {
		return offerGender;
	}

	public void setOfferGender(String offerGender) {
		this.offerGender = offerGender;
	}

	public String getOfferLevel() {
		return offerLevel;
	}

	public void setOfferLevel(String offerLevel) {
		this.offerLevel = offerLevel;
	}

	public int getOfferAge() {
		return offerAge;
	}

	public void setOfferAge(int offerAge) {
		this.offerAge = offerAge;
	}

	public int getOfferCount() {
		return offerCount;
	}

	public void setOfferCount(int offerCount) {
		this.offerCount = offerCount;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getActivityAtea() {
		return activityAtea;
	}

	public void setActivityAtea(String activityAtea) {
		this.activityAtea = activityAtea;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	@Override
	public String toString() {
		return "TeamOffer [offerNo=" + offerNo + ", offerTitle=" + offerTitle + ", offerContent=" + offerContent
				+ ", offerGender=" + offerGender + ", offerLevel=" + offerLevel + ", offerAge=" + offerAge
				+ ", offerCount=" + offerCount + ", userNo=" + userNo + ", teamNo=" + teamNo + ", teamName=" + teamName
				+ ", activityAtea=" + activityAtea + ", offerStatus=" + offerStatus + "]";
	}

	
	
}
