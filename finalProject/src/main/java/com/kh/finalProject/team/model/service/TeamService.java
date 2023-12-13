package com.kh.finalProject.team.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.team.model.dao.TeamDao;
import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamImg;
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
	public int insertTeam(Team t) {
		return teamDao.insertTeam(sqlSession, t);
	}
	
	@Override
	public int insertTeamImg(TeamImg ti) {
		return teamDao.insertTeamImg(sqlSession, ti);
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
	public ArrayList<TeamOffer> selectCity(String activityAtea, int category, PageInfo pi) {
		return teamDao.selectCity(sqlSession, activityAtea, category, pi);
	}

	@Override
	public int selectOfferListCount(String activityAtea, int category) {
		return teamDao.selectOfferListCount(sqlSession, activityAtea, category);
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
	public int teamReq(int userNo, String reqContent, int offerNo) {
		return teamDao.teamReq(sqlSession, userNo, reqContent, offerNo);
	}

	@Override
	public TeamMember selectInformation(int userNo) {
		return teamDao.selectInformation(sqlSession, userNo);
	}

	@Override
	public int insertOfferList(TeamOffer t, int tno) {
		return teamDao.insertOfferList(sqlSession, t, tno);
	}

	@Override
	public int insertOfferImg(TeamImg ti, int tno) {
		return teamDao.insertOfferImg(sqlSession, ti, tno);
	}

	@Override
	public TeamImg selectOfferImg(int tno) {
		return teamDao.selectOfferImg(sqlSession, tno);
	}

	@Override
	public int selectListCountCate(int category) {
		return teamDao.selectListCountCate(sqlSession, category);
	}

	@Override
	public ArrayList<TeamOffer> selectCityAll(int category, PageInfo pi) {
		return teamDao.selectCityAll(sqlSession, category, pi);
	}

	@Override
	public int selectNotCategory(String activityAtea) {
		return teamDao.selectNotCategory(sqlSession, activityAtea);
	}

	@Override
	public ArrayList<TeamOffer> selectOnlyCity(String activityAtea, PageInfo pi) {
		return teamDao.selectOnlyCity(sqlSession, activityAtea, pi);
	}
	
	@Override
	public int teamMemberCount(int tno) {
		return teamDao.teamMemberCount(sqlSession, tno);
	}
	
	@Override
	public int teamAvgAge(int tno) {
		return teamDao.teamAvgAge(sqlSession, tno);
	}

	@Override

	public Team teamProfile(int tno) {
		return teamDao.teamProfile(sqlSession, tno);
	}

	public ArrayList<Team> searchTeam(String selectValue) {
		return teamDao.searchTeam(sqlSession, selectValue);
	}


	@Override
	public ArrayList<TeamMember> teamMemberList(int tno) {
		return teamDao.teamMemberList(sqlSession, tno);
	}

	// 팀 번호 조회
	@Override
	public int getTeamNumber(int userNo) {
		return teamDao.getTeamNumber(sqlSession, userNo);
	}



}
