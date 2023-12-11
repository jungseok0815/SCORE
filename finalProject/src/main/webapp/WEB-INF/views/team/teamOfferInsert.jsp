<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/team/teamOfferInsert.css">
</head>
<body>
    <jsp:include page="../common/header.jsp" />

	<br>
    <div class="freeBoard-area" align="center">
        <form action="insert.tm" method="POST" enctype="multipart/form-data">
        
        	<input type="hidden" name="userNo" value="${loginUser.userNo}">
        	
            <table>
                <h1 align="center" style="font-size: 30px; color: dodgerblue;">팀 구인글 작성</h1>
                
                <!-- 성별 체크-->
                <div class="top_container">
                   	 성별
                    <ul>
                        <li class="btnLocal">
                            <input type="radio" name="offerGender" id="men" value="남자" checked><label for="men">남자</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerGender" id="woman"  value="여자"><label for="woman">여자</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerGender" id="sexual" value="무관"><label for="sexual">무관</label>
                        </li>
                    </ul> 
                </div>
                
                <!-- 나이대 체크-->
                <div class="top_container">
                                                나이
                    <ul>
                        <li class="btnLocal">
                            <input type="radio" name="offerAge" id="ten" value="10" checked><label for="ten">10대</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerAge" id="twenty"  value="20"><label for="twenty">20대</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerAge" id="thirty" value="30"><label for="thirty">30대</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerAge" id="forty" value="40"><label for="forty">40대</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerAge" id="problem" value="40"><label for="problem">무관</label>
                        </li>
                    </ul> 
                </div>

                <!-- 레벨 체크-->
                <div class="top_container">
                   	 레벨
                    <ul>
                        <li class="btnLocal">
                            <input type="radio" name="offerLevel" id="starter" value="스타터" checked><label for="starter">스타터</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerLevel" id="beginner"  value="비기너"><label for="beginner">비기너</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerLevel" id="amateur" value="아마추어"><label for="amateur">아마추어</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerLevel" id="semi" value="세미프로"><label for="semi">세미프로</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerLevel" id="pro" value="프로"><label for="pro">프로</label>
                        </li>
                        <li class="btnLocal">
                            <input type="radio" name="offerLevel" id="noproblem" value="무관"><label for="noproblem">무관</label>
                        </li>
                    </ul> 
                </div>
                
                <tr align="left">
                    <th>
                        	제목 
                    </th>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="offerTitle" class="text-area" placeholder="제목을 입력하세요">
                    </td>
                </tr>
                <tr align="left">
                    <th>
                        	작성자
                    </th>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="" class="text-area" value ="${loginUser.userName}" disabled >
                    </td>
                </tr>

                <div class="a-btn">
	                <label for="file">
	                    <div class="btn-upload">파일 업로드하기</div>
	                </label>
                    <input type="file" name="upfile" id="file">
                </div>

                <tr align="left">
                    <th>팀 홍보를 해보아요</th>
                </tr>
                <tr>
                    <td><textarea name="offerContent" id="" placeholder="내용을 입력하세요"></textarea></td>
                </tr>
               
                <tr>
                    <td align="center">
                        <input class="offer-btn1" type="button" value="돌아가기" onclick="location.href=''">
                        <input class="offer-btn" type="submit" value="저장"></input>
                    </td>
                    
                </tr>
            </table>

        </form>
    </div>
    <br>

    <jsp:include page="../common/footer.jsp" />
</body>
</html>