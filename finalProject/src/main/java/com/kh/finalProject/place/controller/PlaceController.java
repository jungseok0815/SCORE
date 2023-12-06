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

import com.kh.finalProject.place.model.service.PlaceService;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;

@Controller
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;
	
//	@RequestMapping("/insert.pl")
//	public String insertPlace(@RequestParam Map<String, String> mapParam) {
//		
//		return "place/placeInsert";
//	}
	
	@RequestMapping("/insertForm.pl")
	public String insertPlaceForm() {
		return "place/placeInsert";
	}

	@RequestMapping("/insert.pl")
	public String insertPlace(Place p, PlaceImg pi, MultipartFile upfile, HttpSession session, Model model) {
		//전달된 파일이 있을 경우 => 파일명 수정 후 서버 업로드 => 원본명, 서버업로드된 경로로 b에 담기(파일이 있을때만)
		if(!upfile.getOriginalFilename().equals("")) {
		   String changeName = saveFile(upfile, session);
		     
		   pi.setFieldOriginName(upfile.getOriginalFilename());
		   pi.setFieldChangeName("resources/img/place/placeInsert" + changeName);
		}
		
		System.out.println(p);
		int result = placeService.insertPlace(p);
		System.out.println(result);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "경기장 등록이 완료되었습니다.");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "경기장 등록 실패");
			return "/views/common.errorPage";
		}
		
	}
	
	public String saveFile(MultipartFile upfile, HttpSession session) {
	      //파일명 수정 후 서버 업로드 시키기("이미지저장용(2).jpg" => 20231109102712345.jpg)
	      //년월일시분초 + 랜덤숫자 5개 + 확장자
	      String originName = upfile.getOriginalFilename();
	      
	      //시간정보(년월일시분초)
	      String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	      
	      //랜덤숫자 5자리
	      int ranNum = (int)(Math.random() * 90000) + 10000;
	      
	      //확장자
	      String ext = originName.substring(originName.lastIndexOf("."));
	      
	      //변경된이름
	      String changeName = currentTime + ranNum + ext;
	      
	      //첨부파일 저장할 폴더의 물리적인 경우
	      String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
	      
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
