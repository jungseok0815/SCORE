package com.kh.finalProject.common.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.MessageAuth;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@RestController
public class SendMessage {
	
	 final DefaultMessageService messageService;

	 @Autowired
	private MemberService memberService;
	 
    public SendMessage() {
        // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
        this.messageService = NurigoApp.INSTANCE.initialize("NCSEZITHDN92CHU0", "SDIEAKCSXQYKQLNIPMMTXCLJWQRHAE6X", "https://api.coolsms.co.kr");
    }
    @ResponseBody
    @PostMapping("/send-one")
    public String sendOne(String phone, HttpSession session) {
        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01025509401");
        message.setTo(phone);
        Random random = new Random();
        // 100000부터 999999까지의 범위에서 랜덤 숫자 생성
        int min = 100000;
        int max = 999999;
        int randomNum = random.nextInt((max - min) + 1) + min;
        message.setText(String.valueOf(randomNum));
        
        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.print(response);
        if(response.getStatusCode().equals("2000")) {
        	MessageAuth auth = new MessageAuth();
        	auth.setAuthNum(randomNum);
        	auth.setPhone(phone);
        	System.out.print(auth.getAuthNum());
        	System.out.print(auth.getPhone());
        	return memberService.insertAuth(auth) > 0 ? "sendOAuthOk" : "sendAuthServerErr";
        }
        return "sendAuthErr";
    }
}
