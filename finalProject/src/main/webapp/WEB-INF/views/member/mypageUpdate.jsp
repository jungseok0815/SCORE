<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/final/resources/css/member/myPageUpdate.css" >
    <script type="text/javascript" src="./resources/js/member/mypageJs/mypage.js?ver=2"></script>
    <script type="text/javascript" src="./resources/js/member/mypageAjax/mypageAjax.js"></script> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
   <jsp:include page="../common/header.jsp" />   
   
   <div class="title"> 
        <form action="reMyPageUpdate.me" method="post"  enctype="multipart/form-data" class="formUpdate">
            <input type="hidden" name="userNo" value="${loginUser.userNo}" />
            <div class="title2">
                
                <div class="imgUpload">
                    <img src="/resources/img/member/memberInsert" class="img3" id="img-upload-my"/>
                </div>
                
                <div class="a-btn">
                    <label for="file">
                        <div class="btn-upload">파일 업로드하기</div>
                        <div>사진을 수정해주세요</div>
                    </label>
                    <input type="file" name="reupfile" id="file"  onchange="imgChangeUpdate(this)" />
                </div>
                
            
                <div class="title3">이름</div>
                <input type="text" value="${loginUser.userName}" class="input-1" name="userName">
                <button class="b-btn" onclick="">수정</button>

                <div class="title4">연락처</div>
                <input type="text" value="${loginUser.phone}" class="input-1" name="phone">
                <button class="b-btn" onclick="">수정</button>

                <div class="title4">나이</div>
                <input type="text" value="${loginUser.age}" class="input-1" name="age">
                <button class="b-btn" onclick="">수정</button>

                <div class="title4">선호 지역</div>
                <input type="text" value="${loginUser.address}" class="input-1" name="address">
                <button class="b-btn" onclick="">수정</button>>

                <div class="like-style">
                    <p class="title4">종목</p>
                    <div class="like-position-lineONe">
                        <div class="cat comedy">
                            <label>
                            <input type="radio" class="radioCategoryNum" value="1" name="categoryNum" onclick="updateMypage(1)"><span>축구</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="radio" class="radioCategoryNum" value="2" name="categoryNum" onclick="updateMypage(2)"><span>야구</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="radio" class="radioCategoryNum" value="3" name="categoryNum" onclick="updateMypage(3)"><span>농구</span>
                            </label>
                        </div>  
                    </div>
                </div>

                
                <div class="title4">성별</div>
                <div class="select">
                    <input type="radio" id="select" name="gender" value="남자"><label for="select">남자</label>
                    <input type="radio" id="select2" name="gender" value="여자"><label for="select2">여자</label>
                </div>

                <div class="like-style">
                    <p class="title4">좋아하는 스타일</p>
                    <div class="like-position-lineONe" id="like-position">
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" class="checkStyle" value="attack" name="style"><span>공격</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" class="checkStyle" value="balance" name="style"><span>밸런스</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" class="checkStyle" value="defence" name="style"><span>수비</span>
                            </label>
                        </div>  
                    </div>
                </div>
            
                <div class="like-position">
                    <p class="title4">자신있는 능력</p>
                    <div class="like-position-lineONe position1">
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" class="checkSkill" value="shoot" name="skill"><span>슛</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" class="checkSkill" value="pass" name="skill"><span>패스</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" class="checkSkill" value="drible" name="skill"><span>드리블</span>
                            </label>
                        </div>
                    </div>
                    <div class="like-position-lineTwo position2">   
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox" class="checkSkill" value="speed" name="skill"><span>스피드</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox"class="checkSkill" value="physical" name="skill"><span>피지컬</span>
                            </label>
                        </div>
                        <div class="cat comedy">
                            <label>
                            <input type="checkbox"class="checkSkill" value="tikitaka" name="skill"><span>티키타카</span>
                            </label>
                        </div>   
                    </div>
                    <div class="btn-save">
                        <button type="submit" class="subm-btn" onclick="">저장하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>


    <script>
        if("${loginUser.gender}" === "남자"){
            document.querySelector("#select").checked = true;
        }
        else{
            document.querySelector("#select2").checked = true;
        }
  
       

        const categoryNumValue = "${sportInfo.categoryNum}"

        if(categoryNumValue === "1"){
            document.querySelector(".radioCategoryNum[value='1']").checked = true;
        } else if(categoryNumValue === "2"){
            document.querySelector(".radioCategoryNum[value='2']").checked = true;
        } else {
            document.querySelector(".radioCategoryNum[value='3']").checked = true;
        }
        
        
        //스킬
        const checkBoxList = document.querySelectorAll('.checkSkill');
        const skills = "${sportInfo.skill}";
        console.log(skills)
        const arr = skills.split(',');
        //console.log(arr)
        for(let i =0; i< arr.length; i++){
            for(let j = 0; j<checkBoxList.length; j++){
                if (arr[i].includes(checkBoxList[j].value)){
                     checkBoxList[j].checked = true;
                     break;
                }
            }
        }


        //스타일
        const checkBoxList2 = document.querySelectorAll('.checkStyle');
        const styles = "${sportInfo.style}";
        console.log(styles);
        const arr2 = styles.split(',');
        //console.log(arr2);
        for(let i =0; i<arr2.length; i++){
            for(let j=0; j<checkBoxList2.length; j++){
                if(arr2[i].includes(checkBoxList2[j].value)){
                    checkBoxList2[j].checked = true;
                    break;
                }
            }
        }
    </script>
   
   <jsp:include page="../common/footer.jsp" />
</body>
</html>