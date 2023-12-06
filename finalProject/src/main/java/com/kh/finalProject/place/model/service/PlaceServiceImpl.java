package com.kh.finalProject.place.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.place.model.dao.PlaceDao;
import com.kh.finalProject.place.model.vo.Place;

@Service
public class PlaceServiceImpl implements PlaceService{
	
	@Autowired
	private PlaceDao placeDao;
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertPlace(Place p) {
		return placeDao.insertPlace(sqlSession, p);
	}
	
}
