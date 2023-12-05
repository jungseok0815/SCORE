<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/notice/noticeList.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />

	<div class="outer">
		<div class="notice-wrap">
			<div class="notice-header">
				<h1>공지사항</h1>
				<c:if test="${loginUser.userLever eq 1 }">
					<a type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#noticeModal">
					 공지사항등록하러가기
					</a>
				</c:if>
			</div>
			<hr style="border: 1px color= silver;" width="100%">
			<div class="accordion" id="accordionExample">
				<c:forEach var="i" begin="0" end="${noticeList.size()-1}">
					<div class="accordion-item">
						<h2 class="accordion-header">
							<button class="accordion-button" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseOne${i}"
								aria-expanded="true" aria-controls="collapseOne${i}">
								${noticeList[i].noticeTitle }</button>
						</h2>
						<div id="collapseOne${i}" class="accordion-collapse collapse"
							data-bs-parent="#accordionExample">
							<div class="accordion-body">${noticeList[i].noticeContent }
							</div>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>
	</div>

	<!-- 공지사항 등록 모달 -->
	<div class="modal" id="noticeModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 style="margin: auto;">공지사항 등록</h4>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="insert.no" class="notice_form">
						<input type="hidden" name="userNo" value="1"/>
						<h6>제목</h6>
						<div class="input-group input-group-sm mb-3">
							<input type="text" class="form-control" name="noticeTitle"
								placeholder="제목 입력란입니다.">
						</div>
						<h6>공지사항</h6>
						<div class="input-group input-group-sm mb-3">
							<textarea class="form-control" name="noticeContent" id="noticeContent" cols="30" rows="10"
								placeholder="공지사항 입력란입니다."></textarea>
						</div>
						<div class="bottom-btn">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">취소하기</button>
							<button type="submit" class="btn btn-primary">등록하기</button>
						</div>
					</form>
				</div>


			</div>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>