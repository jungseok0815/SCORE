package com.kh.finalProject.team.model.vo;

import java.sql.Date;

public class TeamMember {
	
	private int tmemberNo;
	private Date enrollDate;
	private int teamNo;
	private int userNo;
	private int grade;
	private String userName;
	private String city;
	private String memberOriginName;
	private String memberChangeName;
	private String phone;
	
	
	public TeamMember() {
		super();
	}


	public TeamMember(int tmemberNo, Date enrollDate, int teamNo, int userNo, int grade, String userName, String city,
			String memberOriginName, String memberChangeName, String phone) {
		super();
		this.tmemberNo = tmemberNo;
		this.enrollDate = enrollDate;
		this.teamNo = teamNo;
		this.userNo = userNo;
		this.grade = grade;
		this.userName = userName;
		this.city = city;
		this.memberOriginName = memberOriginName;
		this.memberChangeName = memberChangeName;
		this.phone = phone;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getMemberOriginName() {
		return memberOriginName;
	}


	public void setMemberOriginName(String memberOriginName) {
		this.memberOriginName = memberOriginName;
	}


	public String getMemberChangeName() {
		return memberChangeName;
	}


	public void setMemberChangeName(String memberChangeName) {
		this.memberChangeName = memberChangeName;
	}


	@Override
	public String toString() {
		return "TeamMember [tmemberNo=" + tmemberNo + ", enrollDate=" + enrollDate + ", teamNo=" + teamNo + ", userNo="
				+ userNo + ", grade=" + grade + ", userName=" + userName + ", city=" + city + ", memberOriginName="
				+ memberOriginName + ", memberChangeName=" + memberChangeName + "]";
	}

	
	
	
}
