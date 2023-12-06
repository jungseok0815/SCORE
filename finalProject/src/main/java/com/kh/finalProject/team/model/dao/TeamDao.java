package com.kh.finalProject.team.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.team.model.vo.TeamOffer;

@Repository
public class TeamDao {

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
	

}
