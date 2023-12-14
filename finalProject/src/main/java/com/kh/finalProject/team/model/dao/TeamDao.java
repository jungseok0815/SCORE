package com.kh.finalProject.team.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamImg;
import com.kh.finalProject.team.model.vo.TeamMember;
import com.kh.finalProject.team.model.vo.TeamOffer;


@Repository
public class TeamDao {
	
	//팀 생성
	public int insertTeam(SqlSessionTemplate sqlSession, Team t) {
		return sqlSession.insert("teamMapper.insertTeam", t);
	}
	
	//팀 생성 이미지 등록
	public int insertTeamImg(SqlSessionTemplate sqlSession, TeamImg ti) {
		return sqlSession.insert("teamMapper.insertTeamImg", ti);
	}
	
	//팀 멤버 생성
	public int insertTeamMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("teamMapper.insertTeamMember", m);
	}

	public int selectListCount(SqlSessionTemplate sqlSession) { // 리스트 총 갯수
		return sqlSession.selectOne("teamMapper.selectListCount");
	}
	
	public ArrayList<TeamOffer> selectList(SqlSessionTemplate sqlSession, PageInfo pi){ // 게시글 리스트 조회
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("teamMapper.selectList", null, rowBounds);
	}
	
	public int increaseCount(SqlSessionTemplate sqlSession, int offerNo) {
		return sqlSession.update("teamMapper.increaseCount", offerNo);
	}
	
	public TeamOffer selectOfferDetail(SqlSessionTemplate sqlSession, int offerNo) {
		return sqlSession.selectOne("teamMapper.selectOfferDetail", offerNo);
	}
	
	public ArrayList<TeamOffer> selectCity(SqlSessionTemplate sqlSession, String activityAtea, int category, PageInfo pi){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category);
		params.put("activityAtea", activityAtea);
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("teamMapper.selectCity", params, rowBounds);
	}
	
	public int selectOfferListCount(SqlSessionTemplate sqlSession, String activityAtea, int category) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category);
		params.put("activityAtea", activityAtea);
		
		return sqlSession.selectOne("teamMapper.selectOfferListCount", params);
	}
	
	public int deleteOffer(SqlSessionTemplate sqlSession, int offerNo) {
		return sqlSession.update("teamMapper.deleteOffer", offerNo);
	}
	
	public int teamReq(SqlSessionTemplate sqlSession, int userNo, String reqContent, int offerNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNo", userNo);
		params.put("reqContent", reqContent);
		params.put("offerNo", offerNo);
		
		
		return sqlSession.insert("teamMapper.teamReq", params);
	}
	
	public TeamMember selectInformation(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("teamMapper.selectInformation", userNo);
	}
	// 게시판 등록
	public int insertOfferList(SqlSessionTemplate sqlSession, TeamOffer t, int tno) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("t", t);
		params.put("tno", tno);
		
		return sqlSession.insert("teamMapper.insertOfferList", params);
	}
	// 사진 삽입
	public int insertOfferImg(SqlSessionTemplate sqlSession, TeamImg ti, int tno) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ti", ti);
		params.put("tno", tno);
		
		return sqlSession.insert("teamMapper.insertOfferImg", params);
	}
	
	// 디테일 사진 가져오기 
	public TeamImg selectOfferImg(SqlSessionTemplate sqlSession, int tno) {
		return sqlSession.selectOne("teamMapper.selectOfferImg", tno);
	}
	
	// 가테고리별 전체 지역 까지 가져오기 
	public int selectListCountCate(SqlSessionTemplate sqlSession, int category) { 
		return sqlSession.selectOne("teamMapper.selectListCountCate", category);
	}
	
	// 카테고리별 전체 지역 리스트 
	public ArrayList<TeamOffer> selectCityAll(SqlSessionTemplate sqlSession, int category, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("teamMapper.selectCityAll", category, rowBounds);
	}
	
	// 카테고리 없을때 지역만 
	public int selectNotCategory(SqlSessionTemplate sqlSession, String activityAtea) { 
		return sqlSession.selectOne("teamMapper.selectNotCategory", activityAtea);
	}
	
	// 카테고리 없을때 지역 리스트 
	public ArrayList<TeamOffer> selectOnlyCity(SqlSessionTemplate sqlSession, String activityAtea, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("teamMapper.selectOnlyCity", activityAtea, rowBounds);
	}
	
	public int teamReq(SqlSessionTemplate sqlSession, String userId, String text) {
		return sqlSession.insert("teamMapper.teamReq", userId);
	}
	

	public int teamMemberCount(SqlSessionTemplate sqlSession, int tno) {
		return sqlSession.selectOne("teamMapper.teamMemberCount", tno);
	}
	
	public int teamAvgAge(SqlSessionTemplate sqlSession, int tno) {
		return sqlSession.selectOne("teamMapper.teamAvgAge", tno);
	}
	
	public Team teamProfile(SqlSessionTemplate sqlSession, int tno) {
		return sqlSession.selectOne("teamMapper.teamProfile", tno);
	}
	
	public ArrayList<Team> searchTeam(SqlSessionTemplate sqlSession, String selectValue) {
		return (ArrayList)sqlSession.selectList("teamMapper.searchTeam", selectValue);

	}
	
	public ArrayList<TeamMember> teamMemberList(SqlSessionTemplate sqlSession, int tno){
		return (ArrayList)sqlSession.selectList("teamMapper.teamMemberList", tno);
	}
	
	// 팀 번호 조회 
	public int getTeamNumber(SqlSessionTemplate sqlSession, int userNo) { 
		return sqlSession.selectOne("teamMapper.getTeamNumber", userNo);
	}
	
	 //이미지 다오 
	public String selectTeamImg(SqlSessionTemplate sqlSession, int teamNo) { 
		return sqlSession.selectOne("teamMapper.selectTeamImg", teamNo);
	}
	
//	public ArrayList<TeamOffer> selectTeamImg(SqlSessionTemplate sqlSession, int teamNo, PageInfo pi) { 
//		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
//		int limit = pi.getBoardLimit();
//		
//		RowBounds rowBounds = new RowBounds(offset, limit);
//		
//		return (ArrayList)sqlSession.selectList("teamMapper.selectTeamImg", teamNo, rowBounds);
//	}
	
	
}
