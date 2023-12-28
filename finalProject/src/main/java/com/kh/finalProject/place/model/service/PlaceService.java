package com.kh.finalProject.place.model.service;


import java.util.ArrayList;
import java.util.HashMap;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;
import com.kh.finalProject.place.model.vo.PlaceReview;
import com.kh.finalProject.place.model.vo.Reply;
import com.kh.finalProject.place.model.vo.ReplyReply;
import com.kh.finalProject.place.model.vo.Reservation;
import com.kh.finalProject.place.model.vo.ReviewImg;

public interface PlaceService {
	//경기장 등록
	int insertPlace(Place p);
	//경기장 사진 등록
	int insertPlaceImg(PlaceImg pi);
	
	int placeListCount(Place pl);
	ArrayList<Place> selectPlaceList(PageInfo pi, Place pl);
	Place placeDetailview(int fno);
	ArrayList<Place> selectResPlaceList();
	int placeResCount(int fno);
	ArrayList<Place> searchPlace(String selectValue);
	int insertResMatch(Reservation res);
	int payPoint(Member loginUser);
	int checkResMatch(Reservation res);
	ArrayList<PlaceImg> placeImgList(int fno);
	ArrayList<Reservation> selectResList(String userNo);
	int deleteReservation(int resNo);
	
	//댓글 리스트
	ArrayList<Reply> selectReplyList(int fno);
	PlaceReview selectReplyField(HashMap<String, Integer> map);
	//리뷰 이미지 조회
	ArrayList<ReviewImg> placeReviewImgList(int rno);
	
	//경기장 리뷰 리스트 셀렉트
	ArrayList<PlaceReview> placeReviewList(PageInfo pi);
	ArrayList<PlaceReview> placeChoiceReviewList(PageInfo pi, String categoryNum);
	//경기장 리뷰 등록 
	int insertPlaceReview(PlaceReview pr);
	//경기장 리뷰 사진 등록
	int insertPlaceReviewImg(ReviewImg ri);
	//리뷰 리스트 총 개수
	int selectReviewListCount();
	//리뷰 게시글 검색
	int selectSearchCount(HashMap<String, String> map);
	ArrayList<PlaceReview> selectSearchList(HashMap<String, String> map, PageInfo pi);
	
	int addReplyReply(ReplyReply p);
	ArrayList<ReplyReply> selectReplyReply(int replyNo);
	
	//리뷰게시글 조회수증가(update)
	int reviewIncreaseCount(int rno);
	
	//자기가 리뷰 쓴 경기장 못 쓰게 막음
	int checkReview(PlaceReview pr);
	

}
