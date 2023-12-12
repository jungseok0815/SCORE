package com.kh.finalProject.place.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.place.model.dao.PlaceDao;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;
import com.kh.finalProject.place.model.vo.Reservation;



@Service
public class PlaceServiceImpl implements PlaceService{

	@Autowired
	private PlaceDao pDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public int insertPlace(Place p) {
		return pDao.insertPlace(sqlSession, p);
	}

	@Override
	public int insertPlaceImg(PlaceImg pi) {
		
		return pDao.insertPlaceImg(sqlSession, pi);
	}
	
	
	@Override
	public int placeListCount(Place pl) {
		return pDao.placeListCount(sqlSession, pl);
	}
	
	
	@Override
	public ArrayList<Place> selectPlaceList(PageInfo pi, Place pl) {
		return pDao.selectPlaceList(sqlSession, pi, pl);
	}


	@Override
	public Place placeDetailview(int fno) {
		return pDao.placeDetailview(sqlSession, fno);
	}


	@Override
	public ArrayList<Place> selectResPlaceList() {
		return pDao.selectResPlaceList(sqlSession);
	}

	@Override
	public int placeResCount(int fno) {
		return pDao.placeResCount(sqlSession, fno);
	}

	@Override
	public ArrayList<Place> searchPlace(String selectValue) {
		return pDao.searchPlace(sqlSession,selectValue);
	}

	@Override
	public int insertResMatch(Reservation res) {
		return pDao.insertResMatch(sqlSession, res);
	}

	@Override
	public int payPoint(Member loginUser) {
		return pDao.payPoint(sqlSession, loginUser);
	}


}
