package com.kh.finalProject.common.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.finalProject.chatting.model.service.ChattingService;
import com.kh.finalProject.chatting.model.vo.ChattingMessage;
import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.vo.Member;

@Component("chatServer")
public class ChattingController extends TextWebSocketHandler{
	private final Map<Integer, Map<Integer, WebSocketSession>> roomUserSession = new ConcurrentHashMap();
	
	@Autowired
	private ChattingService chattingService;
	@Autowired
	private MemberService memberService;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Member user = (Member)session.getAttributes().get("loginUser");
		int roomNo = (int) session.getAttributes().get("roomNo");
//		boolean checkroom = (boolean)session.getAttributes().get("checkRoom");
	     Map<Integer, WebSocketSession> userSession = new ConcurrentHashMap();
	     userSession.put(user.getUserNo(), session);
	     //방이 있을 
	     if(roomUserSession.get(roomNo) != null) {
	    	    System.out.println(roomNo + "룸번호 있음");
	    	//방과해당 유저가 있을 
	    	if(roomUserSession.get(roomNo).get(user.getUserNo()) != null) {
	    		  System.out.println(user.getUserNo() + "내 emp 있음");
	    	}else { // 방은 있는데 해당 유저가 없을 
	    		roomUserSession.get(roomNo).put(user.getUserNo(), session);
	    	}
	    	 
	     }else{
	    	  System.out.println(roomNo + "룸번호 없음"); //룸이 없기 때문에 해당 룸을 생
	           ArrayList<Map<Integer, WebSocketSession>> userList = new ArrayList<Map<Integer, WebSocketSession>>();
	           userList.add(userSession);
	           roomUserSession.put(roomNo, userSession);
	     };

	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		int roomNo = (int) session.getAttributes().get("roomNo");
		Member user = (Member)session.getAttributes().get("loginUser");
		JsonObject obj = new JsonParser().parse(message.getPayload()).getAsJsonObject();
		Member sender = memberService.userInfo(user.getUserNo());
		ChattingMessage vo = new ChattingMessage();
		vo.setMessageText((obj.get("message").getAsString()));;
		vo.setUserNo(user.getUserNo());;
		vo.setRoomNo(roomNo);
		vo.setUserName(sender.getUserName());
		vo.setMemberChangeName(sender.getMemberChangeName());
//		vo.setTime(new Date().toLocaleString());
		
//		System.out.println(obj.get("target").getAsString());
		sendMessageToUser(vo,roomNo);
	}
	
	
	private void sendMessageToUser(ChattingMessage vo,int roomNo) {
	Map<Integer, WebSocketSession> chattingUser = roomUserSession.get(roomNo);
		chattingService.saveChattingNoReadMessage(vo);
	   for (Map.Entry<Integer, WebSocketSession> entry : chattingUser.entrySet()) {
		   if(entry.getKey() != vo.getUserNo()) {
	              WebSocketSession targetSession = entry.getValue();
	             if(targetSession != null && targetSession.isOpen()) {
	                String str = new Gson().toJson(vo);
	                TextMessage message = new TextMessage(str);
	                try {
	                   targetSession.sendMessage(message);
	               } catch (IOException e) {
	                  e.printStackTrace();
	               }    
	          }
		   }
	   }
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Member user = (Member)session.getAttributes().get("loginUser");
		int roomNo = (int) session.getAttributes().get("roomNo");
		 roomUserSession.get(roomNo).remove(user.getUserNo());
	}

}
