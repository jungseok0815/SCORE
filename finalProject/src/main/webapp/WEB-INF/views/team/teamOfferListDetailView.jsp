<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
   
    <link rel="stylesheet" href="/final/resources/css/team/teamOfferListDetailView.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
</head>
<body>
	<jsp:include page="../common/header.jsp" />
		<div class="all">
	        <div class="teamMain">
	
	            <div class="team-left-wrap">
	                <div class="team-left-all">
	                    <div class="left-header">
	                        <a class="list-link">
	                            <div class="list-img-all">
	                                <img src="./resources/img/team/teamOfferBoardList/totunum.png" class="list-img"/>
	                            </div>
	                            <div class="list-content">
	                                <div class="list-title">
	                                    <span class="TimeName">${teamOffer.teamName}</span>
	                                </div>
	                                <span class="list-member">${teamOffer.offerAge}, ${teamOffer.offerLevel}, ${teamOffer.offerGender}</span>
	                            </div>
	                        </a>
	                    </div>


	                    <div class="left-body">
	                        <div class="body-list">
	                            <div class="body-list-item">
	                                <span class="body-list-item-text"><img src="./resources/img/team/teamOfferListDetailView/gender.png"  class="list-star-img"/>${teamOffer.offerGender}</span>
	                            </div>
	                            <div class="body-list-item">
	                                <span class="body-list-item-text"><img src="./resources/img/team/teamOfferListDetailView/star.png"  class="list-star-img"/>${teamOffer.offerLevel}</span>
	                            </div>
	                            <br>
	                            <div class="body-list-item">
	                                <span class="body-list-item-text"><img src="./resources/img/team/teamOfferListDetailView/age.png"  class="list-star-img"/>${teamOffer.offerAge}대</span>
	                            </div>
	                            <div class="body-list-item">
	                                <span class="body-list-item-text"><img src="./resources/img/team/teamOfferListDetailView/money.png" class="list-star-img"/>0원</span>
	                            </div>
	                            
	                        </div>
	                    </div>
	                    <div class="btn-wrap">
							<!-- Button to Open the Modal -->
							<c:if test="${empty loginUser and teamOffer.teamNo eq loginUser.teamNo}">
							    <!-- 로그인이 안 되어 있을 때 버튼을 보이지 않게 함 그리고 이미 팀원인 사람은 안보이게 -->
							    <button type="button" class="btnJoin btnFloat btnLightBlue" data-bs-toggle="modal" data-bs-target="#myModal" style="display: none;">가입 신청</button>
							</c:if>
							<c:if test="${not empty loginUser and teamOffer.teamNo ne loginUser.teamNo}"> 
							    <!-- 로그인이 되어 있을 때 버튼을 보이게 함 -->
							    <button type="button" class="btnJoin btnFloat btnLightBlue" data-bs-toggle="modal" data-bs-target="#myModal">가입 신청</button>
							</c:if>
						</div>
						<c:if test="${teamOffer.userNo eq loginUser.userNo}">
							<button onclick="location.href='offerDelete.tm?tno=${teamOffer.offerNo}'" class="custom-btn btn-3"><span>삭제하기</span></button>
	                	</c:if>
	                </div>
	            </div>
	            
	            <div class="content-wrap">
	                <div class="content-body">
	                    <div class="btn-list">
							<!-- <img src="./resources/img/team/teamOfferListDetailView/shm.jpg"  class="content-img"/> -->
							<img src="${teamImg.teamChangeName}"  class="content-img"/>
						</div>
	                    <div class="content-div"> 
	                    ${teamOffer.offerContent}
	                    </div>
	                    
	                    <div class="content-footer">
	                       	조회수 ${teamOffer.offerCount}
	                        
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    
		<jsp:include page="../common/footer.jsp" />
		
		
	    <!-- The Modal -->
	    <div class="modal" id="myModal">
	        <div class="modal-dialog modal-dialog-centered modal-lg">
	            <div class="modal-content">
	
	            <!-- Modal Header -->
	            <div class="modal-header">
	                <h4 class="modal-title" >팀 가입 신청</h4>
	                <button type="button" class="btn-close" id="btnCloseModal" data-bs-dismiss="modal"></button>
	            </div>
	            
	            
	            <!-- Modal body -->
	            <form action="teamReq.tm" method="POST">
	            <input type="hidden" name="offerNo" value="${teamOffer.offerNo}">
	            <input type="hidden" name="userNo" value="${loginUser.userNo}">
	            
	            <div class="modal-body">
	                <div class="join-name">
	                    <label for="join-name">이름</label><br>
	                    <input id="modal-input-name" name="" placeholder="${loginUser.userId}" disabled/>
	                </div>
	                <div class="join-content">
	                    <label for="join-content">각오 한마디</label><br>
	                    <textarea id="modal-input-content" name="reqContent"  placeholder="내용을 입력하세요."></textarea>
	                </div>
	            </div>
	
	            <!-- Modal bottom -->
	            <div class="modal-bottom">
	                <div class="modal-button-join">
	                    <button type="submit" class="btnModelJoin btnFloat2 btnLightBlue2"></button>
	                </div>
	            </div>
				</form>
	        </div>
	    </div> 

</body>
</html>