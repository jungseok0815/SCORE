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

    <div class="outer">
        <h3 align="center" style="color: dodgerblue; margin-bottom: 20px;">팀 구인 글 등록</h3>

        <form action="insertTeamOffer.tm">
            <div class="file-upload">
                <div class="mb-3">
                    <label for="formFile" class="form-label">사진을 등록해보아요</label>
                    <input class="form-control" type="file" id="formFile">
                </div>
                <div class="insert-field">
                    <h6>팀 홍보를 해보아요</h6>
                    <textarea name="" id="text-area" cols="30" rows="10" placeholder="여기에 입력하세요"></textarea>
                    
                </div>
            </div>

            <div align="center">
                <button type="reset" class="btn btn-secondary" style="margin-top: 10px;">뒤로가기</button>
                <button type="submit" class="btn btn-primary" style="margin-top: 10px;">등록하기</button>
            </div>
        </form>
    </div>

    <jsp:include page="../common/footer.jsp" />
</body>
</html>