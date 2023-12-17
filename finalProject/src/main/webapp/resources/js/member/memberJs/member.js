
handleMemberJoin=()=>{
   const userInfo = document.querySelectorAll(".id");
   console.log(userInfo[5].value)
    const yearPart = userInfo[5].value.substring(0, 4); 
   // 현재 날짜를 나타내는 Date 객체 생성
   const currentDate = new Date();

    // 현재 연도를 가져오기
    const  currentYear = currentDate.getFullYear();
    const age = (currentYear - yearPart)+1;

    console.log(age)
    // 결과 출력
    console.log('현재 연도: ' + currentYear);
   const data = {
    userId : userInfo[0].value,
    userPwd : userInfo[1].value,
    userName : userInfo[3].value,
    gender : userInfo[4].value,
    age : age,
    address : userInfo[6].value,
    phone : userInfo[7].value,
   };
   
   if(checkJoin() === "ok"){
        // if(document.querySelector("#phone-certified-btn").innerText === "인증완료"){
            memberAjaxController.getJoinMemeber(data,memberJoin)
        // }else{
        //     alert("휴대폰 인증을 진행해주세요")
        // }
     
   }else if(checkJoin() ==="fail1"){
        alert("비밀번호 형식에 맞추어 작성해주세요")
        return;
   }else{
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
        return
   }

}


memberJoin = (result) =>{
    modalSportInfo = [{
        categoryNum: 1,
        title : "Score  |  풋볼",
        favoriteStyle : ["공격", "밸런스", "수비"],
        favoriteStyleValue : ["attack","balance","defence"],
        ability : ["슛", "패스", "드리블", "스피드", "피지컬", "티키타카"],
        abilityValue : ["shoot","pass","drible","speed","physical","tikitaka"]
    },
    {
        categoryNum: 2,
        title : "Score  |  야구",
        favoriteStyle : ["타자", "포수", "투수"],
        favoriteStyleValue : ["batter","catcher","pitcher"],
        ability : ["구속", "파워", "좌투", "외야수", "내야수", "우투수"],
        abilityValue : ["bollSpeed","power","leftHanded","outfielder","infielder","rightHanded"]
    },
    {
        categoryNum: 3,
        title : "Score  |  농구",
        favoriteStyle : ["공격", "밸런스", "수비"],
        favoriteStyleValue : ["attack","balance","defence"],
        ability : ["슈팅가드", "포인트가드", "스몰포워드", "파워포워드", "센터", "올라운더"],
        abilityValue : ["shootGuard","pointGuard","smailForward","powerForward","center","allRounder"]
    }]

     document.querySelector("#modal-sportInfo").click();
      
        let i = 0;
        tmp(modalSportInfo[i]);
     document.querySelector("#userInfo-modal-btn2").onclick = ()=>{
        const data = handleMemberSportInfo(result.userNo,modalSportInfo[i].categoryNum);
        memberAjaxController.getMemberSportInfo(data, () => {
            if(i === modalSportInfo.length-1) {
                alert("회원가입 성공")
                location.href = "loginView.me"
            } else {
                i = i+1;
                tmp(modalSportInfo[i]);
            }
        })
     }
     document.querySelector("#userInfo-modal-btn").onclick = () =>{
        if(i === modalSportInfo.length-1) {
            alert("회원가입 성공")
            location.href = "loginView.me"
        } else {
            i = i+1;
            tmp(modalSportInfo[i]);
        }
     }
}

tmp = (infodata) =>{
    document.querySelector(".userInfo-modal-title").innerHTML =  infodata.title;
    document.querySelector(".like-style").innerHTML= ""
    document.querySelector(".like-style").innerHTML= "<p class='userInfo-modal-font'>좋아하는 스타일</p>"
    for(let j=0; j< infodata.favoriteStyle.length; j++){
        const str =  "<div class='cat comedy'>"+
                    "<label>"+
                    "<input type='checkbox' class='favorite-style' value='"+infodata.favoriteStyleValue[j]+"'>"+
                    "<span>"+infodata.favoriteStyle[j]+"</span>"

                       
        document.querySelector(".like-style").innerHTML+=str;    
    }

    document.querySelector(".like-position-lineONe").innerHTML="";
    document.querySelector(".like-position-lineTwo").innerHTML="";  
    for(let j=0; j< infodata.ability.length; j++){
        if(j<3){
            const str = "<div class='cat comedy'>"+
                            "<label>"+
                            "<input type='checkbox' class='ability' value='"+infodata.abilityValue[j]+"'>"+
                                "<span>"+infodata.ability[j]+"</span>"
            document.querySelector(".like-position-lineONe").innerHTML+=str;
        }else{
            const str = "<div class='cat comedy'>"+
            "<label>"+
            "<input type='checkbox' class='ability' value='"+infodata.abilityValue[j]+"'>"+
                "<span>"+infodata.ability[j]+"</span>"
            document.querySelector(".like-position-lineTwo").innerHTML+=str;    
        }
    }

}

handleMemberSportInfo=(userNo,categoryNum)=>{
    const ability = document.querySelectorAll(".ability");
    const fvStyle = document.querySelectorAll(".favorite-style");
    console.log(ability);
    console.log(fvStyle);

    // NodeList를 배열로 변환
    const abilityArr = [...ability].filter((a) => {
      return a.checked === true;
    });
    const newabilityArr = abilityArr.map((a) =>{
        return a.value;
    })
    console.log(newabilityArr)
   
    const abilityData = newabilityArr.join(",");
    
      // NodeList를 배열로 변환
    const fvStyleArr = [...fvStyle].filter((a) => {
        return a.checked === true;
      });
      const newfvStyleArr = fvStyleArr.map((a) =>{
          return a.value;
      })
    const fvStyleData = newfvStyleArr.join(",");
    console.log(newfvStyleArr)
  

    const data = {
        skill:  abilityData,
        style : fvStyleData,
        userNo,
        categoryNum
    }

    return data;
}


$(function(){
   const checkId =  document.querySelector(".userid")
   let eventFlag;
   checkId.onkeyup = () =>{
        clearTimeout(eventFlag);
        eventFlag = setTimeout(()=>{
            if(checkId.value.length >= 5) {
                data ={
                    checkId : checkId.value
                }
                memberAjaxController.getCheckUserID(data,drawCheckId)
            } else {
                // document.querySelector("#enrollForm [type='submit']").disabled = true;
                // checkResult.style.display = 'none';
            }
            
        }, 300);
    }
})


drawCheckId =(result) =>{
    const checkResult = document.getElementById("checkResult");
    if (result === "failCheckId"){ //사용불가능한 경우
        checkResult.style.display = 'block';
        checkResult.style.color = 'red';
        checkResult.innerText = "이미 사용중인 아이디입니다.";
    } else { //사용가능한 경우
        checkResult.style.display = 'block';
        checkResult.style.color = 'green';
        checkResult.innerText = "사용가능한 아이디입니다.";
    }
}

$(function(){
    const checkResult2 = document.getElementById("checkResult2");
    const checkResult3 = document.getElementById("checkResult3");
    const inputPwd = document.querySelectorAll('.join-half input[type="password"]')[0]
    const checkInputPwd = document.querySelectorAll('.join-half input[type="password"]')[1]

    //영문 숫자 특수기호 조합 8자리 이상
    let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/

    inputPwd.onkeyup = () =>{
        if(reg.test(inputPwd.value)){
            checkResult2.style.color = 'green';
            checkResult2.innerText="*비밀번호는 영문 숫자 특수기호 조합 8자리 이상 v"
        }else{
            checkResult2.style.color = 'red';
            checkResult2.innerText="*비밀번호는 영문 숫자 특수기호 조합 8자리 이상"
        }
    }

    checkInputPwd.onkeyup = () =>{
        if(inputPwd.value ===checkInputPwd.value){
            checkResult3.style.color = 'green';
            checkResult3.innerText="*비밀번호 확인v"
        }else{
            checkResult3.style.color = 'red';
            checkResult3.innerText="*비밀번호 확인"
        }
    }

})
checkJoin=()=>{
    const inputPwd = document.querySelectorAll('.join-half input[type="password"]')[0]
    const checkInputPwd = document.querySelectorAll('.join-half input[type="password"]')[1]

    //영문 숫자 특수기호 조합 8자리 이상
    let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/
    if(!reg.test(inputPwd.value)){
        return "fail1"
    }

    if(inputPwd.value !==checkInputPwd.value){
       return "fail12"
    }

    return "ok"
    
}


selectPostFriend = () =>{
    memberAjaxController.getPostFriend(drawSelectPostFriend);
} 

drawSelectPostFriend = (result) =>{
    console.log(result)
     document.querySelector("#aaaaaa").innerText = "친구요청 " + result.length+"명 |"
     
    const PostList  = document.querySelector("#postFriendList");
    PostList.innerHTML = "<div class = 'list-title'>친구요청 리스트</div>"

    for(let a of result){
        const postListDiv = document.createElement("div")
        postListDiv.className = "tt22";
        const listbtn = document.createElement("button")
        listbtn.innerText = '승락'
        listbtn.className = "btn-chexk";
        listbtn.onclick = () =>{
            addFriend(a.userNo);
        };
        const str = "<img class='img5'/>"+
                    "<div class='main-title'>"+a.userName+"</div>"+
                    "<div class='sub-title'>"+a.address+"</div>";
        postListDiv.innerHTML += str;
        postListDiv.appendChild(listbtn);
        PostList.appendChild(postListDiv);
    }
}


addFriend = (userNo) =>{
    console.log(userNo)
    data = {
        friendReqUser  : userNo
    }
    memberAjaxController.getAddFriend(data)
}


selectFriendList = () =>{

    memberAjaxController.selectFriendList(drawSelectfriendList)
    
}


drawSelectfriendList= (friendList) =>{
    document.querySelector("#bbbb").innerText = "친구" + friendList.length+"명 |";
    const PostList  = document.querySelector("#friendList");
    PostList.innerHTML = "<div class = 'list-title'>친구요청 리스트</div>"
    for(let a of friendList){
        const postListDiv = document.createElement("div")
        postListDiv.className = "tt22";
        const listbtn = document.createElement("button")
        listbtn.innerText = '친구삭제'
        listbtn.className = "btn-chexk2";
        listbtn.onclick = () =>{
            deleteFriend(a.userNo);
        };
        const str = "<img class='img5'/>"+
                    "<div class='main-title'>"+a.userName+"</div>"+
                    "<div class='sub-title'>"+a.address+"</div>";
        postListDiv.innerHTML += str;
        postListDiv.appendChild(listbtn);
        PostList.appendChild(postListDiv);
    }
}


deleteFriend= (userNo) =>{
    console.log(userNo);
    data = {
        friendReqUser : userNo
    }
    memberAjaxController.deleteFriend(data)
} 


document.querySelectorAll(".collapsed");
selectTeamList =() =>{

}


selectMyTeam = (categoryNum) => {
    console.log(categoryNum);
    data = {
        categoryNum : categoryNum
    }
    memberAjaxController.selectMyteamListAjax(data,drawMyTeamList);
}

drawMyTeamList = (teamListA) =>{
    document.querySelector(".football-part").innerHTML = ""
    document.querySelector(".baseball-part").innerHTML = ""
    document.querySelector(".basketball-part").innerHTML = ""
    for(let teamLIst of teamListA){
        const str = "<a href = /final/teamProfile.tm?teamNo="
                    +teamLIst.teamNo+">"
                    +"<img src=''>"
                    +"<p>"+teamLIst.teamName+"</p>"
        if(teamLIst.categoryNum===1){
            
            document.querySelector(".football-part").innerHTML += str;
        }else if(teamLIst.categoryNum===2){
            
            document.querySelector(".baseball-part").innerHTML += str;
        }else{
            
            document.querySelector(".basketball-part").innerHTML += str;
        }
       
    }
}

selectUserSportInfo =(categoryNum)=>{
    data = {
        categoryNum : categoryNum
    }
    memberAjaxController.selectUserSportInfoAjax(data,drawUserSportInfo)
}

drawUserSportInfo = (userSportInfo) =>{
    document.querySelector(".box2 > div").innerText = userSportInfo.sportScore;
    document.querySelector(".box22 > div").innerText = userSportInfo.sportLever;
    document.querySelector(".btn-4 > div").innerText = userSportInfo.sportCount;
    document.querySelector(".smile-card > div").innerText = userSportInfo.sportSmile;
    document.querySelector(".yellow-card > div").innerText = userSportInfo.sportYellow;
    document.querySelector(".red-card > div").innerText = userSportInfo.sportRed;
}


sendPhoneAuth = () =>{
    const regex = /^\d{11}$/;
    const phoneNum =  document.querySelector(".join-phone > input").value
   
    if(regex.test(phoneNum)){
        data = {
            phone : phoneNum
        }
        memberAjaxController.sendPhoneAuthAjax(data,drawAuthInput)
    }else{
        alert("올바르게 전화번로를 입력해주세요")
    }
    console.log("hihi")
}

drawAuthInput = () =>{
    document.querySelector("#authBtn").click()
    checkAuthTime()
}

checkAuthTime = () =>{
    let time = 30;
    let min = ""
    let sec = "";
   
    const x = setInterval(()=>{
        min = parseInt(time/60);
        sec = time%60;
        document.querySelector("#checkTime").style.color="black"
        document.querySelector("#checkTime").innerHTML = "유효시간 : "+ min+"분" + sec +"초";
        time --;

        if(time < 0){
            clearInterval(x)
            document.querySelector("#checkTime").style.color="red"
            document.querySelector("#checkTime").innerHTML = "시간초과"
        }

    },1000)
}

checkPhoneAuth =()=>{
    const authNum = document.querySelector("#floatingInput2").value
    const phoneNum =  document.querySelector(".join-phone > input").value
    data = {
        authNum : authNum,
        phone : phoneNum
    }
    memberAjaxController.checkPhoneAuthAjax(data,drawCheckPhoneAuth)
}

drawCheckPhoneAuth = (result) =>{
    if(result === "authOk"){
        alert("인증성공")
        document.querySelector("#auth-modal-close").click()
        document.querySelector("#phone-certified-btn").innerText = "인증완료"
        document.querySelector("#phone-certified-btn").disabled = true
    }else{
        alert("인증번호가 다릅니다.")
    }
}






























