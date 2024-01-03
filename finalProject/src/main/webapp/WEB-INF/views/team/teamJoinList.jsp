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
	                 <c:choose>
	                 	 <c:when test="${empty list}">
	                 	 	<div style="display: flex; justify-content: center; display: grid;">
						        <img src="./resources/img/team/teamJoinList/cat.png" style="width: 436px; height: 397px;">
						        <h1 style="display: flex; justify-content: center;">신청 내역이 없습니다...</h1><br>
						        
						        <button onclick="location.href='teamProfile.tm?teamNo=${tno}'">뒤로</button>
						        <br>
						    </div>
	                 	 </c:when>
	                 	 <c:otherwise>
	                 	 	<div class="team-list">
	                    <div class="team-list-container">
	                        <ul>
	                        <c:forEach var="r" items="${list}"> 
	                            <li class="team-list-item">
	                                <div>
	                                    <a href="" class="list-link">
											<c:forEach var="m" items="${resultList}">
												<c:if test="${r.reqUserNo eq m.reqUserNo}">
													<div class="list-img-all">
														<c:choose>
															<c:when test="${m.memberChangeName == null}">
																<img src="./resources/img/team/teamOfferBoardList/profile.jpg" class="list-img"/>
															</c:when>
															<c:otherwise>
																<img src=".${m.memberChangeName}" class="list-img"/>
															</c:otherwise>
														</c:choose>
													</div>
												</c:if>
											</c:forEach>
	                                        
	                               
	                                        
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
	               	</c:otherwise>
	              </c:choose>
	                
	            </div>
	        </div>
	    </div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>