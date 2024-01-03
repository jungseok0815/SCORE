package com.kh.finalProject.place.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.SportInfo;
import com.kh.finalProject.place.model.vo.Field;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;
import com.kh.finalProject.place.model.vo.Reply;
import com.kh.finalProject.place.model.vo.ReplyReply;
import com.kh.finalProject.place.model.vo.PlaceReview;
import com.kh.finalProject.place.model.vo.Reservation;
import com.kh.finalProject.place.model.vo.ReviewImg;

@Repository
public class PlaceDao {
	
	public int insertPlace(SqlSessionTemplate sqlSession, Place p) {
	      
		return sqlSession.insert("placeMapper.insertPlace", p);
	}
	
	public int insertPlaceImg(SqlSessionTemplate sqlSession, PlaceImg pi) {
		return sqlSession.insert("placeMapper.insertPlaceImg", pi);
	
	}
	public int placeListCount(SqlSessionTemplate sqlSession, Place pl) {
		return sqlSession.selectOne("placeMapper.placeListCount", pl);
	}
	public ArrayList<Place> selectPlaceList(SqlSessionTemplate sqlSession, PageInfo pi, Place pl){
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("placeMapper.selectPlaceList", pl, rowBounds);
	}
	public Place placeDetailview(SqlSessionTemplate sqlSession, int fieldNo) {
		return sqlSession.selectOne("placeMapper.placeDetailview", fieldNo);
	}
	public int placeResCount(SqlSessionTemplate sqlSession, int fieldNo) {
		return sqlSession.selectOne("placeMapper.placeResCount", fieldNo);
	}
	public ArrayList<Place> selectResPlaceList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("placeMapper.selectResPlaceList");
	}
	
	public ArrayList<Place> searchPlace(SqlSessionTemplate sqlSession, String selectValue) {
		return (ArrayList)sqlSession.selectList("placeMapper.searchPlace",selectValue);
	}
	
	public int insertResMatch(SqlSessionTemplate sqlSession, Reservation res) {
		return sqlSession.insert("placeMapper.insertResMatch", res);
	}
	public int changePoint(SqlSessionTemplate sqlSession, Member loginUser) {
		return sqlSession.update("memberMapper.changePoint", loginUser);
	}
	public int checkResMatch(SqlSessionTemplate sqlSession, Reservation res) {
		return sqlSession.selectOne("placeMapper.checkResMatch", res);
	}
	public ArrayList<PlaceImg> placeImgList(SqlSessionTemplate sqlSession, int fieldNo){
		return (ArrayList)sqlSession.selectList("placeMapper.placeImgList", fieldNo);
	}
	public ArrayList<Reservation> selectResList(SqlSessionTemplate sqlSession, String resUserNo){
		return (ArrayList)sqlSession.selectList("placeMapper.selectResList", resUserNo);
	}
	public int deleteReservation(SqlSessionTemplate sqlSession, int resNo) {
		return sqlSession.delete("placeMapper.deleteReservation", resNo);
	}
	public int selectMatchPay(SqlSessionTemplate sqlSession, int fieldNo) {
		return sqlSession.selectOne("placeMapper.selectMatchPay", fieldNo);
	}
	public ArrayList<Place> selectResDay(SqlSessionTemplate sqlSession, int userNo){
		return (ArrayList)sqlSession.selectList("placeMapper.selectResDay", userNo);
	}
	public ArrayList<Reservation> dateChoiceResList(SqlSessionTemplate sqlSession, Reservation res){
		return (ArrayList)sqlSession.selectList("placeMapper.dateChoiceResList", res);
	}
	public ArrayList<Reservation> dateAllResList(SqlSessionTemplate sqlSession, int resUserNo){
		return (ArrayList)sqlSession.selectList("placeMapper.dateAllResList", resUserNo);
	}
	public ArrayList<Field> selectManager(SqlSessionTemplate sqlSession, String userName) {
		return (ArrayList)sqlSession.selectList("placeMapper.selectManager", userName);
	}
	public ArrayList<SportInfo> selectMember(SqlSessionTemplate sqlSession, int fieldNo, int categoryNum) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fieldNo", fieldNo);
		params.put("categoryNum", categoryNum);
		return (ArrayList)sqlSession.selectList("placeMapper.selectMember", params);
	}
	public int updateEval(SqlSessionTemplate sqlSession, SportInfo spoInfo) {
		return sqlSession.update("placeMapper.updateEval", spoInfo);
	}
	public int fieldNoDel(SqlSessionTemplate sqlSession, int fieldNo) {
		return sqlSession.delete("placeMapper.fieldNoDel", fieldNo);
	}
	public int fieldDelet(SqlSessionTemplate sqlSession, int fieldNo) {
		return sqlSession.delete("placeMapper.fieldDelet", fieldNo);
	}
	public int fieldReqDel(SqlSessionTemplate sqlSession, int fieldNo) {
		return sqlSession.delete("placeMapper.fieldReqDel", fieldNo);
	}
	public ArrayList<PlaceReview> placeReviewList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("placeMapper.placeReviewList", null, rowBounds);
	}
	public int selectReviewListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("placeMapper.selectReviewListCount");
	}
	public int insertPlaceReviewImg(SqlSessionTemplate sqlSession, ReviewImg ri) {
		return sqlSession.insert("placeMapper.insertPlaceReviewImg", ri);
	}
	public int insertPlaceReview(SqlSessionTemplate sqlSession, PlaceReview pr) {
		return sqlSession.insert("placeMapper.insertPlaceReview", pr);
	}
	public ArrayList<PlaceReview> placeChoiceReviewList(SqlSessionTemplate sqlSession, PageInfo pi, String categoryNum) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("placeMapper.placeChoiceReviewList", categoryNum, rowBounds);
	}
	public int selectSearchCount(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("placeMapper.selectSearchCount", map);
	}
	public ArrayList<PlaceReview> selectSearchList(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("placeMapper.selectSearchList", map, rowBounds);
	}
	public ArrayList<Field> selectReservation(SqlSessionTemplate sqlSession, int fieldNo) {
		return (ArrayList)sqlSession.selectList("placeMapper.selectReservation", fieldNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSessionTemplate sqlSession, int fno) {
		return (ArrayList)sqlSession.selectList("placeMapper.selectReplyList", fno);
	}
	
	public PlaceReview selectReplyField(SqlSessionTemplate sqlSession, HashMap<String, Integer> map) {
		return sqlSession.selectOne("placeMapper.selectReplyField", map);
	}
	
	public int addReplyReply(SqlSessionTemplate sqlSession, ReplyReply p) {
		return sqlSession.insert("placeMapper.addReplyReply", p);
	}
	
	
	public ArrayList<ReviewImg> placeReviewImgList(SqlSessionTemplate sqlSession, int rno) {
		return (ArrayList)sqlSession.selectList("placeMapper.placeReviewImgList", rno);
	}
	
	public ArrayList<ReplyReply> selectReplyReply(SqlSessionTemplate sqlSession, int reply) {
		return (ArrayList)sqlSession.selectList("placeMapper.selectReplyReply", reply);
	}
	
	public int reviewIncreaseCount(SqlSessionTemplate sqlSession, int rno) {
		return sqlSession.update("placeMapper.reviewIncreaseCount", rno);
	}
	
	public int checkReview(SqlSessionTemplate sqlSession, PlaceReview pr) {
		return sqlSession.selectOne("placeMapper.selectReplyField", pr);
	}
	
	public int deleteReview(SqlSessionTemplate sqlSession, int rno) {
		return sqlSession.update("placeMapper.deleteReview", rno);
	}
	
	public int updateReviewImg(SqlSessionTemplate sqlSession, ReviewImg ri) {
		return sqlSession.update("placeMapper.updateReviewImg", ri);
	}
	
	public int updateReview(SqlSessionTemplate sqlSession, PlaceReview pr) {
		return sqlSession.update("placeMapper.updateReview", pr);
	}

	public int fieldManagerUpdate(SqlSessionTemplate sqlSession, int fieldNo) {
		return sqlSession.update("placeMapper.fieldManagerUpdate", fieldNo);
	}
	public int addReply(SqlSessionTemplate sqlSession, Reply r) {
		return sqlSession.insert("placeMapper.addReply", r);
	}
	
	public int upadateReply(SqlSessionTemplate sqlSession, Reply r) {
		return sqlSession.update("placeMapper.upadateReply", r);
	}
	
	public int deleteReply(SqlSessionTemplate sqlSession, Reply r) {
		return sqlSession.delete("placeMapper.deleteReply", r);
	}
	
	public int deleteReplyReply(SqlSessionTemplate sqlSession, ReplyReply rr) {
		return sqlSession.delete("placeMapper.deleteReplyReply", rr);
	}
	
	public int updateReplyReply(SqlSessionTemplate sqlSession, ReplyReply rr) {
		return sqlSession.update("placeMapper.updateReplyReply", rr);
	}
	
	public int deleteReplyRe(SqlSessionTemplate sqlSession, Reply rr) {
		return sqlSession.delete("placeMapper.deleteReplyRe", rr);
	}
	public int countFemalePlayer(SqlSessionTemplate sqlSession, int fno) {
		return sqlSession.selectOne("placeMapper.countFemalePlayer", fno);
	}
	
}
