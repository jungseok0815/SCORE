<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/common/errorPage.css" >
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	
	
	 <div align="center" class="error-up">
        <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/img_404.png" class="error-img">
    </div>

    <div align="center">
        <h1>${errorMsg}</h1>
        <h3>침착하게 처음부터 확인 해보자</h3>
        <button href="/views/main.jsp" class="error-btn">홈으로 가기</button>
    </div>
    
    
    <jsp:include page="../common/footer.jsp" />
</body>
</html>