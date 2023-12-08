package com.kh.finalProject.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.member.model.vo.Friend;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.SportInfo;

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
		System.out.println(sport.getUserNo() + "" + sport.getCategoryNum());
		return sqlSession.selectOne("memberMapper.getUserSportInfo", sport);
	}
	
	public int getCountUserfriends(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("memberMapper.getCountUserfriends", userNo);
	}
	
	public ArrayList<Member> getPostFriends(SqlSessionTemplate sqlSession, int userNo) {
		return (ArrayList)sqlSession.selectList("memberMapper.getPostFriends", userNo);
	}
	
	public int addFriend(SqlSessionTemplate sqlSession, Friend f) {
		return sqlSession.update("memberMapper.addFriend", f);
	}
	

	public ArrayList<Friend> selectFriendList(SqlSessionTemplate sqlSession, int userNo) {
		return (ArrayList)sqlSession.selectList("memberMapper.selectFriendList", userNo);
	}
	
	public int deleteFriend(SqlSessionTemplate sqlSession, Friend f) {
		return sqlSession.delete("memberMapper.deleteFriend",f);
	}
}
