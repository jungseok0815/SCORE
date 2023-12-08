package com.kh.finalProject.team.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.finalProject.common.template.Pagenation;
import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.team.model.service.TeamService;
import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamMember;

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
	
	@RequestMapping("selectMyTeam.tm")
	public String selectMyTeam(int teamNo, int tmemberNo) {
		//categoryNum
		Team t = teamService.selectCategoryNum(teamNo);
		//userNo
		TeamMember tm = teamService.selectUserNo(tmemberNo);
		
		//팀 생성먼저
				
		return "team/teamOfferListDetailView";
	}
	
	@RequestMapping("insertTeam.tm")
	public String insertTeam(Team t, MultipartFile upfile, HttpSession session, Model model) {
		int result = teamService.insertTeam(t);
		if(result > 0) {
			session.setAttribute("alertMsg", "팀 생성 완료");
			return "redirect:main";
		} else {
			model.addAttribute("errorMsg", "팀 생성 실패");
			return "common/errorPage";
		}
	}
	
}
