package com.kh.finalProject.team.model.vo;

import java.sql.Date;

public class TeamMember {
	
	private int tmemberNo;
	private Date enrollDate;
	private int teamNo;
	private int userNo;
	private int grade;
	
	public TeamMember() {
		super();
	}

	public int getTmemberNo() {
		return tmemberNo;
	}

	public void setTmemberNo(int tmemberNo) {
		this.tmemberNo = tmemberNo;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "TeamMember [tmemberNo=" + tmemberNo + ", enrollDate=" + enrollDate + ", teamNo=" + teamNo + ", userNo="
				+ userNo + ", grade=" + grade + "]";
	}
	
	
}
