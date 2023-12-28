package com.kh.finalProject.chatting.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonArray;
import com.kh.finalProject.chatting.model.dao.ChattingDao;
import com.kh.finalProject.chatting.model.vo.ChattingRoom;
import com.kh.finalProject.chatting.model.vo.ChattingMember;
import com.kh.finalProject.chatting.model.vo.ChattingMessage;

@Service
public class ChattingServiceImpl implements ChattingService{

	@Autowired
	private ChattingDao chattingDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession; // 기존의 myBatis의 sqlSession대체
	
	@Transactional
	@Override
	public int addChattingRoom(ArrayList<ChattingMember> chMember,ChattingRoom room) {
		int result = 0;
			if(room.getTeamNo() > 0) {
				result =chattingDao.addChattingRoom(sqlSession,room);
			}else {
				result =chattingDao.addChattingRoom2(sqlSession,room);
			}
		
		int result2 = 0;
	
		if(result > 0) {
			for(ChattingMember ch : chMember) {
				HashMap m1 = new HashMap();
				m1.put("userNo", ch.getUserNo());
				
				if(room.getTeamNo() > 0) {
					m1.put("teamNo", room.getTeamNo());
					result2 = chattingDao.addChattingMember(sqlSession,m1);
				}else {
					result2 = chattingDao.addChattingMember2(sqlSession,m1);
				}
				
			}
			if(result2> 0) {
				return result;
			
		}
		}
		return 0;
	}

	@Override
	public ChattingRoom selectRoomInfo(String chList) {
		return chattingDao.selectRoomInfo(sqlSession,chList);
	}

	@Override
	public int saveChattingNoReadMessage(ChattingMessage vo) {
		return chattingDao.saveChattingNoReadMessage(sqlSession,vo);
	}

	@Override
	public int saveChattingReadMessage(ChattingMessage vo) {
		return chattingDao.saveChattingReadMessage(sqlSession,vo);
	}

	@Override
	public ArrayList<ChattingMessage> selectChattingList(int roomNo) {
		return chattingDao.selectChattingList(sqlSession,roomNo);
	}

	@Override
	public ArrayList<ChattingMember> selectChatiingRoomList(int userNo) {
		return chattingDao.selectChatiingRoomList(sqlSession,userNo);
	}

	@Override
	public ArrayList<ChattingMember> selectChatiingRoomListMem(int roomNo) {
		return chattingDao.selectChatiingRoomListMem(sqlSession,roomNo);
	}

	@Override
	public ChattingMessage selectChattingMessage(int roomNo) {
		return chattingDao.selectChattingMessage(sqlSession,roomNo);
	}

}
