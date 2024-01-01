package com.kh.finalProject.chatting.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kh.finalProject.chatting.model.service.ChattingService;
import com.kh.finalProject.chatting.model.vo.ChattingRoom;
import com.kh.finalProject.chatting.model.vo.ChattingMember;
import com.kh.finalProject.chatting.model.vo.ChattingMessage;
import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.SportInfo;
import com.kh.finalProject.team.model.service.TeamService;
import com.kh.finalProject.team.model.vo.TeamMember;

@Controller
public class ChattingController {

	@Autowired
	private ChattingService chattingService;
	
	@Autowired
	private TeamService teamService;
	
	
	@ResponseBody
	@RequestMapping(value = "/addChattingRoom.ch")
	public HashMap addChattingRoom(HttpSession session,String chattingMember,int teamNo) {
		System.out.println(teamNo);
		System.out.println(chattingMember);
		Member m = (Member) session.getAttribute("loginUser");
		String chString = chattingMember.replace("[", "").replace("]", "");
		String MemberString = chString+","+String.valueOf(m.getUserNo());
		String[] test1 = MemberString.split(",");
		  Arrays.sort(test1);
		String arr2 = Arrays.toString(test1);
		String realDate = arr2.replace("[", "").replace("]", "");
		ChattingRoom room =new ChattingRoom();
		room.setChattingMember(realDate);
		room.setTeamNo(teamNo);

	
		ChattingRoom result = chattingService.selectRoomInfo(realDate);	
		System.out.println(result);
		HashMap m1 = new HashMap();
		if(result != null) {
			session.setAttribute("roomNo", result.getRoomNo());
			m1.putIfAbsent("roomNo", result.getRoomNo());
			m1.putIfAbsent("result", "alreadyChattingRoom");
//			session.setAttribute("checkRoom", true);
			return m1;
			//기존의 채팅방 정보를 가져와서 데이터를 처리해준다.
		}else {
//			session.setAttribute("chackRoom", false);
			Gson gson = new Gson();
			JsonArray  jsonArray  = new JsonParser().parseString(chattingMember).getAsJsonArray();
			ArrayList<ChattingMember> chMember  = new ArrayList();
			ChattingMember ch1 = new ChattingMember();
			ch1.setUserNo(m.getUserNo());
			chMember.add(ch1);
		     for (JsonElement element : jsonArray) {
		    	 ChattingMember ch2 = new ChattingMember();
		    	 ch2.setUserNo((element.getAsInt()));
		    	 chMember.add(ch2);
		     }
			int result1 = chattingService.addChattingRoom(chMember,room);
			if(result1 >0)  {
				System.out.println(result1+"!!!!!!!!!11111111");
				session.setAttribute("roomNo",result1);
				m1.putIfAbsent("result", "addChattingRoomOk");
				return m1;
			}
			
		}
		
		m1.putIfAbsent("result", "addChattingRoomfail");
		return m1;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/saveRoomNoAjax.ch")
	public String saveRoomNoAjax(HttpSession session,int roomNo) {
		session.setAttribute("roomNo", roomNo);
		return "saveRoomNoOk";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/selectChattingList.ch")
	public HashMap selectChattingList(HttpSession session,int roomNo) {
		ArrayList<ChattingMessage> list = chattingService.selectChattingList(roomNo);
		HashMap m2 = new HashMap();
		m2.put("chattingList", list);
		m2.put("loginUser",session.getAttribute("loginUser"));
		return m2;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectChatiingRoomList.ch")
	public HashMap selectChatiingRoomList(HttpSession session) {
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();
		 ArrayList<ArrayList<ChattingMember>> outerList = new ArrayList<>();
		 ArrayList<ChattingMessage> messageArr = new ArrayList();
		 HashMap m2 = new HashMap();
		ArrayList<ChattingMember> list = chattingService.selectChatiingRoomList(userNo);
		for(ChattingMember chMem : list) {
			ArrayList<ChattingMember> chattingRoomMem = chattingService.selectChatiingRoomListMem(chMem.getRoomNo());
			messageArr.add(chattingService.selectChattingMessage(chMem.getRoomNo())); 
			for(ChattingMember i : chattingRoomMem) {
				System.out.println(i);
				if(i.getMemberChangeName() == null) {
					i.setMemberChangeName("null");
				}
			}
		
			outerList.add(chattingRoomMem);
		}
		for(ChattingMessage i : messageArr) {
			System.out.println(i);
		}
		m2.put("list", outerList);
		m2.put("message",messageArr);
		m2.put("loginUser",session.getAttribute("loginUser"));
		
		return m2;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectTeamMemberListAjax.ch")
	public HashMap selectTeamMemberListAjax(HttpSession session,int teamNo) {
		HashMap m2 = new HashMap();
		ArrayList<TeamMember> list = teamService.teamMemberList(teamNo);
		m2.put("list", list);
		m2.put("loginUser",session.getAttribute("loginUser"));
		return m2;
	}
	
}
