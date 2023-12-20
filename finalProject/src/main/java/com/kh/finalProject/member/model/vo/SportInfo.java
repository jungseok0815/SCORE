package com.kh.finalProject.member.model.vo;

import java.util.Date;

public class SportInfo {

	private String sportLever;
	private int sportScore;
	private int sportCount;
	private String style;
	private String skill;
	private int userNo;
	private int categoryNum;
	private int sportSmile;
	private int sportYellow;
	private int sportRed;
	
	private int resNo;
	private Date resDate;
	private int resUserNo;
	private int fieldNo;
	private String userName;
	private String spoInfo;

	
	
	public SportInfo() {
		super();
	}



	public SportInfo(String sportLever, int sportScore, int sportCount, String style, String skill, int userNo,
			int categoryNum, int sportSmile, int sportYellow, int sportRed, int resNo, Date resDate, int resUserNo,
			int fieldNo, String userName) {
		super();
		this.sportLever = sportLever;
		this.sportScore = sportScore;
		this.sportCount = sportCount;
		this.style = style;
		this.skill = skill;
		this.userNo = userNo;
		this.categoryNum = categoryNum;
		this.sportSmile = sportSmile;
		this.sportYellow = sportYellow;
		this.sportRed = sportRed;
		this.resNo = resNo;
		this.resDate = resDate;
		this.resUserNo = resUserNo;
		this.fieldNo = fieldNo;
		this.userName = userName;
	}

	public String getSpoInfo() {
        return spoInfo;
    }

    public void setSpoInfo(String spoInfo) {
        this.spoInfo = spoInfo;
    }


	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}


	public int getResUserNo() {
		return resUserNo;
	}

	public void setResUserNo(int resUserNo) {
		this.resUserNo = resUserNo;
	}

	public int getFieldNo() {
		return fieldNo;
	}


	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}





	public String getSportLever() {
		return sportLever;
	}





	public void setSportLever(String sportLever) {
		this.sportLever = sportLever;
	}





	public int getSportScore() {
		return sportScore;
	}





	public void setSportScore(int sportScore) {
		this.sportScore = sportScore;
	}





	public int getSportCount() {
		return sportCount;
	}





	public void setSportCount(int sportCount) {
		this.sportCount = sportCount;
	}





	public String getStyle() {
		return style;
	}





	public void setStyle(String style) {
		this.style = style;
	}





	public String getSkill() {
		return skill;
	}





	public void setSkill(String skill) {
		this.skill = skill;
	}





	public int getUserNo() {
		return userNo;
	}





	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}





	public int getCategoryNum() {
		return categoryNum;
	}





	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}





	public int getSportSmile() {
		return sportSmile;
	}





	public void setSportSmile(int sportSmile) {
		this.sportSmile = sportSmile;
	}





	public int getSportYellow() {
		return sportYellow;
	}





	public void setSportYellow(int sportYellow) {
		this.sportYellow = sportYellow;
	}





	public int getSportRed() {
		return sportRed;
	}





	public void setSportRed(int sportRed) {
		this.sportRed = sportRed;
	}



	@Override
	public String toString() {
		return "SportInfo [sportLever=" + sportLever + ", sportScore=" + sportScore + ", sportCount=" + sportCount
				+ ", style=" + style + ", skill=" + skill + ", userNo=" + userNo + ", categoryNum=" + categoryNum
				+ ", sportSmile=" + sportSmile + ", sportYellow=" + sportYellow + ", sportRed=" + sportRed + ", resNo="
				+ resNo + ", resDate=" + resDate + ", resUserNo=" + resUserNo + ", fieldNo=" + fieldNo + ", userName="
				+ userName + "]";
	}



}
