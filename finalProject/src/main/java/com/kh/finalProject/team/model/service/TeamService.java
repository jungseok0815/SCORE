package com.kh.finalProject.team.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.team.model.dao.TeamDao;
import com.kh.finalProject.team.model.vo.TeamOffer;

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
	public ArrayList<TeamOffer> selectList(PageInfo pi) {
		return teamDao.selectList(sqlSession, pi);
	}

	@Override
	public int increaseCount(int offerNo) {
		return teamDao.increaseCount(sqlSession, offerNo);
	}

	@Override
	public TeamOffer selectOfferDetail(int offerNo) {
		return teamDao.selectOfferDetail(sqlSession, offerNo);
	}

	@Override
	public ArrayList<TeamOffer> selectCity(String activityAtea) {
		return teamDao.selectCity(sqlSession, activityAtea);
	}

	@Override
	public int selectOfferListCount(String activityAtea) {
		return teamDao.selectOfferListCount(sqlSession, activityAtea);
	}

//	@Override
//	public int selectOfferListAll(String activityAtea) {
//		return teamDao.selectOfferListAll(sqlSession, activityAtea);
//	}



	
}
