package com.kh.finalProject.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamController {

	@RequestMapping("offerBoardList.tm")
	public String teamOfferBoardList() {
		return "team/teamOfferBoardList";
		
	}
}
