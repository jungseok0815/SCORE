package com.kh.finalProject.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.SportInfo;

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
	public ModelAndView updateMember(HttpSession session, ModelAndView mv, @RequestParam(name = "point", defaultValue = "0") int point) {
		Member m = (Member)session.getAttribute("loginUser");
		m.setPoint(point);
	    int result = memberService.updateUserPoint(m);
	    
	    Member loginUser = memberService.loginMember(m.getUserId());
	    if(result > 0) {
	        // DB로부터 수정된 회원정보를 다시 조회해서
	        // session 영역에 loginUser라는 키값으로 덮어씌워야합니다.
	        session.setAttribute("loginUser", loginUser);
	        session.setAttribute("alertMsg", "충전이 완료되었습니다.");

	        mv.setViewName("redirect:/");
	        
	    } else {
	    	mv.addObject("errorMsg", "충전 실패");
	    	mv.setViewName("common/errorPage");
	    }

	    return mv;
	}
	
	@RequestMapping("/myPage.me")
	public ModelAndView myPage(HttpServletRequest req,ModelAndView mv) {
		Member m = (Member)req.getSession().getAttribute("loginUser");
		System.out.println(m.getUserNo());
		SportInfo sport = new SportInfo();
		sport.setCategoryNum(1);
		sport.setUserNo(m.getUserNo());
		SportInfo sportInfo = memberService.getUserSportInfo(sport);
		int countfriends = memberService.getCountUserfriends(m.getUserNo());
		System.out.println(sportInfo);
		System.out.println(countfriends);
		mv.addObject("sportInfo", sportInfo).addObject("countfriends",countfriends).setViewName("member/mypage");
		return mv;
	}
	
	@RequestMapping("/myPageUpdate.me")
	public String myPageUpdate() {
		return "member/mypageUpdate";
		
	}
	
	@ResponseBody
	@RequestMapping(value= "/join.me",produces="application/json; charset=UTF-8" )
	public String joinMember(Member m,ModelAndView mv, HttpSession session) {
		String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
		m.setUserPwd(encPwd); // Member객체에 userPwd필드에 평문이 아닌 암호문으로 변경
		System.out.println(m.getUserId());
		int result =memberService.joinMember(m);
		if(result > 0) {
			return new Gson().toJson(memberService.selectJoinmember(m.getUserId()));
		}
		return "joinfail";
	}
	
	
	@ResponseBody
	@RequestMapping("/insertSportInfo.me")
	public String insertSportInfo(SportInfo info,ModelAndView mv, HttpSession session) {
		System.out.println(info);
		int result = memberService.insertSportInfo(info);
		return "tt";
	}
	
	
	@ResponseBody
	@RequestMapping("/idCheck.me")
	public String checkId(String checkId) {
		System.out.println(checkId);
		int result = memberService.checkId(checkId);
		
		
		return result > 0 ? "failCheckId" : "passCheckId"; 
	}
	
	@RequestMapping("/login.me") 
	public ModelAndView loginMember(Member m, ModelAndView mv, HttpSession session) {
		System.out.println(m);
		
		Member loginUser = memberService.loginMember(m.getUserId()); //아이디로만 멤버객체 가져오기
		System.out.println(loginUser);
		
		if(loginUser == null || !bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())) { // 로그인실패 => 에러문구를 requestScope에 담고 에러페이지로 포워딩
			mv.addObject("errorMsg", "로그인 실패");
			mv.setViewName("common/errorPage");
		} else {
			session.setAttribute("loginUser", loginUser);	
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	
//	@ResponseBody
//	@RequestMapping(value= "/getUserInfo.me",produces="application/json; charset=UTF-8" )
//	public String getUserInfo(Member m) {
//		System.out.println(m.getUserNo());
//		SportInfo sportInfo = memberService.getUserSportInfo(m.getUserNo());
//		SportInfo friendsInfo = memberService.getUserfriendsInfo(m.getUserNo());
//		
//		
//		
//		return result > 0 ? "failCheckId" : "passCheckId"; 
//	}

}
