package com.kh.finalProject.team.model.service;

import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamMember;

public interface TeamServiceImp {

	//게시글 총 갯수 가져오기
	int selectListCount();
	Team selectCategoryNum(int teamNo);
	TeamMember selectUserNo(int tmemberNo);
	int insertTeam(Team t);
}
