package com.kh.finalProject.team.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDao {

	public int selectListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("teammapper.selectListCount");
	}
	
	
}
