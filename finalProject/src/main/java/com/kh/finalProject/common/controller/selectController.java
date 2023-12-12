package com.kh.finalProject.common.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.place.model.service.PlaceServiceImpl;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.team.model.service.TeamService;
import com.kh.finalProject.team.model.vo.Team;

@Controller
public class selectController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private PlaceServiceImpl pService;
	
	
	@ResponseBody 
	@RequestMapping(value= "/searchMain.cm",produces="application/json; charset=UTF-8" )
	public String searchMain(String selectValue,HttpSession session) {
			
			ArrayList<Member> mList = memberService.searchMember(selectValue);
			ArrayList<Team> tList = teamService.searchTeam(selectValue);
			ArrayList<Place> pList = pService.searchPlace(selectValue);
//			ArrayList<Member> myFriendList = memberService.selectReaResFriendList(m.getUserNo());
			
			HashMap selectData = new HashMap();
			selectData.put("mList",memberService.searchMember(selectValue));
			selectData.put("tList",teamService.searchTeam(selectValue));
			selectData.put("pList",pService.searchPlace(selectValue));
			
			return new Gson().toJson(selectData);
	}
}
