<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/final/resources/css/team/teamProfileUpdate.css">
	<script src="resources/js/team/teamJs/teamProfileUpdate.js?ver=4"></script>
	<script src="resources/js/team/teamAjax/teamProfileAjax.js"></script>
</head>

<body>
	<jsp:include page="../common/header.jsp" />
	<div class="outer">
		<form method="post" action="update.tm" enctype="multipart/form-data">
			<input type="hidden" name="teamNo" value="${team.teamNo}">
			<div class="team-update-main">
				<div class="team-profile-update">
					<div class="profile-imgbox">
						<label for="file">
							<div class="btn-upload"><img src="${team.teamChangeName}"
									alt="" id="update-file"></div>
						</label>
						<input type="file" id="file" class="form-control-file border" name="reupfile"
							onchange="loadImg(this)">
						<c:if test="${not empty team.teamOriginName}">
							<input type="hidden" name="teamOriginName" value="${team.teamOriginName}" />
							<input type="hidden" name="teamChangeName" value="${team.teamChangeName}" />
						</c:if>
					</div>
					<p class="ab-font">엠블럼 바꾸기</p>
				</div>
				<p>종목</p>
				<div class="team-category">
					<div>
						<input type="radio" name="categoryNum" class="btn-check team-category" value="1"
							id="team-category1" autocomplete="off" ${team.categoryNum eq 1 ? 'checked' : '' }>
						<label class="btn btn-outline-primary" for="team-category1">축구</label><br>
					</div>

					<div>
						<input type="radio" name="categoryNum" class="btn-check team-category" value="2"
							id="team-category2" autocomplete="off" ${team.categoryNum eq 2 ? 'checked' : '' }>
						<label class="btn btn-outline-primary" for="team-category2">야구</label><br>
					</div>

					<div>
						<input type="radio" name="categoryNum" class="btn-check team-category" value="3"
							id="team-category3" autocomplete="off" ${team.categoryNum eq 3 ? 'checked' : '' }>
						<label class="btn btn-outline-primary" for="team-category3">농구</label><br>
					</div>
				</div>

				<div class="team-area">
					<label for="" class="form-label">팀 이름</label>
					<input type="text" value="${team.teamName}" class="form-control" name="teamName">
				</div>

				<div class="team-city">
					<label for="" class="form-label">도시</label>
					<input type="text" value="${team.activityAtea}" class="form-control" name="activityAtea">
				</div>

				<p>성별</p>
				<div class="team-gender">
					<div>
						<input type="radio" name="teamGender" class="btn-check team-gender-sl" value="남녀 모두"
							id="team-gender1" autocomplete="off" ${team.teamGender eq '남녀 모두' ? 'checked' : '' }>
						<label class="btn btn-outline-primary" for="team-gender1">남녀 모두</label><br>
					</div>
					<div>
						<input type="radio" name="teamGender" class="btn-check team-gender-sl" value="남자"
							id="team-gender2" autocomplete="off" ${team.teamGender eq '남자' ? 'checked' : '' }>
						<label class="btn btn-outline-primary" for="team-gender2">남자</label><br>
					</div>
					<div>
						<input type="radio" name="teamGender" class="btn-check team-gender-sl" value="여자"
							id="team-gender3" autocomplete="off" ${team.teamGender eq '여자' ? 'checked' : '' }>
						<label class="btn btn-outline-primary" for="team-gender3">여자</label><br>
					</div>
				</div>

				<p>나이</p>
				<div class="team-age-wrap">
					<div class="team-age">
						<div>
							<input type="checkbox" class="btn-check check-age" id="btn-check-outlined" autocomplete="off"
								value="10대" name="teamUserAge">
							<label class="btn btn-outline-primary" for="btn-check-outlined">10대</label><br>
						</div>
						<div>
							<input type="checkbox" class="btn-check check-age" id="btn-check-outlined2" autocomplete="off"
								value="20대" name="teamUserAge">
							<label class="btn btn-outline-primary" for="btn-check-outlined2">20대</label><br>
						</div>
						<div>
							<input type="checkbox" class="btn-check check-age" id="btn-check-outlined3" autocomplete="off"
								value="30대" name="teamUserAge">
							<label class="btn btn-outline-primary" for="btn-check-outlined3">30대</label><br>
						</div>
					</div>
					<div class="team-age2">
						<div>
							<input type="checkbox" class="btn-check check-age" id="btn-check-outlined4" autocomplete="off"
								value="40대" name="teamUserAge">
							<label class="btn btn-outline-primary" for="btn-check-outlined4">40대</label><br>
						</div>
						<div>
							<input type="checkbox" class="btn-check check-age" id="btn-check-outlined5" autocomplete="off"
								value="50대" name="teamUserAge">
							<label class="btn btn-outline-primary" for="btn-check-outlined5">50대</label><br>
						</div>
						<div>
							<input type="checkbox" class="btn-check check-age" id="btn-check-outlined6" autocomplete="off"
								value="60대 이상" name="teamUserAge">
							<label class="btn btn-outline-primary" for="btn-check-outlined6">60대 이상</label><br>
						</div>
					</div>
				</div>

				<p>레벨</p>
				<div class="team-level-wrap">
					<div class="team-level">
						<div>
							<input type="radio" name="teamLevel" class="btn-check" id="btn-check-outlined10"
								autocomplete="off" value="실력무관" ${team.teamLevel eq '실력무관' ? 'checked' : '' }>
							<label class="btn btn-outline-primary" for="btn-check-outlined10">실력무관</label><br>
						</div>
						<div>
							<input type="radio" name="teamLevel" class="btn-check" id="btn-check-outlined11"
								autocomplete="off" value="스타터" ${team.teamLevel eq '스타터' ? 'checked' : '' }>
							<label class="btn btn-outline-primary" for="btn-check-outlined11">스타터</label><br>
						</div>
						<div>
							<input type="radio" name="teamLevel" class="btn-check" id="btn-check-outlined12"
								autocomplete="off" value="비기너" ${team.teamLevel eq '비기너' ? 'checked' : '' }>
							<label class="btn btn-outline-primary" for="btn-check-outlined12">비기너</label><br>
						</div>
					</div>
					<div class="team-level2">
						<div>
							<input type="radio" name="teamLevel" class="btn-check" id="btn-check-outlined13"
								autocomplete="off" value="아마추어" ${team.teamLevel eq '아마추어' ? 'checked' : '' }>
							<label class="btn btn-outline-primary" for="btn-check-outlined13">아마추어</label><br>
						</div>
						<div>
							<input type="radio" name="teamLevel" class="btn-check" id="btn-check-outlined14"
								autocomplete="off" value="세미프로" ${team.teamLevel eq '세미프로' ? 'checked' : '' }>
							<label class="btn btn-outline-primary" for="btn-check-outlined14">세미프로</label><br>
						</div>
						<div>
							<input type="radio" name="teamLevel" class="btn-check" id="btn-check-outlined15"
								autocomplete="off" value="프로" ${team.teamLevel eq '프로' ? 'checked' : '' }>
							<label class="btn btn-outline-primary" for="btn-check-outlined15">프로</label><br>
						</div>
					</div>
				</div>


				<div class="team-btn">
					<button class="btn btn-primary" type="submit">수정</button>
					<button type="button" class="btn btn-outline-danger delete-btn">삭제</button>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="../common/footer.jsp" />

	<script>
		//나이
		const checkBoxList = document.querySelectorAll('.check-age');
		const age = "${team.teamUserAge}";
		console.log(age)
		const arr = age.split(',');
		console.log(arr)
		for (let i = 0; i < arr.length; i++) {
			for (let j = 0; j < checkBoxList.length; j++) {
				if (arr[i].includes(checkBoxList[j].value)) {
					checkBoxList[j].checked = true;
					break;
				}
			}
		}
	</script>
</body>

</html>