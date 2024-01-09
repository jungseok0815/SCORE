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
## 기상청 공공데이터
 #### 오늘날짜로부터 3일동안의 날씨정보를 가져오는 코드
 @ResponseBody
	@RequestMapping(value="fastWeatherAjax.pl", produces="application/json; charset=UTF-8")
	public String weatherAjax(@RequestParam("fieldArea") String fieldArea,@RequestParam("startTime") String startTime,
								 @RequestParam("fieldDate") String fieldDate, Model m) throws IOException, ParseException, org.json.simple.parser.ParseException {
		// 현재 날짜 가져오기
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        // 입력된 날짜 파싱
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        // 현재 날짜를 지정한 형식으로 날짜를 변환
        String convertedDate = dateFormat.format(currentDate);
        
		// 현재 주소를 가지고 기상청날씨를 불러오기위한 좌표값을 구해오는 메서드
        HashMap map = loadCoordinate(fieldArea);
        
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=YNI9%2FTqzyomsIOP52v7CqWRtntwjz5qAaMRawm%2FRFKkqq4T6jVH%2BiCbZCcJvtSBgQA%2FfDNJH1aJJrMrtBjJ2FQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(convertedDate, "UTF-8")); /*‘21년 6월 28일발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0500", "UTF-8")); /*05시 발표*/
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode((String) map.get("x"), "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode((String) map.get("y"), "UTF-8")); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        String responseText = "";
        String line;
        while ((line = rd.readLine()) != null) {
        	responseText += line;
        }
        rd.close();
        conn.disconnect();
        m.addAttribute("responseText", responseText);
        return new Gson().toJson(m);
        
	}
 #### 현재 주소를 가지고 기상청날씨를 불러오기위한 좌표값을 구해오는 코드
 public HashMap loadCoordinate(String fieldArea) throws org.json.simple.parser.ParseException, IOException {
		String[] strArr = fieldArea.split(" ");
		String result;
		String areaTop=null;	//지역
		String areaMdl=null;
		String areaLeaf=null;
		String code=null;	//지역 코드
		String x = null;
		String y = null;
		
		switch(strArr[0]) {
			case "서울" : 
				areaTop="서울특별시";
				break;
			case "부산" : 
				areaTop="부산광역시";
				break;
			case "대구" : 
				areaTop="대구광역시";
				break;
			case "인천" : 
				areaTop="인천광역시";
				break;
			case "광주" : 
				areaTop="광주광역시";
				break;
			case "대전" : 
				areaTop="대전광역시";
				break;
			case "울산" : 
				areaTop="울산광역시";
				break;
			case "경기" : 
				areaTop="경기도";
				break;
			case "강원" : 
				areaTop="강원도";
				break;
			case "충북" : 
				areaTop="충청북도";
				break;
			case "충남" : 
				areaTop="충청남도";
				break;
			case "전북" : 
				areaTop="전라북도";
				break;
			case "전남": 
				areaTop="전라남도";
				break;
			case "경북" : 
				areaTop="경상북도";
				break;
			case "경남" : 
				areaTop="경상남도";
				break;
			case "제주" : 
				areaTop="제주특별자치도";
				break;
		}
		if (strArr[2].charAt(strArr[2].length() - 1) == '구') {
			areaMdl = (strArr[1] + strArr[2]);
			areaLeaf = strArr[3];
		}else {
			areaMdl = strArr[1];
			areaLeaf = strArr[2];
		}
		
		URL url;
		BufferedReader br;
		URLConnection conn;
		
		JSONParser parser;
		JSONArray jArr;
		JSONObject jobj;
		
        //시 검색
		url = new URL("http://www.kma.go.kr/DFSROOT/POINT/DATA/top.json.txt");
		conn = url.openConnection();
		br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		result = br.readLine().toString();
		br.close();
		
		parser = new JSONParser(); 
        jArr = (JSONArray) parser.parse(result);
        for(int i = 0 ; i < jArr.size(); i++) {
        	jobj = (JSONObject) jArr.get(i);
        	if(jobj.get("value").equals(areaTop)) {
        		code=(String)jobj.get("code");
        		break;
        	}
        }
        
        //구 검색
        url = new URL("http://www.kma.go.kr/DFSROOT/POINT/DATA/mdl."+code+".json.txt");
		conn = url.openConnection();
		br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		result = br.readLine().toString();
		br.close();
		
		parser = new JSONParser(); 
        jArr = (JSONArray) parser.parse(result);
        
        for(int i = 0 ; i < jArr.size(); i++) {
        	jobj = (JSONObject) jArr.get(i);
        	if(jobj.get("value").equals(areaMdl)) {
        		code=(String)jobj.get("code");
        		break;
        	}
        }
        
        //동 검색
        url = new URL("http://www.kma.go.kr/DFSROOT/POINT/DATA/leaf."+code+".json.txt");
		conn = url.openConnection();
		br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		result = br.readLine().toString();
		br.close();
		
		parser = new JSONParser(); 
        jArr = (JSONArray) parser.parse(result);
        
    	for(int i = 0 ; i < jArr.size(); i++) {
        	jobj = (JSONObject) jArr.get(i);
        	if(jobj.get("value").equals(areaLeaf)) {
        		x=(String)jobj.get("x");
        		y=(String)jobj.get("y");
        		break;
        	}
        }
    	
        HashMap teamMap = new HashMap();
		teamMap.put("x", x);
		teamMap.put("y",y);
		return teamMap;
	}
 #### 오늘날짜로부터 3일~7일의 날씨정보를 가져오는 코드
 @ResponseBody
	@RequestMapping(value="slowWeatherAjax.pl", produces="application/json; charset=UTF-8")
	public String slowWeatherAjax(@RequestParam("fieldArea") String fieldArea, @RequestParam("fieldDate") String fieldDate,
			@RequestParam("todayDate") Date todayDate, Model m) throws IOException {
		// 입력된 날짜 파싱
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        // 현재 날짜를 지정한 형식으로 날짜를 변환
        String convertedDate = dateFormat.format(todayDate);
        
		String weatherValue = afterWeather(fieldArea, fieldDate,convertedDate);
		String temperatureValue = afterTemperature(fieldArea,fieldDate,convertedDate);
		m.addAttribute("weatherValue", weatherValue);
		m.addAttribute("temperatureValue", temperatureValue);
        return new Gson().toJson(m);
    }
 #### 오늘날짜로부터 3일~7일의 날씨상태를 가져오는 코드 (ex. 맑음, 비, 눈)
public String afterWeather(String fieldArea, String fieldDate, String convertedDate) throws IOException {
		String areaCode = "";
		switch(fieldArea){
		case "서울" : 
		case "인천" :
		case "경기" :
			areaCode = "11B00000";
			break;
		case "강원" : 
			areaCode = "11D10000";
			break;
		case "대전" : 
		case "충남" :
			areaCode = "11C20000";
			break;
		case "충북" : 
			areaCode = "11C10000";
			break;
		case "광주" : 
		case "전남" :
			areaCode = "11F20000";
			break;
		case "전북" :
			areaCode = "11F10000";
			break;
		case "대구" : 
		case "경북" :
			areaCode = "11H10000";
			break;
		case "부산" : 
		case "울산" :
		case "경남" :
			areaCode = "11H20000";
			break;
		case "제주" :
			areaCode = "11G00000";
			break;
		}
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=YNI9%2FTqzyomsIOP52v7CqWRtntwjz5qAaMRawm%2FRFKkqq4T6jVH%2BiCbZCcJvtSBgQA%2FfDNJH1aJJrMrtBjJ2FQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8")); /*11B0000 서울, 인천, 경기도 11D10000 등 (활용가이드 하단 참고자료 참조)*/
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(convertedDate+"0600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600(1800)-최근 24시간 자료만 제공*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        String responseText = "";
        String line;
        while ((line = rd.readLine()) != null) {
        	responseText += line;
        }
        rd.close();
        conn.disconnect();
        return responseText;
	}
 #### 오늘날짜로부터 3일~7일의 기온을 가져오는 코드
	public String afterTemperature(String fieldArea, String fieldDate, String convertedDate) throws IOException{
		
		String areaCode = "";
		switch(fieldArea){
		case "서울" : 
			areaCode = "11B10101";
			break;
		case "인천" :
			areaCode = "11B20201";
			break;
		case "경기" :
			areaCode = "11B20601";
			break;
		case "강원" : 
			areaCode = "11D10301";
			break;
		case "대전" : 
			areaCode = "11C20401";
			break;
		case "충남" :
			areaCode = "11C20101";
			break;
		case "충북" : 
			areaCode = "11C10301";
			break;
		case "광주" : 
			areaCode = "11F20501";
			break;
		case "전남" :
			areaCode = "21F20801";
			break;
		case "전북" :
			areaCode = "21F10501";
			break;
		case "대구" : 
			areaCode = "11H10701";
			break;
		case "경북" :
			areaCode = "11H10501";
			break;
		case "부산" : 
			areaCode = "11H20201";
			break;
		case "울산" :
			areaCode = "11H20101";
			break;
		case "경남" :
			areaCode = "11H20301";
			break;
		case "제주" :
			areaCode = "11G00201";
			break;
		}
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=YNI9%2FTqzyomsIOP52v7CqWRtntwjz5qAaMRawm%2FRFKkqq4T6jVH%2BiCbZCcJvtSBgQA%2FfDNJH1aJJrMrtBjJ2FQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8")); /*11B10101 서울, 11B20201 인천 등 ( 별첨엑셀자료 참고)*/
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(convertedDate+"0600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력- YYYYMMDD0600(1800) 최근 24시간 자료만 제공*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        String responseText = "";
        String line;
        while ((line = rd.readLine()) != null) {
        	responseText += line;
        }
        rd.close();
        conn.disconnect();
        return responseText;
	}
