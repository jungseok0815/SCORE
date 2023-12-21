<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="/final/resources/css/place/evaluation.css">
    <script src="./resources/js/member/evaluationJs/evalUpdate.js"></script>
    <script src="./resources/js/member/evaluationAjax/evaluationAjax.js"></script>
 
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	<div class="inpo-teul">
        <form>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">이름</th>
                        <th scope="col">스마일 카드</th>
                        <th scope="col">옐로우 카드</th>
                        <th scope="col">레드 카드</th>
                        <th scope="col">매너 점수</th>
                        <th scope="col">레 벨</th>
                    </tr>
                </thead>
                <c:forEach var="t" items="${list}" varStatus="loop"> 
                    <input type="hidden" value="${t.userNo}" id="enalUserNo${loop.index}">
                    <input type="hidden" value="${t.categoryNum}" id="enalCategoryNum">
                    <input type="hidden" value="${t.fieldNo}" id="enalFieldNo">
                    <tr class ="check" id= "sportInfo${loop.index}">
                        <th class="inpo-th" scope="row">${t.userName}</th>
                        <td class="inpo-td">
                            <select name="sportSmile">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select>장
                        </td>
                        <td class="inpo-td">
                            <select name="sportYellow">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select>장
                        </td>
                        <td class="inpo-td">
                            <select name="sportRed">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select>장
                        </td>
                        <td class="inpo-td">
                            <input type="text" name="sportScore" required value="0" class="yes-input">점
                        </td>
                        <td>
                            <select name="sportLever">
                                <option value="루키">루키</option>
                                <option value="스타터">스타터</option>
                                <option value="비기너">비기너</option>
                                <option value="아마추어">아마추어</option>
                                <option value="세미프로">세미프로</option>
                                <option value="프로">프로</option>
                            </select>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            
        

            <div class="inpo-btn">
                <button type="reset" class="btn btn-secondary" style="margin-top: 10px; margin-right: 55px;" onclick="location.href='myPage.me?userNo=${loginUser.userNo}'">뒤로가기</button>
                <button type="button" onclick ="updateEnal()" class="btn btn-primary" style="margin-top: 10px;">등록하기</button>
            </div>

      </form>
    </div>
    
    <jsp:include page="../common/footer.jsp" />
</body>
</html>