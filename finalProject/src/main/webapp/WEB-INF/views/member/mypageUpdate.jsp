<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/member/myPageUpdate.css" >
</head>
<body>
   <jsp:include page="../common/header.jsp" />   
   
   <div class="title"> 
        <div class="title2">

            <img src="/img/img1.jpg" class="img3">
            <div class="a-btn">
                <label for="file">
                <div class="btn-upload">파일 업로드하기</div>
                </label>
                <input type="file" name="file" id="file">
            </div>
            
            <div class="title3">이름</div>
            <input type="text" value="${loginUser.userName}" class="input-1">
            <button class="b-btn" onclick="">수정</button>

            <div class="title4">연락처</div>
            <input type="text" value="${loginUser.phone}" class="input-1">
            <button class="b-btn" onclick="">수정</button>

            <div class="title4">나이</div>
            <input type="text" value="${loginUser.age}" class="input-1">
            <button class="b-btn" onclick="">수정</button>

            <div class="title4">선호 지역</div>
            <input type="text" value="${loginUser.address}" class="input-1">
            <button class="b-btn" onclick="">수정</button>


            <div class="title4">성별</div>
            <div class="select">
                <input type="radio" id="select" name="gender"><label for="select">남자</label>
                <input type="radio" id="select2" name="gender"><label for="select2">여자</label>
            </div>

            <div class="like-style">
                <p class="title4">좋아하는 스타일</p>
                <div class="like-position-lineONe">
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
            </div>
        
               <div class="like-position">
                    <p class="title4">자신있는 능력</p>
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
                            <input type="checkbox" value="1"><span>스피드</span>
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

            <button class="subm-btn" onclick="">저장하기</button>

        </div>
    </div>
   
   <jsp:include page="../common/footer.jsp" />
</body>
</html>