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
import com.kh.finalProject.team.model.vo.TeamReq;


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
	public int insertOfferList(SqlSessionTemplate sqlSession, TeamOffer t, int teamNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("t", t);
		params.put("teamNo", teamNo);
		
		return sqlSession.insert("teamMapper.insertOfferList", params);
	}
	// 사진 삽입
	public int insertOfferImg(SqlSessionTemplate sqlSession, TeamImg ti, int teamNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ti", ti);
		params.put("teamNo", teamNo);
		
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
	
	public int updateTeam(SqlSessionTemplate sqlSession, Team t) {
		return sqlSession.update("teamMapper.updateTeam", t);
	}
	
	public int updateTeamImg(SqlSessionTemplate sqlSession, TeamImg ti) {
		return sqlSession.update("teamMapper.updateTeamImg", ti);
	}

	
	// 팀 번호 조회 
	public int getTeamNumber(SqlSessionTemplate sqlSession, int userNo) { 
		return sqlSession.selectOne("teamMapper.getTeamNumber", userNo);
	}
	
	 //이미지 다오 
	public String selectTeamImg(SqlSessionTemplate sqlSession, int teamNo) { 
		return sqlSession.selectOne("teamMapper.selectTeamImg", teamNo);
	}
	
	// 팀 프로필 가져오기
	public TeamImg offerProfileImg(SqlSessionTemplate sqlSession, int teamNo) {
		return sqlSession.selectOne("teamMapper.offerProfileImg", teamNo);
	}
	

	public ArrayList<Team> selectMyTeamList(SqlSessionTemplate sqlSession, HashMap<String,Integer> map) {
		return (ArrayList)sqlSession.selectList("teamMapper.selectMyTeamList", map);
	}
	
	public int deleteTeam(SqlSessionTemplate sqlSession, int tNo) {
		return sqlSession.delete("teamMapper.deleteTeam", tNo);
	}
	
	public int deleteTeamMemberAll(SqlSessionTemplate sqlSession, int tNo) {
		return sqlSession.delete("teamMapper.deleteTeamMemberAll", tNo);
	}
	
	public int deleteTeamImg(SqlSessionTemplate sqlSession, int tNo) {
		return sqlSession.delete("teamMapper.deleteTeamImg", tNo);
	}
	
	public int changeTeamGradeUp(SqlSessionTemplate sqlSession, TeamMember tm) {
		return sqlSession.update("teamMapper.changeTeamGradeUp", tm);
	}
	
	public int changeTeamGradeDown(SqlSessionTemplate sqlSession, TeamMember tm) {
		return sqlSession.update("teamMapper.changeTeamGradeDown", tm);
	}
	public int deleteTeamMember(SqlSessionTemplate sqlSession, TeamMember tm) {
		return sqlSession.delete("teamMapper.deleteTeamMember", tm);
	}

	// 유저 팀 번호 가져오기
	public ArrayList<TeamMember> selectLoginUserNo(SqlSessionTemplate sqlSession, int userNo) {
		return (ArrayList)sqlSession.selectList("teamMapper.selectLoginUserNo", userNo);
	}

	// 팀 요청 리스트 가져오기
	public ArrayList<TeamReq> selectReqList(SqlSessionTemplate sqlSession, int tno) {
		
		return (ArrayList)sqlSession.selectList("teamMapper.selectReqList", tno);
	}
	
	// 팀요청 수락
	public int teamReqAccept(SqlSessionTemplate sqlSession, int reqNo) {
		return sqlSession.update("teamMapper.teamReqAccept", reqNo);
	}
	
	// 팀요청 거절
	public int teamReqReqRefuse(SqlSessionTemplate sqlSession, int reqNo) {
		return sqlSession.delete("teamMapper.teamReqReqRefuse", reqNo);
	}
	
	// 팀 이름 가져오기
	public String selectTeamName(SqlSessionTemplate sqlSession, int tno) {
		return sqlSession.selectOne("teamMapper.selectTeamName", tno);
	}
	
	// 팀 프로필 가져오기
	public String selectTeamProImg(SqlSessionTemplate sqlSession, int tno) {
		return sqlSession.selectOne("teamMapper.selectTeamProImg", tno);
	}
	
	// 회원 번호 가져오기
	public int reqList(SqlSessionTemplate sqlSession, int reqNo) {
		return sqlSession.selectOne("teamMapper.reqList", reqNo);
	}
	
	// 회원 번호 가져오기
	public int acceptTeamMember(SqlSessionTemplate sqlSession, int reqList, int tno) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("reqList", reqList);
		params.put("tno", tno);
		
		return sqlSession.insert("teamMapper.acceptTeamMember", params);
	}
	
	// 팀 요청 리스트에서 유저 번호 가져오기
	public ArrayList<TeamReq> selectReqUserNo(SqlSessionTemplate sqlSession, int tno) {
		return (ArrayList)sqlSession.selectList("teamMapper.selectReqUserNo", tno);
	}
	
	// 개인 프로필 가져오기
	public String selectMemberProImg(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("teamMapper.selectMemberProImg", userNo);
	}
}
