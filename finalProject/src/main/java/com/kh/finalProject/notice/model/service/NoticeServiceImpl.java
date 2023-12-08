package com.kh.finalProject.notice.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.notice.model.dao.NoticeDao;
import com.kh.finalProject.notice.model.vo.Notice;

@Service
public class NoticeServiceImpl implements NoticeService{
	
   @Autowired
   private NoticeDao noticeDao;
   
   @Autowired
   private SqlSessionTemplate sqlSession; 

	@Override
	public ArrayList<Notice> selectNoticeList() {
		return noticeDao.selectNoticeList(sqlSession);
	}

	@Override
	public int insertNotice(Notice n) {
		return noticeDao.insertNotice(sqlSession, n);
	}
	


}
