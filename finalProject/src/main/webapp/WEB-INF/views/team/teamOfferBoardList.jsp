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
	                        <li class="btnLocal">
	                            <input type="radio" name="local" id="all"><label for="all">전체</label>
	                        </li>
	                        <li class="btnLocal">
	                            <input type="radio" name="local" id="seoul"><label for="seoul">서울</label>
	                        </li>
	                        <li class="btnLocal">
	                            <input type="radio" name="local" id="incheon"><label for="incheon">인천</label>
	                        </li>
	                        <li class="btnLocal">
	                            <input type="radio" name="local" id="deagu"><label for="deagu">대구</label>
	                        </li>
	                        <li class="btnLocal">
	                            <input type="radio" name="local" id="busan"><label for="busan">부산</label>
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
	
	
	                        </ul> 
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>