package com.kh.finalProject.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.common.template.Pagenation;
import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.place.model.service.PlaceServiceImpl;

@Controller
public class PlaceCtroller {
	
	@Autowired
	private PlaceServiceImpl pService;
	
	
	@RequestMapping("/insert.pl")
	public String myPage() {
		return "place/placeInsert";
		
	}
	
	@RequestMapping("/detail.pl")
	public String placeDetailview() {
		return "place/placeDetailView";
		
	}
	
	@RequestMapping("/loadList.pl")
	public ModelAndView placeListCount(@RequestParam(value="cpage", defaultValue="1") int currentPage,
			ModelAndView mv) {
		PageInfo pi = Pagenation.getPageInfo(pService.placeListCount(), currentPage, 5, 5);
		mv.addObject("pi",pi)
		  .addObject("list", pService.selectPlaceList(pi))
		  .setViewName("");
		return mv;
	}
}
