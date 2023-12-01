<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/common/main.css">

</head>
<body>
	<jsp:include page="common/header.jsp" />
	<div class="outer">
        <!-- 네비게이터 (소셜매치 팀관리 구장등록) -->
        <div class="nav-container">
            <div class="nav-wrapper">
                <div class="nav-item"><a href="" class="selected">소셜매치</a></div>
                <div class="nav-item"><a href="" class="">팀관리</a></div>
                <div class="nav-item"><a href="" class="">구장등록</a></div>
            </div>
        </div>
    
        <!-- 공지사항, 포인트충전, 팀 구인, 팀 생성으로 가는 태그 -->
        <div class='explore-container'>
            <div class="explore-wrapper">
                <div class="explore-item">
                    <a href="">
                        <img src="./resources/img/main/notice.img.png" alt="">
                        <p>공지사항</p>
                    </a>
                    <a href="">
                        <img src="./resources/img/main/coin.png" alt="">
                        <p>포인트 충전</p>
                    </a>
                    <a href="">
                        <img src="./resources/img/main/thunder.png" alt="">
                        <p>팀 구인</p>
                    </a>
                    <a href="">
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
        <div class="choice-sports">
            <div class="baseball-btn">
                <a href="">
                    <img class="baseball-img"src="./resources/img/main/bb_img.png" alt="">
                    <p>Baseball</p>
                </a>
            </div>
            <div class="football-btn">
                <a href="">
                    <img class="sports-img" src="./resources/img/main/soccerImg.png" alt="">
                    <p>Football</p>
                </a>
            </div>
            <div class="basketball-btn">
                <a href="">
                    <img class="sports-img" src="./resources/img/main/basketballImg.png" alt="">
                    <p>Basketball</p>
                </a>
            </div>
        </div>

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
                        <li class="on" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            <span>지역</span>
                            <img class="filter-item-arrow" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_filter_arrow_selected.svg" alt="">
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">지역</h1>
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
                                            ☆남녀모두
                                        </div>
                                        <div class="modal-body">
                                            남자
                                        </div>
                                        <div class="modal-body">
                                            여자
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
                    <a>
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
            <button class="btn btn-light" onclick="location.href=''">4</button>
            <button class="btn btn-light" onclick="location.href=''">5</button>
            <button class="btn btn-light" onclick="location.href=''">&gt;</button>
        </div>

    </div>

    <!-- <script>
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
    </script> -->
	<jsp:include page="common/footer.jsp" />
</body>
</html>