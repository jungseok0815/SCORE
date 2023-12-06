<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/final/resources/css/place/placeInsert.css">
    <script type="text/javascript" src="./resources/js/place/placeInsert.js"></script>
    
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div align="center" class="outer">
        <form action="insert.pl" class="field-insert-input" method="post" enctype="multipart/form-data">
            <table align="center" class="field-table" id="formData">
                <tr>
                    <td style="display:block">
                        <h5>경기장 등록</h5>
                        <select name="categoryNum" id="sport" class="sport-select" value="football" onchange="changeSportSelect()">
                            <option value="1">축구</option>
                            <option value="2">야구</option>
                            <option value="3">농구</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="filebox" align="center">
                            <label for="fileImgFile">
                                <div class="btn-upload">경기장사진첨부</div>
                            </label>
                            <input type="file" name="upfile" id="fileImgFile">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" value="" class="from-input" placeholder="[매니저 이름]을 입력해주세요" name="manager">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" value="" class="from-input" placeholder="[경기장 이름]을 입력해주세요" name="fieldName">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" value="" class="from-input" placeholder="[경기 장소]을 입력해주세요" name="fieldArea" onclick="openAddress()">
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <select name="matchLevel" value="" class="field-select">
                            <option value="레벨선택">레벨선택</option>
                            <option value="모든레벨">모든레벨</option>
                            <option value="아마추어 이하">아마추어 이하</option>
                            <option value="아마추어 이상">아마추어 이상</option>
                            <option value="프로">프로</option>
                        </select>

                        <select name="matchType" id="match-type" value="" class="field-select">
                            <option>매치선택</option>
                            <option value="6vs6 3파전">6vs6 3파전</option>
                            <option value="5vs5 3파전">5vs5 3파전</option>
                        </select>

                        <select name="matchGender" value="" class="field-select">
                            <option value="">성별</option>
                            <option value="3">남녀 모두</option>
                            <option value="1">남자만</option>
                            <option value="2">여자만</option>
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <select name="parking" class="field-select">
                            <option value="">주차정보</option>
                            <option value="3">주차장 없음</option>
                            <option value="1">무료주차</option>
                            <option value="2">유료주차</option>
                        </select>
                        
                        <input name="fieldCount" class="field-select" type="number" placeholder="인원 수">
                        
                        <select id="shoes" name="shoes" class="field-select">
                            <option value="">신발정보</option>
                            <option  value="풋살화/운동화">풋살화/운동화</option>
                            <option  value="상관없음">상관없음</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="date" value="" name="fieldDate" style="margin: 5px 40px 10px 10px; width: 180px;">
                        <input class="timepicker" type="time" value="" name="startTime" style="width: 120px;"> ~
                        <input class="timepicker" type="time" value="" name="endTime" style="width: 120px;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="" class="from-input" value="" style="width: 240px; margin-right: 15px;" placeholder=" 경기장 규모" name="fieldSize">
                        <input type="" class="from-input" value="" style="width: 240px;" placeholder=" 가격" name="matchPay">
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <button type="reset" class="btn btn-secondary" style="margin-top: 10px;">뒤로가기</button>
                        <button type="submit" class="btn btn-primary" style="margin-top: 10px;">등록하기</button>
                    </td>
                </tr>
                
            </table>
        </form>
    </div>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>