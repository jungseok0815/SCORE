package com.kh.finalProject.team.model.service;

import java.util.ArrayList;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamImg;
import com.kh.finalProject.team.model.vo.TeamMember;

import com.kh.finalProject.team.model.vo.TeamOffer;

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
	
	// 초이스 스포츠 갯수
	int selectChoiceSportsCount(int category, String activityAtea);
	
	// 초이스 스포츠 리스트 가져오기
	ArrayList<TeamOffer> selectChoiceList(int category, String activityAtea, PageInfo pi);
	
	//게시글 총 갯수 가져오기
	int selectChoiceAllCount(int category);
	
	// 초이스 스포츠 전부다 리스트 가져오기
	ArrayList<TeamOffer> selectChoiceAllList(int category, PageInfo pi);
	
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

	// offerList 작성할때 작성자 정보 
	TeamMember selectInformation(int userNo);
	
	// 구인글 등록 
	int insertOfferList(TeamOffer t, int tno);
	
	// 구인글 사진 등록 
	int insertOfferImg(TeamImg ti, int tno);
	
	// 디테일뷰 이미지 가져오기 
	TeamImg selectOfferImg(int tno);
	
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
//	ArrayList<TeamOffer> selectTeamImg(int teamNo, PageInfo pi);
}
