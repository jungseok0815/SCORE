package com.kh.finalProject.place.controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
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
import com.kh.finalProject.place.model.service.PlaceServiceImpl;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;
import com.kh.finalProject.place.model.vo.Reply;
import com.kh.finalProject.place.model.vo.ReplyReply;
import com.kh.finalProject.place.model.vo.PlaceReview;
import com.kh.finalProject.place.model.vo.Reservation;
import com.kh.finalProject.place.model.vo.ReviewImg;

@Controller
public class PlaceController {
	
	@Autowired
	private PlaceServiceImpl pService;
	
	//placeInsert로 보내주는 메소드
	@RequestMapping("/insertForm.pl")
	public String insertPlaceForm() {
		return "place/placeInsert";
	}

	@RequestMapping("/insert.pl")
	public String insertPlace(Place p, ArrayList<MultipartFile> upfile, HttpSession session, Model m) {
		
		int resultPlace = pService.insertPlace(p);
		int resultImg = 1;
		
		for(MultipartFile mf : upfile) {
			//전달된 파일이 있을 경우 => 파일명 수정 후 서버 업로드 => 원본명, 서버업로드된 경로로 DB에 담기(파일이 있을때만)
			if(!mf.getOriginalFilename().equals("")) {
				PlaceImg pi = new PlaceImg();
				String changeName = saveFile(mf, session);
				
				pi.setFieldUrl("resources/img/place/");
				pi.setFieldOriginName(mf.getOriginalFilename());
				pi.setFieldChangeName("resources/img/place/placeInsert/" + changeName);
				
				resultImg = resultImg * pService.insertPlaceImg(pi);
			}
		}
		
		if(resultPlace * resultImg > 0) {
			session.setAttribute("alertMsg", "경기장 등록이 완료되었습니다.");
		} else {
			session.setAttribute("alertMsg", "경기장 등록에 실패하였습니다.");
		}
		return "redirect:/";
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
	
	@RequestMapping("/detail.pl")
	public String placeDetailview(int fno, Model m) {
		//금액 3자리 마다 ,찍어주는 클래스
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		Place pl = pService.placeDetailview(fno);
		// 날짜 형식 변경 2023-12-07  =>  12월 7일 
		String monthDate = pl.getFieldDate().substring(5,7) + "월 ";
		String dayDate = (Integer.parseInt(pl.getFieldDate().substring(8,10))) + "일";
		pl.setFieldDate(monthDate+dayDate);
		
		m.addAttribute("pl", pl);
		m.addAttribute("matchPay", formatter.format(pl.getMatchPay()));
		m.addAttribute("resCount", pService.placeResCount(fno));
		m.addAttribute("plImgList", pService.placeImgList(fno));
		return "place/placeDetailView";
	}
	

	
	@ResponseBody
	@RequestMapping(value="/loadList.pl",produces="application/json; charset=UTF-8")
	public String placeListCount(@RequestParam(value="cpage", defaultValue="1") int currentPage,
			@RequestParam(value="categoryNum", defaultValue="1") int categoryNum,
			@RequestParam(value="area", defaultValue="서울") String area,
			@RequestParam(value="gender", defaultValue="3") int gender,
			@RequestParam(value="level", defaultValue="모든레벨") String level,
			@RequestParam(value="date", defaultValue="") String date,
			ModelAndView mv) {
		Place pl = new Place();
		pl.setCategoryNum(categoryNum);
		pl.setFieldArea(area);
		pl.setMatchGender(gender);
		pl.setMatchLevel(level);
		pl.setFieldDate(date);
		
		PageInfo pi = Pagenation.getPageInfo(pService.placeListCount(pl), currentPage, 5, 5);
		ArrayList<Place> list = pService.selectPlaceList(pi, pl);
		ArrayList<Place> resList = pService.selectResPlaceList();
		mv.addObject("pi",pi)
		  .addObject("list", list)
		  .addObject("resList", resList);
		return new Gson().toJson(mv);
	}
	@RequestMapping(value="insertSoloResMatch.pl")
	public String insertSoloResMatch(@RequestParam("fieldNo") int fieldNo, 
									 @RequestParam("matchPay") int matchPay, 
									 HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		if(loginUser.getPoint()-matchPay<0) {
			session.setAttribute("alertMsg", "포인트가 부족하여  충전페이지로 이동합니다.");
			return "member/chargingPoint";
		}
		Reservation res = new Reservation();
		res.setFieldNo(fieldNo);
		res.setResUserNo(loginUser.getUserNo());
		if(pService.checkResMatch(res) > 0) {
			session.setAttribute("alertMsg", "이미 예약된 경기입니다.");
			return "main";
		}
		int result = pService.insertResMatch(res);
		if(result>0) {
			loginUser.setPoint(loginUser.getPoint()-matchPay);
			int resultPay = pService.payPoint(loginUser);
			if(resultPay>0) {
				session.setAttribute("alertMsg", "성공적으로 예약되었습니다.");
			}else {
				session.setAttribute("errorMsg", "예약 실패!");
			}
		}else {
			session.setAttribute("errorMsg", "예약 실패!");
		}
		return "main";
	}
	
	@RequestMapping(value="insertResMatch.pl")
	public String insertResMatch(@RequestParam("teamMember") ArrayList<Integer> teamMember,
								 @RequestParam("matchPay") int matchPay,
								 @RequestParam("fieldNo") int fieldNo,
									HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		if(loginUser.getPoint()-(teamMember.size()*matchPay)<0) {
			session.setAttribute("alertMsg", "포인트가 부족하여  충전페이지로 이동합니다.");
			return "member/chargingPoint";
		}
		
		for(int i = 0; i < teamMember.size(); i++) {
			Reservation res = new Reservation();
			res.setFieldNo(fieldNo);
			res.setResUserNo(teamMember.get(i));
			
			if(pService.checkResMatch(res) > 0) {
				session.setAttribute("alertMsg", "이미 예약한 인원이 존재합니다.");
				return "main";
			}
		}
		for(int i = 0; i < teamMember.size(); i++) {
			Reservation res = new Reservation();
			res.setFieldNo(fieldNo);
			res.setResUserNo(teamMember.get(i));
			int result = pService.insertResMatch(res);
		}
		loginUser.setPoint(loginUser.getPoint()-(teamMember.size()*matchPay));
		int resultPay = pService.payPoint(loginUser);
		if(resultPay>0) {
			session.setAttribute("alertMsg", "성공적으로 예약되었습니다.");
		}
		return "main";
	}
	@ResponseBody
	@RequestMapping(value="/selectResList.pl",produces="application/json; charset=UTF-8")
	public String selectResList(String userNo, ModelAndView mv) {
		ArrayList<Reservation> arrayRes = pService.selectResList(userNo);
		mv.addObject("arrayRes",arrayRes);
		return new Gson().toJson(mv);
	}
	@RequestMapping("/deleteRes.pl")
	public String deleteReservation(int resNo, int fieldNo, HttpSession session) {
		int result = pService.deleteReservation(resNo);
		if(result>0) {
			session.setAttribute("alertMsg", "성공적으로 예약취소 되었습니다.");
			return "redirect:/";
		}else{
			session.setAttribute("alertMsg", "예약취소에 실패하였습니다.");
			return "redirect:/";
		}
	}
	
	//리뷰 작성할 때 로그인유저가 예약했었던 경기장만 리뷰 쓸 수 있게 하려고
	@ResponseBody
	@RequestMapping(value="/placeReviewList.pl", produces="application/json; charset=UTF-8")
	public ModelAndView placeReviewListView(ModelAndView mv, String userNo, @RequestParam(value="cpage", defaultValue = "1") int currentPage) {
		
		if(!userNo.equals("")) {
			ArrayList<Reservation> rList = pService.selectResList(userNo);
			mv.addObject("rList", rList);
		}
		mv.setViewName("place/placeReviewList");
		
		return mv;
	}
	
	//경기장 리뷰 상세페이지 
	@RequestMapping("/placeReviewDetail.pl")
	public String placeReviewDetail(int fno, Model m, int rno) {
		System.out.println(fno);
		System.out.println(rno);
		PlaceReview pr = pService.selectReplyField(fno);
		ArrayList<ReviewImg> ri = pService.placeReviewImgList(rno);
		System.out.println(pr);
		System.out.println(rno);
		m.addAttribute("pr", pr);
		m.addAttribute("reImgList", ri);
		return "place/placeReviewDetail";
	}
	
	//댓글 리스트
	@ResponseBody
	@RequestMapping(value= "/rlist.pl", produces = "appalication/json; charset = UTF-8")
	public String placeReplyList(Model m, @RequestParam("fno") int fno) {
		ArrayList<Reply> rlist = pService.selectReplyList(fno);
		m.addAttribute("rlist", rlist);
		return new Gson().toJson(rlist);
	}
	//답글 등록
	@ResponseBody
	@RequestMapping(value= "/addReplyReply.pl")
	public HashMap addReplyReply(ReplyReply p, HttpSession session) {
		p.setUserNo(((Member)session.getAttribute("loginUser")).getUserNo());
		
		System.out.println(p);
		int result  = pService.addReplyReply(p);
		HashMap m1 = new HashMap();
		if(result> 0) {
			ArrayList<ReplyReply> rlist = pService.selectReplyReply(p.getReplyNo());
			m1.put("list", rlist);
			m1.put("loginUser",((Member)session.getAttribute("loginUser")).getUserNo());
			return m1;
		}
		m1.put("list", "fail");
		return  m1;
	}
	
	//답글 리스트
	@ResponseBody
	@RequestMapping(value= "/selectReplyReply.pl")
	public HashMap selectReplyReply(int replyNo, HttpSession session) {
		System.out.println(replyNo+"@222222222222222");
		ArrayList<ReplyReply> rlist = pService.selectReplyReply(replyNo);
		
		for(ReplyReply a : rlist) {
			System.out.println(a);
		}
		
		HashMap m1 = new HashMap();
		m1.put("list", rlist);
		m1.put("loginUser",((Member)session.getAttribute("loginUser")).getUserNo());
		
		return m1;
	}


	//경기장 리뷰 insert
	@RequestMapping("/insertReview.pl")
	public String insertPlaceReview(int fieldNo, String userNo, PlaceReview pr, ReviewImg ri, MultipartFile upfile, HttpSession session, Model model) {
		Member m =  (Member) session.getAttribute("loginUser");
		Place p = pService.placeDetailview(fieldNo);
		pr.setCategoryNum(Integer.toString(p.getCategoryNum()));
		pr.setFieldNo(fieldNo);
		pr.setUserNo(userNo);
		
		int resultReview = pService.insertPlaceReview(pr);
		
		int resultImg = 0;
		
		if(!upfile.getOriginalFilename().equals("")) {
			
			String changeName = saveFile(upfile, session);
			ri.setReviewUrl("resources/img/place//placeReviewList/");
			ri.setReviewOriginName(upfile.getOriginalFilename());
			ri.setReviewChangeName("resources/img/place/placeReviewList/" + changeName);
			
			resultImg = pService.insertPlaceReviewImg(ri);
			 
		}
		
		if(resultReview * resultImg > 0) {
			session.setAttribute("alertMsg", "리뷰 작성 완료");
			return "redirect:placeReviewList.pl?userNo=" + m.getUserNo() + "&currentPage=1";
		}else {
			session.setAttribute("alertMsg", "리뷰 작성 실패");
			return "common/errorPage";
		}
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/ReviewListAjax.pl", produces="application/json; charset=UTF-8")
	public String placeReviewListView(Model m, @RequestParam(value="cpage", defaultValue="1") int currentPage,
			@RequestParam(value="categoryNum", defaultValue="4") String categoryNum) {
		
		int cno = Integer.parseInt(categoryNum);
		PageInfo pi = Pagenation.getPageInfo(pService.selectReviewListCount(), currentPage, 5, 10);
		
		
		if(cno == 4) {
			ArrayList<PlaceReview> pList =  pService.placeReviewList(pi);
			
			m.addAttribute("pi",pi);
			m.addAttribute("pList",pList);
		}else {
			ArrayList<PlaceReview> pList =  pService.placeChoiceReviewList(pi, categoryNum);
			m.addAttribute("pi",pi);
			m.addAttribute("pList",pList);
		}
		
		return new Gson().toJson(m);
	}
	
	@ResponseBody
	@RequestMapping(value="/search.pl", produces="application/json; charset=UTF-8")
	public HashMap selectSearchList(ModelAndView mv,
										 @RequestParam("condition") String condition,
										 @RequestParam("keyword") String keyword,
										 @RequestParam(value="cpage", defaultValue="1") int currentPage,
										 HttpSession session) {
		System.out.println(keyword);
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		String userNo = Integer.toString(((Member)session.getAttribute("loginUser")).getUserNo());
		PageInfo pi = Pagenation.getPageInfo(pService.selectSearchCount(map), currentPage, 5, 10);
		System.out.println(pi);
		ArrayList<PlaceReview> pList =  pService.selectSearchList(map, pi);
		System.out.println(pList);
		HashMap result = new HashMap();
		result.put("pList", pList);
		result.put("pi", pi);
		
		if(userNo != null && !userNo.equals("")) {
			ArrayList<Reservation> rList = pService.selectResList(userNo);	
			result.put("rList", rList);
		}
		
		return result ;
	}
		
	
}
