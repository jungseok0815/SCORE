
handleMemberJoin=()=>{
   const userInfo = document.querySelectorAll(".id");
   const data = {
    userId : userInfo[0].value,
    userPwd : userInfo[1].value,
    userName : userInfo[3].value,
    gender : userInfo[4].value,
    phone : userInfo[5].value
   };
   
   if(checkJoin() === "ok"){
        memberAjaxController.getJoinMemeber(data,memberJoin)
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





















