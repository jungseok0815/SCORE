package com.kh.finalProject.team.model.service;

import java.util.ArrayList;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.team.model.vo.TeamOffer;

public interface TeamServiceImp {

	//게시글 총 갯수 가져오기
	int selectListCount();
	
	//게시글 리스트 조회
	ArrayList<TeamOffer> selectList(PageInfo pi);
	
	//게시글 조회수증가(update)
	int increaseCount(int offerNo);
	
	//게시글 상세조회
	TeamOffer selectOfferDetail(int offerNo);
	
	// 지역순 리스트 가져오기
	ArrayList<TeamOffer> selectCity(String activityAtea, PageInfo pi);
		
	// 지역순 총 갯수
	int selectOfferListCount(String activityAtea);
	
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
	int teamReq(String userId, String text);
}
