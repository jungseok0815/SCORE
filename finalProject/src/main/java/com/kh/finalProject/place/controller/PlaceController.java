package com.kh.finalProject.place.controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
import com.kh.finalProject.place.model.service.PlaceService;
import com.kh.finalProject.place.model.service.PlaceServiceImpl;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;

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
	public String insertPlace(Place p, PlaceImg pi, MultipartFile upfile, HttpSession session, Model m) {
		
		int resultPlace = pService.insertPlace(p);
		int resultImg = 0;
		
		
		//전달된 파일이 있을 경우 => 파일명 수정 후 서버 업로드 => 원본명, 서버업로드된 경로로 DB에 담기(파일이 있을때만)
		if(!upfile.getOriginalFilename().equals("")) {
			
		   String changeName = saveFile(upfile, session);
		   
		   pi.setFieldUrl("resources/img/place/");
		   pi.setFieldOriginName(upfile.getOriginalFilename());
		   pi.setFieldChangeName("resources/img/place/placeInsert" + changeName);
		   
		   resultImg = pService.insertPlaceImg(pi);
		}
		
		if(resultPlace * resultImg > 0) {
			session.setAttribute("alertMsg", "경기장 등록이 완료되었습니다.");
	        return "redirect:/";
		} else {
			session.setAttribute("alertMsg", "사진을 꼭 첨부해주세요.");
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
		mv.addObject("pi",pi)
		  .addObject("list", pService.selectPlaceList(pi, pl));
		return new Gson().toJson(mv);
	}
}
