<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/final/resources/css/team/teamJoinList.css">
	<script src="resources/js/team/teamJs/teamJoinList.js"></script>
	<script src="resources/js/team/teamAjax/teamJoinListAjax.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
		<jsp:include page="../common/header.jsp" />
		  <div class="main" id="joinTeam">
	        <div class="all"> 
	            <div class="topWrapper">
	                <div class="top_container">
	                    <span class="memberListCount"><img src="${tProfile}"  class="top-member-img"/>${tName} | 멤버관리</span>
	                </div>
	                
	                <div class="team-list">
	                    <div class="team-list-container">
	                        <ul>
	                        <c:forEach var="r" items="${list}"> 
	                            <li class="team-list-item">
	                                <div>
	                                    <a href="" class="list-link">
	                                       <div class="list-img-all">
	                                            <img src=".${r.memberChangeName}" class="list-img"/>
	                                        </div>
	                                        <div class="list-content">
	                                            <div class="list-title">
	                                                <span class="memberName">${r.userName}</span>
	                                            </div>
	                                            <span class="list-member">${r.gender} · ${r.userLevel} · ${r.userBirth}세 · ${r.city}</span>
	                                        </div>
	                                    </a>
	                                </div> 
	                                <div>
	                                    <div class="list-member-x">
	                                        <a onclick="location.href='refuse.tm?reqNo=${r.reqNo}&tno=${tno}'"><img src="./resources/img/team/teamJoinList/x.png" class="list-img-x"/></a>
	                                    </div>
	                                </div>
	                                <div>
	                                    <div class="list-text">
	                                        ${r.reqContent}
	                                    </div>
	                                </div>
	                                <div>
	                                    <a>
	                                        <div class="btnList">
	                                       
	                                            <a onclick="location.href='refuse.tm?reqNo=${r.reqNo}&tno=${tno}'" class="buttonRe btnFloat btnLightBlue"></a>  
	                                           
	                                            <a onclick="location.href='accept.tm?reqNo=${r.reqNo}&tno=${tno}'" class="buttonAc btnFloat2 btnLightBlue2"></a>
	                                        </div>
	                                    </a>
	                                </div>
	                            </li>
							</c:forEach>
	
	
	                             
	
	
	                            
	
	                        </ul> 
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>