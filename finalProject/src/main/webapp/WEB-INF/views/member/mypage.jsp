<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Insert title here</title>
  <link rel="stylesheet" href="/final/resources/css/member/myPage.css" >
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
                <button class="btn-1" onclick="location.href='${pageContext.request.contextPath}/myPageUpdate.me'">프로필 설정</button>
            </div>
                
            <div class="bot02">
                <button class="btn-1" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">나의 친구 보기</button>
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
                    <button class="btn-sm-2" style="margin-right: 50px;" onclick="">축구</button>
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

    <!-- 친구 목록 모달창-->
    <div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalToggleLabel">
                친구요청 2 |
                <button class="btn-btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">친구 보기</button>
            </h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body" style="height: 440px;">
                <div class="list-title">친구요청 리스트</div>
                <div class="tt22">
                    <img class="img5" src="/img/img1.jpg">
                    <div class="main-title">임도현</div>
                    <div class="sub-title">서울시 강남구</div>
                    <button class="btn-chexk" onclick="">수락</button>
                </div>
                <div class="tt22">
                    <img class="img5" src="/img/img1.jpg">
                    <div class="main-title">최행배</div>
                    <div class="sub-title">부산시 서면</div>
                    <button class="btn-chexk" onclick="">수락</button>
                </div>
            </div>
          </div>
        </div>
      </div>

      <div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalToggleLabel2">
                친구 5 |
                <button class="btn-btn-primary" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">친구 요청 보기</button>
            </h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="height: 440px;">
                <div class="list-title">친구 리스트</div>
                <div class="tt22">
                    <img class="img5" src="/img/img1.jpg">
                    <div class="main-title">최행배</div>
                    <div class="sub-title">부산시 서면</div>
                    <button class="btn-chexk2" onclick="">친구삭제</button>
                </div>
                <div class="tt22">
                    <img class="img5" src="/img/img1.jpg">
                    <div class="main-title">임도현</div>
                    <div class="sub-title">서울시 강남구</div>
                    <button class="btn-chexk2" onclick="">친구삭제</button>
                </div>
            </div>
          </div>
        </div>
      </div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>