<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/final/resources/css/place/placeInsert.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div align="center">
        <form action="" class="field-insert-input">
            <table align="center" class="field-table">
                <tr>
                    <td>
                        <h5>경기장 등록</h5>
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
                        <select name="" class="field-select">
                            <option value="">모든레벨</option>
                            <option value="">아마추어 이하</option>
                            <option value="">아마추어 이상</option>
                            <option value="">프로</option>
                        </select>
                        <select name="" class="field-select">
                            <option value="">6vs6 3파전</option>
                            <option value="">5vs5 3파전</option>
                        </select>
                        <select name="" class="field-select">
                            <option value="">남녀 모두</option>
                            <option value="">남자만</option>
                            <option value="">여자만</option>
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <select name="" class="field-select">
                            <option value="">주차장 없음</option>
                            <option value="">무료주차</option>
                            <option value="">유료주차</option>
                        </select>
                        <select name="" class="field-select">
                            <option value="">10~15명</option>
                            <option value="">12~18명</option>
                        </select>
                        <select name="" class="field-select">
                            <option value="">풋살화/운동화</option>
                            <option value="">상관없음</option>
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
                    <td>
                        <p style="margin-left: 5px;">*경기장 정보</p>
                        <textarea style="resize: none;" name="" cols="50" rows="10"></textarea>
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
	<jsp:include page="../common/footer.jsp" />
	
</body>
</body>
</html>