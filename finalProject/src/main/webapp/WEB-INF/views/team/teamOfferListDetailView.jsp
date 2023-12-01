<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
   
    <link rel="stylesheet" href="./resources/css/team/teamOfferListDetailView.css">
    
</head>
<body>
	<jsp:include page="../common/header.jsp" />
		<div class="all">
	        <div class="teamMain">
	
	            <div class="team-left-wrap">
	                <div class="team-left-all">
	                    <div class="left-header">
	                        <a href="" class="list-link">
	                            <div class="list-img-all">
	                                <img src="./resources/img/team/teamOfferBoardList/totunum.png" class="list-img"/>
	                            </div>
	                            <div class="list-content">
	                                <div class="list-title">
	                                    <span class="TimeName">토트넘Fc</span>
	                                </div>
	                                <span class="list-member">남녀 모두 · 20~30대 · 아마추어3</span>
	                            </div>
	                        </a>
	                        <div class="btn-wrap">
	                            <!-- Button to Open the Modal -->
	                            <button type="button" class="btnJoin" data-bs-toggle="modal" data-bs-target="#myModal">가입 신청</button>
	                        </div>
	                    </div>
	
	
	                    <div class="left-body">
	                        <div class="btn-list">
	                            <img src="./resources/img/team/teamOfferListDetailView/shm.jpg"  class="content-img"/>
	                        </div>
	                        <div class="body-list">
	                            <div class="body-list-item">
	                                <span class="body-list-item-text"><img src="./resources/img/team/teamOfferListDetailView/star.png"  class="list-star-img"/>남녀 모두</span>
	                            </div>
	                            <div class="body-list-item">
	                                <span class="body-list-item-text"><img src="./resources/img/team/teamOfferListDetailView/star.png"  class="list-star-img"/>실력무관</span>
	                            </div>
	                            <br>
	                            <div class="body-list-item">
	                                <span class="body-list-item-text"><img src="./resources/img/team/teamOfferListDetailView/star.png"  class="list-star-img"/>20대~30대</span>
	                            </div>
	                            <div class="body-list-item">
	                                <span class="body-list-item-text"><img src="./resources/img/team/teamOfferListDetailView/star.png" class="list-star-img"/>0원/월</span>
	                            </div>
	                            
	                        </div>
	                    </div>
	                   
	                </div>
	            </div>
	
	
	
	            
	            <div class="content-wrap">
	                <div class="content-body">
	                    
	                    <div class="content-div">
	                        경기장에 나가면 쏟아부을 수 있는 것을<br>
	                        모두 쏟으려고 해요<br>
	                        팀을 위해 모든 것을 쏟아내는게<br>
	                        나의 목표입니다.<br>
	                        <br>
	
	                        제 인생에서 공짜로 얻는 것은 단 하나도 없어요.<br>
	                        드리블, 슈팅, 컨디션 유지, 부상 방지 등은<br>
	                        전부 죽어라 노력해서 얻은 것이라고 믿어요.<br>
	                    </div>
	                    <div class="content-tag-list">
	                        <div class="content-tag">#손흥민</div>
	                        <div class="content-tag">#실력키우기</div>
	                    </div>
	                    <div class="content-footer">
	                        조회 8888 · 신청 20
	                        <span style="float: right;">업데이트 1달 전</span>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	
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
	            <div class="modal-body">
	                <div class="join-name">
	                    <label for="join-name">이름</label><br>
	                    <input type="text" id="modal-input-name" name=""  placeholder="내용을 입력하세요."/>
	                </div>
	                <div class="join-content">
	                    <label for="join-content">각오 한마디</label><br>
	                    <input type="text" id="modal-input-content" name=""  placeholder="내용을 입력하세요."/>
	                </div>
	            </div>
	
	            <!-- Modal bottom -->
	            <div class="modal-bottom">
	                <div class="modal-button-join">
	                    <button type="button" id="btnModelJoin">가입 신청</button>
	                </div>
	            </div>
	
	        </div>
	    </div> 
	<jsp:include page="../common/footer.jsp" />
</body>
</html>