<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/final/resources/css/common/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/final/resources/js/common/main-api.js"></script>
    <script src="/final/resources/js/common/main.js"></script>

</head>


<body onload="mainInit(`${pageContext.request.contextPath}`)">
    
	<jsp:include page="common/header.jsp" />
	<div class="outer">
        <!-- 네비게이터 (소셜매치 팀관리 구장등록) -->
        <div class="nav-container">
            <div class="nav-wrapper">
                <div class="nav-item"><a href="" class="selected">소셜매치</a></div>

                <c:choose>
                    <c:when test="${ empty loginUser }">
                        <div class="nav-item"><a href="${pageContext.request.contextPath}/loginView.me" type="button" >팀관리</a></div>
                    </c:when>
                    <c:otherwise>
                        <div class="nav-item"><a href="" type="button" data-bs-toggle="modal" data-bs-target="#viewMyTeamsModal">팀관리</a></div>
                    </c:otherwise>
                </c:choose>

                <!-- 관리자만 볼 수 있게 -->
                <div class="nav-item">
                    <c:if test="${loginUser.userLevel eq 1}">
                        <a href="${pageContext.request.contextPath}/insertForm.pl">
                            구장등록
                        </a>
				    </c:if>
                </div> 
            </div>
        </div>
    
        <!-- 공지사항, 포인트충전, 팀 구인, 팀 생성으로 가는 태그 -->
        <div class='explore-container'>
            <div class="explore-wrapper">
                <div class="explore-item">
                    <a href="${pageContext.request.contextPath}/noticeList.no">
                        <img src="./resources/img/main/notice.img.png" alt="">
                        <p>공지사항</p>
                    </a>
                    <c:choose>
                        <c:when test="${ empty loginUser }">
                            <a href="${pageContext.request.contextPath}/loginView.me">
                                <img src="./resources/img/main/coin.png" alt="">
                                <p>포인트 충전</p>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/pointView.me">
                                <img src="./resources/img/main/coin.png" alt="">
                                <p>포인트 충전</p>
                            </a>
                        </c:otherwise>
                    </c:choose>
                    <a href="${pageContext.request.contextPath}/offerBoardList.tm">
                        <img src="./resources/img/main/thunder.png" alt="">
                        <p>팀 구인</p>
                    </a>
                    <c:choose>
                        <c:when test="${ empty loginUser }">
                            <a href="${pageContext.request.contextPath}/loginView.me">

                                <img src="./resources/img/main/searchPeople.png" alt="">
                                <p>팀 생성</p>
                            </a>
                        </c:when>
						<c:otherwise>
                            <a href="${pageContext.request.contextPath}/insertTeam.tm" type="button" data-bs-toggle="modal" data-bs-target="#myModal" >

                                <img src="./resources/img/main/searchPeople.png" alt="">
                                <p>팀 생성</p>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

        <!-- 캐러셀 부트스트랩(사진 보여주기) -->
        <div class="carousel-container">
            <div class="carousel-wrapper">
                <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner img-inner">
                      <div class="carousel-item active img-edit">
                        <img src="./resources/img/main/christmas_baseball.jpg" class="d-block w-100 real-img" alt="...">
                      </div>
                      <div class="carousel-item img-edit">
                        <img src="./resources/img/main/football1.jpg" class="d-block w-100 real-img" alt="...">
                      </div>
                      <div class="carousel-item img-edit">
                        <img src="./resources/img/main/basketball2.jpg" class="d-block w-100 real-img" alt="...">
                      </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 축구, 야구, 농구 중 어떤 경기리스트를 보여줄지 클릭하는 버튼 -->
        <div class="choice-sports">
            <div onclick="changeSport(2)" class="baseball-btn">
                <img class="baseball-img"src="./resources/img/main/bb_img.png" alt="">
                <p>Baseball</p>
            </div>
            <div onclick="changeSport(1)" class="football-btn">
                <img class="sports-img" src="./resources/img/main/soccerImg.png" alt="">
                <p>Football</p>
            </div>
            <div onclick="changeSport(3)" class="basketball-btn">
                <img class="sports-img" src="./resources/img/main/basketballImg.png" alt="">
                <p>Basketball</p>
            </div>
        </div>

        <!-- 캘린더 -->
        <div class="date-container">
        </div>

        <!-- 지역, 성별, 레벨 필터 -->
        <!-- 클릭되면 li태그의 클래스로 on들어가야되고 이미지도 selected로 바뀌어야 함 -->
        <div class="main-filter">
            <div class="main-match-filter">
                <div class="filter-wrapper">
                    <select class="choice-box" id="selectArea" onchange="changeArea()">
                        <option>서울</option>
                        <option>경상</option>
                        <option>대구</option>
                        <option>대전</option>
                        <option>경기</option>
                        <option>광주</option>
                        <option>부산</option>
                        <option>충청</option>
                        <option>인천</option>
                        <option>전라</option>
                        <option>울산</option>
                        <option>세종</option>
                        <option>강원</option>
                        <option>제주</option>
                    </select>
                    <select class="choice-box" id="selectGender" onchange="changeGender()">
                        <option value="3">남녀모두</option>
                        <option value="1">남자</option>
                        <option value="2">여자</option>
                    </select>
                    <select class="choice-box" id="selectLevel" onchange="changeLevel()">
                        <option>모든레벨</option>
                        <option>스타터</option>
                        <option>아마추어</option>
                        <option>세미프로</option>
                        <option>프로</option>
                    </select>
                </div>
            </div>
        </div>
        
        <!-- 매치 스케쥴 -->
        <div class="match-schedule-container">
            
        </div>

        <div class="paging-area" align="center" style="margin: 50px;">
        </div>

    </div>

    <!-- 팀 생성 Modal -->
    <div class="modal" id="myModal">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
      
            <div class="modal-header">
              <h5 class="header-h5">팀 만들기</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
      
            <div class="modal-body">
              <form action="insertTeam.tm" method="post" enctype="multipart/form-data">
              
              <p class="body-p">팀 정보를 <br>입력해주세요</p>
              
                <p class="userInfo-modal-font">종목 선택</p>
                <div class="btn-group-top" role="group" aria-label="Basic radio toggle button group">
                    <ul style="padding: 0px;">
                        <li class="">
                            <input type="radio" class="btn-checkX" name="categoryNum" id="ability-offence" autocomplete="off" value="1">
                            <label class="btn btn-checkX-label madal-label" for="ability-offence">축구</label>
                        </li>
                        <li class="">
                            <input type="radio" class="btn-checkX" name="categoryNum" id="ability-balance" autocomplete="off" value="2">
                            <label class="btn btn-checkX-label madal-label" for="ability-balance">야구</label>
                        </li>
                        <li class="">
                            <input type="radio" class="btn-checkX" name="categoryNum" id="ability-defence" autocomplete="off" value="3">
                            <label class="btn btn-checkX-label madal-label" for="ability-defence">농구</label>
                        </li>
                    </ul>
                </div>

  
                  <div class="profile-imgbox">
                      <label for="file" style="display: flex; justify-content: center;">
                          <div class="btn-upload"><img src="./resources/img/team/teamOfferBoardList/profile.jpg" alt="" id="profile-img"></div>
                      </label>
                      <input type="file" name="upfile" id="file" onchange="imgChange(this)" required>

                  </div>
  
                  <p class="madal-font">팀 이름</p>
                  <div class="input-group mb-3 input-group-lg">
                      <input type="text" class="form-control" placeholder="팀 이름을 작성해주세요" name="teamName" required>
                  </div>
                  <p class="madal-font">활동지역</p>
                  <div class="input-group mb-3 input-group-lg home-field-search">
                      <input type="text" class="form-control" placeholder="홈 구장 찾기" name="activityAtea" required>
                  </div>
                  <p class="userInfo-modal-font">성별</p>
                  <div class="btn-group-top" role="group" aria-label="Basic radio toggle button group">
                      <ul style="padding: 0px;">
                          <li class="">
                              <input type="radio" class="btn-checkX" name="teamGender" id="gender-all" value="남녀 모두">
                              <label class="btn btn-checkX-label madal-label" for="gender-all">남녀 모두</label>
                          </li>
                          <li class="">
                              <input type="radio" class="btn-checkX" name="teamGender" id="gender-male" value="남자">
                              <label class="btn btn-checkX-label madal-label" for="gender-male">남자</label>
                          </li>
                          <li class="">
                              <input type="radio" class="btn-checkX" name="teamGender" id="gender-female" value="여자">
                              <label class="btn btn-checkX-label madal-label" for="gender-female">여자</label>
                          </li>
                      </ul>
                  </div>
                  <p class="madal-font">레벨</p>
                  <div>
                      <div class="btn-group-top" role="group" aria-label="Basic radio toggle button group">
                          <ul>
                              <li class="">
                                  <input type="radio" class="btn-checkX" name="teamLevel" id="level-all" autocomplete="off" value="실력무관">
                                  <label class="btn btn-checkX-label madal-label" for="level-all">실력무관</label>
                              </li>
                              <li>
                                  <input type="radio" class="btn-checkX" name="teamLevel" id="level-1" autocomplete="off" value="스타터">
                                  <label class="btn btn-checkX-label madal-label" for="level-1">스타터</label>
                              </li>
                              <li>
                                  <input type="radio" class="btn-checkX" name="teamLevel" id="level-2" autocomplete="off" value="비기너">
                                  <label class="btn btn-checkX-label madal-label" for="level-2">비기너</label>
                              </li>
                          </ul>
                          <ul>
                              <li>
                                  <input type="radio" class="btn-checkX" name="teamLevel" id="level-3" autocomplete="off" value="아마추어">
                                  <label class="btn btn-checkX-label madal-label" for="level-3">아마추어</label>
                              </li>
                              <li>
                                  <input type="radio" class="btn-checkX" name="teamLevel" id="level-4" autocomplete="off" value="세미프로">
                                  <label class="btn btn-checkX-label madal-label" for="level-4">세미프로</label>
                              </li>
                              <li>
                                  <input type="radio" class="btn-checkX" name="teamLevel" id="level-5" autocomplete="off" value="프로">
                                  <label class="btn btn-checkX-label madal-label" for="level-5">프로</label>
                              </li>
                          </ul>
                      </div>
                  </div>
                  <p class="madal-font">나이(중복 가능)</p>
                  <div>
                      <div class="btn-group-top" role="group" aria-label="Basic radio toggle button group">
                          <ul>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="teamUserAge" id="age-10" autocomplete="off" value="10대">
                                  <label class="btn btn-checkX-label madal-label" for="age-10">10대</label>
                              </li>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="teamUserAge" id="age-20" autocomplete="off" value="20대">
                                  <label class="btn btn-checkX-label madal-label" for="age-20">20대</label>
                              </li>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="teamUserAge" id="age-30" autocomplete="off" value="30대">
                                  <label class="btn btn-checkX-label madal-label" for="age-30">30대</label>
                              </li>
                          </ul>
                          <ul>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="teamUserAge" id="age-40" autocomplete="off" value="40대">
                                  <label class="btn btn-checkX-label madal-label" for="age-40">40대</label>
                              </li>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="teamUserAge" id="age-50" autocomplete="off" value="50대">
                                  <label class="btn btn-checkX-label madal-label" for="age-50">50대</label>
                              </li>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="teamUserAge" id="age-60" autocomplete="off" value="60대 이상" >
                                  <label class="btn btn-checkX-label madal-label" for="age-60">60대 이상</label>
                              </li>
                          </ul>
                      </div>
                  </div>
                  <button type="submit" class="btn btn-primary btn-next">다음</button>
              </form>
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
                        <div class="accordion-body football-part">
                          
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

    
	<jsp:include page="common/footer.jsp" />
</body>
</html>