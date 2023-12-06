package com.kh.finalProject.place.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.finalProject.place.model.service.PlaceService;
import com.kh.finalProject.place.model.vo.Place;

@Controller
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;
	
//	@RequestMapping("/insert.pl")
//	public String insertPlace(@RequestParam Map<String, String> mapParam) {
//		
//		return "place/placeInsert";
//	}
	
	@RequestMapping("/insertForm.pl")
	public String insertPlaceForm() {
		return "place/placeInsert";
	}

	@RequestMapping("/insert.pl")
	public String insertPlace(Place p, HttpSession session, Model model) {
		System.out.println(p);
		int result = placeService.insertPlace(p);
		System.out.println(result);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "경기장 등록이 완료되었습니다.");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "경기장 등록 실패");
			return "/views/common.errorPage";
		}
		
	}
	
	@RequestMapping("/detail.pl")
	public String placeDetailview() {
		return "place/placeDetailView";
		
	}
}
