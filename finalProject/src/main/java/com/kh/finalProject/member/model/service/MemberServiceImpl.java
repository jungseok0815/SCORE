package com.kh.finalProject.member.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.member.model.dao.MemberDao;
import com.kh.finalProject.member.model.vo.Friend;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.SportInfo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession; // 기존의 myBatis의 sqlSession대체
	
	@Override
	public int joinMember(Member m) {
		return memberDao.joinMember(sqlSession, m);
	}

	@Override
	public Member loginMember(String userId) {
		return memberDao.loginMember(sqlSession, userId);
	}

	@Override
	public Member selectJoinmember(String userId) {
		return memberDao.selectJoinmember(sqlSession, userId);
	}

	@Override
	public int insertSportInfo(SportInfo info) {
		return memberDao.insertSportInfo(sqlSession, info);
	}

	@Override
	public int checkId(String checkId) {
		return memberDao.checkId(sqlSession, checkId);
	}

	@Override
	public SportInfo getUserSportInfo(SportInfo sport) {
		return memberDao.getUserSportInfo(sqlSession, sport);
	}

	@Override
	public int getCountUserfriends(int userNo) {
		return memberDao.getCountUserfriends(sqlSession,userNo);
	}

	@Override
	public ArrayList<Member> getPostFriends(int userNo) {
		return memberDao.getPostFriends(sqlSession,userNo);
	}

	@Override
	public int addFriend(Friend f) {
		return memberDao.addFriend(sqlSession,f);
	}

	@Override
	public ArrayList<Friend> selectFriendList(int userNo) {
		return memberDao.selectFriendList(sqlSession,userNo);
	}

	@Override
	public int deleteFriend(Friend f) {
		return memberDao.deleteFriend(sqlSession,f);
	}



	
}
