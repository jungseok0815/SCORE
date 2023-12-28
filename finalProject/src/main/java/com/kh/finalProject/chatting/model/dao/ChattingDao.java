package com.kh.finalProject.chatting.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonElement;
import com.kh.finalProject.chatting.model.vo.ChattingMember;
import com.kh.finalProject.chatting.model.vo.ChattingMessage;
import com.kh.finalProject.chatting.model.vo.ChattingRoom;
import com.kh.finalProject.notice.model.vo.Notice;

@Repository
public class ChattingDao {
	
	public int addChattingRoom(SqlSessionTemplate sqlSession,ChattingRoom room) {
		sqlSession.insert("chattingMapper.insertChattingRoom",room);
		int generatedRoomNo = room.getRoomNo();
	
		return generatedRoomNo;
	}
	public int addChattingRoom2(SqlSessionTemplate sqlSession,ChattingRoom room) {
		sqlSession.insert("chattingMapper.insertChattingRoom2",room);
		int generatedRoomNo = room.getRoomNo();
	
		return generatedRoomNo;
	}
	
	public int addChattingMember(SqlSessionTemplate sqlSession, HashMap m1) {
		return sqlSession.insert("chattingMapper.addChattingMember",m1);
	}
	public int addChattingMember2(SqlSessionTemplate sqlSession, HashMap m1) {
		return sqlSession.insert("chattingMapper.addChattingMember2",m1);
	}
//	public Chatting selectChattingRoom(SqlSessionTemplate sqlSession) {
//		return sqlSession.selectOne("chattingMapper.selectChattingRoom");
//	}
	public ChattingRoom selectRoomInfo(SqlSessionTemplate sqlSession, String chList) {
		return sqlSession.selectOne("chattingMapper.selectRoomInfo",chList);
	}
	public int saveChattingNoReadMessage(SqlSessionTemplate sqlSession, ChattingMessage vo) {
		return sqlSession.insert("chattingMapper.saveChattingNoReadMessage",vo);
	}
	public int saveChattingReadMessage(SqlSessionTemplate sqlSession, ChattingMessage vo) {
		return sqlSession.insert("chattingMapper.saveChattingReadMessage",vo);
	}
	public ArrayList<ChattingMessage> selectChattingList(SqlSessionTemplate sqlSession, int roomNo) {
		return (ArrayList)sqlSession.selectList("chattingMapper.selectChattingList",roomNo);
	}
	public ArrayList<ChattingMember> selectChatiingRoomList(SqlSessionTemplate sqlSession, int userNo) {
		return (ArrayList)sqlSession.selectList("chattingMapper.selectChatiingRoomList",userNo);
	}
	public ArrayList<ChattingMember> selectChatiingRoomListMem(SqlSessionTemplate sqlSession, int roomNo) {
		return (ArrayList)sqlSession.selectList("chattingMapper.selectChatiingRoomListMem",roomNo);
	}
	public ChattingMessage selectChattingMessage(SqlSessionTemplate sqlSession, int roomNo) {
		return sqlSession.selectOne("chattingMapper.selectChattingMessage",roomNo);
	}


}
