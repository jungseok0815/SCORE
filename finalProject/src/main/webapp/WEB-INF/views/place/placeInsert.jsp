<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/final/resources/css/place/placeInsert.css">
</head>

	<jsp:include page="../common/header.jsp" />
	<div align="center" class="outer">
        <form action="" class="field-insert-input">
            <table align="center" class="field-table" id="formData">
                <tr>
                    <td style="display:block">
                        <h5>경기장 등록</h5>
                        <select name="sport" id="sport" class="sport-select" value="football" onchange="changeSportSelect()">
                            <option value="football">축구</option>
                            <option value="baseball">야구</option>
                            <option value="basketball">농구</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="filebox" align="center">
                            <label for="fileImgFile">
                                <div class="btn-upload">경기장사진첨부</div>
                            </label>
                            <input type="file" name="file" id="fileImgFile">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="" class="from-input" placeholder=" 제목을 입력해주세요" name="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="" class="from-input" placeholder=" 주소을 입력해주세요" name="">
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <select name="level" class="field-select">
                            <option value="">레벨선택</option>
                            <option value="allLevel">모든레벨</option>
                            <option value="underAmature">아마추어 이하</option>
                            <option value="overAmature">아마추어 이상</option>
                            <option value="pro">프로</option>
                        </select>

                        <select id="match-type" name="match-type" class="field-select">
                            <option>매치선택</option>
                            <option value="football-match">6vs6 3파전</option>
                            <option value="football-match">5vs5 3파전</option>
                        </select>

                        <select name="gender" class="field-select">
                            <option value="">성별</option>
                            <option value="allGender">남녀 모두</option>
                            <option value="onlyMen">남자만</option>
                            <option value="onlyWomen">여자만</option>
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <select name="parking" class="field-select">
                            <option value="">주차정보</option>
                            <option value="noParking">주차장 없음</option>
                            <option value="freeParking">무료주차</option>
                            <option value="payParking">유료주차</option>
                        </select>
                        
                        <input class="field-select" type="number" placeholder="인원 수">
                        
                        <select id="shoes" name="shoes" class="field-select">
                            <option value="">신발정보</option>
                            <option value="football-shoes">풋살화/운동화</option>
                            <option value="football-shoes">상관없음</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="date" name="" style="margin: 5px 40px 10px 10px; width: 180px;">
                        <input type="time" name="" style="width: 120px;"> ~
                        <input type="time" name="" style="width: 120px;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="" class="from-input" style="width: 240px; margin-right: 15px;" placeholder=" 경기장 규모" name="">
                <input type="" class="from-input" style="width: 240px;" placeholder=" 가격" name="">
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <button type="submit" class="btn btn-secondary" style="margin-top: 10px;">뒤로가기</button>
                        <button type="submit" class="btn btn-primary" style="margin-top: 10px;">등록하기</button>
                    </td>
                </tr>
                
            </table>
        </form>
    </div>

    <script>
        changeSportSelect= () => {
            
            const select = document.querySelector("#sport").value;
            if(select === 'baseball'){
                const drawMatchBs = document.querySelector("#match-type");
                drawMatchBs.innerHTML = "";
                drawMatchBs.innerHTML = "<option>매치선택</option>"+
                                        "<option value='baseball-match'>용병 매치</option>"+
                                        "<option value='baseball-match'>팀 매치</option>"

                const drawShoesBs = document.querySelector("#shoes");
                drawShoesBs.innerHTML = "";
                drawShoesBs.innerHTML = "<option>신발정보</option>"+
                                        "<option value='baseball-shoes'>야구화/스파이크</option>"+
                                        "<option value='baseball-shoes'>상관없음</option>"

            }else if (select === 'basketball') {
                const drawMatchBk = document.querySelector("#match-type");
                drawMatchBk.innerHTML = "";
                drawMatchBk.innerHTML = "<option>매치선택</option>"+
                                        "<option value='basketball-match'>3vs3</option>"+
                                        "<option value='basketball-match'>5vs5</option>"

                const drawShoesBk = document.querySelector("#shoes");
                drawShoesBk.innerHTML = "";
                drawShoesBk.innerHTML = "<option>신발정보</option>"+
                                        "<option value='basketball-shoes'>농구화</option>"+
                                        "<option value='basketball-shoes'>상관없음</option>"
            }else {
                const drawMatchFt = document.querySelector("#match-type");
                drawMatchFt.innerHTML = "";
                drawMatchFt.innerHTML = "<option>매치선택</option>"+
                                        "<option value='football-match'>6vs6 3파전</option>"+
                                        "<option value='football-match'>5vs5 3파전</option>"

                const drawShoesFt = document.querySelector("#shoes");
                drawShoesFt.innerHTML = "";
                drawShoesFt.innerHTML = "<option>신발정보</option>"+
                                        "<option value='football-shoes'>풋살화/운동화</option>"+
                                        "<option value='football-shoes'>상관없음</option>"
            }


        }
    </script>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>