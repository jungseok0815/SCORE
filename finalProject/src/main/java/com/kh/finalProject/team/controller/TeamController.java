package com.kh.finalProject.team.controller;

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
import com.kh.finalProject.team.model.service.TeamService;
import com.kh.finalProject.team.model.vo.TeamOffer;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@RequestMapping("offerBoardList.tm")
	public ModelAndView teamOfferBoardList(@RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv) {
		
		PageInfo pi = Pagenation.getPageInfo(teamService.selectListCount(), currentPage, 10, 5);
		
		mv.addObject("pi", pi)
		  .addObject("list", teamService.selectList(pi))
		  .setViewName("team/teamOfferBoardList");
		
		return mv;
	}
	
	@RequestMapping("offerDetailView.tm")
	public String teamOfferDetailView(int tno, Model model) {
		
		int result = teamService.increaseCount(tno);
		
		if (result > 0) {
			TeamOffer team = teamService.selectOfferDetail(tno);
			model.addAttribute("team", team);
			
			return "team/teamOfferListDetailView";
		} else {
			model.addAttribute("errorMsg", "게시글 조회 실패");
			return "common/errorMsg";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="offerAjax.tm", produces="application/json; charset=UTF-8")
	public String teamOfferAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String activityAtea, ModelAndView mv) {
		System.out.println(activityAtea);
		
//		int offerCount = teamService.selectOfferListCount(activityAtea);
//		PageInfo pi = Pagenation.getPageInfo(offerCount, currentPage, 10, 5);
		
		// 게시물 갯수와 페이징 
//		PageInfo pi = Pagenation.getPageInfo(teamService.selectOfferListCount(activityAtea), currentPage, 10, 5);
		
		if(activityAtea.equals("all")) {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectListCount(), currentPage, 10, 5);
			
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectCity(activityAtea, pi);
			
			mv.addObject("pi", pi)
			  .addObject("list", teamService.selectList(pi));

			return new Gson().toJson(mv);
			
		} else {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectOfferListCount(activityAtea), currentPage, 10, 5);
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectCity(activityAtea, pi);
			
			mv.addObject("pi", pi)						// pi 처리
			  .addObject("list", teamService.selectCity(activityAtea, pi));
			

			return new Gson().toJson(mv);
		}
		
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
	
	
	
	
}
