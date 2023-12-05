package com.kh.finalProject.place.model.service;

import java.util.ArrayList;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.place.model.vo.Place;

public interface PlaceService {

	int placeListCount();
	ArrayList<Place> selectPlaceList(PageInfo pi);
	
}
