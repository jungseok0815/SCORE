package com.kh.finalProject.place.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.place.model.dao.PlaceDao;
import com.kh.finalProject.place.model.vo.Place;

@Service
public class PlaceServiceImpl implements PlaceService{

	@Autowired
	private PlaceDao pDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public int placeListCount() {
		return pDao.placeListCount(sqlSession);
	}
	
	
	@Override
	public ArrayList<Place> selectPlaceList(PageInfo pi) {
		return pDao.selectPlaceList(sqlSession, pi);
	}


}
