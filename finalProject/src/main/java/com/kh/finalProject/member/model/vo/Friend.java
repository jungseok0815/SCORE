package com.kh.finalProject.member.model.vo;

public class Friend {
	
	private int friendNo;
	private int friendReqUser;
	private int friendResUser;
	private String friendStatus;
	
	
	
	public Friend() {
		super();
	}



	public Friend(int friendNo, int friendReqUser, int friendResUser, String friendStatus) {
		super();
		this.friendNo = friendNo;
		this.friendReqUser = friendReqUser;
		this.friendResUser = friendResUser;
		this.friendStatus = friendStatus;
	}



	public int getFriendNo() {
		return friendNo;
	}



	public void setFriendNo(int friendNo) {
		this.friendNo = friendNo;
	}



	public int getFriendReqUser() {
		return friendReqUser;
	}



	public void setFriendReqUser(int friendReqUser) {
		this.friendReqUser = friendReqUser;
	}



	public int getFriendResUser() {
		return friendResUser;
	}



	public void setFriendResUser(int friendResUser) {
		this.friendResUser = friendResUser;
	}



	public String getFriendStatus() {
		return friendStatus;
	}



	public void setFriendStatus(String friendStatus) {
		this.friendStatus = friendStatus;
	}



	@Override
	public String toString() {
		return "Friend [friendNo=" + friendNo + ", friendReqUser=" + friendReqUser + ", friendResUser=" + friendResUser
				+ ", friendStatus=" + friendStatus + "]";
	}
	
	
	
	
	

}
