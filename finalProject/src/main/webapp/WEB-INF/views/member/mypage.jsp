<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <link rel="stylesheet" href="/final/resources/css/member/myPage.css" >
  <link rel="stylesheet" href="/final/resources/css/common/main.css">
  <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

    <script src="resources/js/member/memberJs/member.js?ver=5"></script>
    <script src="resources/js/member/memberAjax/memberAjax.js?ver=4"></script>
    <script src="resources/js/member/mypageJs/mypage.js"></script>
    <script src="resources/js/member/mypageAjax/mypageAjax.js"></script>
</head>
<body onload="mypageInit(`${pageContext.request.contextPath}`)">
	<jsp:include page="../common/header.jsp"/>
	
	<div class="title"> 

        <div class="title2">
          <div class="titleWrap">
              <div class="myPageLeft">
                  <div style="font-size: 22px; width: 80px; height: 30px;">${userInfo.userName}</div><br>
                  <div style="font-size: 14px; width: 90px; height: 20px; color: cadetblue;">${userInfo.userId}</div><br>
                  <div style="font-size: 14px; width: 90px; height: 20px;">선호 지역 : ${userInfo.address}</div><br>
                  <div style="font-size: 14px; width: 80px; height: 0px;">${countfriends}명의 친구</div><br><br>
              </div>

              <div class="myPageImg">
                <c:choose>
                  <c:when test="${empty userInfo.memberChangeName}">
                    <div class="img-teul">
                        <img src="./resources/img/team/teamOfferBoardList/profile.jpg" alt="" class="img1">
                    </div>
                  </c:when>
                  <c:otherwise>
                    <div class="img-teul">
                      <img src=".${userInfo.memberChangeName}" alt="" class="img1">
                    </div>
                  </c:otherwise>
                </c:choose>
              </div>
          </div>

            <c:choose>
            <c:when test="${loginUser.userNo eq userInfo.userNo}">
	            <div class="bot01">
	                <button class="btn-1" onclick="location.href='${pageContext.request.contextPath}/myPageUpdate.me'">프로필 설정</button>
	            </div>
	                
	            <div class="bot02">
	                <button class="btn-1" data-bs-target="#exampleModalToggle" data-bs-toggle="modal" onclick="selectPostFriend()">나의 친구 보기</button>
	            </div>
	
	            <div class="bot02">
	                <button class="btn-1" data-bs-toggle="modal" data-bs-target="#viewMyTeamsModal">나의 팀보기</button>
	            </div>
              <div class="bot02">
                  <button class="btn-1" data-bs-toggle="modal" data-bs-target="#viewMyResListModal" onclick="selectResListBtn('${loginUser.userNo}')">나의 예약목록보기</button>
              </div>
	        </c:when>
	        <c:otherwise>
	        	 <div class="bot01">
	                <button class="btn-1" disabled onclick="location.href='${pageContext.request.contextPath}/myPageUpdate.me'">프로필 설정</button>
	            </div>
	                
	            <div class="bot02">
	                <button class="btn-1" disabled data-bs-target="#exampleModalToggle" data-bs-toggle="modal" onclick="selectPostFriend()">나의 친구 보기</button>
	            </div>
	
	            <div class="bot02">
	                <button class="btn-1" disabled data-bs-toggle="modal" data-bs-target="#viewMyTeamsModal">나의 팀보기</button>
	            </div>
	        </c:otherwise>
			</c:choose>
        </div>

        <div class="title5">
            <div class="start-1">
                <div class="match">소셜 매치</div>
                <br>
                <div class="point">POINT<div class="ipbox1">${loginUser.point}원</div></div>

                <div class="btn-3">
                    <button class="btn-sm-2" style="margin-right: 50px;" onclick="selectUserSportInfo(1)">축구</button>
                    <button class="btn-sm-2" style="margin-right: 50px;" onclick="selectUserSportInfo(2)">야구</button>
                    <button class="btn-sm-2" onclick="selectUserSportInfo(3)">농구</button>
                </div>

                <div class="btn-4">경기수 <div class="ipbox2">${sportInfo.sportCount}</div></div>
                
                <div class="btn-5 smile-card"> 스마일 카드 <div class="ipbox2">${sportInfo.sportSmile}</div></div>
                
                <div class="btn-5 yellow-card">옐로우 카드 <div class="ipbox2">${sportInfo.sportYellow}</div></div>
                
                <div class="btn-5 red-card">레드 카드 <div class="ipbox2">${sportInfo.sportRed}</div></div>
                
                <div class="bot03">
                  <div class="box2" style="margin-right: 15px;">매너<img src="/img/good.png" class="img2"><div class="ipbox">${sportInfo.sportScore}</div></div>
                  <div class="box22">레벨<img src="/img/king.png" class="img2"><div class="ipbox">${sportInfo.sportLever}</div></div>
                </div>
              </div>
        </div>
    </div>

    <!-- 친구 목록 모달창-->
    <div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalToggleLabel">
                <span id="aaaaaa">친구요청  |</span>
                <button class="btn-btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal" onclick="selectFriendList()">친구 보기</button>
            </h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" onclick="location.reload()"></button>
            </div>

            <div class="modal-body" id="postFriendList" style="height: 440px;">
                
            </div>
          </div>
        </div>
      </div>

      <div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1" >
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalToggleLabel2">
                <span id="bbbb">친구요청  |</span>
                <button class="btn-btn-primary" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">친구 요청 보기</button>
            </h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" id="friendList" style="height: 440px;">
               
            </div>
          </div>
        </div>
      </div>
      
       <!-- 내팀 보기 모달-->
    <div class="modal fade" id="viewMyTeamsModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">MY TEAM</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <!-- 아코디언 추가 (내팀, 축구, 야구, 농구) -->
            <div class="modal-body">
                <div class="accordion" id="accordionExample">
                    <div class="accordion-item">
                      <h2 class="accordion-header">
                        <button onclick="selectMyTeam(1)" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                          축구
                        </button>
                      </h2>
                      <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                        <div class="accordion-body football-part" >
                            
                        </div>
                      </div>
                    </div>
                    <div class="accordion-item">
                      <h2 class="accordion-header">
                        <button onclick="selectMyTeam(2)" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                          야구
                        </button>
                      </h2>
                      <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                        <div class="accordion-body baseball-part">
                         
                        </div>
                      </div>
                    </div>
                    <div class="accordion-item">
                      <h2 class="accordion-header">
                        <button onclick="selectMyTeam(3)" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                          농구
                        </button>
                      </h2>
                      <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                        <div class="accordion-body basketball-part">
                         
                        </div>
                      </div>
                    </div>
                  </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">뒤로</button>
              <button type="button" class="btn btn-primary">확인</button>
            </div>
        </div>
      </div>
    </div>
    <!-- 내 예약목록 보기 모달-->
    <div class="modal fade" id="viewMyResListModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">예약목록</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="resListBody">
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">뒤로</button>
          </div>
      </div>
    </div>
  </div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>