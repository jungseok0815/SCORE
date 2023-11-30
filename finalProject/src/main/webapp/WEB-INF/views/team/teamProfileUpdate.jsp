<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/team/teamProfileUpdate.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="outer">
	<div class="team-update-main">
		<div class="team-profile-update">
			<div class="team-profile-update-img">
				<div><i class="fa-solid fa-crown fa-4x"></i></div>
			</div>
			<p class="ab-font">엠블럼 바꾸기</p>
		</div>	
		<div class="team-area">
			<label for="inputPassword5" class="form-label">팀 이름</label>
			<input type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock">
		</div>
		<div class="team-city">
			<label for="inputPassword5" class="form-label">도시</label>
			<input type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock">	
		</div>
		<p>나이</p>
		<div class="team-age">
			<div>
				<input type="checkbox" class="btn-check" id="btn-check-outlined" autocomplete="off">
				<label class="btn btn-outline-primary" for="btn-check-outlined">10대</label><br>
			</div>
			<div>
				<input type="checkbox" class="btn-check" id="btn-check-outlined2" autocomplete="off">
				<label class="btn btn-outline-primary" for="btn-check-outlined2">20대</label><br>
			</div>
			<div>
				<input type="checkbox" class="btn-check" id="btn-check-outlined3" autocomplete="off">
				<label class="btn btn-outline-primary" for="btn-check-outlined3">30대</label><br>
			</div>
		</div>
		<div class="team-age2">
			<div>
				<input type="checkbox" class="btn-check" id="btn-check-outlined4" autocomplete="off">
				<label class="btn btn-outline-primary" for="btn-check-outlined4">40대</label><br>
			</div>
			<div>
				<input type="checkbox" class="btn-check" id="btn-check-outlined5" autocomplete="off">
				<label class="btn btn-outline-primary" for="btn-check-outlined5">50대</label><br>
			</div>
			<div>
				<input type="checkbox" class="btn-check" id="btn-check-outlined6" autocomplete="off">
				<label class="btn btn-outline-primary" for="btn-check-outlined6">60대 이상</label><br>
			</div>
		</div>
		
		<p>종목</p>
		<div class="team-category">
			<div>
				<input type="checkbox" class="btn-check" id="btn-check-outlined7" autocomplete="off">
				<label class="btn btn-outline-primary" for="btn-check-outlined7">축구</label><br>
			</div>
			<div>
				<input type="checkbox" class="btn-check" id="btn-check-outlined8" autocomplete="off">
				<label class="btn btn-outline-primary" for="btn-check-outlined8">농구</label><br>
			</div>
			<div>
				<input type="checkbox" class="btn-check" id="btn-check-outlined9" autocomplete="off">
				<label class="btn btn-outline-primary" for="btn-check-outlined9">야구</label><br>
			</div>
		</div>
		<div class="team-btn">
				<button class="btn btn-primary" type="button">수정</button>
				<button type="button" class="btn btn-outline-danger delete-btn">삭제</button>
		</div>
	</div>
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>