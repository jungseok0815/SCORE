<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/place/placeDetailView.css">
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
                    <div>
                        <a href="">다음 일정을 미리 예약하세요</a>
                    </div>
                    <div>
                        <button class="btn btn-secondary">신청마감</button>
                    </div>
                </div>

            </div>
        </section>
    </div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>