<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/member/myPage.css" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	
	<div class="title"> 

        <div class="title2">
            <div style="float: left; width: 35%; padding:10px;">
                <div style="font-size: 22px; width: 80px; height: 30px;">임도현</div><br>
                <div style="font-size: 14px; width: 90px; height: 20px; color: cadetblue;">아이디</div><br>
                <div style="font-size: 14px; width: 90px; height: 20px;">강남구 역삼동</div><br>
                <div style="font-size: 14px; width: 80px; height: 0px;">5명의 친구</div><br><br>
            </div>

            <div class="img-teul">
                <img src="/img/img1.jpg" alt="" class="img1">
            </div>
            
            <div class="bot01">
                <button class="btn-1">프로필 설정</button>
            </div>
                
            <div class="bot02">
                <button class="btn-1">나의 친구 보기</button>
            </div>

            <div class="bot02">
                <button class="btn-sm-1">마이페이지</button>
                <button class="btn-sm-1">나의 팀보기</button>
            </div>

            <div class="bot03">
                <div class="box2" style="margin-right: 15px;">매너<img src="/img/good.png" class="img2"><div class="ipbox">100</div></div>
                <div class="box22">레벨<img src="/img/king.png" class="img2"><div class="ipbox">아마추어</div></div>
            </div>
        </div>

        <div class="title5">
            <div class="start-1">
                <div class="match">소셜 매치</div>
                <br>
                <div class="point">POINT<div class="ipbox1">10,000</div></div>

                <div class="btn-3">
                    <button class="btn-sm-2" style="margin-right: 50px;" onclick="">풋살</button>
                    <button class="btn-sm-2" style="margin-right: 50px;" onclick="">야구</button>
                    <button class="btn-sm-2" onclick="">농구</button>
                </div>

                <div class="btn-4">경기수 <div class="ipbox2">3</div></div>
                
                <div class="btn-5"> 스마일 카드 <div class="ipbox2">3</div></div>
                
                <div class="btn-5">옐로우 카드 <div class="ipbox2">0</div></div>
                
                <div class="btn-5">레드 카드 <div class="ipbox2">0</div></div>
            </div>
            
        </div>
    </div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>