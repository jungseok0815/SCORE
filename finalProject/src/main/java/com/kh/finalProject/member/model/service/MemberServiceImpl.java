package com.kh.finalProject.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.member.model.dao.MemberDao;
import com.kh.finalProject.member.model.vo.Friend;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.MemberImg;
import com.kh.finalProject.member.model.vo.MessageAuth;
import com.kh.finalProject.member.model.vo.SportInfo;
import com.kh.finalProject.team.model.vo.Team;

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


	//유저 포인트 충전
	@Override
	public int updateUserPoint(Member m) {
		return memberDao.updateUserPoint(sqlSession, m);
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

	@Override
	public ArrayList<Team> selectMyTeam(HashMap teamMap) {
		return memberDao.selectMyTeam(sqlSession,teamMap);
	}

	@Override
	public int addFriend2(Friend f) {
		return memberDao.addFriend2(sqlSession,f);
	}

	@Override
	public int deleteFriend2(Friend f) {
		return memberDao.deleteFriend2(sqlSession,f);
	}

	@Override
	public ArrayList<Member> searchMember(String searchMain) {
		return memberDao.searchMember(sqlSession,searchMain);
	}

	@Override
	public int sendPostFriend(Friend f) {
		return memberDao.sendPostFriend(sqlSession,f);
	}

	@Override
	public ArrayList<Friend> selectReqResFriendList(int userNo) {
		return memberDao.selectReqResFriendList(sqlSession,userNo);
	}
	
	@Override
	public int checkFriendStatus(Friend f) {
		return memberDao.checkFriendStatus(sqlSession,f);
	}

	@Override
	public Member userInfo(int userNo) {
		return memberDao.userInfo(sqlSession,userNo);
	}

	@Override
	public int insertAuth(MessageAuth auth) {
		return memberDao.insertAuth(sqlSession,auth);
	}

	@Override
	public int checkPhoneAuth(MessageAuth auth) {
		return memberDao.checkPhoneAuth(sqlSession,auth);
	}

	@Override
	public int updateMyPageSport(SportInfo sport) {
		return memberDao.updateMyPageSport(sqlSession, sport);
	}

	@Override
	public int updateMyPageMember(Member m) {
		return memberDao.updateMyPageMember(sqlSession, m);
	}
	
	@Override
	public int updateMemImg(MemberImg mi) {
		return memberDao.updateMemImg(sqlSession, mi);
	}
	
}
