package com.kh.finalProject.member.model.service;

import java.util.ArrayList;

import com.kh.finalProject.member.model.vo.Friend;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.SportInfo;

public interface MemberService {
	int joinMember(Member m);
	Member loginMember(String userId);
	Member selectJoinmember(String userId);
	int insertSportInfo(SportInfo info);
	int checkId(String checkId);
	SportInfo getUserSportInfo(SportInfo sport);	
	int getCountUserfriends(int userNo);
}

