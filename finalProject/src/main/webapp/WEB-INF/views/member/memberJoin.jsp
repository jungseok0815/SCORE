<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/final/resources/css/member/join.css">
    <link rel="stylesheet" href="/final/resources/css/member/joinModal.css">
</head>
</head>
<body>
    <div class="outer">
        <div class="join-main" >
            <div class="join-header">
                <h2>운동하고 싶을땐</h2>
                <h2 class="login-main-name">Score</h2>
            </div>
            <br><br><br>
            <form action="">
                <div class="join-middle">
                    <div class="form-floating mb-3">
                        <p class="join-font">아이디</p>
                        <input type="text" class="form-control id userid" id="floatingInput" placeholder="name@example.com">
                    </div> 
                    <div class="join-password-part">
                        <div class="form-floating mb-3 join-half">
                            <p class="join-font">비밀번호</p>
                            <input type="text" class="form-control id " id="floatingInput" placeholder="name@example.com">
                        </div> 
                        <div class="form-floating mb-3 join-half">
                            <p class="join-font">비밀번호 확인</p>
                            <input type="text" class="form-control id " id="floatingInput" placeholder="name@example.com">
                        </div> 
                    </div>
                    <div class="join-content">매치 참여시 본인 확인 및 안대톡을 보내드립니다.<br>
                        이름과 휴대폰 번호를 꼭 바르게 적어주세여
                    </div>
                    <br>
                    <div class="join-password-part">
                        <div class="form-floating mb-3 join-half">
                            <p class="join-font">이름</p>
                            <input type="text" class="form-control id" id="floatingInput" placeholder="name@example.com">
                        </div> 
                        <div class="form-floating mb-3 join-half">
                            <p class="join-font">성별</p>
                            <select type="text" class="form-control id" id="floatingInput" placeholder="name@example.com">
                                <option value="남자">남</option>
                                <option value="남자">여</option>
                            </select>
                        </div> 
                    </div>
                    <p class="join-font">휴대폰 번호</p>
                    <div class="join-password-part">
                        <div class="form-floating mb-3 join-phone">
                            <input type="text" class="form-control id" id="floatingInput" placeholder="name@example.com">
                        </div> 
                        <button type="button"  class="btn btn-primary" id="phone-certified-btn">인증요청</button>
                    </div>
                    <div class="d-grid gap-2 join-btn-div" >
                        <button class="btn btn-primary" id="join-btn" type="submit">회원가입</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Launch demo modal
      </button>

      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
                <div>
                    <h2>운동하고 싶을 땐</h2>
                    <h2 class="userInfo-modal-title">Score  |  풋살</h2>
                </div>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="margin-bottom: 10%;">
               <div class="like-style">
                <p class="userInfo-modal-font">좋아하는 스타일</p>
                    <div class="cat comedy">
                        <label>
                        <input type="checkbox" value="1"><span>공격</span>
                        </label>
                    </div>
                    <div class="cat comedy">
                        <label>
                        <input type="checkbox" value="1"><span>밸런스</span>
                        </label>
                    </div>
                    <div class="cat comedy">
                        <label>
                        <input type="checkbox" value="1"><span>수비</span>
                        </label>
                    </div>  
               </div>

               <div class="like-position">
                    <p class="userInfo-modal-font">자신있는 능력</p>
                    <div class="like-position-lineONe">
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" value="1"><span>슛</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" value="1"><span>패스</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" value="1"><span>드리블</span>
                            </label>
                        </div>
                    </div>
                    <div class="like-position-lineTwo">   
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" value="1"><span>스피트</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" value="1"><span>피지컬</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" value="1"><span>티키타카</span>
                            </label>
                        </div>   
                    </div>      
               </div>
            </div>
            <div class="footer">
              <button type="button" id="userInfo-modal-btn" class="btn btn-secondary" data-bs-dismiss="modal">건너뛰기</button>
              <button type="button" id="userInfo-modal-btn2" class="btn btn-primary">확인</button>
            </div>
          </div>
        </div>
      </div>
      




</body>
</html>