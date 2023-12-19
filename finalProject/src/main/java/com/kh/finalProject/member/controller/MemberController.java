package com.kh.finalProject.member.controller;

import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.vo.Friend;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.MemberImg;
import com.kh.finalProject.member.model.vo.MessageAuth;
import com.kh.finalProject.member.model.vo.SportInfo;
import com.kh.finalProject.team.model.vo.TeamMember;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder; 

	
	@RequestMapping("/loginView.me")
	public String loginView() {
		return "member/memberLogin";
		
	}
	

	@RequestMapping("/joinView.me")
	public String joinView() {
		return "member/memberJoin";
		
	}
	
	@RequestMapping("/pointView.me")
	public String pointView() {
		return "member/chargingPoint";
		
	}
	
	@RequestMapping("/updatePoint.me")
	public ModelAndView updatePoint(HttpSession session, ModelAndView mv, @RequestParam(name = "point", defaultValue = "0") int point) {
		Member m = (Member)session.getAttribute("loginUser");
		m.setPoint(point);
	    int result = memberService.updateUserPoint(m);
	    
	    Member loginUser = memberService.loginMember(m.getUserId());
	    if(result > 0) {
	        // DB로부터 수정된 회원정보를 다시 조회해서
	        // session 영역에 loginUser라는 키값으로 덮어씌워야 함
	    	session.setAttribute("loginUser", loginUser);
	        session.setAttribute("alertMsg", "충전이 완료되었습니다.");

	        mv.setViewName("redirect:/");
	        
	    }

	    return mv;
	}
	
	@RequestMapping("/myPage.me")
	public ModelAndView myPage(HttpSession session,ModelAndView mv,String userNo) {
		int userNum = Integer.parseInt(userNo);
		SportInfo sport = new SportInfo();
		sport.setCategoryNum(1);
		sport.setUserNo(userNum);
		Member m = memberService.userInfo(userNum);
		SportInfo sportInfo = memberService.getUserSportInfo(sport);
		int countfriends = memberService.getCountUserfriends(userNum);
		mv.addObject("sportInfo", sportInfo).addObject("countfriends",countfriends).addObject("userInfo",m).setViewName("member/mypage");
		return mv;
	}
	
	
	@RequestMapping("/myPageUpdate.me")
	public ModelAndView myPageUpdate(HttpSession session,ModelAndView mv){
		Member m = (Member) session.getAttribute("loginUser");
		MemberImg mi = memberService.selectMemberImg(m.getUserNo());
		SportInfo sport = new SportInfo();
		sport.setUserNo(m.getUserNo());
		sport.setCategoryNum(1);
		SportInfo sportInfo = memberService.getUserSportInfo(sport);
		mv.addObject("sportInfo", sportInfo).addObject("memberImg", mi).setViewName("member/mypageUpdate");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/myPageCheckCategory.me",produces="application/json; charset=UTF-8")
	public String myPageCheckCategory(HttpSession session,SportInfo sport) {
		Member m = (Member) session.getAttribute("loginUser");
		//System.out.println(sport.getCategoryNum());
		sport.setUserNo(m.getUserNo());
		SportInfo info = memberService.getUserSportInfo(sport);
		if(info.getSkill() == null) {
			info.setSkill("null");
		}
		if(info.getStyle() == null) {
			info.setStyle("null");
		}
		return new Gson().toJson(info);
	
	}
	
	//마이페이지 수정
	@ResponseBody
	@RequestMapping(value= "/reMyPageUpdate.me",produces="application/json; charset=UTF-8")
	public ModelAndView updateMyPageMember(Member m, HttpSession session,ModelAndView mv, MultipartFile reupfile,  String[] skill, String[] style, SportInfo sport, MemberImg mi) {
		Member login =  (Member) session.getAttribute("loginUser");
		sport.setUserNo(m.getUserNo());
		int resultMemImg =0;

		if(!reupfile.getOriginalFilename().equals("")) {
			String changeName = saveFile(reupfile, session, "/resources/img/member/memberInsert/");
			mi.setMemberUrl("/resources/img/member/memberInsert/");
			mi.setMemberOriginName(reupfile.getOriginalFilename());
			mi.setMemberChangeName("/resources/img/member/memberInsert/" + changeName);
			if(memberService.selectMemberImg(m.getUserNo()) == null) {
				resultMemImg = memberService.insertMemImg(mi);
			}else {
				resultMemImg = memberService.updateMemImg(mi);
			}
		}	
		int result = memberService.updateMyPageMember(m);
		int result2 = memberService.updateMyPageSport(sport);
		System.out.println(result + "," +result2 + "," + resultMemImg);
		
	    if(result * result2  > 0) {
	    	Member loginInfo = memberService.loginMember(login.getUserId());
		    SportInfo sportInfo = memberService.getUserSportInfo(sport);
		    session.setAttribute("loginUser", loginInfo);
		    session.setAttribute("alertMsg", "수정 성공");
		    mv.addObject("sportInfo", sportInfo)
		    .addObject("userInfo", loginInfo)
		    .addObject("memberImg", mi)
		    .setViewName("redirect:myPage.me?userNo=" + login.getUserNo());
	    } else {
	    	mv.addObject("errorMsg", "수정  실패");
	    }
		return mv;
	}
	
	 public String saveFile(MultipartFile upfile, HttpSession session, String path) {
	      String originName = upfile.getOriginalFilename();
	      
	      String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	      
	      int ranNum = (int)(Math.random() * 90000) + 10000;
	      
	      String ext = originName.substring(originName.lastIndexOf("."));
	      
	      String changeName = currentTime + ranNum + ext;
	      
	      String savePath = session.getServletContext().getRealPath(path);
	      
	      try {
	         upfile.transferTo(new File(savePath + changeName));
	      } catch (IllegalStateException | IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return changeName;
	   }
	
	@ResponseBody
	@RequestMapping(value= "/join.me",produces="application/json; charset=UTF-8" )
	public String joinMember(Member m,ModelAndView mv, HttpSession session) {
		String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
		m.setUserPwd(encPwd); // Member객체에 userPwd필드에 평문이 아닌 암호문으로 변경
		int result =memberService.joinMember(m);
		if(result > 0) {
			return new Gson().toJson(memberService.selectJoinmember(m.getUserId()));
		}
		return "joinfail";
	}
	
	
	@ResponseBody
	@RequestMapping("/insertSportInfo.me")
	public String insertSportInfo(SportInfo info,ModelAndView mv, HttpSession session) {
		int result = memberService.insertSportInfo(info);
		return "tt";
	}
	
	
	@ResponseBody
	@RequestMapping("/idCheck.me")
	public String checkId(String checkId) {
		int result = memberService.checkId(checkId);
		return result > 0 ? "failCheckId" : "passCheckId"; 
	}
	
	@RequestMapping("/login.me") 
	public ModelAndView loginMember(Member m, ModelAndView mv, HttpSession session) {	
		
		Member loginUser = memberService.loginMember(m.getUserId()); //아이디로만 멤버객체 가져오기
		
		if(loginUser == null || !bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())) { // 로그인실패 => 에러문구를 requestScope에 담고 에러페이지로 포워딩
			mv.addObject("errorMsg", "로그인 실패");
			mv.setViewName("common/errorPage");
		} else {
			session.setAttribute("loginUser", loginUser);	
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping("/logOut.me") 
	public String logOut(HttpSession session) {	
		
		session.removeAttribute("loginUser");
	
		return "redirect:/";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value= "/getPostFriend.me",produces="application/json; charset=UTF-8" )
	public String getUserInfo(HttpServletRequest req) {
		Member m = (Member)req.getSession().getAttribute("loginUser");
		return new Gson().toJson(memberService.getPostFriends(m.getUserNo()));
	}
	
	@ResponseBody
	@RequestMapping("/addFriend.me")
	public String addFriend(Friend f,HttpSession session) {
		Member m =  (Member) session.getAttribute("loginUser");
		f.setFriendResUser(m.getUserNo());
		int result = memberService.addFriend(f);  
		if(result > 0) {
			return memberService.addFriend2(f) > 0 ? "addFriendOk" : "addFriendFail" ; 
		}
		return "addFriendFail";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value= "/selectFriendList.me",produces="application/json; charset=UTF-8" )
	public String selectFriendList(HttpSession session) {
		Member m =  (Member) session.getAttribute("loginUser");
		ArrayList<Member> friendList = memberService.selectFriendList(m.getUserNo());
	
		for(Member i : friendList) {
			System.out.println(i);
			if(i.getMemberChangeName() == null) {
				i.setMemberChangeName("null");
			}
		}
		return new Gson().toJson(friendList);
	}
	
	
	@ResponseBody
	@RequestMapping("/deleteFriend.me")
	public String deleteFriend(Friend f,HttpSession session) {
		Member m =  (Member) session.getAttribute("loginUser");
		f.setFriendResUser(m.getUserNo());	
		int result = memberService.deleteFriend(f);
		if(result > 0) {
			return memberService.deleteFriend2(f) > 0 ? "deleteFriendOk" : "deleteFriendFail" ; 
		}
		
		return  "deleteFriendFail";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value= "/selectMyTeam.me",produces="application/json; charset=UTF-8" )
	public String selectMyTeam(HttpSession session, int categoryNum) {
		Member m =  (Member) session.getAttribute("loginUser");
		HashMap teamMap = new HashMap();
		teamMap.put("userNo", m.getUserNo());
		teamMap.put("categoryNum",categoryNum);	
		return new Gson().toJson(memberService.selectMyTeam(teamMap));
	}
	
	@ResponseBody
	@RequestMapping(value= "/selectUserSportInfo.me",produces="application/json; charset=UTF-8" )
	public String selectUserSportInfo(HttpSession session, SportInfo info) {
		Member m =  (Member) session.getAttribute("loginUser");
		info.setUserNo(m.getUserNo());
		return new Gson().toJson(memberService.getUserSportInfo(info));
	}
	
	
	@ResponseBody
	@RequestMapping("/sendPostFriend.me")
	public String sendPostFriend(Friend f,HttpSession session) {
		Member m =  (Member) session.getAttribute("loginUser");

		f.setFriendResUser(m.getUserNo());
		int result = memberService.checkFriendStatus(f);
		if(result > 0) {
			return "PostFriendFail";
		}
		f.setFriendResUser(f.getFriendReqUser());
		f.setFriendReqUser(m.getUserNo());
		int result2 = memberService.checkFriendStatus(f);
		if(result2> 0) {
			return "PostFriendFail";
		 }
		return   memberService.sendPostFriend(f) > 0 ? "PostFriendOk" : "PostFriendFail";
	}
	
	@ResponseBody
	@RequestMapping(value= "/selectReqResList.me",produces="application/json; charset=UTF-8" )
	public String selectReqResList(HttpSession session) {
		Member m =  (Member) session.getAttribute("loginUser");
		return new Gson().toJson(memberService.selectReqResFriendList(m.getUserNo()));
	}
	

	@ResponseBody
	@RequestMapping(value= "/checkPhoneAuth.me")
	public String checkPhoneAuth(HttpSession session,MessageAuth auth) {
	
	
		int reusult = memberService.checkPhoneAuth(auth);
		System.out.println();
		System.out.println(reusult);
		if(reusult > 0) {
			return "authOk";
		}
	
		return "authFail";
	}
	

}


