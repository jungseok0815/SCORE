package com.kh.finalProject.chatting.model.vo;

public class ChattingMember {
	private int ChattingMemberNo;
	private int userNo;
	private int roomNo;
	private String memberChangeName;
	private String userName;
	private String userId;
	private int teamNo;
	private int categoryNum;
	private String teamName;
	private String teamChangeName;
	
	
	
	public ChattingMember() {
		super();
	}


	public ChattingMember(int chattingMemberNo, int userNo, int roomNo) {
		super();
		ChattingMemberNo = chattingMemberNo;
		this.userNo = userNo;
		this.roomNo = roomNo;
	}


	public ChattingMember(int chattingMemberNo, int userNo, int roomNo, String memberChangeName, String userName) {
		super();
		ChattingMemberNo = chattingMemberNo;
		this.userNo = userNo;
		this.roomNo = roomNo;
		this.memberChangeName = memberChangeName;
		this.userName = userName;
	}


	public ChattingMember(int chattingMemberNo, int userNo, int roomNo, String memberChangeName, String userName,
			String userId) {
		super();
		ChattingMemberNo = chattingMemberNo;
		this.userNo = userNo;
		this.roomNo = roomNo;
		this.memberChangeName = memberChangeName;
		this.userName = userName;
		this.userId = userId;
	}

	
	

	public ChattingMember(int chattingMemberNo, int userNo, int roomNo, String memberChangeName, String userName,
			String userId, int teamNo, int categoryNum, String teamName, String teamChangeName) {
		super();
		ChattingMemberNo = chattingMemberNo;
		this.userNo = userNo;
		this.roomNo = roomNo;
		this.memberChangeName = memberChangeName;
		this.userName = userName;
		this.userId = userId;
		this.teamNo = teamNo;
		this.categoryNum = categoryNum;
		this.teamName = teamName;
		this.teamChangeName = teamChangeName;
	}


	public int getTeamNo() {
		return teamNo;
	}


	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}


	public int getCategoryNum() {
		return categoryNum;
	}


	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public String getTeamChangeName() {
		return teamChangeName;
	}


	public void setTeamChangeName(String teamChangeName) {
		this.teamChangeName = teamChangeName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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


	public int getChattingMemberNo() {
		return ChattingMemberNo;
	}


	public void setChattingMemberNo(int chattingMemberNo) {
		ChattingMemberNo = chattingMemberNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public int getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}


	@Override
	public String toString() {
		return "ChattingMember [ChattingMemberNo=" + ChattingMemberNo + ", userNo=" + userNo + ", roomNo=" + roomNo
				+ ", memberChangeName=" + memberChangeName + ", userName=" + userName + ", userId=" + userId
				+ ", teamNo=" + teamNo + ", categoryNum=" + categoryNum + ", teamName=" + teamName + ", teamChangeName="
				+ teamChangeName + "]";
	}


	
	
	

}
