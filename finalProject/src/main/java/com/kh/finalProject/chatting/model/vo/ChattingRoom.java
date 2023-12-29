package com.kh.finalProject.chatting.model.vo;

public class ChattingRoom {
	private int roomNo;
	private String chattingMember;
	private int teamNo;
	
	

	public ChattingRoom() {
		super();
	}


	public ChattingRoom(int roomNo) {
		super();
		this.roomNo = roomNo;
	}
	

	public ChattingRoom(int roomNo, String chattingMember) {
		super();
		this.roomNo = roomNo;
		this.chattingMember = chattingMember;
	}


	public ChattingRoom(int roomNo, String chattingMember, int teamNo) {
		super();
		this.roomNo = roomNo;
		this.chattingMember = chattingMember;
		this.teamNo = teamNo;
	}


	public int getTeamNo() {
		return teamNo;
	}


	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}


	public String getChattingMember() {
		return chattingMember;
	}


	public void setChattingMember(String chattingMember) {
		this.chattingMember = chattingMember;
	}


	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}


	@Override
	public String toString() {
		return "Chatting [roomNo=" + roomNo + "]";
	}
	
	
	
}
