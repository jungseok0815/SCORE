<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/final/resources/css/team/teamOfferBoardList.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
		 <div class="main">
	        <div class="all"> 
	            <div class="topWrapper">
	                <div class="top_container">
	                    <ul>
	                        <li class="btnAll">
	                            <span>전체</span>
	                        </li>
	                        <li class="btnLocal">
	                            <span>서울</span>
	                        </li>
	                        <li class="btnLocal">
	                            <span>인천</span>
	                        </li>
	                        <li class="btnLocal">
	                            <span>대구</span>
	                        </li>
	                        <li class="btnLocal">
	                            <span>부산</span>
	                        </li>
	                    </ul> 
	                </div>
	
	                <div class="team-list">
	                    <div class="team-list-container">
	                        <ul>
	                            <li class="team-list-item">
	                                <a href="${pageContext.request.contextPath}/offerDetailView.tm" class="list-link" >
	                                    <div class="list-img-all">
	                                        <img src="./resources/img/team/teamOfferBoardList/arsenal.jpg"  class="list-img"/>
	                                    </div>
	                                    <div class="list-content">
	                                        <div class="list-title">
	                                            <span class="TimeName">아스날FC</span>
	                                            <span class="memberListCount"><img src="./resources/img/team/teamOfferBoardList/memberIcon.png"  class="list-member-img"/>20</span>
	                                            <span class="memberPosting">멤버모집</span>
	                                        </div>
	                                        <span class="list-local">서울시 강남구</span>
	                                        <span class="list-member">남녀 모두 · 20~30대 · 아마추어3</span>
	                                    </div>
	                                </a>
	                            </li>
	
	                            <li class="team-list-item">
	                                <a href="${pageContext.request.contextPath}/offerDetailView.tm" class="list-link">
	                                    <div class="list-img-all">
	                                        <img src="./resources/img/team/teamOfferBoardList/re.jpg" class="list-img"/>
	                                    </div>
	                                    <div class="list-content">
	                                        <div class="list-title">
	                                            <span class="TimeName">리버풀FC</span>
	                                            <span class="memberListCount"><img src="./resources/img/team/teamOfferBoardList/memberIcon.png"  class="list-member-img"/>15</span>
	                                            <span class="memberPosting">멤버모집</span>
	                                        </div>
	                                        <span class="list-local">서울시 강남구</span>
	                                        <span class="list-member">남녀 모두 · 20~30대 · 아마추어3</span>
	                                    </div>
	                                </a>
	                            </li>
	
	                            <li class="team-list-item">
	                                <a href="${pageContext.request.contextPath}/offerDetailView.tm" class="list-link">
	                                    <div class="list-img-all">
	                                        <img src="./resources/img/team/teamOfferBoardList/menU.jpg" class="list-img"/>
	                                    </div>
	                                    <div class="list-content">
	                                        <div class="list-title">
	                                            <span class="TimeName">맨유FC</span>
	                                            <span class="memberListCount"><img src="./resources/img/team/teamOfferBoardList/memberIcon.png"  class="list-member-img"/>13</span>
	                                            <span class="memberPosting">멤버모집</span>
	                                        </div>
	                                        <span class="list-local">서울시 강남구</span>
	                                        <span class="list-member">남녀 모두 · 20~30대 · 아마추어3</span>
	                                    </div>
	                                </a>
	                            </li>
	
	                            <li class="team-list-item">
	                                <a href="${pageContext.request.contextPath}/offerDetailView.tm" class="list-link">
	                                    <div class="list-img-all">
	                                        <img src="./resources/img/team/teamOfferBoardList/oulbe.png" class="list-img"/>
	                                    </div>
	                                    <div class="list-content">
	                                        <div class="list-title">
	                                            <span class="TimeName">울버햄튼FC</span>
	                                            <span class="memberListCount"><img src="./resources/img/team/teamOfferBoardList/memberIcon.png"  class="list-member-img"/>3</span>
	                                            <span class="memberPosting">멤버모집</span>
	                                        </div>
	                                        <span class="list-local">서울시 강남구</span>
	                                        <span class="list-member">남녀 모두 · 20~30대 · 아마추어3</span>
	                                    </div>
	                                </a>
	                            </li>
	
	                            <li class="team-list-item">
	                                <a href="${pageContext.request.contextPath}/offerDetailView.tm" class="list-link">
	                                    <div class="list-img-all">
	                                        <img src="./resources/img/team/teamOfferBoardList/totunum.png" class="list-img"/>
	                                    </div>
	                                    <div class="list-content">
	                                        <div class="list-title">
	                                            <span class="TimeName">토트넘FC</span>
	                                            <span class="memberListCount"><img src="./resources/img/team/teamOfferBoardList/memberIcon.png"  class="list-member-img"/>30</span>
	                                            <span class="memberPosting">멤버모집</span>
	                                        </div>
	                                        <span class="list-local">서울시 강남구</span>
	                                        <span class="list-member">남녀 모두 · 20~30대 · 아마추어3</span>
	                                    </div>
	                                </a>
	                            </li>
	                        </ul> 
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>