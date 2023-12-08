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
	private int categotyNum;
	
	public Team() {}

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

	public int getCategotyNum() {
		return categotyNum;
	}

	public void setCategotyNum(int categotyNum) {
		this.categotyNum = categotyNum;
	}

	@Override
	public String toString() {
		return "Team [teamNo=" + teamNo + ", teamName=" + teamName + ", createDate=" + createDate + ", teamTitle="
				+ teamTitle + ", activityAtea=" + activityAtea + ", teamLevel=" + teamLevel + ", categotyNum="
				+ categotyNum + "]";
	}
	
	
	
}
