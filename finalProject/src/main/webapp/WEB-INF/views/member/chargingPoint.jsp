<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/member/Point.css" >
<script src="resources/js/member/memberJs/chargingPoint.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	
    
        <div class="no1-title">
            <div class="big-title">
                <div class="point-1">미리 충전하고</div>
                <div class="point-2">더욱 편리하게</div>
                
                <form action="updatePoint.me" method="post" id="pointForm">
                    <div class="point-3">충전할 금액</div>
                    <div class="select1">
                        <input type="radio" name="point" id="five" value="5000" selected><label for="five">5,000</label>
                        <input type="radio" name="point" id="ten" value="10000" checked><label for="ten">10,000</label>
                        <input type="radio" name="point" id="twenty" value="20000"><label for="twenty">20,000</label> 
                        <input type="radio" name="point" id="thirty" value="30000"><label for="thirty">30,000</label>
                        <input type="radio" name="point" id="fifty" value="50000"><label for="fifty">50,000</label>
                        <input type="radio" name="point" id="hundred" value="100000"><label for="hundred">100,000</label>
                    </div>
                </form>

                <div class="point-4">결제수단 선택</div>
                <div class="select2">
                    <input type="radio" name="money-one" id="account"><label for="account">가상계좌</label>
                    <input type="radio" name="money-one" id="card" checked><label for="card">카드결제</label>
                    <input type="radio" name="money-one" id="kakao"><label for="kakao">카카오페이</label>
                </div>

                <div class="point-tt">
                    <div class="point-5">
                        <div class="point-6">가상계좌 안내</div>
                        <div class="point-7">즉시 입금 시 가능합니다.</div>
                    </div>
                </div>
                <div class="point-8">
                    <input type="checkbox" checked required>[필수] 결제 서비스 이용 약관, 개인정보 처리 동의
                </div>

                <div class="point-tt">
                    <button class="point-btn" onclick="charging()">충전</button>
                </div>
            </div>
        </div>
    <script>
        
    </script>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>