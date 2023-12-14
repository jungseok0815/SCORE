package com.kh.finalProject.team.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		
		ArrayList<TeamOffer> list = teamService.selectList(pi);
		
//		for (TeamOffer t : list) {
//		    int teamNo = t.getTeamNo();
//		    System.out.println("팀 번호" + teamNo);
//		
//		    String img = teamService.selectTeamImg(teamNo);
////		    ArrayList<TeamOffer> img = teamService.selectTeamImg(teamNo, pi);
//		    System.out.println("팀 이미지" + img);
//		    
//		    mv.addObject("pi", pi)
//			  .addObject("list", list)
//			  .addObject("img", img)
//			  .setViewName("team/teamOfferBoardList");
//			
//			return mv;
//		}
		
//		for (TeamOffer t : list) {
//		    int teamNo = t.getTeamNo();
//		    System.out.println("팀 번호" + teamNo);
//		    
//		    String img = teamService.selectTeamImg(teamNo);
//		    ArrayList<TeamOffer> img = teamService.selectTeamImg(teamNo);
//		}
		
//		mv.addObject("pi", pi)
//		  .addObject("list", list)
//		  .setViewName("team/teamOfferBoardList");
		
		
//		for(int i= 0; i < list.size(); i++) {
//			System.out.println(list.size());
//			
//			for (TeamOffer t : list) {
//				System.out.println(t);
//			    int teamNo = t.getTeamNo();
//			    System.out.println("팀 번호" + teamNo);
//			    
//			    String img = teamService.selectTeamImg(teamNo);  // 팀번호가 일치하는 이미지 가져 오기 
////			    ArrayList<TeamOffer> img = teamService.selectTeamImg(teamNo);
//			    
//			    list.get(i).setTeamChangeName(img);
//				System.out.println(list + "sssss");
//				
//				mv.addObject("pi", pi)
//				  .addObject("list", list)
//				  .setViewName("team/teamOfferBoardList");
//				
//				return mv;
//			}
//		}
		
		for(int i= 0; i < list.size(); i++) {
			System.out.println("팀 번호" + list.get(i).getTeamNo());
			
			String img = teamService.selectTeamImg(list.get(i).getTeamNo());
//			String img = teamService.selectTeamImg(teamNo);
			System.out.println("이미지 이름" + img);
			
			list.get(i).setTeamChangeName(img);
			System.out.println("체인지 들어감" + list);
			
			mv.addObject("pi", pi)
			  .addObject("list", list)
			  .setViewName("team/teamOfferBoardList");
			
			return mv;
		}
		
		mv.addObject("pi", pi)
		  .addObject("list", list)
		  .setViewName("team/teamOfferBoardList");
		
		return mv;
	}
	
	@RequestMapping("offerDetailView.tm")
	public String teamOfferDetailView(int tno, Model model, HttpSession session) {
		int result = teamService.increaseCount(tno);  // tno는 게시물 번호 

		if (result > 0) {
			TeamOffer teamOffer = teamService.selectOfferDetail(tno);
			TeamImg teamImg = teamService.selectOfferImg(tno);
			
			model.addAttribute("teamOffer", teamOffer);
			// 어쏘를 데이터베이스로부터 조회해서 넘겨주자
			model.addAttribute("teamImg", teamImg);
			
			return "team/teamOfferListDetailView";
		} else {
			model.addAttribute("errorMsg", "게시글 조회 실패");
			return "common/errorMsg";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="offerAjax.tm", produces="application/json; charset=UTF-8")
	public String teamOfferAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String activityAtea, int category, ModelAndView mv) {
		
//		int offerCount = teamService.selectOfferListCount(activityAtea);
//		PageInfo pi = Pagenation.getPageInfo(offerCount, currentPage, 10, 5);

		// 게시물 갯수와 페이징 
//		PageInfo pi = Pagenation.getPageInfo(teamService.selectOfferListCount(activityAtea), currentPage, 10, 5);
		
		if(activityAtea.equals("all") && category == 0) {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectListCount(), currentPage, 10, 5);
			
			ArrayList<TeamOffer> list = teamService.selectList(pi);
			
			mv.addObject("pi", pi)
			  .addObject("list", teamService.selectList(pi));
			
			return new Gson().toJson(mv);
		}
		
		
		if(activityAtea.equals("all")) {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectListCountCate(category), currentPage, 10, 5);
			
																// 카테고리 조건으로 
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectCityAll(category, pi);
			
			mv.addObject("pi", pi)
			  .addObject("list", teamService.selectCityAll(category, pi));

			return new Gson().toJson(mv);
			
		} else if(!activityAtea.equals("all") && category == 0){
			PageInfo pi = Pagenation.getPageInfo(teamService.selectNotCategory(activityAtea), currentPage, 10, 5);
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectOnlyCity(activityAtea, pi);
				
			mv.addObject("pi", pi)
			  .addObject("list", teamService.selectOnlyCity(activityAtea, pi));
			
			return new Gson().toJson(mv);
		} else {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectOfferListCount(activityAtea, category), currentPage, 10, 5);
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectCity(activityAtea, category, pi);
			
			mv.addObject("pi", pi)						
			  .addObject("list", teamService.selectCity(activityAtea, category, pi));
			
			return new Gson().toJson(mv);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="choiceSportsAjax.tm", produces="application/json; charset=UTF-8")
	public String teamChoiceSportsAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String activityAtea, int category, ModelAndView mv) {
		
		if(activityAtea.equals("all")) {
			int choiceCount = teamService.selectChoiceAllCount(category);

			
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
			
			session.setAttribute("alertMsg", "게시글 삭제 성공");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "게시글 삭제 실패");
			return "common/errorMsg";
		}
	}
	
	@RequestMapping("teamReq.tm")
	public String teamReq(int userNo, String reqContent, int offerNo, Model model, HttpSession session) {
		
		int teamR = teamService.teamReq(userNo, reqContent, offerNo);
		
		if(teamR > 0) {
			session.setAttribute("alertMsg", "팀 신청 성공");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "신청 실패");
			return "common/errorMsg";
		}
		
	}
	
	
	@RequestMapping("teamProfile.tm")
	public ModelAndView teamProfile(String teamNo, HttpSession session, ModelAndView mv) {
		int tno = Integer.parseInt(teamNo);
		int tmc = teamService.teamMemberCount(tno);
		int taa = teamService.teamAvgAge(tno);
		
		Team t = teamService.teamProfile(tno);
		ArrayList<TeamMember> tm = teamService.teamMemberList(tno);
		
		mv.addObject("teamMemberCount", tmc)
		.addObject("teamAvgAge", taa)
		.addObject("team", t)
		.addObject("teamMemberList", tm)
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
		int result = teamService.insertTeam(t);
		int resultImg = 0;
	
		if(!upfile.getOriginalFilename().equals("")) {
			
			 String changeName = saveFile(upfile, session, "resources/img/team/teamInsert");
			 
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
	
	// 구인글 작성 
	@RequestMapping("insertOffer.tm")
	public String InsertOffer(TeamOffer t, int userNo, TeamImg ti, MultipartFile upfile, HttpSession session, Model model) {
		
		// userPo이 안에 팀 번호 있음
		TeamMember userPo = teamService.selectInformation(userNo);
		
		// tno에 팀 번호 담음 
		int tno = userPo.getTeamNo();
		int resultImg = 0;
		
		// 게시글 등록 
		int result = teamService.insertOfferList(t, tno);
		
		if(!upfile.getOriginalFilename().equals("")) {
			
			String changeName = saveFile(upfile, session, "resources/img/team/teamOfferListDetailView/");
			
			ti.setTeamImgUrl("resources/img/team/teamOfferListDetailView/");
			ti.setTeamOriginName(upfile.getOriginalFilename());
			ti.setTeamChangeName("resources/img/team/teamOfferListDetailView/" + changeName);
			
			resultImg = teamService.insertOfferImg(ti, tno);
		}
		
		if(result * resultImg > 0) {
			session.setAttribute("alertMsg", "구인글 작성 완료");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "구인글 작성 실패");
			return "common/errorPage";
		}
	}
	

	public String saveFile(MultipartFile upfile, HttpSession session, String path) {
		//파일명 수정 후 서버 업로드 시키기("이미지저장용 (2).jpg" => 20231109102712345.jpg)
		//년월일시분초 + 랜덤숫자 5개 + 확장자
		
		//원래 파일명
		String originName = upfile.getOriginalFilename();
		
		//시간정보 (년월일시분초)
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		//랜덤숫자 5자리
		int ranNum = (int)(Math.random() * 90000) + 10000;
		
		//확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		
		//변경된이름
		String changeName = currentTime + ranNum + ext;
		
		//첨부파일 저장할 폴더의 물리적인 경우
		String savePath = session.getServletContext().getRealPath(path);
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
	}
	
	
	
	
	@RequestMapping("insertTeamOffer.tm")
	public String teamOfferInsert() {
		return "team/teamProfile";
	}
}
