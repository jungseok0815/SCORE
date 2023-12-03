package com.kh.finalProject.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {
	
	@RequestMapping("/noticeList.no")
	public String noticeList() {
		return "notice/noticeList";
		
	}
}
