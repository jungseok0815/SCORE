<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/final/resources/css/common/main.css">

</head>
<body>
    <c:if test="${ !empty alertMsg}">
             <script>
                alertify.alert('제목', '${alertMsg}');
             </script>
           <c:remove var="alertMsg" scope="session" />
    </c:if>
    
	<jsp:include page="common/header.jsp" />
	<div class="outer">
        <!-- 네비게이터 (소셜매치 팀관리 구장등록) -->
        <div class="nav-container">
            <div class="nav-wrapper">
                <div class="nav-item"><a href="" class="selected">소셜매치</a></div>
                <div class="nav-item"><a href="" type="button" data-bs-toggle="modal" data-bs-target="#viewMyTeamsModal">팀관리</a></div>
                <div class="nav-item"><a href="${pageContext.request.contextPath}/insertForm.pl" class="">구장등록</a></div>
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
                    <a href="${pageContext.request.contextPath}/pointView.me">
                        <img src="./resources/img/main/coin.png" alt="">
                        <p>포인트 충전</p>
                    </a>
                    <a href="${pageContext.request.contextPath}/offerBoardList.tm">
                        <img src="./resources/img/main/thunder.png" alt="">
                        <p>팀 구인</p>
                    </a>
                    <a href="" type="button" data-bs-toggle="modal" data-bs-target="#myModal" >
                        <img src="./resources/img/main/searchPeople.png" alt="">
                        <p>팀 생성</p>
                    </a>
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
        <jsp:include page="common/sportSelectBtn.jsp" />

        <!-- 캘린더 -->
        <div class="calender">
            <div class="event-section-calender">
                <div class="event-section-calender-div">
                    <div class="event-calenderLists">
                        <div class="calendar2" id="calendar2"></div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 지역, 성별, 레벨 필터 -->
        <!-- 클릭되면 li태그의 클래스로 on들어가야되고 이미지도 selected로 바뀌어야 함 -->
        <div class="main-filter">
            <div class="main-match-filter">
                <div class="filter-wrapper">
                    <ul>
                        <li class="on" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                            <span>지역</span>
                            <img class="filter-item-arrow" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_filter_arrow_selected.svg" alt="">
                            <!-- Modal -->
                            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="staticBackdropLabel">지역</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            서울
                                        </div>
                                        <div class="modal-body">
                                            경상
                                        </div>
                                        <div class="modal-body">
                                            대구
                                        </div>
                                        <div class="modal-body">
                                            대전
                                        </div>
                                        <div class="modal-body">
                                            경기
                                        </div>
                                        <div class="modal-body">
                                            광주
                                        </div>
                                        <div class="modal-body">
                                            부산
                                        </div>
                                        <div class="modal-body">
                                            충청
                                        </div>
                                        <div class="modal-body">
                                            인천
                                        </div>
                                        <div class="modal-body">
                                            전라
                                        </div>
                                        <div class="modal-body">
                                            울산
                                        </div>
                                        <div class="modal-body">
                                            세종
                                        </div>
                                        <div class="modal-body">
                                            강원
                                        </div>
                                        <div class="modal-body">
                                            제주
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                                            <button type="button" class="btn btn-primary">확인</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li data-bs-toggle="modal" data-bs-target="#exampleModa2">
                            <span>성별</span>
                            <img class="filter-item-arrow" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_filter_arrow.svg" alt="">
                            <div class="modal fade" id="exampleModa2" tabindex="-1" aria-labelledby="exampleModalLabe2" aria-hidden="true">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabe2">성별</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <input type="checkbox">☆남녀모두
                                        </div>
                                        <div class="modal-body">
                                            <input type="checkbox"> 남자
                                        </div>
                                        <div class="modal-body">
                                            <input type="checkbox"> 여자
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                                            <button type="button" class="btn btn-primary">확인</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li data-bs-toggle="modal" data-bs-target="#exampleModa3">
                            <span>레벨</span>
                            <img class="filter-item-arrow" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_filter_arrow.svg" alt="">
                            <div class="modal fade" id="exampleModa3" tabindex="-1" aria-labelledby="exampleModalLabe2" aria-hidden="true">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabe3">레벨</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            스타터
                                        </div>
                                        <div class="modal-body">
                                            아마추어
                                        </div>
                                        <div class="modal-body">
                                            세미프로
                                        </div>
                                        <div class="modal-body">
                                            프로
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                                            <button type="button" class="btn btn-primary">확인</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        
        <!-- 매치 스케쥴 -->
        <div class="match-schedule-container">
            <ul>
                <li class="match-schedule-item">
                    <a href="${pageContext.request.contextPath}/detail.pl">
                        <div class="match-time">
                            <p>18:00</p>
                        </div>
                        <div class="match-info">
                            <div class="match-title">
                                <h3>서울 역삼동 역삼파크 B구장</h3>
                            </div>
                            <div class="match-option">
                                <span>☆남녀모두-</span>
                                <!-- <span>☆남자.</span> -->
                                <!-- <span>☆여자.</span> -->
                                <span>축구-</span>
                                <span>모든레벨</span>
                                <!-- <span>스타터</span> -->
                                <!-- <span>세미프로</span> -->
                            </div>
                        </div>
                        <div class="match-schedule-status">
                            <!-- 신청가능 -->
                            <div class="match-status isOpen">
                                <p>신청가능</p>
                            </div>

                            <!-- 마감임박! -->
                            <!-- <div class="match-status isHurry">
                                
                            </div> -->

                            <!-- 마감 -->
                            <!-- <div class="match-status isFull">
                                
                            </div> -->
                        </div>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="match-schedule-item">
                    <a>
                        <div class="match-time">
                            <p>22:00</p>
                        </div>
                        <div class="match-info">
                            <div class="match-title">
                                <h3>광주 전남대학교 대운동장</h3>
                            </div>
                            <div class="match-option">
                                <span>☆남녀모두-</span>
                                <!-- <span>☆남자.</span> -->
                                <!-- <span>☆여자.</span> -->
                                <span>축구-</span>
                                <span>모든레벨</span>
                                <!-- <span>스타터</span> -->
                                <!-- <span>세미프로</span> -->
                            </div>
                        </div>
                        <div class="match-schedule-status">
                            <!-- 신청가능 -->
                            <!-- <div class="match-status isOpen">
                                <p>신청가능</p>
                            </div> -->

                            <!-- 마감임박! -->
                            <div class="match-status isHurry">
                                <p>마감임박!</p>
                            </div>

                            <!-- 마감 -->
                            <!-- <div class="match-status isFull">
                                
                            </div> -->
                        </div>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="match-schedule-item">
                    <a>
                        <div class="match-time">
                            <p>13:30</p>
                        </div>
                        <div class="match-info">
                            <div class="match-title">
                                <h3>서울 송파 올림픽공원 축구장</h3>
                            </div>
                            <div class="match-option">
                                <span>☆남녀모두-</span>
                                <!-- <span>☆남자.</span> -->
                                <!-- <span>☆여자.</span> -->
                                <span>축구-</span>
                                <span>모든레벨</span>
                                <!-- <span>스타터</span> -->
                                <!-- <span>세미프로</span> -->
                            </div>
                        </div>
                        <div class="match-schedule-status">
                            <!-- 신청가능 -->
                            <!-- <div class="match-status isOpen">
                                <p>신청가능</p>
                            </div> -->

                            <!-- 마감임박! -->
                            <!-- <div class="match-status isHurry">
                                
                            </div> -->

                            <!-- 마감 -->
                            <div class="match-status isFull">
                                <p>마감</p>
                            </div>
                        </div>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="match-schedule-item">
                    <a>
                        <div class="match-time">
                            <p>20:00</p>
                        </div>
                        <div class="match-info">
                            <div class="match-title">
                                <h3>강원 강원FC 부설구장</h3>
                            </div>
                            <div class="match-option">
                                <span>☆남녀모두-</span>
                                <!-- <span>☆남자.</span> -->
                                <!-- <span>☆여자.</span> -->
                                <span>축구-</span>
                                <span>모든레벨</span>
                                <!-- <span>스타터</span> -->
                                <!-- <span>세미프로</span> -->
                            </div>
                        </div>
                        <div class="match-schedule-status">
                            <!-- 신청가능 -->
                            <!-- <div class="match-status isOpen">
                                <p>신청가능</p>
                            </div> -->

                            <!-- 마감임박! -->
                            <div class="match-status isHurry">
                                <p>마감임박!</p>
                            </div>

                            <!-- 마감 -->
                            <!-- <div class="match-status isFull">
                                
                            </div> -->
                        </div>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="match-schedule-item">
                    <a>
                        <div class="match-time">
                            <p>18:00</p>
                        </div>
                        <div class="match-info">
                            <div class="match-title">
                                <h3>경기 용인시 꿈나무 축구장</h3>
                            </div>
                            <div class="match-option">
                                <span>☆남자-</span>
                                <!-- <span>☆남자.</span> -->
                                <!-- <span>☆여자.</span> -->
                                <span>축구-</span>
                                <!-- <span>모든레벨</span> -->
                                <!-- <span>스타터</span> -->
                                <span>세미프로</span>
                            </div>
                        </div>
                        <div class="match-schedule-status">
                            <!-- 신청가능 -->
                            <div class="match-status isOpen">
                                <p>신청가능</p>
                            </div>

                            <!-- 마감임박! -->
                            <!-- <div class="match-status isHurry">
                                
                            </div> -->

                            <!-- 마감 -->
                            <!-- <div class="match-status isFull">
                                
                            </div> -->
                        </div>
                    </a>
                </li>
            </ul>
        </div>

        <div class="paging-area" align="center" style="margin: 50px;">
            <button class="btn btn-light" onclick="location.href=''">&lt;</button>
            <button class="btn btn-light" onclick="location.href=''">1</button>
            <button class="btn btn-light" onclick="location.href=''">2</button>
            <button class="btn btn-light" onclick="location.href=''">3</button>
            <button class="btn btn-light" onclick="location.href=''">&gt;</button>
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
              <form action="">
                  <p class="body-p">팀 정보를 <br>입력해주세요</p>
  
                  <div class="profile-imgbox">
                      <label for="file">
                          <div class="btn-upload"><img src="./em_K09.png" alt=""></div>
                      </label>
                      <input type="file" name="file" id="file">
                  </div>
  
                  <p class="madal-font">팀 이름</p>
                  <div class="input-group mb-3 input-group-lg">
                      <input type="text" class="form-control" placeholder="팀 이름을 작성해주세요">
                  </div>
                  <p class="madal-font">활동지역</p>
                  <div class="input-group mb-3 input-group-lg home-field-search">
                      <input type="text" class="form-control" placeholder="홈 구장 찾기">
                  </div>
                  <p class="userInfo-modal-font">성별</p>
                  <div class="btn-group-top" role="group" aria-label="Basic radio toggle button group">
                      <ul style="padding: 0px;">
                          <li class="">
                              <input type="checkbox" class="btn-checkX" name="gender" id="gender-all" autocomplete="off">
                              <label class="btn btn-checkX-label madal-label" for="gender-all">남녀 모두</label>
                          </li>
                          <li class="">
                              <input type="checkbox" class="btn-checkX" name="gender" id="gender-male" autocomplete="off">
                              <label class="btn btn-checkX-label madal-label" for="gender-male">남자</label>
                          </li>
                          <li class="">
                              <input type="checkbox" class="btn-checkX" name="gender" id="gender-female" autocomplete="off">
                              <label class="btn btn-checkX-label madal-label" for="gender-female">여자</label>
                          </li>
                      </ul>
                  </div>
                  <p class="userInfo-modal-font">좋아하는 스타일</p>
                  <div class="btn-group-top" role="group" aria-label="Basic radio toggle button group">
                      <ul style="padding: 0px;">
                          <li class="">
                              <input type="checkbox" class="btn-checkX" name="ability" id="ability-offence" autocomplete="off">
                              <label class="btn btn-checkX-label madal-label" for="ability-offence">공격</label>
                          </li>
                          <li class="">
                              <input type="checkbox" class="btn-checkX" name="ability" id="ability-balance" autocomplete="off">
                              <label class="btn btn-checkX-label madal-label" for="ability-balance">밸런스</label>
                          </li>
                          <li class="">
                              <input type="checkbox" class="btn-checkX" name="ability" id="ability-defence" autocomplete="off">
                              <label class="btn btn-checkX-label madal-label" for="ability-defence">수비</label>
                          </li>
                      </ul>
                  </div>
                  <p class="madal-font">레벨(중복가능)</p>
                  <div>
                      <div class="btn-group-top" role="group" aria-label="Basic radio toggle button group">
                          <ul>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="level" id="level-all" autocomplete="off">
                                  <label class="btn btn-checkX-label madal-label" for="level-all">실력무관</label>
                              </li>
                              <li>
                                  <input type="checkbox" class="btn-checkX" name="level" id="level-1" autocomplete="off">
                                  <label class="btn btn-checkX-label madal-label" for="level-1">스타터</label>
                              </li>
                              <li>
                                  <input type="checkbox" class="btn-checkX" name="level" id="level-2" autocomplete="off">
                                  <label class="btn btn-checkX-label madal-label" for="level-2">비기너</label>
                              </li>
                          </ul>
                          <ul>
                              <li>
                                  <input type="checkbox" class="btn-checkX" name="level" id="level-3" autocomplete="off">
                                  <label class="btn btn-checkX-label madal-label" for="level-3">아마추어</label>
                              </li>
                              <li>
                                  <input type="checkbox" class="btn-checkX" name="level" id="level-4" autocomplete="off">
                                  <label class="btn btn-checkX-label madal-label" for="level-4">세미프로</label>
                              </li>
                              <li>
                                  <input type="checkbox" class="btn-checkX" name="level" id="level-5" autocomplete="off">
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
                                  <input type="checkbox" class="btn-checkX" name="age" id="age-10" autocomplete="off">
                                  <label class="btn btn-checkX-label madal-label" for="age-10">10대</label>
                              </li>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="age" id="age-20" autocomplete="off">
                                  <label class="btn btn-checkX-label madal-label" for="age-20">20대</label>
                              </li>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="age" id="age-30" autocomplete="off">
                                  <label class="btn btn-checkX-label madal-label" for="age-30">30대</label>
                              </li>
                          </ul>
                          <ul>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="age" id="age-40" autocomplete="off">
                                  <label class="btn btn-checkX-label madal-label" for="age-40">40대</label>
                              </li>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="age" id="age-50" autocomplete="off">
                                  <label class="btn btn-checkX-label madal-label" for="age-50">50대</label>
                              </li>
                              <li class="">
                                  <input type="checkbox" class="btn-checkX" name="age" id="age-60" autocomplete="off">
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
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                          축구
                        </button>
                      </h2>
                      <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <a href="${pageContext.request.contextPath}/teamProfile.tm">
                                <img src="./resources/images/sonny2.jpg" alt="">
                                <p>기만FC</p>
                            </a>
                            <a href="">
                                <img src="./resources/images/liverpool.png" alt="">
                                <p>기만유나이티드</p>
                            </a>
                            <!-- 가입 신청 내역(고정) -->
                            <a href="">
                                <img src="./resources/images/makingteams.png" alt="">
                                <p>가입 신청 내역</p>
                            </a>
                        </div>
                      </div>
                    </div>
                    <div class="accordion-item">
                      <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                          야구
                        </button>
                      </h2>
                      <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                          <a href="">
                              <img src="./resources/images/human_img.png" alt="">
                              <p>LG쌍둥이둥이</p>
                          </a>
                          <!-- 가입 신청 내역(고정) -->
                          <a href="">
                            <img src="./resources/images/makingteams.png" alt="">
                            <p>가입 신청 내역</p>
                        </a>
                        </div>
                      </div>
                    </div>
                    <div class="accordion-item">
                      <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                          농구
                        </button>
                      </h2>
                      <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <a href="">
                                <img src="./resources/images/human_img.png" alt="">
                                <p>파주레이커스</p>
                            </a>
                            <!-- 가입 신청 내역(고정) -->
                            <a href="">
                              <img src="./resources/images/makingteams.png" alt="">
                              <p>가입 신청 내역</p>
                          </a>
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

    <script>
        function initCalendar() {
        const calendarContainer = document.getElementById('calendar2');
        const daysOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
        const today = new Date();
        let selectedDay = today;

        function updateCalendar() {
            calendarContainer.innerHTML = '';

            for (let i = 0; i < 7; i++) {
                const day = new Date(selectedDay);
                day.setDate(selectedDay.getDate() - selectedDay.getDay() + i);

                const dayElement = document.createElement('div');
                dayElement.classList.add('day');
                if (i === today.getDay() && day.getDate() === today.getDate()) {
                    dayElement.classList.add('current-day');
                }

                const dayOfWeekElement = document.createElement('div');
                dayOfWeekElement.innerText = daysOfWeek[i];
                // 색상 스타일 추가
                if (i === 0) {
                    dayOfWeekElement.classList.add('sunday');
                    dayElement.classList.add('sunday');
                } else if (i === 6) {
                    dayOfWeekElement.classList.add('saturday');
                    dayElement.classList.add('saturday');
                }

                const dateElement = document.createElement('div');
                dateElement.innerText = day.getDate();

                dayElement.appendChild(dayOfWeekElement);
                dayElement.appendChild(dateElement);

                dayElement.addEventListener('click', function () {
                    document.querySelector('.current-day').classList.remove('current-day');
                    dayElement.classList.add('current-day');
                    selectedDay = day;
                    
                    ajaxEventCalenderImage(day.getFullYear(), day.getMonth()+1, day.getDate(), 1);
                });

                calendarContainer.appendChild(dayElement);
            }
        }

        updateCalendar();
    }

    initCalendar();
    </script>
	<jsp:include page="common/footer.jsp" />
</body>
</html>