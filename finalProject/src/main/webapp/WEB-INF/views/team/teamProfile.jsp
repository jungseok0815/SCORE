<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/team/teamProfile.css">

</head>
<body>	
	<jsp:include page="../common/header.jsp" />	
	<div class="content-wrap">
        <div class="content-body-double">
            <!-- 팀프로필 보여주는 부분(왼쪽) -->
            <div class="content-body-left">
                <section>
                    <div class="profile">
                        <div class="profile-container" style="display: flex; width: 100%;">
                            <div class="profile-info">
                                <div class="team-profile-info">
                                    <p class="team-profile-name">승2FC</p>
                                    <p class="team-profile-stadium">
                                        <a href="">배재고등학교축구장</a>
                                    </p>
                                    <p class="team-profile-addInfo">서울 강동구</p>
                                    <p class="team-profile-addInfo"> 남자・10대~30대・아마추어</p>
                                </div>
                            </div>
                            <div class="profile-image">
                                <div>
                                    <img class="profile-photo" src="./resources/img/team/teamProfile/liverpool.png" alt="">
                                </div>
                            </div>
                        </div>
                        <div class="profile-btn d-grid gap-2">
                            <button class="btn btn-outline-secondary" onclick="location.href='${pageContext.request.contextPath}/teamProfileUpdate.jsp'";>
                                프로필 설정
                            </button>
                        </div>
                    </div>
                </section>
            </div>
            <div class="content-body-right">
                <section>
                    <div class="section-header">
                        <div class="friend-nav">
                            <!-- 클릭되면 friend-tab-focused 클래스 추가되게 -->
                            <div class="friend-tab friend-tab-focused">
                                <p>오버뷰</p>
                            </div>
                            <div class="friend-tab">
                                <p>멤버</p>
                            </div>
                        </div>
                    </div>
                    <!-- team 태그는 멤버를 클릭할 시에 display:none으로 바뀌어야 함 -->
                    <div class="team-overview">
                        <section class="section">
                            <div class="section-header">
                                <div class="section-title">팀 정보</div>
                            </div>
                            <div class="section-body">
                                <div class="team-preview-wrapper">
                                    <div class="team-preview-list">
                                        <img class="team-preview-list-icon" src="./resources/img/team/teamProfile/location.png" alt="">
                                        <span class="team-preview-list-title">지역</span>
                                        <span class="team-preview-list-value team-preview-list-value-blue">서울 강동구</span>
                                    </div>
                                    <div class="team-preview-list">
                                        <img class="team-preview-list-icon" src="./resources/img/team/teamProfile/home.png" alt="">
                                        <span class="team-preview-list-title">홈 경기장</span>
                                        <span class="team-preview-list-value team-preview-list-value-blue">배재고등학교축구장</span>
                                    </div>
                                    <div class="team-preview-list">
                                        <img class="team-preview-list-icon" src="./resources/img/team/teamProfile/timer.png" alt="">
                                        <span class="team-preview-list-title">모임 시간</span>
                                        <span class="team-preview-list-value">주말 낮</span>
                                    </div>
                                    <div class="team-preview-list">
                                        <img class="team-preview-list-icon" src="./resources/img/team/teamProfile/average.png" alt="">
                                        <span class="team-preview-list-title">평균 나이</span>
                                        <span class="team-preview-list-value">27세</span>
                                    </div>
                                    <div class="team-preview-list">
                                        <img class="team-preview-list-icon" src="./resources/img/team/teamProfile/teamate.png" alt="">
                                        <span class="team-preview-list-title">멤버</span>
                                        <span class="team-preview-list-value">5명</span>
                                    </div>
                                    <div class="team-preview-list">
                                        <img class="team-preview-list-icon" src="./resources/img/team/teamProfile/star.png" alt="">
                                        <span class="team-preview-list-title">레벨</span>
                                        <span class="team-preview-list-value">아마추어</span>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>

                    <div class="team-member" style="display: none">
                        <ul>
                            <li>
                                <div class="team-member-item">
                                    <a class="team-member-profile" href="">
                                        <img class="team-member-profile-img" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/img_profile_default.png">
                                        <div class="team-member-profile-info">
                                            <div class="team-member-profile-info-wrapper">
                                                <p class="team-member-profile-info-name">
                                                    김귀만
                                                </p>
                                                <div class="team-member-profile-info-label">
                                                    <span>
                                                        운영진
                                                    </span>
                                                </div>
                                            </div>
                                            <span class="team-member-profile-info-address">
                                                경기 구리시
                                            </span>
                                        </div>
                                    </a>
                                    <div>
                                        <img src="">
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <ul>
                            <li>
                                <div class="team-member-item">
                                    <a class="team-member-profile" href="">
                                        <img class="team-member-profile-img" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/img_profile_default.png">
                                        <div class="team-member-profile-info">
                                            <div class="team-member-profile-info-wrapper">
                                                <p class="team-member-profile-info-name">
                                                    윤구진
                                                </p>
                                                <div class="team-member-profile-info-label">
                                                    <span>
                                                        운영진
                                                    </span>
                                                </div>
                                            </div>
                                            <span class="team-member-profile-info-address">
                                                경기 군포시
                                            </span>
                                        </div>
                                    </a>
                                    <div>
                                        <img class="team-member-profile-info-img" src="./resources/img/team/teamProfile/dotted-barline.png">
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <ul>
                            <li>
                                <div class="team-member-item">
                                    <a class="team-member-profile" href="">
                                        <img class="team-member-profile-img" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/img_profile_default.png">
                                        <div class="team-member-profile-info">
                                            <div class="team-member-profile-info-wrapper">
                                                <p class="team-member-profile-info-name">
                                                    임두현
                                                </p>
                                                <div class="team-member-profile-info-label">
                                                    <span>
                                                        멤버
                                                    </span>
                                                </div>
                                            </div>
                                            <span class="team-member-profile-info-address">
                                                경북 의성시
                                            </span>
                                        </div>
                                    </a>
                                    <div>
                                        <img class="team-member-profile-info-img" src="./resources/img/team/teamProfile/dotted-barline.png">
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <ul>
                            <li>
                                <div class="team-member-item">
                                    <a class="team-member-profile" href="">
                                        <img class="team-member-profile-img" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/img_profile_default.png">
                                        <div class="team-member-profile-info">
                                            <div class="team-member-profile-info-wrapper">
                                                <p class="team-member-profile-info-name">
                                                    차성적
                                                </p>
                                                <div class="team-member-profile-info-label">
                                                    <span>
                                                        멤버
                                                    </span>
                                                </div>
                                            </div>
                                            <span class="team-member-profile-info-address">
                                                경기 시흥시
                                            </span>
                                        </div>
                                    </a>
                                    <div>
                                        <img class="team-member-profile-info-img" src="./resources/img/team/teamProfile/dotted-barline.png">
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </section>
            </div>
        </div>
    </div>

    <script>
        // window.onload를 사용하여 전체 문서가 로드된 후에 실행
        window.onload = function () {
            // 멤버 탭을 클릭할 때의 동작
            document.querySelector('.friend-tab:nth-child(2)').addEventListener('click', function () {
                this.classList.add('friend-tab-focused');
                document.querySelector('.friend-tab:nth-child(1)').classList.remove('friend-tab-focused');
                document.querySelector('.team-overview').style.display = 'none';
                document.querySelector('.team-member').style.display = 'block';
            });

            // 오버뷰 탭을 클릭할 때의 동작
            document.querySelector('.friend-tab:nth-child(1)').addEventListener('click', function () {
                this.classList.add('friend-tab-focused');
                document.querySelector('.friend-tab:nth-child(2)').classList.remove('friend-tab-focused');
                document.querySelector('.team-overview').style.display = 'block';
                document.querySelector('.team-member').style.display = 'none';
            });
        };
    </script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>