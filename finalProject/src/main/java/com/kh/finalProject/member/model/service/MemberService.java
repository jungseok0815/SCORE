package com.kh.finalProject.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.finalProject.member.model.vo.Friend;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.SportInfo;
import com.kh.finalProject.team.model.vo.Team;

public interface MemberService {
	int joinMember(Member m);
	Member loginMember(String userId);
	Member selectJoinmember(String userId);
	int insertSportInfo(SportInfo info);
	int checkId(String checkId);
	SportInfo getUserSportInfo(SportInfo sport);	
	int getCountUserfriends(int userNo);
	//포인트 충전
	int updateUserPoint(Member m);
	ArrayList<Member> getPostFriends(int userNo);
	int addFriend(Friend f);
	ArrayList<Friend> selectFriendList(int userNo);
	int deleteFriend(Friend f);
	ArrayList<Team>selectMyTeam(HashMap teamMap);
	int addFriend2(Friend f);
	int deleteFriend2(Friend f);
	ArrayList<Member> searchMember(String searchMain);
	int sendPostFriend(Friend f);
	ArrayList<Friend> selectReqResFriendList(int userNo);
	
}

