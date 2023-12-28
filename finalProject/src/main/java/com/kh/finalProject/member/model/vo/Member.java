package com.kh.finalProject.member.model.vo;

public class Member {
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String gender;
	private String age;
	private String phone;
	private String address;
	private String status;
	private int point;
	private int userLevel;
	private int teamNo;
	private String memberChangeName;
	
	
	public Member() {
		super();
	}

	public Member(int userNo, String userId, String userPwd, String userName, String gender, String age, String phone,
			String address, String status, int point, int userLevel,String memberChangeName) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.status = status;
		this.point = point;
		this.userLevel = userLevel;
		this.memberChangeName = memberChangeName;
	}
	
	
	// 지워 버려 
	public Member(int userNo, String userId, String userPwd, String userName, String gender, String age, String phone,
			String address, String status, int point, int userLevel, int teamNo) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.status = status;
		this.point = point;
		this.userLevel = userLevel;
		this.teamNo = teamNo;
		this.memberChangeName = memberChangeName;
	}
	
	
	
	public String getMemberChangeName() {
		return memberChangeName;
	}

	public void setMemberChangeName(String memberChangeName) {
		this.memberChangeName = memberChangeName;
	}

	// 지워 버려 
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", gender=" + gender + ", age=" + age + ", phone=" + phone + ", address=" + address + ", status="
				+ status + ", point=" + point + ", userLevel=" + userLevel + ", teamNo=" + teamNo
				+ ", memberChangeName=" + memberChangeName + "]";
	}


	
	
	
}
