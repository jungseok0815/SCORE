package com.kh.finalProject.place.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlaceCtroller {
	
	@RequestMapping("/insert.pl")
	public String myPage() {
		return "place/placeInsert";
		
	}
	
	@RequestMapping("/detail.pl")
	public String placeDetailview() {
		return "place/placeDetailView";
		
	}
}
