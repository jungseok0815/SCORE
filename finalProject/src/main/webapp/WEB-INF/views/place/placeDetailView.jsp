<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/place/placeDetailView.css">
<script src="/final/resources/js/place/placeDetailView.js"></script>
<script src="/final/resources/js/place/placeAjax/placeAjax.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body onload="init()">
	<jsp:include page="../common/header.jsp" />
	<div class="outer">
        <div class="slider">
            <div class="slide">
                <img src="https://d31wz4d3hgve8q.cloudfront.net/media/stadium_01_gasan.jpg" alt="플랩 스타디움 가산 마리오 단일 구장">
            </div>
            <div class="slide">
                <img src="https://d31wz4d3hgve8q.cloudfront.net/media/stadium_02_gasan.jpg" alt="">
            </div>
        </div>
        <section>
            <div class="section_body">
                <div class="section_div body_left">
                    <div class="section_header">
                        <h3>매치 포인트</h3>
                    </div>
                    <div>
                        <ul>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_level.svg" class="icon">
                                <div>
                                    <p>${pl.matchLevel}</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_gender.svg" class="icon">
                                <div>
                                  <c:choose> 
                                    <c:when test="${pl.matchGender eq 1}">
                                      <p>남자만</p>
                                    </c:when> 
                                    <c:when test="${pl.matchGender eq 2}">
                                      <p>여자만</p>
                                    </c:when> 
                                    <c:otherwise>
                                      <p>남녀모두</p>
                                    </c:otherwise> 
                                  </c:choose> 
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_stadium.svg" class="icon">
                                <div>
                                    <p>${pl.matchType}</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_max_player_cnt.svg" class="icon">
                                <div>
                                    <p>${pl.fieldCount}</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_shoes.svg" class="icon">
                                <div>
                                    <p>${pl.shoes}</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_park.svg" alt="유료주차" class="icon">
                                <div>
                                  <c:choose> 
                                    <c:when test="${pl.parking eq 1}">
                                      <p>무료 주차</p>
                                    </c:when> 
                                    <c:when test="${pl.parking eq 2}">
                                      <p>유료 주차</p>
                                    </c:when> 
                                    <c:otherwise>
                                      <p>주차장 없음</p>
                                    </c:otherwise> 
                                  </c:choose> 
                                </div>
                            </li>
                        </ul>
                    </div>
                    <hr>
                    <div>
                        <ul>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_fire.svg" class="icon">
                                <p>아직 여자플레이어가 0명이에요</p>
                            </li>
                            <br>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_manager.svg" class="icon">
                                <p>${pl.manager} 매니저가 진행해요</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="body_right section_div">
                    <p>${pl.fieldDate} ${pl.startTime}</p>
                    <h1>${pl.fieldName}</h1>
                    <span>${pl.fieldArea}<h6><a>주소복사</a><a>지도보기</a></h6></span>
                    <br>
                    <hr>
                    <h1 class="body_right_pay">${matchPay}</h1><h6 class="body_right_pay">/2시간</h6>
                    <hr>
                    <div class="body_right_btn_div">
                      <c:choose> 
                        <c:when test="${pl.fieldCount-resCount le 5}">
                          <p>마감까지 ${pl.fieldCount-resCount}자리남았어요.</p>
                          <button class="btn btn-primary" data-bs-target="#matchUpModal" data-bs-toggle="modal" onclick="loadTeam('${loginUser.userNo}')">신청하기</button>
                        </c:when> 
                        <c:when test="${pl.fieldCount-resCount le 0}">
                          <p>현재 이 경기는 마감되었습니다.</p>
                          <button class="btn btn-secondary" id="soldoutBtn">신청마감</button>
                        </c:when> 
                        <c:otherwise>
                          <p>지금 신청하면<br>진행 확정이 빨라져요!</p>
                          <button class="btn btn-primary" data-bs-target="#matchUpModal" data-bs-toggle="modal" onclick="loadTeam('${loginUser.userNo}','${pl.categoryNum}')">신청하기</button>
                          </c:otherwise> 
                      </c:choose>
                    </div>
                </div>

            </div>
        </section>
    </div>

    <!-- 팀 리스트 모달-->
    <div class="modal fade" id="matchUpModal" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
              <!-- <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
            <div class="modal-body">
                <div class="accordion" id="accordionExample">
                    <div class="accordion-item">
                      <h2 class="accordion-header">
                        <button type="button" class="match-solo-btn">
                            개인 신청
                        </button>
                        <button class="accordion-button match-team-btn collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                            <span>팀별 신청</span>
                        </button>
                      </h2>
                      <div id="collapseOne" class="accordion-collapse collapse collapse" data-bs-parent="#accordionExample">
                        <div class="accordion-body choice-team-body">
                          <button class="choice-team" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">
                            <img src="./토트넘_홋스퍼_FC_로고.svg.png" alt="">
                            <label>토트넘 홋스퍼</label>
                          </button>
                        </div>
                        <div class="accordion-body choice-team-body">
                          <button class="choice-team" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">
                            <img src="./em_K09.png" alt="">
                            <label>FC 정석</label>
                          </button>
                        </div>
                      </div>
                    </div>
                    
                  </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 팀원 리스트 모달-->
      <div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalToggleLabel2">팀원</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="">
              <div class="modal-body">
                <div class="team-member">
                  <img src="./person.png" alt="">
                  <div>
                    <span>김기만</span><p>경기도 구리시</p>
                  </div>
                  <input type="checkbox" name="" id="">
                </div>
                <div class="team-member">
                  <img src="./person.png" alt="">
                  <div>
                    <span>김기만</span><p>경기도 구리시</p>
                  </div>
                  <input type="checkbox" name="" id="">
                </div>
                <div class="team-member">
                  <img src="./person.png" alt="">
                  <div>
                    <span>김기만</span><p>경기도 구리시</p>
                  </div>
                  <input type="checkbox" name="" id="">
                </div>
              </div>
              <div class="modal-footer">
                <button class="btn btn-primary" type="submit">신청</button>
              </div>
            </form>
          </div>
        </div>
      </div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>