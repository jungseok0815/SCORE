package com.kh.finalProject.team.model.service;

import java.util.ArrayList;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamImg;
import com.kh.finalProject.team.model.vo.TeamMember;
import java.util.HashMap;
import com.kh.finalProject.team.model.vo.TeamOffer;
import com.kh.finalProject.team.model.vo.TeamReq;

public interface TeamServiceImp {

	//게시글 총 갯수 가져오기
	int selectListCount();
	
	//팀 생성
	int insertTeam(Team t);
	
	//팀 생성 사진 등록
	int insertTeamImg(TeamImg ti);
	
	//팀 멤버 생성
	int insertTeamMember(Member m);

	//게시글 리스트 조회
	ArrayList<TeamOffer> selectList(PageInfo pi);
	
	//게시글 조회수증가(update)
	int increaseCount(int offerNo);
	
	//게시글 상세조회
	TeamOffer selectOfferDetail(int offerNo);
	
	// 지역순 리스트 가져오기
	ArrayList<TeamOffer> selectCity(String activityAtea, int category, PageInfo pi);
		
	// 지역순 총 갯수
	int selectOfferListCount(String activityAtea, int category);
	
	//게시글 삭제서비스(update)
	int deleteOffer(int offerNo);
	
	// 팀 요청 
	int teamReq(int userNo, String reqContent, int offerNo);

	
	//팀 프로필 조회
	Team teamProfile(int tno);

	
	//팀원 총 몇명인지 조회
	int teamMemberCount(int tno);
	
	//팀원의 멤버들 평균 나이
	int teamAvgAge(int tno);
	
	//팀 멤버 불러오기
	ArrayList<TeamMember> teamMemberList(int tno);

	ArrayList<Team> searchTeam(String selectValue);
	
	//팀 프로필 업데이트
	int updateTeam(Team t);
	
	//팀 프로필 이미지 엄데이트
	int updateTeamImg(TeamImg ti);
	
	//나의 팀 리스트 불러오기
	ArrayList<Team> selectMyTeamList(HashMap<String, Integer> map);

	// offerList 작성할때 작성자 정보 
	TeamMember selectInformation(int userNo);
	
	// 구인글 등록 
	int insertOfferList(TeamOffer t, int teamNo);
	
	// 구인글 사진 등록 
	int insertOfferImg(TeamImg ti, int teamNo);
	
	// 디테일뷰 이미지 가져오기 
	TeamImg selectOfferImg(int tno);
	
	// 팀 프로필 가져오기
	TeamImg offerProfileImg(int teamNo);
	
	// 가테고리별 전체 지역까지 가져오기
	int selectListCountCate(int category);
	
	// 카테고리별 전체 지역 가져오기 
	ArrayList<TeamOffer> selectCityAll(int category, PageInfo pi);
	
	// 카테고리 없을때 지역만 
	int selectNotCategory(String activityAtea);
	
	// 카테고리 없을때 지역만 가져오는 리스트 
	ArrayList<TeamOffer> selectOnlyCity(String activityAtea, PageInfo pi);
	
	// 팀 번호 조회 
	int getTeamNumber(int userNo);
	
	// ㅇㅇㅇㅇ
	String selectTeamImg(int teamNo);
	
	
	int deleteTeam(int tNo);
	
	int deleteTeamMemberAll(int tNo);
//	ArrayList<TeamOffer> selectTeamImg(int teamNo, PageInfo pi);
	
	int deleteTeamImg(int tNo);
	
	//팀 멤버 등급올리는 
	int changeTeamGradeUp(TeamMember tm);
	//팀 멤버 등급 내리는 것 
	int changeTeamGradeDown(TeamMember tm);
	int deleteTeamMember(TeamMember tm);
	
	//	ArrayList<TeamOffer> selectTeamImg(int teamNo, PageInfo pi);


	
	// 유저 팀 번호 가져오기
	ArrayList<TeamMember> selectLoginUserNo(int userNo);
	
	// 팀요청 리스트 가져오기
	ArrayList<TeamReq> selectReqList(int tno);
	
	// 친구요청 수락
	int teamReqAccept(int reqNo);
	
	// 친구요청 거절
	int teamReqReqRefuse(int reqNo);
	
	// 팀 이름 가져오기  
	String selectTeamName(int tno);
	
	// 팀 프로필 이미지 가져오기 
	String selectTeamProImg(int tno);

	// 회원 번호 가져오기
	int reqList(int reqNo);
	
	// 수락시 팀 멤버에 넘겨주기 
	int acceptTeamMember(int reqList, int tno);

	// 팀 가입 신청 리스트에서 유저 번호만 빼오기
	ArrayList<TeamReq> selectReqUserNo(int tno);
	
	//// 팀 프로필 이미지 가져오기 
	String selectMemberProImg(int userNo);

	ArrayList<Team> selectMyteam(int userNo);
	
	ArrayList<Team> chattingSelectTeam(HashMap info);
	// 신청한 팀원 리스트
	int selectReqListCheck(int userNo, int tno);
	
	// 오퍼로만 신청한 팀원 리스트
	int selectReqListCheck22(int userNo, int tno, int teamNo);
	
	// 오퍼로만 신청한 팀원 리스트
		int selectReqListCheck33(int userNo, int tno, int offerNo);
	
	// 팀 해체시 게시물 삭제
	int deleteOfferAll(int tNo);
	// 팀 번호로 구인 번호 다 받아오기
	ArrayList<TeamOffer> teamOfferListNo(int tNo);
	// 구인번호로 TeamReq삭제
	int deleteTeamReqAll(int offerNo);
	// 팀 프로필로 가서 팀 신청하기
	int teamReqSolo(int userNo, String reqContent, int offerNo);
	// 구인글 이미지 삭제
	int deleteOfferImg(int offerNo);
	// 구인글 있나 없나 여부조사
	ArrayList<TeamOffer> listCountNo(int tno);
	// 예약자 있나 없나 여부조사
	ArrayList<TeamReq> selectListReqCount(int tno);
	
}
