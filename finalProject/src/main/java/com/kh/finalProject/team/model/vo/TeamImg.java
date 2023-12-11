package com.kh.finalProject.team.model.vo;

public class TeamImg {

	private int teamImgNo;
	private String teamImgUrl;
	private String teamOriginName;
	private String teamChangeName;
	private String deleteTeamImg;
	private int teamNo;
	private int offerNo;
	
	public TeamImg() {}

	public TeamImg(int teamImgNo, String teamImgUrl, String teamOriginName, String teamChangeName, String deleteTeamImg,
			int teamNo, int offerNo) {
		super();
		this.teamImgNo = teamImgNo;
		this.teamImgUrl = teamImgUrl;
		this.teamOriginName = teamOriginName;
		this.teamChangeName = teamChangeName;
		this.deleteTeamImg = deleteTeamImg;
		this.teamNo = teamNo;
		this.offerNo = offerNo;
	}

	public int getTeamImgNo() {
		return teamImgNo;
	}

	public void setTeamImgNo(int teamImgNo) {
		this.teamImgNo = teamImgNo;
	}

	public String getTeamImgUrl() {
		return teamImgUrl;
	}

	public void setTeamImgUrl(String teamImgUrl) {
		this.teamImgUrl = teamImgUrl;
	}

	public String getTeamOriginName() {
		return teamOriginName;
	}

	public void setTeamOriginName(String teamOriginName) {
		this.teamOriginName = teamOriginName;
	}

	public String getTeamChangeName() {
		return teamChangeName;
	}

	public void setTeamChangeName(String teamChangeName) {
		this.teamChangeName = teamChangeName;
	}

	public String getDeleteTeamImg() {
		return deleteTeamImg;
	}

	public void setDeleteTeamImg(String deleteTeamImg) {
		this.deleteTeamImg = deleteTeamImg;
	}

	public int getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}

	public int getOfferNo() {
		return offerNo;
	}

	public void setOfferNo(int offerNo) {
		this.offerNo = offerNo;
	}

	@Override
	public String toString() {
		return "TeamImg [teamImgNo=" + teamImgNo + ", teamImgUrl=" + teamImgUrl + ", teamOriginName=" + teamOriginName
				+ ", teamChangeName=" + teamChangeName + ", deleteTeamImg=" + deleteTeamImg + ", teamNo=" + teamNo
				+ ", offerNo=" + offerNo + "]";
	}
	
	
	
}
