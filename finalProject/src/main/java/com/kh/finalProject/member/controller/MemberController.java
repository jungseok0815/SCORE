package com.kh.finalProject.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
//	@Autowired
//	private MemberService memberService;
//	@Autowired
//	private BCryptPasswordEncoder bcryptPasswordEncoder;
//	
	
	
	@RequestMapping("/loginView.me")
	public String loginView() {
		return "member/memberLogin";
		
	}
	
	
//	@RequestMapping("/login.me") 
//	public ModelAndView loginMember(Member m, ModelAndView mv, HttpSession session) {
//		Member loginUser = memberService.loginMember(m); //아이디로만 멤버객체 가져오기
//		if(loginUser == null || !bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())) { // 로그인실패 => 에러문구를 requestScope에 담고 에러페이지로 포워딩
//			mv.addObject("errorMsg", "로그인 실패");
//			mv.setViewName("common/errorPage");
//		} else {
//			session.setAttribute("loginUser", loginUser);	
//			mv.setViewName("redirect:/");
//		}
//		return mv;
//	}

}
