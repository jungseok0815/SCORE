package com.kh.finalProject.team.model.vo;

import java.sql.Date;

public class Team {
	
// ---------------- 팀 컬럼 ---------------
	private int teamNo;
	private String teamName;
	private Date createDate;
	private String teamTitle;
	private String activityAtea;
	private String teamLevel;
	private int categoryNum;
	private String teamGender;
	private String teamUserAge;
	private String teamOriginName;
	private String teamChangeName;
	
	public Team() {}

	public Team(int teamNo, String teamName, Date createDate, String teamTitle, String activityAtea, String teamLevel,
			int categoryNum, String teamGender, String teamUserAge, String teamOriginName, String teamChangeName) {
		super();
		this.teamNo = teamNo;
		this.teamName = teamName;
		this.createDate = createDate;
		this.teamTitle = teamTitle;
		this.activityAtea = activityAtea;
		this.teamLevel = teamLevel;
		this.categoryNum = categoryNum;
		this.teamGender = teamGender;
		this.teamUserAge = teamUserAge;
		this.teamOriginName = teamOriginName;
		this.teamChangeName = teamChangeName;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getTeamTitle() {
		return teamTitle;
	}

	public void setTeamTitle(String teamTitle) {
		this.teamTitle = teamTitle;
	}

	public String getActivityAtea() {
		return activityAtea;
	}

	public void setActivityAtea(String activityAtea) {
		this.activityAtea = activityAtea;
	}

	public String getTeamLevel() {
		return teamLevel;
	}

	public void setTeamLevel(String teamLevel) {
		this.teamLevel = teamLevel;
	}


	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public String getTeamGender() {
		return teamGender;
	}

	public void setTeamGender(String teamGender) {
		this.teamGender = teamGender;
	}

	public String getTeamUserAge() {
		return teamUserAge;
	}

	public void setTeamUserAge(String teamUserAge) {
		this.teamUserAge = teamUserAge;
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

	@Override
	public String toString() {
		return "Team [teamNo=" + teamNo + ", teamName=" + teamName + ", createDate=" + createDate + ", teamTitle="
				+ teamTitle + ", activityAtea=" + activityAtea + ", teamLevel=" + teamLevel + ", categoryNum="
				+ categoryNum + ", teamGender=" + teamGender + ", teamUserAge=" + teamUserAge + ", teamOriginName="
				+ teamOriginName + ", teamChangeName=" + teamChangeName + "]";

	}

	
}
