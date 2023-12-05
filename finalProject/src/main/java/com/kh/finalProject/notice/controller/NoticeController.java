package com.kh.finalProject.notice.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.notice.model.service.NoticeService;
import com.kh.finalProject.notice.model.vo.Notice;

@Controller
public class NoticeController {
	
	@Autowired
	 private NoticeService noticeService;
	
	@RequestMapping("/noticeList.no")
	public ModelAndView noticeList(ModelAndView mv) {
		ArrayList<Notice> list = noticeService.selectNoticeList();
		System.out.print(list);
		mv.addObject("noticeList", list).setViewName("notice/noticeList");
		return mv;
		
	}
	
	@RequestMapping("/insert.no")
	public String insertNotice(Notice n, HttpSession session, Model model) {
		//n.setUserNo(1);
		int result = noticeService.insertNotice(n);
		if(result > 0) {
			session.setAttribute("alertMsg", "공지사항 작성 완료");
			return "redirect:noticeList.no";
		} else {
			model.addAttribute("errorMsg", "공지사항 작성 실패");
			return "common/errorPage";
		}
	}
}
