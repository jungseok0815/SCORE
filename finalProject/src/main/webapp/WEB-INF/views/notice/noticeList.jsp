<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div claa="notice-wrap">
		  <div class="notice-header">
			  <h1>공지사항</h1>
			  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#noticeModal">
				공지사항등록하러가기
			  </button>
		  </div>
		  <hr style="border:1px color= silver;" width="100%">
		  <div class="accordion" id="accordionExample">
			<div class="accordion-item">
			  <h2 class="accordion-header">
				<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				  ◇ 가격 인상 안내 ◇
				</button>
			  </h2>
			  <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				<div class="accordion-body">
				  먼저 플랩풋볼 서비스를 사랑해 주시는 플래버님들께 진심으로 감사의 말씀드립니다. 
	
					  플랩풋볼은 오는 11월 1일 수요일 매치부터 일부 경기 참가비를 인상하게 되었음을 안내드립니다. 
					  
					  그동안 코로나19 영향 및 지속적인 비용 상승에도 불구하고 인상 요인들을 내부적으로 감내하며, 6년 동안 가격 동결을 유지해왔습니다. 
					  
					  그러나 플래버님들께 더 좋은 서비스와 혜택을 드리기 위해서는 지속적인 투자가 필요하다고 판단했고, 오랜 고민 끝에 가격 인상을 결정했습니다. 
					  
					  이에 따라 11월 1일 수요일 매치부터 지역과 시간에 따라 10,000원에서 12,000원 사이의 세분화된 가격이 적용될 예정입니다. 
				</div>
			  </div>
			</div>
			<div class="accordion-item">
			  <h2 class="accordion-header">
				<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
				  ◇ 친구 신청 시 QR코드를 이용해보세요 ◇
				</button>
			  </h2>
			  <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				<div class="accordion-body">
				  'QR 코드'로 경기장에서 만난 플래버를 친구 등록하기 쉬워졌어요. 
					  연락처를 알고 있는 플래버라면 '링크 복사'로 내 프로필 주소를 공유해 주세요.
					  
					  [친구 신청 및 추가 방법]
					  1. 마이페이지 '프로필 보기' 버튼 우측의 'QR 코드 모양 아이콘' 클릭
					  2. 'QR 코드' 혹은 '링크 복사'를 통해 친구에게 내 프로필 주소 공유
					  3. 친구가 내 프로필에 접속해 '친구 신청' 버튼 클릭
					  4. '마이페이지-친구'의 '신청대기' 탭에서 수락
				</div>
			  </div>
			</div>
			<div class="accordion-item">
			  <h2 class="accordion-header">
				<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
				  ◇ 임도현 집중 ◇
				</button>
			  </h2>
			  <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				<div class="accordion-body" id="accordion-bottom">
				  림도현 집중림도현 집중림도현 집중림도현 집중림도현 집중ㅍㅍ림도현 집중림도현 집중림도현 집중림도현 집중림도현 집중림도현 집중림도현 집중
				</div>
			  </div>
			</div>
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
			  <form action="" class="notice_form">
				  <h6>제목</h6>
				  <div class="input-group input-group-sm mb-3">
					  <input type="text" class="form-control" name="" placeholder="제목 입력란입니다.">
				  </div>
				  <h6>공지사항</h6>
				  <div class="input-group input-group-sm mb-3">
					  <textarea class="form-control" name="" id="" cols="30" rows="10" placeholder="공지사항 입력란입니다."></textarea>
				  </div>
				  <div class="bottom-btn">
					  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소하기</button>
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