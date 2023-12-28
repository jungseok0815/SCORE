package com.kh.finalProject.chatting.model.service;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.kh.finalProject.chatting.model.vo.ChattingRoom;
import com.kh.finalProject.chatting.model.vo.ChattingMember;
import com.kh.finalProject.chatting.model.vo.ChattingMessage;

public interface ChattingService {
	int addChattingRoom(ArrayList<ChattingMember> chMember,ChattingRoom room);
	
	ChattingRoom selectRoomInfo(String chList);
	int saveChattingNoReadMessage(ChattingMessage vo);
	int saveChattingReadMessage(ChattingMessage vo);
	ArrayList<ChattingMessage> selectChattingList(int roomNo);
	ArrayList<ChattingMember> selectChatiingRoomList(int userNo);
	ArrayList<ChattingMember> selectChatiingRoomListMem(int roomNo);
	ChattingMessage selectChattingMessage(int roomNo);
}