package com.kh.finalProject.team.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.team.model.dao.TeamDao;

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

	
}
