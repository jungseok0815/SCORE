package com.kh.finalProject.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.finalProject.common.template.Pagenation;
import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.team.model.service.TeamService;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@RequestMapping("offerBoardList.tm")
	public String teamOfferBoardList(@RequestParam(value="cpage", defaultValue="1") int currentPage) {
		int teamListCount = teamService.selectListCount();
		
		PageInfo pi = Pagenation.getPageInfo(teamListCount, currentPage, 10, 5);
		
		return "team/teamOfferBoardList";
	}
	
	@RequestMapping("teamProfile.tm")
	public String teamProfileView() {
		return "team/teamProfile";
	}
	@RequestMapping("updateForm.tm")
	public String teamProfileUpdateForm() {
		return "team/teamProfileUpdate";
	}
	@RequestMapping("joinList.tm")
	public String teamJoinListForm() {
		return "team/teamJoinList";
	}
	@RequestMapping("offerDetailView.tm")
	public String teamOfferDetailView() {
		return "team/teamOfferListDetailView";
	}
	
	
	
}
