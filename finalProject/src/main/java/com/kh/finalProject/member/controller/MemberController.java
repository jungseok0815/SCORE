package com.kh.finalProject.member.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
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
			 // 파일에 있던거 지웠던거 처럼 DB에서도 지워 줘야 함 
			if(memberService.selectMemberImg(m.getUserNo()) == null) {
				resultMemImg = memberService.insertMemImg(mi);
			}else {
				resultMemImg = memberService.updateMemImg(mi);
			}
		}	
		
//		MemberImg existingImg = memberService.selectMemberImg(m.getUserNo());
//		
//		String changeName = saveFile(reupfile, session, "/resources/img/member/memberInsert/");
//		mi.setMemberUrl("/resources/img/member/memberInsert/");
//		mi.setMemberOriginName(reupfile.getOriginalFilename());
//		mi.setMemberChangeName("/resources/img/member/memberInsert/" + changeName);
//		// 파일에 있던거 지웠던거 처럼 DB에서도 지워 줘야 함 
//		
//		if (existingImg != null) {
//	        String existingFilePath = session.getServletContext().getRealPath(existingImg.getMemberChangeName());
//	        boolean deleteResult = new File(existingFilePath).delete();
//	        if (deleteResult) {
//	            System.out.println("기존 파일 삭제 성공");
//	        } else {
//	            System.out.println("기존 파일 삭제 실패");
//	        }
//	    }
//		
//		if(existingImg == null) {
//			resultMemImg = memberService.insertMemImg(mi);
//		}else {
//			resultMemImg = memberService.updateMemImg(mi);
//		}
		
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
	//회원가
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
		
		System.out.println("스타일" + info);
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
		
		ArrayList<Member> friendList = memberService.getPostFriends(m.getUserNo());
		for(Member i : friendList) {
			System.out.println(i);
			if(i.getMemberChangeName() == null) {
				i.setMemberChangeName("null");
			}
		}
		
		return new Gson().toJson(friendList);
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
	
	//친구요청 
	@ResponseBody
	@RequestMapping("/sendPostFriend.me")
	public String sendPostFriend(Friend f,HttpSession session) {
		Member m =  (Member) session.getAttribute("loginUser");
		f.setFriendResUser(m.getUserNo());
		int result = memberService.checkFriendStatus(f); // 이미 친구요청 상태를 검
		int result3 =  memberService.checkFriendStatus2(f); // 이미 친구인 상태를 검사 
		if(result > 0) {
			return "PostFriendFail";
		}
		if(result3> 0) {
			return "PostFriendFail12";
		 }
		
		f.setFriendResUser(f.getFriendReqUser());
		f.setFriendReqUser(m.getUserNo());
		int result2 = memberService.checkFriendStatus(f);
		int result4 =  memberService.checkFriendStatus2(f);
		if(result2> 0) {
			return "PostFriendFail1";
		 }
		if(result4> 0) {
			return "PostFriendFail12";
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
	

	
	@ResponseBody
	@RequestMapping(value="payPoint.me", produces="application/json; charset=UTF-8")
	public String kakaoPay(int point, HttpSession session) {
		
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready"); 	// 주소 
			HttpURLConnection join =  (HttpURLConnection) address.openConnection(); // 서버 연결
			join.setRequestMethod("POST"); 
			join.setRequestProperty("Authorization", "KakaoAK 5ec0b38b846924ddb31e67e0cc96795c"); 
			join.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			join.setDoOutput(true);
			String parameter = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=Score&quantity=1&total_amount=" + point + "&tax_free_amount=0&approval_url=http://localhost:8030/final/kakaoPoint.me&cancel_url=http://localhost:8030/final/kakaoPoint.me&fail_url=http://localhost:8030/final/pointView.me";
			// parameter = 파라미터 
			OutputStream sendPay = join.getOutputStream(); // 데이터를 줄수 있게 만듬
			DataOutputStream sendData = new DataOutputStream(sendPay); // 데이터를 주는 애 
			sendData.writeBytes(parameter); // 문자열을 형변환 시켜줌
			sendData.close(); // 자기가 가지고있는 바이트를 서버로 전송함 
			
			int result = join.getResponseCode(); // 결과 
			
			InputStream getResult; // 받는 애
			if(result == 200) { // 200이면 성공 나머지는 다 실패
				getResult = join.getInputStream();
			} else {
				getResult = join.getErrorStream();
			}
			InputStreamReader captain = new InputStreamReader(getResult); // 받은 거에서 읽어주는 역할
			BufferedReader charginWrite = new BufferedReader(captain); // 읽어주는거 받아서 형변환 시켜주기
			
//			session.setAttribute("loginUser", point);
			Member loginUser = (Member)session.getAttribute("loginUser");
			loginUser.setPoint(point);
			
			session.setAttribute("loginUser", loginUser);
			
			return charginWrite.readLine();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "";
	}
	
	
	
	@RequestMapping(value= "kakaoPoint.me")
	public ModelAndView successPay(String pg_token, ModelAndView mv, HttpSession session) {
		System.out.println(pg_token);
		
		if(pg_token != null) { // 토큰이 있을 때
			Member m = (Member)session.getAttribute("loginUser");
			
			System.out.println(m.getPoint());
			System.out.println(m.getUserNo());

			int result = memberService.updatePay(m.getPoint(), m.getUserNo());
			Member m2 = memberService.loginMember(m.getUserId());
		    if(result > 0) {
		    	session.setAttribute("loginUser", m2);
		        session.setAttribute("alertMsg", "결제가 완료되었습니다.");

		        mv.setViewName("redirect:/");
		    }
		} else { // 토큰이 없을 때 
	        session.setAttribute("alertMsg", "결제가 취소되었습니다.");
	        mv.setViewName("member/chargingPoint");
	        
			return mv;
		}
	
		return mv;
	}
	
	
	
}


