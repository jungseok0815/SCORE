package com.kh.finalProject.place.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.place.model.service.PlaceService;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;

@Controller
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;
	
	//placeInsert로 보내주는 메소드
	@RequestMapping("/insertForm.pl")
	public String insertPlaceForm() {
		return "place/placeInsert";
	}

	@RequestMapping("/insert.pl")
	public String insertPlace(Place p, PlaceImg pi, MultipartFile upfile, HttpSession session, Model m) {
		
		int resultPlace = placeService.insertPlace(p);
		int resultImg = 0;
		
		
		//전달된 파일이 있을 경우 => 파일명 수정 후 서버 업로드 => 원본명, 서버업로드된 경로로 DB에 담기(파일이 있을때만)
		if(!upfile.getOriginalFilename().equals("")) {
			
		   String changeName = saveFile(upfile, session);
		   
		   pi.setFieldUrl("resources/img/place/");
		   pi.setFieldOriginName(upfile.getOriginalFilename());
		   pi.setFieldChangeName("resources/img/place/placeInsert" + changeName);
		   
		   resultImg = placeService.insertPlaceImg(pi);
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
	public String placeDetailview() {
		return "place/placeDetailView";
		
	}
}
