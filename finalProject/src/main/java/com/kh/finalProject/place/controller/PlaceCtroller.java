package com.kh.finalProject.place.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.finalProject.common.template.Pagenation;
import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.place.model.service.PlaceServiceImpl;
import com.kh.finalProject.place.model.vo.Place;

@Controller
public class PlaceCtroller {
	
	@Autowired
	private PlaceServiceImpl pService;
	
	
	@RequestMapping("/insert.pl")
	public String myPage() {
		return "place/placeInsert";
		
	}
	
	@RequestMapping("/detail.pl")
	public String placeDetailview(int fno, Model m) {
		//금액 3자리 마다 ,찍어주는 클래스
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		Place pl = pService.placeDetailview(fno);
		// 날짜 형식 변경 2023-12-07  =>  12월 7일 
		String monthDate = pl.getFieldDate().substring(5,7) + "월 ";
		String dayDate = (Integer.parseInt(pl.getFieldDate().substring(8,10))) + "일";
		pl.setFieldDate(monthDate+dayDate);
		
		m.addAttribute("pl", pl);
		m.addAttribute("matchPay", formatter.format(pl.getMatchPay()));
		return "place/placeDetailView";
	}
	

	
	@ResponseBody
	@RequestMapping(value="/loadList.pl",produces="application/json; charset=UTF-8")
	public String placeListCount(@RequestParam(value="cpage", defaultValue="1") int currentPage,
			@RequestParam(value="categoryNum", defaultValue="1") int categoryNum,
			@RequestParam(value="area", defaultValue="서울") String area,
			@RequestParam(value="gender", defaultValue="3") int gender,
			@RequestParam(value="level", defaultValue="모든레벨") String level,
			@RequestParam(value="date", defaultValue="") String date,
			ModelAndView mv) {
		Place pl = new Place();
		pl.setCategoryNum(categoryNum);
		pl.setFieldArea(area);
		pl.setMatchGender(gender);
		pl.setMatchLevel(level);
		pl.setFieldDate(date);
		
		PageInfo pi = Pagenation.getPageInfo(pService.placeListCount(pl), currentPage, 5, 5);
		ArrayList<Place> list = pService.selectPlaceList(pi, pl);
		ArrayList<Place> resList = pService.selectResPlaceList();
		System.out.println(resList);
		mv.addObject("pi",pi)
		  .addObject("list", list);
		return new Gson().toJson(mv);
	}

	

}
