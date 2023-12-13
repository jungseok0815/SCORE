package com.kh.finalProject.team.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.finalProject.common.template.Pagenation;
import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.team.model.service.TeamService;
import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamImg;
import com.kh.finalProject.team.model.vo.TeamMember;
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
	
	@ResponseBody
	@RequestMapping(value="choiceSportsAjax.tm", produces="application/json; charset=UTF-8")
	public String teamChoiceSportsAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String activityAtea, int category, ModelAndView mv) {
		
		if(activityAtea.equals("all")) {
			int choiceCount = teamService.selectChoiceAllCount(category);
			System.out.println(choiceCount);
			
			// 게시물 갯수와 페이징 
			PageInfo pi = Pagenation.getPageInfo(teamService.selectChoiceAllCount(category), currentPage, 10, 5);
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectChoiceAllList(category, pi);
			mv.addObject("pi", pi)
			  .addObject("list", teamService.selectChoiceAllList(category, pi));
			
			return new Gson().toJson(mv);
		
		} else {
			int choiceCount = teamService.selectChoiceSportsCount(category, activityAtea);
			
			// 게시물 갯수와 페이징 
			PageInfo pi = Pagenation.getPageInfo(teamService.selectChoiceSportsCount(category, activityAtea), currentPage, 10, 5);
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectChoiceList(category, activityAtea, pi);
			mv.addObject("pi", pi)
			  .addObject("list", teamService.selectChoiceList(category, activityAtea, pi));
			
			return new Gson().toJson(mv);
		}
	}
	
	@RequestMapping("offerDelete.tm")
	public String teamOfferDelete(int tno, String filePath, HttpSession session, Model model) {
		
		int result = teamService.deleteOffer(tno);
		
		if (result > 0) { //삭제성공
			
			if(!filePath.equals("")) {
//				new File(session.getServletContext().getRealPath(filePath)).delete();
			}
			session.setAttribute("alertMsg", "게시글 삭제 성공");
			return "team/teamOfferListDetailView";
		} else {
			model.addAttribute("errorMsg", "게시글 삭제 실패");
			return "common/errorMsg";
		}

	}
	
	@RequestMapping("teamReq.tm")
	public String teamReq(String userId, String text) {
		System.out.println(text);
		System.out.println(userId);
		int teamR = teamService.teamReq(userId, text);
		return "";
	}
	
	//팀 프로필 뷰 셀렉트
	@RequestMapping("teamProfile.tm")
	public ModelAndView teamProfile(String teamNo, HttpSession session, ModelAndView mv) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int tno = Integer.parseInt(teamNo);
		int tmc = teamService.teamMemberCount(tno);
		int taa = teamService.teamAvgAge(tno);
		
		Team t = teamService.teamProfile(tno);
		System.out.println(t);
		ArrayList<TeamMember> tm = teamService.teamMemberList(tno);
		System.out.println(tm);
		
		int myGrade = 1;
		for (TeamMember m : tm) {
			if(m.getUserNo() == loginUser.getUserNo())
				myGrade = m.getGrade();
			
		}
		
		mv.addObject("teamMemberCount", tmc)
		.addObject("teamAvgAge", taa)
		.addObject("team", t)
		.addObject("teamMemberList", tm)
		.addObject("myGrade", myGrade)
		.setViewName("team/teamProfile");
		
		return mv;
	}
	
	
	@RequestMapping("updateForm.tm")
	public String teamProfileUpdateForm() {
		return "team/teamProfileUpdate";
	}
	@RequestMapping("joinList.tm")
	public String teamJoinListForm() {
		return "team/teamJoinList";
	}
	
	
	//팀프로필에서 버튼 눌렀을 때 보내주는 메소드
	@RequestMapping("insertTeamOfferForm.tm")
	public String teamOfferInsertForm() {
		return "team/teamOfferInsert";
	}
	
	
	//팀 생성
	@RequestMapping("insertTeam.tm")
	public String insertTeam(Team t, TeamImg ti, MultipartFile upfile, HttpSession session, Model model) {

		Member m = (Member)session.getAttribute("loginUser");

		int result = teamService.insertTeam(t);
		int result2 = teamService.insertTeamMember(m);
		int resultImg = 0;
	
		if(!upfile.getOriginalFilename().equals("")) {
			
			 String changeName = saveFile(upfile, session);
			 
			 ti.setTeamImgUrl("resources/img/team/");
			 ti.setTeamOriginName(upfile.getOriginalFilename());
			 ti.setTeamChangeName("resources/img/team/teamInsert" + changeName);
			 
			 resultImg = teamService.insertTeamImg(ti);
			 
		}
		
		if(result * resultImg > 0) {
			session.setAttribute("alertMsg", "팀 생성 완료되었습니다.");
			return "redirect:/";
		} else {
			session.setAttribute("alertMsg", "사진을 첨부해주세요");
			return "redirect:/";
		}
	}
	
	public String saveFile(MultipartFile upfile, HttpSession session) {
		  
	      String originName = upfile.getOriginalFilename();
	      
	      String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	      
	      int ranNum = (int)(Math.random() * 90000) + 10000;
	      
	      String ext = originName.substring(originName.lastIndexOf("."));
	      
	      String changeName = currentTime + ranNum + ext;
	      
	      String savePath = session.getServletContext().getRealPath("/resources/img/place/placeInsert/");
	      
	      try {
	         upfile.transferTo(new File(savePath + changeName));
	      } catch (IllegalStateException | IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      return changeName;
	   }
	

	@RequestMapping("insertTeamOffer.tm")
	public String teamOfferInsert() {
		return "team/teamProfile";
	}
	@ResponseBody
	@RequestMapping(value="resMatch.tm", produces="application/json; charset=UTF-8")
	public String reservationMatch(int userNo, int categoryNum, Model m){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("userNo", userNo);
		map.put("categoryNum", categoryNum);
		ArrayList<Team> myTeamList = teamService.selectMyTeamList(map);
		m.addAttribute("myTeamList", myTeamList);
		return new Gson().toJson(m);
	}

	@ResponseBody
	@RequestMapping(value="selectTeamMember.tm", produces="application/json; charset=UTF-8")
	public ArrayList<TeamMember> selectTeamMemberList(@RequestParam("teamNo") int teamNo){
		ArrayList<TeamMember> tm = teamService.teamMemberList(teamNo);
		return tm;
	}
}
