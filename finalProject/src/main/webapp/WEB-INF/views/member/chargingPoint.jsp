<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/member/Point.css" >
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	
	<div class="no1-title">
        <div class="big-title">
            <div class="point-1">미리 충전하고</div>
            <div class="point-2">더욱 편리하게</div>

            <div class="point-3">충전할 금액</div>
            <div class="select1">
                <input type="radio" name="money" id="five"><label for="five">5,000</label>
                <input type="radio" name="money" id="ten"><label for="ten">10,000</label>
                <input type="radio" name="money" id="twenty"><label for="twenty">20,000</label> 
                <input type="radio" name="money" id="thirty"><label for="thirty">30,000</label>
                <input type="radio" name="money" id="fifty"><label for="fifty">50,000</label>
                <input type="radio" name="money" id="hundred"><label for="hundred">100,000</label>
            </div>

            <div class="point-4">결제수단 선택</div>
            <div class="select2">
                <input type="radio" name="money-one" id="account"><label for="account">가상계좌</label>
                <input type="radio" name="money-one" id="card"><label for="card">카드결제</label>
                <input type="radio" name="money-one" id="kako"><label for="kako">카카오페이</label>
            </div>

            <div class="point-tt">
                <div class="point-5">
                    <div class="point-6">가상계좌 안내</div>
                    <div class="point-7">즉시 입금 시 가능합니다.</div>
                </div>
            </div>
            <div class="point-8">
                <input type="checkbox">[필수] 결제 서비스 이용 약관, 개인정보 처리 동의
            </div>

            <div class="point-tt">
                <button class="point-btn" onclick="">충전</button>
            </div>
        </div>
    </div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>