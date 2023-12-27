package com.kh.finalProject.place.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.place.model.dao.PlaceDao;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;
import com.kh.finalProject.place.model.vo.Reply;
import com.kh.finalProject.place.model.vo.ReplyReply;
import com.kh.finalProject.place.model.vo.PlaceReview;
import com.kh.finalProject.place.model.vo.Reservation;
import com.kh.finalProject.place.model.vo.ReviewImg;



@Service
public class PlaceServiceImpl implements PlaceService{

	@Autowired
	private PlaceDao pDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public int insertPlace(Place p) {
		return pDao.insertPlace(sqlSession, p);
	}

	@Override
	public int insertPlaceImg(PlaceImg pi) {
		
		return pDao.insertPlaceImg(sqlSession, pi);
	}
	
	
	@Override
	public int placeListCount(Place pl) {
		return pDao.placeListCount(sqlSession, pl);
	}
	
	
	@Override
	public ArrayList<Place> selectPlaceList(PageInfo pi, Place pl) {
		return pDao.selectPlaceList(sqlSession, pi, pl);
	}


	@Override
	public Place placeDetailview(int fno) {
		return pDao.placeDetailview(sqlSession, fno);
	}


	@Override
	public ArrayList<Place> selectResPlaceList() {
		return pDao.selectResPlaceList(sqlSession);
	}

	@Override
	public int placeResCount(int fno) {
		return pDao.placeResCount(sqlSession, fno);
	}

	@Override
	public ArrayList<Place> searchPlace(String selectValue) {
		return pDao.searchPlace(sqlSession,selectValue);
	}

	@Override
	public int insertResMatch(Reservation res) {
		return pDao.insertResMatch(sqlSession, res);
	}

	@Override
	public int payPoint(Member loginUser) {
		return pDao.payPoint(sqlSession, loginUser);
	}

	@Override
	public int checkResMatch(Reservation res) {
		return pDao.checkResMatch(sqlSession, res);
	}

	@Override
	public ArrayList<PlaceImg> placeImgList(int fno) {
		return pDao.placeImgList(sqlSession, fno);
	}

	@Override
	public ArrayList<Reservation> selectResList(String userNo) {
		return pDao.selectResList(sqlSession, userNo);
	}

	@Override
	public int deleteReservation(int resNo) {
		return pDao.deleteReservation(sqlSession, resNo);
	}

	@Override
	public ArrayList<Reply> selectReplyList(int fno) {
		return pDao.selectReplyList(sqlSession, fno);
	}

	@Override
	public PlaceReview selectReplyField(int fno) {
		return pDao.selectReplyField(sqlSession, fno);
	}	
		
	public ArrayList<PlaceReview> placeReviewList(PageInfo pi) {
		return pDao.placeReviewList(sqlSession, pi);
	}

	@Override
	public int insertPlaceReviewImg(ReviewImg ri) {
		return pDao.insertPlaceReviewImg(sqlSession, ri);
	}

	@Override
	public int selectReviewListCount() {
		return pDao.selectReviewListCount(sqlSession);
	}

	@Override
	public int insertPlaceReview(PlaceReview pr) {
		return pDao.insertPlaceReview(sqlSession, pr);
	}

	@Override
	public ArrayList<PlaceReview> placeChoiceReviewList(PageInfo pi, String categoryNum) {
		return pDao.placeChoiceReviewList(sqlSession, pi, categoryNum);
	}

	@Override
	public ArrayList<ReviewImg> placeReviewImgList(int rno) {
		return pDao.placeReviewImgList(sqlSession, rno);
	}

	@Override
	public int addReplyReply(ReplyReply p) {
		return pDao.addReplyReply(sqlSession, p);
	}

	@Override
	public ArrayList<ReplyReply> selectReplyReply(int replyNo) {
		return pDao.selectReplyReply(sqlSession, replyNo);
	}


}
