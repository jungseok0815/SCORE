<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/team/teamProfile.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="resources/js/team/teamJs/teamProfile.js"></script>
<script src="resources/js/team/teamAjax/teamProfileAjax.js"></script>

</head>
<body onload="init()">	
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
                                    <p class="team-profile-name">${team.teamName}</p>
                                    <p class="team-profile-stadium">
                                        <a href="">홈 경기장이 없습니다</a>
                                    </p>
                                    <p class="team-profile-addInfo">${team.activityAtea}</p>
                                    <p class="team-profile-addInfo"> ${team.teamGender}・${team.teamUserAge}・${team.teamLevel}</p>
                                </div>
                            </div>
                            <div class="profile-image">
                                <div>
                                    <img class="profile-photo" src="./resources/img/team/teamProfile/liverpool.png" alt="">
                                </div>
                            </div>
                        </div>
                        <c:choose>
                            <!-- 로그인한 유저가 주장일 때 보여주는 버튼(팀 생성자) -->
                            <c:when test="${myGrade eq 3}">
                                <div class="profile-btn d-grid gap-2">
                                    <button class="btn btn-outline-secondary" onclick="location.href='${pageContext.request.contextPath}/updateForm.tm'">
                                        팀 프로필 설정
                                    </button>
                                </div>
                                <div class="profile-btn d-grid gap-2">
                                    <button class="btn btn-outline-secondary" onclick="location.href='${pageContext.request.contextPath}/joinList.tm'">
                                        가입신청 보기
                                    </button>
                                </div>
                                <div class="profile-btn d-grid gap-2">
                                    <button class="btn btn-outline-secondary" onclick="location.href='${pageContext.request.contextPath}/insertTeamOfferForm.tm'">
                                        구인글 작성
                                    </button>
                                </div>
                                <div class="profile-btn d-grid gap-2">
                                    <button class="btn btn-outline-danger" onclick="">
                                        팀 해체
                                    </button>
                                </div>
                            </c:when>
                            <!-- 로그인한 유저가 일반 멤버일 때 보여주는 버튼(운영진, 멤버) -->
                            <c:otherwise>
                                <div class="profile-btn d-grid gap-2">
                                    <button class="btn btn-outline-danger" onclick="">
                                        팀 탈퇴
                                    </button>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </section>
            </div>
            <div class="content-body-right">
                <section>
                    <div class="section-header">
                        <div class="friend-nav">
                            <!-- 클릭되면 friend-tab-focused 클래스 추가되게 -->
                            <div class="overview-tab">
                                <p id="overview" onclick="overviewView()">오버뷰</p>
                            </div>
                            <div class="member-tab">
                                <p id="member" onclick="memberView()">멤버</p>
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
                                        <span class="team-preview-list-value team-preview-list-value-blue">${team.activityAtea}</span>
                                    </div>
                                    <!-- 지도로 설정할 지 api로 할지 아직 모름 -->
                                    <div class="team-preview-list">
                                        <img class="team-preview-list-icon" src="./resources/img/team/teamProfile/home.png" alt="">
                                        <span class="team-preview-list-title">홈 경기장</span>
                                        <span class="team-preview-list-value team-preview-list-value-blue">없음</span>
                                    </div>
                                    <div class="team-preview-list">
                                        <img class="team-preview-list-icon" src="./resources/img/team/teamProfile/average.png" alt="">
                                        <span class="team-preview-list-title">평균 나이</span>
                                        <span class="team-preview-list-value">${teamAvgAge}세</span>
                                    </div>
                                    <div class="team-preview-list">
                                        <img class="team-preview-list-icon" src="./resources/img/team/teamProfile/teamate.png" alt="">
                                        <span class="team-preview-list-title">멤버</span>
                                        <span class="team-preview-list-value">${teamMemberCount}명</span>
                                    </div>
                                    <div class="team-preview-list">
                                        <img class="team-preview-list-icon" src="./resources/img/team/teamProfile/star.png" alt="">
                                        <span class="team-preview-list-title">레벨</span>
                                        <span class="team-preview-list-value">${team.teamLevel}</span>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                    <!-- 팀 멤버를 보여주는 곳(오른쪽) -->
                    <div class="team-member" style="display: none">
                        <c:forEach var="list" items="${teamMemberList}">
                            <ul>
                                <li>
                                    <div class="team-member-item">
                                        <a class="team-member-profile" type="button">
                                            <img class="team-member-profile-img" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/img_profile_default.png">
                                            <div class="team-member-profile-info">
                                                <div class="team-member-profile-info-wrapper">
                                                    <p class="team-member-profile-info-name">
                                                        ${list.userName}
                                                    </p>
                                                    <c:choose>
                                                        <c:when test = "${list.grade eq 3}">
                                                            <div class="team-member-profile-info-label">
                                                                <span>
                                                                    주장
                                                                </span>
                                                            </div>
                                                        </c:when>
                                                        <c:when test = "${list.grade eq 2}">
                                                            <div class="team-member-profile-info-label">
                                                                <span>
                                                                    운영진
                                                                </span>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="team-member-profile-info-label">
                                                                <span>
                                                                    멤버
                                                                </span>
                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </a>
                                        <div>
                                            <c:if test="${loginUser.userNo != list.userNo}">
                                                <img class="team-member-profile-info-img" 
                                                src="./resources/img/team/teamProfile/dotted-barline.png"
                                                data-bs-toggle="modal" data-bs-target="#manage-status${list.userNo}">
                                            </c:if>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                            <!-- 멤버 상태 관리 모달 -->
                            <div class="modal fade" id="manage-status${list.userNo}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">${list.userName}</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <!-- 로그인한 유저가 주장일 때(팀생성한 사람) -->
                                            <c:if test="${myGrade eq 3}">
                                                <div class="d-grid gap-2">
                                                    <button class="btn btn-outline-secondary" type="button">친구신청</button>
                                                    <!-- <button class="btn btn-outline-secondary" type="button">친구신청 취소</button> -->
                                                        <c:choose>
                                                            <c:when test="${list.grade ne 1}">
                                                                <button class="btn btn-outline-secondary" type="button">일반멤버로 변경</button>
                                                            </c:when>
                                                            <c:when test="${list.grade ne 2}">
                                                                <button class="btn btn-outline-secondary" type="button">운영진으로 추가</button>
                                                            </c:when>
                                                        </c:choose>
                                                    <button class="btn btn-outline-secondary" type="button">연락처 복사</button>
                                                    <button class="btn btn-outline-danger" type="button">강제 퇴장</button>
                                                </div>
                                            </c:if>
                                            <!-- 로그인한 유저가 운영진일 때 -->
                                            <c:if test="${myGrade eq 2}">
                                                <div class="d-grid gap-2">
                                                    <button class="btn btn-outline-secondary" type="button">친구신청</button>
                                                    <!-- <button class="btn btn-outline-secondary" type="button">친구신청 취소</button> -->
                                                    <button class="btn btn-outline-secondary" type="button">연락처 복사</button>
                                                    <c:if test="${ list.grade eq 1 }">
                                                        <button class="btn btn-outline-danger" type="button">강제 퇴장</button>
                                                    </c:if>
                                                </div>
                                            </c:if>
                                            <!-- 로그인한 유저가 일반 멤버일 때 -->
                                            <c:if test="${myGrade eq 1}">
                                                <div class="d-grid gap-2">
                                                    <button class="btn btn-outline-secondary" type="button">친구신청</button>
                                                    <!-- <button class="btn btn-outline-secondary" type="button">친구신청 취소</button> -->
                                                    <button class="btn btn-outline-secondary" type="button">연락처 복사</button>
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </section>
            </div>
        </div>
    </div>

    
	<jsp:include page="../common/footer.jsp" />
</body>
</html>