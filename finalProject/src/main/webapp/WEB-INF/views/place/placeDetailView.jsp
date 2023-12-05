<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/place/placeDetailView.css">
<script src="/final/resources/js/place/placeDetailView.js"></script>
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
                                    <p>모든 레벨</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_gender.svg" class="icon">
                                <div>
                                    <p>남녀모두</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_stadium.svg" class="icon">
                                <div>
                                    <p>6vs6 3파전</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_max_player_cnt.svg" class="icon">
                                <div>
                                    <p>10~18명</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_shoes.svg" class="icon">
                                <div>
                                    <p>풋살화/운동화</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_park.svg" alt="유료주차" class="icon">
                                <div>
                                    <p>무료 주차</p>
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
                                <p>최지원 매니저가 진행해요</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="body_right section_div">
                    <p>11월 21일 화요일 22:00</p>
                    <h1>서울 영등포 SKY 풋살파크 A구장</h1>
                    <span>서울시 영등포구 선유로 43길 19<h6><a>주소복사</a><a>지도보기</a></h6></span>
                    <br>
                    <div class="body_right_count_like">
                        <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_viewer.svg">
                        <p>150회</p>
                        <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_bookmark_filled.svg">
                        <p>23개</p>
                    </div>
                    <hr>
                    <h1 class="body_right_pay">12,000</h1><h6 class="body_right_pay">/2시간</h6>
                    <hr>
                    <div class="body_right_btn_div">
                        <div>
                            <!-- 신청 여부에 따라 멘트 조정
                            <a href="">다음 일정을 미리 예약하세요</a>
                            <p>마감까지 7자리남았어요</p>-->
                            <p>지금 신청하면<br>진행 확정이 빨라져요!</p>
                        </div>
                        <div>
                            <!-- 신청 여부에 따라 버튼 조정-->
                            <button class="btn btn-primary" data-bs-target="#matchUpModal" data-bs-toggle="modal">신청하기</button>
                            <!--
                            <button class="btn btn-secondary">신청마감</button>
                            -->
                        </div>
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