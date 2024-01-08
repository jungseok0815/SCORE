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

 
