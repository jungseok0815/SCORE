# backend 주요 코드 분석

## 채팅방
 #### 채팅방의 존재 여부를 데이터베이스에서 조회에서 없다면 만들어주고 채팅 세션에 담아주고 있다면 세션에 담아 실시간 연결을 해주는 코드
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
			session.setAttribute("checkRoom", true);
			return m1;
			//기존의 채팅방 정보를 가져와서 데이터를 처리해준다.
		}else {
			session.setAttribute("chackRoom", false);
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





#### 채팅방이 없다면 트랜젝션 처리로 채팅방을 만들고 그안에 멤버들을 넣어주는 서비스
	@Transactional
	@Override
	public int addChattingRoom(ArrayList<ChattingMember> chMember,ChattingRoom room) {
		int result = 0;
			if(room.getTeamNo() > 0) {
				result =chattingDao.addChattingRoom(sqlSession,room);
			}else {
				result =chattingDao.addChattingRoom2(sqlSession,room);
			}
		
		int result2 = 0;
	
		if(result > 0) {
			for(ChattingMember ch : chMember) {
				HashMap m1 = new HashMap();
				m1.put("userNo", ch.getUserNo());
				
				if(room.getTeamNo() > 0) {
					m1.put("teamNo", room.getTeamNo());
					result2 = chattingDao.addChattingMember(sqlSession,m1);
				}else {
					result2 = chattingDao.addChattingMember2(sqlSession,m1);
				}
				
			}
			if(result2> 0) {
				return result;
			
		}
		}
		return 0;
	}

## 문자인증 
#### 문자요청이 들어오면 난수를 생성하여 인증번호를 보내고 데이터베이스에 저장하는 코드


 ```
 @RestController
  public class SendMessage {
  	 final DefaultMessageService messageService;
  
  	 @Autowired
  	private MemberService memberService;
  	 
      public SendMessage() {
          // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
          this.messageService = NurigoApp.INSTANCE.initialize("************", "******************", "https://api.coolsms.co.kr");
      }
      @ResponseBody
      @PostMapping("/send-one")
      public String sendOne(String phone, HttpSession session) {
          Message message = new Message();
          // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
          message.setFrom("*********");
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
```

## 팀 프로필
#### 로그인한 유저의 팀 정보와 멤버별 등급에 따라 다른 권한을 가지고 있다는걸 보여주는 코드


 ```
	@RequestMapping("teamProfile.tm")
	public ModelAndView teamProfile(String teamNo, HttpSession session, ModelAndView mv) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int tno = Integer.parseInt(teamNo);
		int tmc = teamService.teamMemberCount(tno);
		int taa = teamService.teamAvgAge(tno);
		
		//팀 프로필
		Team t = teamService.teamProfile(tno);
		
		int reqList = 0;
		int offerNo = 0;
		
		//구인글 리스트
		ArrayList<TeamOffer> list = teamService.teamOfferListNo(tno);
		
		if(loginUser != null) {
			
			for(int i = 0; i < list.size(); i++) {
				TeamOffer teamOffer = list.get(i); 
			    offerNo = teamOffer.getOfferNo(); 
			}
			
			reqList = teamService.selectReqListCheck33(loginUser.getUserNo(), tno, offerNo); 
		}
		
		// 구인리스트 카운트
		ArrayList<TeamOffer> listCount = teamService.listCountNo(tno);
		
		// 팀 멤버
		ArrayList<TeamMember> tm = teamService.teamMemberList(tno);
		
		int myGrade = 0;
		for (TeamMember m : tm) {
			if(m.getUserNo() == loginUser.getUserNo())
				myGrade = m.getGrade();
			
		}
		mv.addObject("teamMemberCount", tmc)
		.addObject("teamAvgAge", taa)
		.addObject("team", t)
		.addObject("teamMemberList", tm)
		.addObject("myGrade", myGrade)
		.addObject("reqList", reqList)
		.addObject("listCount", listCount)
		.setViewName("team/teamProfile");
		
		return mv;
	}

```

## 경기장 리뷰
#### 조건에따라 경기장 리뷰 글을 검색할 수 있는 코드(맵 형태로 리턴하여 키, 값 형태로 꺼내서 쓸 수 있음)


 ```
	@ResponseBody
	@RequestMapping(value="/search.pl", produces="application/json; charset=UTF-8")
	public HashMap selectSearchList(ModelAndView mv,
					 @RequestParam("condition") String condition,
					 @RequestParam("keyword") String keyword,
					 @RequestParam(value="cpage", defaultValue="1") int currentPage,
					 HttpSession session) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		Member user = (Member)session.getAttribute("loginUser");
		
		PageInfo pi = Pagenation.getPageInfo(pService.selectSearchCount(map), currentPage, 5, 5);
		
		ArrayList<PlaceReview> pList =  pService.selectSearchList(map, pi);
		
		HashMap result = new HashMap();
		result.put("pList", pList);
		result.put("pi", pi);
		
		if(user != null && !user.equals("")) {
			String userNo = Integer.toString(user.getUserNo());
			ArrayList<Reservation> rList = pService.selectResList(userNo);	
			result.put("rList", rList);
		}
		
		return result ;
	}
```


## 마이페이지
#### 마이페이지를 수정할때 기본 이미지, 수정된 이미지로 변경할 수 있고 필요한 값들을 넘겨주는 코드


 ```
	@ResponseBody
	@RequestMapping(value= "/reMyPageUpdate.me",produces="application/json; charset=UTF-8")
	public ModelAndView updateMyPageMember(Member m, HttpSession session,ModelAndView mv, MultipartFile reupfile,  String[] skill, String[] style, SportInfo sport, MemberImg mi) {
		Member login = (Member) session.getAttribute("loginUser");
		sport.setUserNo(m.getUserNo());
		int resultMemImg = 0;
		if(!reupfile.getOriginalFilename().equals("")) {
			String changeName = saveFile(reupfile, session, "/resources/img/member/memberInsert/");
			mi.setMemberUrl("/resources/img/member/memberInsert/");
			mi.setMemberOriginName(reupfile.getOriginalFilename());
			mi.setMemberChangeName("/resources/img/member/memberInsert/" + changeName);
			if(memberService.selectMemberImg(m.getUserNo()) == null) {
				resultMemImg = memberService.insertMemImg(mi);
			}else {
				resultMemImg = memberService.updateMemImg(mi);
			}
		}else{
			if(memberService.selectMemImg(m.getUserNo()) > 0) {
				resultMemImg = memberService.deleteMemImg(mi);
			}
		}

		int result = memberService.updateMyPageMember(m);
		int result2 = memberService.updateMyPageSport(sport);
				
	    	if(result * result2  > 0) {
	            Member loginInfo = memberService.loginMember(login.getUserId());
		    SportInfo sportInfo = memberService.getUserSportInfo(sport);
		    session.setAttribute("loginUser", loginInfo);
		    session.setAttribute("alertMsg", "수정 성공");
		    mv.addObject("sportInfo", sportInfo)
		    .addObject("userInfo", loginInfo)
		    .addObject("memberImg", mi)
		    .setViewName("redirect:myPage.me?userNo=" + login.getUserNo());
	    	} else {
			mv.addObject("errorMsg", "수정  실패");
	    	}
		return mv;
	}

```

 
## 게임 평가 
#### 게임에 참여했던 선수들에게 스마일카드, 레드카드, 레벨 등등을 책정한 value값을 배열로 만들어 준다

```
updateEnal = (sportSmile) =>{
    console.log(sportSmile)
    const sprotInfo = document.querySelectorAll(".check")
    let data = []
    for(let i =0; i<sprotInfo.length; i++){
        let sprotInfoi =  document.querySelectorAll("#sportInfo" + i + ">td > select")
        let sprotInfoj =  document.querySelector("#sportInfo" + i + ">td > input")
        const userNo = document.querySelector("#enalUserNo" + i).value
        const categoryNum = document.querySelector("#enalCategoryNum").value
        const fieldNo = document.querySelector("#enalFieldNo").value
        console.log(fieldNo)
            info ={
                fieldNo : fieldNo,
                categoryNum : categoryNum,
                userNo : userNo,
                sportSmile : sprotInfoi[0].value,
                sportYellow : sprotInfoi[1].value,
                sportRed : sprotInfoi[2].value,
                sportLever : sprotInfoi[3].value,
                sportScore : sprotInfoj.value
        }
        data.push(info)
    }

        const realData=  JSON.stringify(data)
        evaluationAjaxController.test(realData,test2)
        
        console.log(typeof(realData) )
    }
```

## 게임 평가 
#### 받은 데이터들을 오브젝트로 형변환 시킨 후 첫번째 인덱스부터 마지막 인덱스까지 차례대로 서비스로 보내서 업데이트를 시킨다.

```
@RequestMapping(value="evaluationUpdate.pl", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> evaluationUpdate(String realdata, Model model, HttpSession session) {
		
		Gson gson = new Gson();
		int updateSpo = 0;
		ArrayList<SportInfo> list = new ArrayList<>();
		
		JsonArray  jsonArray  = new JsonParser().parseString(realdata).getAsJsonArray();

		JsonElement firstElement = jsonArray.get(0); // 1번째 인덱스의 요소 가져오기
		JsonObject firstObject = firstElement.getAsJsonObject(); // JsonObject로 변환

		int fieldNo = firstObject.get("fieldNo").getAsInt(); // "fieldNo" 키의 값을 가져와서 int로 변환
	
        for (JsonElement element : jsonArray) {
        	SportInfo spoInfo = gson.fromJson(element, SportInfo.class);

            list.add(spoInfo);
        }
        
        for (SportInfo spoInfo : list) {
            updateSpo = pService.updateEval(spoInfo);
        }
        Member m = (Member)session.getAttribute("loginUser");
        
        Map<String, Object> resultMap = new HashMap<>();
        if(updateSpo > 0) {
        	resultMap.put("fieldNo", fieldNo);
        	resultMap.put("result", "success");
            resultMap.put("message", "게임 평가 완료");
            resultMap.put("userNo", m.getUserNo());
        } else {
```

        	 resultMap.put("result", "failure");
             resultMap.put("message", "게임 평가 실패");
        }
        return resultMap;
	}
 
