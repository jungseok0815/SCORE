package com.kh.finalProject.team.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.team.model.dao.TeamDao;
import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamMember;
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
	public ArrayList<TeamOffer> selectCity(String activityAtea, PageInfo pi) {
		return teamDao.selectCity(sqlSession, activityAtea, pi);
	}

	@Override
	public int selectOfferListCount(String activityAtea) {
		return teamDao.selectOfferListCount(sqlSession, activityAtea);
	}

	@Override
	public int selectChoiceSportsCount(int category, String activityAtea) {
		return teamDao.selectChoiceSportsCount(sqlSession, category, activityAtea);
	}

	@Override
	public ArrayList<TeamOffer> selectChoiceList(int category, String activityAtea, PageInfo pi) {
		return teamDao.selectChoiceList(sqlSession, category, activityAtea, pi);
	}

	@Override
	public int selectChoiceAllCount(int category) {
		return teamDao.selectChoiceAllCount(sqlSession, category);
	}

	@Override
	public ArrayList<TeamOffer> selectChoiceAllList(int category, PageInfo pi) {
		return teamDao.selectChoiceAllList(sqlSession, category, pi);
	}

	@Override
	public int deleteOffer(int offerNo) {
		return teamDao.deleteOffer(sqlSession, offerNo);
	}

	@Override
	public int teamReq(String userId, String text) {
		return teamDao.teamReq(sqlSession, userId, text);
	}

	

}
