package com.kh.finalProject.team.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamMember;

@Repository
public class TeamDao {

	public int selectListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("teamMapper.selectListCount");
	}
	
	public Team selectCategoryNum(SqlSessionTemplate sqlSession, int teamNo) {
		return sqlSession.selectOne("teamMapper.selectCategoryNum", teamNo);
	}
	
	public TeamMember selectUserNo(SqlSessionTemplate sqlSession, int tmemberNo) {
		return sqlSession.selectOne("teamMapper.selectUserNo", tmemberNo);
	}
	
	public int insertTeam(SqlSessionTemplate sqlSession, Team t) {
		return sqlSession.insert("teamMapper.insertTeam", t);
	}
}
