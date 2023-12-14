package com.kh.finalProject.team.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamImg;
import com.kh.finalProject.team.model.vo.TeamMember;
import com.kh.finalProject.common.vo.PageInfo;
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
	
	public ArrayList<TeamOffer> selectCity(SqlSessionTemplate sqlSession, String activityAtea, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("teamMapper.selectCity", activityAtea, rowBounds);
	}
	
	public int selectOfferListCount(SqlSessionTemplate sqlSession, String activityAtea) {
		return sqlSession.selectOne("teamMapper.selectOfferListCount", activityAtea);
	}
	
	public int selectChoiceSportsCount(SqlSessionTemplate sqlSession, int category, String activityAtea) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category);
		params.put("activityAtea", activityAtea);
		    
		return sqlSession.selectOne("teamMapper.selectChoiceSportsCount", params);
	}
	
	public ArrayList<TeamOffer> selectChoiceList(SqlSessionTemplate sqlSession, int category, String activityAtea, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category);
		params.put("activityAtea", activityAtea);
		
		return (ArrayList)sqlSession.selectList("teamMapper.selectChoiceList", params, rowBounds);
	}
	
	public int selectChoiceAllCount(SqlSessionTemplate sqlSession, int category) {
		return sqlSession.selectOne("teamMapper.selectChoiceAllCount", category);
	}
	
	public ArrayList<TeamOffer> selectChoiceAllList(SqlSessionTemplate sqlSession, int category, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("teamMapper.selectChoiceAllList", category, rowBounds);
	}
	
	public int deleteOffer(SqlSessionTemplate sqlSession, int offerNo) {
		return sqlSession.update("teamMapper.deleteOffer", offerNo);
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
}
