<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/final/resources/css/team/teamOfferBoardList.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="resources/js/team/teamJs/teamOfferBoardList.js"></script>
	<script src="resources/js/team/teamAjax/teamOfferBoardListAjax.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
		 <div class="main">
	        <div class="all">
	         
	    <div class="choice-sports">
	        <div onclick="choiceSports(2)" class="baseball-btn">
	            <img class="baseball-img"src="./resources/img/main/bb_img.png" alt="">
	            <p>Baseball</p>
	        </div>
	        <div onclick="choiceSports(1)" class="football-btn">
	            <img class="sports-img" src="./resources/img/main/soccerImg.png" alt="">
	            <p>Football</p>
	        </div>
	        <div onclick="choiceSports(3)" class="basketball-btn">
	            <img class="sports-img" src="./resources/img/main/basketballImg.png" alt="">
	            <p>Basketball</p>
	        </div>
	   </div>
	   <br>
    
			  
	            <div class="topWrapper">
	                <div class="top_container">
	                    <ul>
	                        <li class="btnLocal">
	                            <input type="radio" name="local" id="all" value="all" onclick="choiceCity()" checked><label for="all">전체</label>
	                        </li>
	                        <li class="btnLocal">
	                            <input type="radio" name="local" id="seoul"  value="서울" onclick="choiceCity()"><label for="seoul">서울</label>
	                        </li>
	                        <li class="btnLocal">
	                            <input type="radio" name="local" id="incheon" value="인천" onclick="choiceCity()"><label for="incheon">인천</label>
	                        </li>
	                        <li class="btnLocal">
	                            <input type="radio" name="local" id="deagu" value="대구" onclick="choiceCity()" ><label for="deagu">대구</label>
	                        </li>
	                        <li class="btnLocal">
	                            <input type="radio" name="local" id="busan" value="부산" onclick="choiceCity()" ><label for="busan">부산</label>
	                        </li>
	                    </ul> 
	                </div>

	                <div class="team-list" id="commenttable">
	                    <div class="team-list-container">
	                        <ul>
	                            <li class="team-list-item">
	                            <c:forEach var="t" items="${list}"> 
	                                <a onclick="location.href='offerDetailView.tm?tno=${t.offerNo}'" class="list-link" >
	                                    <div class="list-img-all">
	                                        <img src="${t.teamChangeName}"  class="list-img"/>
	                                    </div>
	                                    <div class="list-content">
	                                        <div class="list-title">
	                                            <span class="TimeName">${t.teamName}</span>
	                                            <span class="memberListCount"><img src="./resources/img/team/teamOfferBoardList/memberIcon.png"  class="list-member-img"/>${t.offerCount}</span>
	                                            <span class="memberPosting">${t.offerTitle}</span>
	                                        </div>
	                                        <span class="list-local">${t.activityAtea}</span>
	                                        <span class="list-member">${t.offerAge}대, ${t.offerLevel}, ${t.offerGender}</span>
	                                    </div>
	                                </a>
	                                </c:forEach>
	                            </li>
	                        </ul> 
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    
	    <div id="pagingArea">
                <ul class="pagination">
                
                	<c:choose>
                		<c:when test="${ pi.currentPage eq 1 }">
                    		<li class="page-item disabled"><a class="page-link">Previous</a></li>
                    	</c:when>
                    	<c:otherwise>
                    		<li class="page-item"><a class="page-link" href="offerBoardList.tm?cpage=${ pi.currentPage - 1 }">Previous</a></li>
                    	</c:otherwise>
					</c:choose>

					<c:forEach var="p" begin="${pi.startPage}" end="${ pi.endPage }" >
                   		<li class="page-item"><a class="page-link" href="offerBoardList.tm?cpage=${ p }">${ p }</a></li>  
                    </c:forEach>
             
                    
                    <c:choose>
                		<c:when test="${ pi.currentPage eq pi.maxPage }">
                    		<li class="page-item disabled"><a class="page-link">Next</a></li>
                    	</c:when>
                    	<c:otherwise>
                    		<li class="page-item"><a class="page-link" href="offerBoardList.tm?cpage=${ pi.currentPage + 1 }">Next</a></li>
                    	</c:otherwise>
					</c:choose>
                  	
                
                </ul>
            </div>
            
	    
	<jsp:include page="../common/footer.jsp" />
</body>
</html>