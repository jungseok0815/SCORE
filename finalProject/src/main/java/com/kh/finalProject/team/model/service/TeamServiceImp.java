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
	ArrayList<TeamOffer> selectCity(String activityAtea);
		
	// 지역순 총 갯수
	int selectOfferListCount(String activityAtea);
	
//	// 지역을 전체로 했을 때
//	int selectOfferListAll(String activityAtea);
}
