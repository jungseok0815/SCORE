package com.kh.finalProject.member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.member.model.vo.Friend;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.MemberImg;
import com.kh.finalProject.member.model.vo.MessageAuth;
import com.kh.finalProject.member.model.vo.SportInfo;
import com.kh.finalProject.team.model.vo.Team;

@Repository
public class MemberDao {
	public int joinMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("memberMapper.joinMember", m);
	}
	
	public Member selectJoinmember(SqlSessionTemplate sqlSession, String userId) {
		return sqlSession.selectOne("memberMapper.selectJoinmember", userId);
	}
	
	public int insertSportInfo(SqlSessionTemplate sqlSession, SportInfo info) {
		return sqlSession.insert("memberMapper.insertSportInfo", info);
	}
	
	public int checkId(SqlSessionTemplate sqlSession, String checkId) {
		return sqlSession.selectOne("memberMapper.checkId", checkId);
	}
	public Member loginMember(SqlSessionTemplate sqlSession, String userId) {
		return sqlSession.selectOne("memberMapper.loginMember", userId);
	}
	
	public SportInfo getUserSportInfo(SqlSessionTemplate sqlSession, SportInfo sport) {
		return sqlSession.selectOne("memberMapper.getUserSportInfo", sport);
	}
	
	public int getCountUserfriends(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("memberMapper.getCountUserfriends", userNo);
	}
	public int updateUserPoint(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateUserPoint", m);
	}
	public ArrayList<Member> getPostFriends(SqlSessionTemplate sqlSession, int userNo) {
		return (ArrayList)sqlSession.selectList("memberMapper.getPostFriends", userNo);
	}
	
	public int addFriend(SqlSessionTemplate sqlSession, Friend f) {
		return sqlSession.update("memberMapper.addFriend", f);
	}
	public int addFriend2(SqlSessionTemplate sqlSession, Friend f) {
		return sqlSession.insert("memberMapper.addFriend2", f);
	}
	
	public ArrayList<Member> selectFriendList(SqlSessionTemplate sqlSession, int userNo) {
		return (ArrayList)sqlSession.selectList("memberMapper.selectFriendList", userNo);
	}
	
	public int deleteFriend(SqlSessionTemplate sqlSession, Friend f) {
		return sqlSession.delete("memberMapper.deleteFriend",f);

	}
	public int deleteFriend2(SqlSessionTemplate sqlSession, Friend f) {
		return sqlSession.delete("memberMapper.deleteFriend2",f);

	}
	public ArrayList<Team> selectMyTeam(SqlSessionTemplate sqlSession, HashMap teamMap) {
		return (ArrayList)sqlSession.selectList("teamMapper.selectMyTeam", teamMap);
	}
	public ArrayList<Member> searchMember(SqlSessionTemplate sqlSession, String searchMain) {
		return (ArrayList)sqlSession.selectList("memberMapper.searchMember", searchMain);
	}
	
	public int sendPostFriend(SqlSessionTemplate sqlSession, Friend f) {
		return sqlSession.insert("memberMapper.sendPostFriend",f);
	}
	
	public ArrayList<Friend> selectReqResFriendList(SqlSessionTemplate sqlSession, int userNo) {
		return (ArrayList)sqlSession.selectList("memberMapper.selectReqResFriendList", userNo);
	}
	
	public int checkFriendStatus(SqlSessionTemplate sqlSession, Friend f) {
		return sqlSession.selectOne("memberMapper.checkFriendStatus",f);
	}
	public Member userInfo(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("memberMapper.userInfo",userNo);
	}
	public int insertAuth(SqlSessionTemplate sqlSession, MessageAuth auth) {
		return sqlSession.insert("memberMapper.insertAuth",auth);
	}
	public int checkPhoneAuth(SqlSessionTemplate sqlSession, MessageAuth auth) {
		return sqlSession.selectOne("memberMapper.checkPhoneAuth",auth);
	}
	
	//마이페이지 스포츠 수정
	public int updateMyPageSport(SqlSessionTemplate sqlSession, SportInfo sport) {
		return sqlSession.update("memberMapper.updateMyPageSport", sport);
	}
	
	//마이페이지 멤버 수정
	public int updateMyPageMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateMyPageMember", m);
	}
	
	//마이페이지 이미지 수정
	public int insertMemImg(SqlSessionTemplate sqlSession, MemberImg mi) {
		return sqlSession.insert("memberMapper.insertMemImg", mi);
	}
	//마이페이지 이미지 수정
	public int updateMemImg(SqlSessionTemplate sqlSession, MemberImg mi) {
		return sqlSession.update("memberMapper.updateMemImg", mi);
	}
	
	//마이페이지 이미지 조회
	public MemberImg selectMemberImg(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("memberMapper.selectMemberImg", userNo);
	}
	
	// 운영진인 사람들만 조회
	public ArrayList<Member> levelMember(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("memberMapper.levelMember");
	}
	// 카카오페이로 결제
	public int updatePay(SqlSessionTemplate sqlSession, int point, int userNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("point", point);
		params.put("userNo", userNo);
		
		return sqlSession.update("memberMapper.updatePay", params);
	}
}
