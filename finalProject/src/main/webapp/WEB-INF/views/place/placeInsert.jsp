<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    
	<link rel="stylesheet" href="/final/resources/css/place/placeInsert.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
    <script type="text/javascript" src="./resources/js/place/placeInsert.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body onload="init()">
	<jsp:include page="../common/header.jsp" />
	<div align="center" class="outer">
        <form action="insert.pl" class="field-insert-input" method="post" enctype="multipart/form-data">
            <table align="center" class="field-table" id="formData">
                <tr>
                    <td style="display:block; margin-bottom: 10px;" colspan="2">
                        <h5 align="center">구장 등록</h5>
                        <select name="categoryNum" id="sport" class="sport-select" value="football" onchange="changeSportSelect()">
                            <option value="1">축구</option>
                            <option value="2">야구</option>
                            <option value="3">농구</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="margin-bottom: -10px;" colspan="2">
                        <p>↓아래 상자를 클릭해 사진을 등록해주세요(★처음 이미지 필수)</p>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="filebox">
                                <div class="btn-upload">
                                    <img src="" id="file-img1" onclick="clickImg(1)">
                                    <img src="" id="file-img2" onclick="clickImg(2)">
                                    <img src="" id="file-img3" onclick="clickImg(3)">
                                    <img src="" id="file-img4" onclick="clickImg(4)">
                                </div>
                            
                            <input type="file" name="upfile" id="fileImgFile1" onchange="loadImg(this,1)" required>
                            <input type="file" name="upfile" id="fileImgFile2" onchange="loadImg(this,2)">
                            <input type="file" name="upfile" id="fileImgFile3" onchange="loadImg(this,3)">
                            <input type="file" name="upfile" id="fileImgFile4" onchange="loadImg(this,4)">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <!-- <input type="text" value="" class="from-input" placeholder="[매니저 이름]을 입력해주세요" name="manager" required> -->
                        <select name="manager" value="" class="manager-select-box" required>
                            <option value="" selected disabled hidden>담당매니저를 선택해주세요</option>
                            <c:forEach var="t" items="${list}"> 
                            	<option value="${t.userName}">${t.userName}</option>
                            </c:forEach>
                           
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="text" value="" class="from-input" placeholder="[경기장 이름]을 입력해주세요" name="fieldName" required>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="text" style="padding: 10px;" class="address-input" id="sample6_address" name="fieldArea" placeholder="주소">
                        <input type="button" style="width: 65px; height: 35px;" onclick="sample6_execDaumPostcode()" value="주소 찾기">
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <select name="matchLevel" value="" class="field-select" required>
                            <option value="모든레벨">모든레벨</option>
                            <option value="아마추어 이하">스타터</option>
                            <option value="아마추어 이상">아마추어</option>
                            <option value="세미프로">세미프로</option>
                            <option value="세미프로">프로</option>
                        </select>

                        <select name="matchType" id="match-type" value="" class="field-select" required>
                            <option value="6vs6 3파전">6vs6 3파전</option>
                            <option value="5vs5 3파전">5vs5 3파전</option>
                        </select>

                        <select name="matchGender" value="" class="field-select" required>
                            <option value="3">남녀 모두</option>
                            <option value="1">남자만</option>
                            <option value="2">여자만</option>
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <select name="parking" class="field-select" required>
                            <option value="3">주차장 없음</option>
                            <option value="1">무료주차</option>
                            <option value="2">유료주차</option>
                        </select>
                        
                        <input name="fieldCount" class="field-select" type="number" placeholder="인원 수" required>
                        
                        <select id="shoes" name="shoes" class="field-select" required>
                            <option  value="상관없음">상관없음</option>
                            <option  value="풋살화/운동화">풋살화/운동화</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="date" value="" name="fieldDate" style="margin: 5px 40px 10px 10px; width: 180px;" required>
                        <input class="timepicker" type="time" value="" name="startTime" style="width: 120px;" required> ~
                        <input class="timepicker" type="time" value="" name="endTime" style="width: 120px;" required>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="" class="from-input" value="" style="width: 240px; margin-right: 15px;" placeholder=" 경기장 규모(소, 중, 대)" name="fieldSize" required>
                        <input type="" class="from-input" value="" style="width: 240px;" placeholder=" 가격" name="matchPay" required>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <button type="reset" class="btn btn-secondary" style="margin-top: 10px;" onclick="location.href='../final'">뒤로가기</button>
                        <button type="submit" class="btn btn-primary" style="margin-top: 10px;">등록하기</button>
                    </td>
                </tr>
                
            </table>
        </form>
    </div>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>