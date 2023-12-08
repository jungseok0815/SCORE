package com.kh.finalProject.team.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.team.model.dao.TeamDao;
import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamMember;

@Service
public class TeamService implements TeamServiceImp{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private TeamDao teamDao;
	
	@Override
	public int selectListCount() {
		return teamDao.selectListCount(sqlSession);
	}

	@Override
	public Team selectCategoryNum(int teamNo) {
		return teamDao.selectCategoryNum(sqlSession, teamNo);
	}

	@Override
	public TeamMember selectUserNo(int tmemberNo) {
		return teamDao.selectUserNo(sqlSession, tmemberNo);
	}
	
	@Override
	public int insertTeam(Team t) {
		return teamDao.insertTeam(sqlSession, t);
	}
	
}
