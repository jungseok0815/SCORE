package com.kh.finalProject.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamController {

	@RequestMapping("offerBoardList.tm")
	public String teamOfferBoardList() {
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
