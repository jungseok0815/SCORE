<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script src="resources/js/member/memberJs/member.js"></script>
    <link rel="stylesheet" href="/final/resources/css/member/login.css">
    <link rel="stylesheet" href="/final/resources/css/member/findUserInfo.css">
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <div class="login-header" align="center">
        <h2>운동하고 싶을땐</h2> 
        <h2 class="login-main-name">Score</h2>
    </div>
	 <div class="login-main">
        <form action="login.me" method="post">
            <div class="login-middle">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control id" id="floatingInput" name="userId" placeholder="name@example.com">
                    <label for="floatingInput">아이디 또는 이메일</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" name="userPwd" placeholder="Password">
                    <label for="floatingPassword">비밀번호</label>
                </div>
            </div>
            <div class="login-footer">
                <div class="checkbox-wrapper-1 save-id">
                    <input id="example-1" class="substituted" type="checkbox" aria-hidden="true" />
                    <label for="example-1">아이디 저장</label>
                </div>
                <div class="d-grid gap-2 login-btn-div" >
                    <button class="btn btn-primary" id="login-btn" type="submit">login</button>
                </div>
                <div align="center" class="find-join-area">
                    <div class="login-find-User" data-bs-toggle="modal" data-bs-target="#exampleModal">아이디/비밀번호 찾기</div>
                    <div class="login-join" onclick="location.href ='joinView.me'">회원가입</div>
                </div>
        </form>
   
	  
    </div>
    <!-- 아이디 비밀번로 찾기 모달 -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
                <div>
                    <h1>아이디 비밀번호 찾기</h1>
                    <p class="modal-font">휴대폰 인증을 하면 회원가입된 아이디를 알려드려요</p>
                </div>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
             </div>
            <div class="modal-body">
                <div class="find-modal-body">
                    <div class="find-id-div"><button class="btn btn-primary find-id-btn" onclick="drawFindId()">아이디 찾기</button></div>
                    <div class="find-password-div"><button class="btn btn-primary find-password-btn" onclick="drawFindPassword()">비밀번호 찾기</button></div>
                </div>
                <div class="find-area">
                </div>
        
            <div class="find-modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            </div>
          </div>
        </div>
      </div>

  


</body>
</html>