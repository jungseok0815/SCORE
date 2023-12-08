package com.kh.finalProject.notice.model.service;

import java.util.ArrayList;

import com.kh.finalProject.notice.model.vo.Notice;

public interface NoticeService {
	
	//공지사항 리스트 조회
	ArrayList<Notice> selectNoticeList();
	//공지사항 작성
	int insertNotice(Notice n);
}
