package com.kh.finalProject.place.model.service;

import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;

public interface PlaceService {
	//경기장 등록
	int insertPlace(Place p);
	//경기장 사진 등록
	int insertPlaceImg(PlaceImg pi);
}
