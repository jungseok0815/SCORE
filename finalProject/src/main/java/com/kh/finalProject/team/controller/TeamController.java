package com.kh.finalProject.team.controller;

import java.awt.List;
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
import com.kh.finalProject.team.model.vo.TeamReq;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@RequestMapping("offerBoardList.tm")
	public ModelAndView teamOfferBoardList(@RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv) {
		PageInfo pi = Pagenation.getPageInfo(teamService.selectListCount(), currentPage, 10, 5);
		ArrayList<TeamOffer> list = teamService.selectList(pi);
		for(int i= 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
			String img = teamService.selectTeamImg(list.get(i).getTeamNo());

			// 리스트에 팀 프로필 이미지 담아 주기
			list.get(i).setTeamChangeName(img);
			
//			mv.addObject("pi", pi)
//			  .addObject("list", list)
//			  .setViewName("team/teamOfferBoardList");
			

//			String img = teamService.selectTeamImg(teamNo);
			// 리스트에 팀 프로필 이미지 담아 주기
			list.get(i).setTeamChangeName(img);

		}
		mv.addObject("pi", pi)
		  .addObject("list", list)
		  .setViewName("team/teamOfferBoardList");
		
		return mv;
	}
	
	@RequestMapping("offerDetailView.tm")
	public String teamOfferDetailView(int tno, int teamNo, Model model, HttpSession session) {
					// tno는 게시물 번호  teamNo 팀 번호
		int result = teamService.increaseCount(tno);  

		Member loginUser = (Member)session.getAttribute("loginUser");
		int isMyteam = 0;
		int reqList = 0;
		if (loginUser != null) {
			ArrayList<TeamMember> tlist = teamService.selectLoginUserNo(loginUser.getUserNo());

			//tlist 반복하면 서  팀넘버랑 teamNo비교 동일한게 있다면 isMyteam = 1
			for(TeamMember teamList : tlist) {
				if(teamList.getTeamNo() == teamNo) {
					isMyteam = 1;
					break;
				}
			}
		}
		
		ArrayList<TeamReq> listReq = teamService.selectListReqCount(tno);
		
		if (result > 0) {
			TeamOffer teamOffer = teamService.selectOfferDetail(tno);
			TeamImg teamImg = teamService.selectOfferImg(tno);
			TeamImg profileImg = teamService.offerProfileImg(teamNo);
			
			if(loginUser != null) {
				reqList = teamService.selectReqListCheck22(loginUser.getUserNo(), tno, teamNo);
			}
			
			model.addAttribute("teamOffer", teamOffer);
			// 어쏘를 데이터베이스로부터 조회해서 넘겨주자
			model.addAttribute("teamImg", teamImg);
			model.addAttribute("profileImg", profileImg);
			model.addAttribute("teamNo", teamNo);
			model.addAttribute("isMyteam", isMyteam);
			model.addAttribute("reqList", reqList);
			model.addAttribute("listReq", listReq);
			
			return "team/teamOfferListDetailView";
		} else {
			model.addAttribute("errorMsg", "게시글 조회 실패");
			return "common/errorMsg";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="offerAjax.tm", produces="application/json; charset=UTF-8")
	public String teamOfferAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String activityAtea, int category, ModelAndView mv) {
		
		if(activityAtea.equals("all") && category == 0) {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectListCount(), currentPage, 10, 5);
			
			ArrayList<TeamOffer> list = teamService.selectList(pi);
			
			if(list == null) {
				mv.addObject("pi", pi)
				  .addObject("list", list)
				  .setViewName("team/teamOfferBoardList");
				return new Gson().toJson(mv);
			} else {
				for(int i= 0; i < list.size(); i++) {
					
					String img = teamService.selectTeamImg(list.get(i).getTeamNo());
					
					list.get(i).setTeamChangeName(img);
					
//					mv.addObject("pi", pi)
//					  .addObject("list", list)
//					  .setViewName("team/teamOfferBoardList");
				}
			}
			mv.addObject("pi", pi)
			  .addObject("list", list)
			  .setViewName("team/teamOfferBoardList");

			return new Gson().toJson(mv);
			
		} else if(!activityAtea.equals("all") && category == 0) {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectNotCategory(activityAtea), currentPage, 10, 5);

			ArrayList<TeamOffer> list = teamService.selectOnlyCity(activityAtea, pi);
			
			if(list != null) {
				for(int i= 0; i < list.size(); i++) {
					
					String img = teamService.selectTeamImg(list.get(i).getTeamNo());
					
					list.get(i).setTeamChangeName(img);
					
//					mv.addObject("pi", pi)
//					  .addObject("list", list)
//					  .setViewName("team/teamOfferBoardList");
				}
			}
			mv.addObject("pi", pi)
			  .addObject("list", list)
			  .setViewName("team/teamOfferBoardList");

			return new Gson().toJson(mv);
			
		} else if(activityAtea.equals("all") && category != 0) {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectListCountCate(category), currentPage, 10, 5);

			ArrayList<TeamOffer> list = teamService.selectCityAll(category, pi);
			
			if(list != null) {
				for(int i= 0; i < list.size(); i++) {
					
					String img = teamService.selectTeamImg(list.get(i).getTeamNo());
					
					list.get(i).setTeamChangeName(img);
					
//					mv.addObject("pi", pi)
//					  .addObject("list", list)
//					  .setViewName("team/teamOfferBoardList");
				}
			}
			
			mv.addObject("pi", pi)
			  .addObject("list", list)
			  .setViewName("team/teamOfferBoardList");
			
			return new Gson().toJson(mv);	
			
		} else {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectOfferListCount(activityAtea, category), currentPage, 10, 5);
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectCity(activityAtea, category, pi);
			
			if(list != null) {
				for(int i= 0; i < list.size(); i++) {
					
					String img = teamService.selectTeamImg(list.get(i).getTeamNo());
					
					list.get(i).setTeamChangeName(img);
					
//					mv.addObject("pi", pi)
//					  .addObject("list", list)
//					  .setViewName("team/teamOfferBoardList");
				}
			}
			
			mv.addObject("pi", pi)
			  .addObject("list", list)
			  .setViewName("team/teamOfferBoardList");
			
			return new Gson().toJson(mv);
		}	
	}
	

	
	@RequestMapping("offerDelete.tm")
	public String teamOfferDelete(int tno, String filePath, HttpSession session, Model model) {
		// tno가 게시물 번호임 !!
		int result1 = teamService.deleteOfferImg(tno);
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
	
	//팀 프로필 뷰 셀렉트
	@RequestMapping("teamProfile.tm")
	public ModelAndView teamProfile(String teamNo, HttpSession session, ModelAndView mv) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int tno = Integer.parseInt(teamNo);
		int tmc = teamService.teamMemberCount(tno);
		int taa = teamService.teamAvgAge(tno);
		
		Team t = teamService.teamProfile(tno);
		
		int reqList = 0;
		int offerNo = 0;
		
		ArrayList<TeamOffer> list = teamService.teamOfferListNo(tno);
		
		if(loginUser != null) {
			
			for(int i = 0; i < list.size(); i++) {
				TeamOffer teamOffer = list.get(i); 
			    offerNo = teamOffer.getOfferNo(); 
			    System.out.println("구인번호: " + offerNo);
			}
			
			reqList = teamService.selectReqListCheck33(loginUser.getUserNo(), tno, offerNo); 
			System.out.println("신청자들 없으면 -1 : " + reqList);
		}

		ArrayList<TeamOffer> listCount = teamService.listCountNo(tno);
		System.out.println("ajsepajs" + listCount);
		
		// 팀 프로필
		ArrayList<TeamMember> tm = teamService.teamMemberList(tno);

		int myGrade = 0;
		for (TeamMember m : tm) {
			if(m.getUserNo() == loginUser.getUserNo())
				myGrade = m.getGrade();
			
		}
//		System.out.println(tm);
		mv.addObject("teamMemberCount", tmc)
		.addObject("teamAvgAge", taa)
		.addObject("team", t)
		.addObject("teamMemberList", tm)
		.addObject("myGrade", myGrade)
		.addObject("reqList", reqList)
		.addObject("listCount", listCount)
		.setViewName("team/teamProfile");
		
		return mv;
	}
	
	
	@RequestMapping("updateForm.tm")
	public ModelAndView teamUpdateForm(int tno, ModelAndView mv) {
//		System.out.println(tno);
		Team t = teamService.teamProfile(tno);
//		System.out.println(t);
		mv.addObject("team", t).setViewName("team/teamProfileUpdate");
		return mv;
	}
	
	@RequestMapping("update.tm")
	public ModelAndView teamProfileUpdate(Team t, TeamImg ti, MultipartFile reupfile, HttpSession session, ModelAndView mv) {
//		System.out.println(t);
		int resultImg = 0;
		
	    //새로운 첨부파일 존재유무 확인
	    if(!reupfile.getOriginalFilename().equals("")) {
	       String changeName = saveFile(reupfile, session, "resources/img/team/teamProfile/");
	       if(ti.getTeamOriginName() != null) {
	          new File(session.getServletContext().getRealPath(ti.getTeamChangeName())).delete();
	       }     
	       
	       ti.setTeamOriginName(reupfile.getOriginalFilename());
	       ti.setTeamChangeName("resources/img/team/teamProfile/" + changeName); 
	      
	    }
	    
	    resultImg = teamService.updateTeamImg(ti);
	    int resultContent = teamService.updateTeam(t);
	    
	    if(resultContent > 0) {
	        session.setAttribute("alertMsg", "팀 수정 완료");
	        mv.setViewName("redirect:teamProfile.tm?teamNo=" + t.getTeamNo());
	    }else {
	    	session.setAttribute("alertMsg", "다시 수정해주세요");
	    }
	      
	      return mv;
	}
	
	@RequestMapping("joinList.tm")
	public ModelAndView teamJoinListForm(int tno, ModelAndView mv) {
		// 유저 번호 조회
		ArrayList<TeamReq> userNoList = teamService.selectReqUserNo(tno);
		
		ArrayList<TeamReq> resultList = new ArrayList<>();
		
		for (TeamReq teamReq : userNoList) {
		    int userNo = teamReq.getReqUserNo();
		  
		    String memberChangeName = teamService.selectMemberProImg(userNo); // 개인 프로필
			
			teamReq.setMemberChangeName(memberChangeName);
			
			resultList.add(teamReq);
		}
		
		ArrayList<TeamReq> list = teamService.selectReqList(tno);
		
		String tName = teamService.selectTeamName(tno);			// 팀 이름
		String tProfile = teamService.selectTeamProImg(tno); // 팀 프로필

		mv.addObject("list", list)
		.addObject("resultList", resultList)
		.addObject("tno", tno)
		.addObject("tName", tName)
		.addObject("tProfile", tProfile)
		.setViewName("team/teamJoinList");
		
		return mv;
	}
	
	@RequestMapping("accept.tm")
	public String reqAccept(int reqNo, int tno, HttpSession session, Model model) {
		
		
		int reqList = teamService.reqList(reqNo);
		
		int insert = teamService.acceptTeamMember(reqList, tno);
		
		int req = teamService.teamReqReqRefuse(reqNo);
		
		if(req * insert > 0) {
			session.setAttribute("alertMsg", "수락 성공");
//			return "redirect:/teamProfile.tm?teamNo=" + tno;
			return "redirect:/joinList.tm?tno=" + tno;
		} else {
			model.addAttribute("errorMsg", "신청 실패");
			return "common/errorMsg";
		}
	}
	
	@RequestMapping("refuse.tm")
	public String reqRefuse(int reqNo, int tno, HttpSession session, Model model) {
		
		int req = teamService.teamReqReqRefuse(reqNo);
		
		if(req > 0) {
			session.setAttribute("alertMsg", "거절 성공");
//			return "redirect:/teamProfile.tm?teamNo=" + tno;
			return "redirect:/joinList.tm?tno=" + tno;
		} else {
			model.addAttribute("errorMsg", "신청 실패");
			return "common/errorMsg";
		}

	}

	//팀프로필에서 버튼 눌렀을 때 보내주는 메소드
	@RequestMapping("insertTeamOfferForm.tm")
	public ModelAndView teamOfferInsertForm(String tno, ModelAndView mv) {

		mv.addObject("tno", tno).setViewName("team/teamOfferInsert");

		return mv;
	}
	

	
	
	//팀 생성
	@RequestMapping("insertTeam.tm")
	public String insertTeam(Team t, TeamImg ti, MultipartFile upfile, HttpSession session, Model model) {

		Member m = (Member)session.getAttribute("loginUser");

		int result = teamService.insertTeam(t);
		int result2 = teamService.insertTeamMember(m);
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
	public String InsertOffer(TeamOffer t, int userNo, int teamNo, TeamImg ti, MultipartFile upfile, HttpSession session, Model model) {
		
		// userPo이 안에 팀 번호 있음
//		TeamMember userPo = teamService.selectInformation(userNo);
		
		// tno에 팀 번호 담음 
//		int tno = userPo.getTeamNo();
		int resultImg = 0;
		
		// 게시글 등록 
		int result = teamService.insertOfferList(t, teamNo);
		
		if(!upfile.getOriginalFilename().equals("")) {
			
			String changeName = saveFile(upfile, session, "resources/img/team/teamOfferListDetailView/");
			
			ti.setTeamImgUrl("resources/img/team/teamOfferListDetailView/");
			ti.setTeamOriginName(upfile.getOriginalFilename());
			ti.setTeamChangeName("resources/img/team/teamOfferListDetailView/" + changeName);
			
			resultImg = teamService.insertOfferImg(ti, teamNo);
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
	
	

	@RequestMapping("deleteTeam.tm")
	public String deleteTeam(int tNo){
		int result1 = teamService.deleteTeamMemberAll(tNo);
		int result3 = teamService.deleteTeamImg(tNo);
		
		ArrayList<TeamOffer> list = teamService.teamOfferListNo(tNo);
		
		for(int i = 0; i < list.size(); i++) {
			TeamOffer teamOffer = list.get(i); 
		    int offerNo = teamOffer.getOfferNo(); 
		    
		    int result4 = teamService.deleteTeamReqAll(offerNo);
		}

		int result = teamService.deleteOfferAll(tNo); // 게시글 삭제    
		
		if(result1 * result3 > 0) {
			int result2  =teamService.deleteTeam(tNo);
		}
		return "main";
	}
	
	
	@ResponseBody
	@RequestMapping(value="changeTeamGrade.tm")
	public String changeTeamGrade(TeamMember tm){
//		System.out.print(tm);
		if(tm.getGrade() == 1) {
			return  teamService.changeTeamGradeUp(tm) > 0 ? "changeTeamGradeOk" :  "changeTeamGradeFail";
		}else {
			return  teamService.changeTeamGradeDown(tm) > 0 ? "changeTeamGradeOk" :  "changeTeamGradeFail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="deleteTeamMember.tm")
	public String deleteTeamMember(TeamMember tm){
		return  teamService.deleteTeamMember(tm) > 0 ? "deleteTeamMemberGradeOk" : "deleteTeamMemberGradeFail";
		
	}
	
	//팀 프로필 뷰 셀렉트
	@RequestMapping("teamOutside.tm")
	public ModelAndView teamOutside(TeamMember tm, ModelAndView mv,HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		Member m = (Member) session.getAttribute("loginUser");
		tm.setUserNo(m.getUserNo());
		int result = teamService.deleteTeamMember(tm);
		
		if(result> 0) {
			mv.setViewName("main");
			
		}else {
			mv.addObject("errorMsg", "로그인 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;	
	}

	
	@ResponseBody 
	@RequestMapping(value= "/selectMyteam.tm",produces="application/json; charset=UTF-8" )
	public String selectMyteam(HttpSession session) {
			Member m =  (Member) session.getAttribute("loginUser");
			return new Gson().toJson(teamService.selectMyteam(m.getUserNo()));
	}

	@RequestMapping("teamReqSolo.tm")
	public String teamReqSolo(int teamNo, int userNo, String reqContent, Model model, HttpSession session) {
		
		int offerNo = 0;
		
		ArrayList<TeamOffer> list = teamService.teamOfferListNo(teamNo);
		
		for(int i = 0; i < list.size(); i++) {
			TeamOffer teamOffer = list.get(0); 
		    offerNo = teamOffer.getOfferNo(); 
		}
		
		int teamR = teamService.teamReqSolo(userNo, reqContent, offerNo);
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		int reqList = teamService.selectReqListCheck(loginUser.getUserNo(), teamNo);  //오퍼없이 신청자들 
		
		
		if(teamR > 0) {
			session.setAttribute("alertMsg", "팀 신청 성공");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "신청 실패");
			return "common/errorMsg";
		}
		
	}
	
	
}

