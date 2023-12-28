package com.kh.finalProject.place.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.finalProject.common.template.Pagenation;
import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.place.model.service.PlaceServiceImpl;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;
import com.kh.finalProject.place.model.vo.Reservation;

@Controller
public class PlaceController {
	
	@Autowired
	private PlaceServiceImpl pService;
	@Autowired
	private MemberService mService;
	
	//placeInsert로 보내주는 메소드
	@RequestMapping("/insertForm.pl")
	public String insertPlaceForm(Model m) {
		m.addAttribute("list", mService.selectManegerList());
		return "place/placeInsert";
	}

	@RequestMapping("/insert.pl")
	public String insertPlace(Place p, ArrayList<MultipartFile> upfile, HttpSession session, Model m) {
		
		int resultPlace = pService.insertPlace(p);
		int resultImg = 1;
		
		for(MultipartFile mf : upfile) {
			//전달된 파일이 있을 경우 => 파일명 수정 후 서버 업로드 => 원본명, 서버업로드된 경로로 DB에 담기(파일이 있을때만)
			if(!mf.getOriginalFilename().equals("")) {
				PlaceImg pi = new PlaceImg();
				String changeName = saveFile(mf, session);
				
				pi.setFieldUrl("resources/img/place/");
				pi.setFieldOriginName(mf.getOriginalFilename());
				pi.setFieldChangeName("resources/img/place/placeInsert/" + changeName);
				
				resultImg = resultImg * pService.insertPlaceImg(pi);
			}
		}
		
		if(resultPlace * resultImg > 0) {
			session.setAttribute("alertMsg", "경기장 등록이 완료되었습니다.");
		} else {
			session.setAttribute("alertMsg", "경기장 등록에 실패하였습니다.");
		}
		return "redirect:/";
	}
	
	public String saveFile(MultipartFile upfile, HttpSession session) {
	  
	      String originName = upfile.getOriginalFilename();
	      
	      String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	      
	      int ranNum = (int)(Math.random() * 90000) + 10000;
	      
	      String ext = originName.substring(originName.lastIndexOf("."));
	      
	      String changeName = currentTime + ranNum + ext;
	      
	      String savePath = session.getServletContext().getRealPath("/resources/img/place/placeInsert/");
	      
	      try {
	         upfile.transferTo(new File(savePath + changeName));
	      } catch (IllegalStateException | IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      return changeName;
	   }
	
	@RequestMapping("/detail.pl")
	public String placeDetailview(int fno, Model m) {
		//금액 3자리 마다 ,찍어주는 클래스
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		Place pl = pService.placeDetailview(fno);
		
		//날씨를 가져오기위한 날씨 자료
		int fieldDate = Integer.parseInt(pl.getFieldDate().replaceAll("-", ""));
		
		// 날짜 형식 변경 2023-12-07  =>  12월 7일 
		String monthDate = pl.getFieldDate().substring(5,7) + "월 ";
		String dayDate = (Integer.parseInt(pl.getFieldDate().substring(8,10))) + "일";
		pl.setFieldDate(monthDate+dayDate);
		
		
		m.addAttribute("pl", pl);
		m.addAttribute("fieldDate", fieldDate);
		m.addAttribute("matchPay", formatter.format(pl.getMatchPay()));
		m.addAttribute("resCount", pService.placeResCount(fno));
		m.addAttribute("plImgList", pService.placeImgList(fno));
		return "place/placeDetailView";
	}
	

	
	@ResponseBody
	@RequestMapping(value="/loadList.pl",produces="application/json; charset=UTF-8")
	public String placeListCount(@RequestParam(value="cpage", defaultValue="1") int currentPage,
			@RequestParam(value="categoryNum", defaultValue="1") int categoryNum,
			@RequestParam(value="area", defaultValue="서울") String area,
			@RequestParam(value="gender", defaultValue="3") int gender,
			@RequestParam(value="level", defaultValue="모든레벨") String level,
			@RequestParam(value="date", defaultValue="") String date,
			ModelAndView mv) {
		Place pl = new Place();
		pl.setCategoryNum(categoryNum);
		pl.setFieldArea(area);
		pl.setMatchGender(gender);
		pl.setMatchLevel(level);
		pl.setFieldDate(date);
		
		PageInfo pi = Pagenation.getPageInfo(pService.placeListCount(pl), currentPage, 5, 5);
		ArrayList<Place> list = pService.selectPlaceList(pi, pl);
		ArrayList<Place> resList = pService.selectResPlaceList();
		mv.addObject("pi",pi)
		  .addObject("list", list)
		  .addObject("resList", resList);
		return new Gson().toJson(mv);
	}
	@RequestMapping(value="insertSoloResMatch.pl")
	public String insertSoloResMatch(@RequestParam("fieldNo") int fieldNo, 
									 @RequestParam("matchPay") int matchPay, 
									 HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		if(loginUser.getPoint()-matchPay<0) {
			session.setAttribute("alertMsg", "포인트가 부족하여  충전페이지로 이동합니다.");
			return "member/chargingPoint";
		}
		Reservation res = new Reservation();
		res.setFieldNo(fieldNo);
		res.setResUserNo(loginUser.getUserNo());
		if(pService.checkResMatch(res) > 0) {
			session.setAttribute("alertMsg", "이미 예약된 경기입니다.");
			return "main";
		}
		int result = pService.insertResMatch(res);
		if(result>0) {
			loginUser.setPoint(loginUser.getPoint()-matchPay);
			int resultPay = pService.changePoint(loginUser);
			if(resultPay>0) {
				session.setAttribute("alertMsg", "성공적으로 예약되었습니다.");
			}else {
				session.setAttribute("errorMsg", "예약 실패!");
			}
		}else {
			session.setAttribute("errorMsg", "예약 실패!");
		}
		return "main";
	}
	
	@RequestMapping(value="insertResMatch.pl")
	public String insertResMatch(@RequestParam("teamMember") ArrayList<Integer> teamMember,
								 @RequestParam("matchPay") int matchPay,
								 @RequestParam("fieldNo") int fieldNo,
									HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		if(loginUser.getPoint()-(teamMember.size()*matchPay)<0) {
			session.setAttribute("alertMsg", "포인트가 부족하여  충전페이지로 이동합니다.");
			return "member/chargingPoint";
		}
		
		for(int i = 0; i < teamMember.size(); i++) {
			Reservation res = new Reservation();
			res.setFieldNo(fieldNo);
			res.setResUserNo(teamMember.get(i));
			
			if(pService.checkResMatch(res) > 0) {
				session.setAttribute("alertMsg", "이미 예약한 인원이 존재합니다.");
				return "main";
			}
		}
		for(int i = 0; i < teamMember.size(); i++) {
			Reservation res = new Reservation();
			res.setFieldNo(fieldNo);
			res.setResUserNo(teamMember.get(i));
			int result = pService.insertResMatch(res);
		}
		loginUser.setPoint(loginUser.getPoint()-(teamMember.size()*matchPay));
		int resultPay = pService.changePoint(loginUser);
		if(resultPay>0) {
			session.setAttribute("alertMsg", "성공적으로 예약되었습니다.");
		}
		return "main";
	}
	@ResponseBody
	@RequestMapping(value="/selectResList.pl",produces="application/json; charset=UTF-8")
	public String selectResList(int userNo, ModelAndView mv) {
		ArrayList<Reservation> arrayRes = pService.selectResList(userNo);
		mv.addObject("arrayRes",arrayRes);
		return new Gson().toJson(mv);
	}
	@RequestMapping("/deleteRes.pl")
	public String deleteReservation(int resNo, int fieldNo, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		int matchPay = pService.selectMatchPay(fieldNo);
		loginUser.setPoint(loginUser.getPoint()+matchPay);
		//포인트 페이백
		int result1 = pService.changePoint(loginUser);
		if(result1>0) {
			int result2 = pService.deleteReservation(resNo);
			if(result2>0) {
					session.setAttribute("alertMsg", "성공적으로 예약취소 되었습니다.");
			}else{
				//예약취소에 실패하면 다시 포인트차감
				loginUser.setPoint(loginUser.getPoint()-matchPay);
				pService.changePoint(loginUser);
				session.setAttribute("alertMsg", "예약취소에 실패하였습니다.");
			}
		}else {
			session.setAttribute("alertMsg", "예약취소에 실패하였습니다.");
		}
		return "redirect:detail.pl?fno="+fieldNo;
	}
	
	@ResponseBody
	@RequestMapping(value="/calendar.pl",produces="application/json; charset=UTF-8")
	public ModelAndView calendarView(int userNo, HttpSession session, ModelAndView mv) {
		if(userNo == 0) {
			session.setAttribute("alertMsg", "로그인 후 이용가능한 서비스입니다.");
			mv.setViewName("member/memberLogin");
			return mv;
		}
		mv.addObject("list", new Gson().toJson(pService.selectResDay(userNo)));
		mv.setViewName("member/calendar");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/dateChoiceRes.pl",produces="application/json; charset=UTF-8")
	public String dateChoiceResList(@RequestParam("fieldDate") String fieldDate, HttpSession session, ModelAndView mv) {
		Reservation res = new Reservation();
		res.setResUserNo(((Member)session.getAttribute("loginUser")).getUserNo());
		res.setFieldDate(fieldDate);
		ArrayList<Reservation> list = pService.dateChoiceResList(res);
		mv.addObject("list", pService.dateChoiceResList(res));
		return new Gson().toJson(mv);
	}
	@ResponseBody
	@RequestMapping(value="/dateAllRes.pl",produces="application/json; charset=UTF-8")
	public String dateAllResList(HttpSession session, ModelAndView mv) {
		
		ArrayList<Reservation> list = pService.dateAllResList(((Member)session.getAttribute("loginUser")).getUserNo());
		mv.addObject("list", list);
		return new Gson().toJson(mv);
	}
	
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
        //System.out.println("변환된 날짜: " + convertedDate);
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
//        System.out.println("Response code: " + conn.getResponseCode());
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
//        System.out.println(responseText);
        m.addAttribute("responseText", responseText);
        return new Gson().toJson(m);
        
	}
	
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
//		System.out.println(result);
		
		parser = new JSONParser(); 
        jArr = (JSONArray) parser.parse(result);
        for(int i = 0 ; i < jArr.size(); i++) {
        	jobj = (JSONObject) jArr.get(i);
        	if(jobj.get("value").equals(areaTop)) {
        		code=(String)jobj.get("code");
//        		System.out.println(areaTop+"코드 : "+code);
        		break;
        	}
        }
        
        //구 검색
        url = new URL("http://www.kma.go.kr/DFSROOT/POINT/DATA/mdl."+code+".json.txt");
		conn = url.openConnection();
		br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		result = br.readLine().toString();
		br.close();
//		System.out.println(result);
		
		parser = new JSONParser(); 
        jArr = (JSONArray) parser.parse(result);
        
        for(int i = 0 ; i < jArr.size(); i++) {
        	jobj = (JSONObject) jArr.get(i);
        	if(jobj.get("value").equals(areaMdl)) {
        		code=(String)jobj.get("code");
//        		System.out.println(areaMdl+"코드 : "+code);
        		break;
        	}
        }
        
        //동 검색
        url = new URL("http://www.kma.go.kr/DFSROOT/POINT/DATA/leaf."+code+".json.txt");
		conn = url.openConnection();
		br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		result = br.readLine().toString();
		br.close();
//		System.out.println(result);
		
		parser = new JSONParser(); 
        jArr = (JSONArray) parser.parse(result);
        
    	for(int i = 0 ; i < jArr.size(); i++) {
        	jobj = (JSONObject) jArr.get(i);
        	if(jobj.get("value").equals(areaLeaf)) {
        		x=(String)jobj.get("x");
        		y=(String)jobj.get("y");
//        		System.out.println(areaLeaf+"의 x값 : "+x+", y값 :"+y);
        		break;
        	}
        }
    	
        HashMap teamMap = new HashMap();
		teamMap.put("x", x);
		teamMap.put("y",y);
		return teamMap;
	}
	
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
//        System.out.println(responseText);
        return responseText;
	}
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
//        System.out.println(responseText);
        return responseText;
	}
}


