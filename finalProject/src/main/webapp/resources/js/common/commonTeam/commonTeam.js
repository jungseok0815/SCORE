const haderValue = {
    eventFlag: null,
    tmp: {}
}

selectReqResList = () =>{
    commonAjaxController.selectReqResListAjax((data) => {
        haderValue.tmp = data;
    })
}



searchMain =() =>{
    const selectValue = document.querySelector(".search-bar > input").value
    
    clearTimeout(haderValue.eventFlag);
    haderValue.eventFlag = setTimeout(() => {  
        const data = {
        selectValue: selectValue
        };
    if (selectValue.length >= 1) {
        commonAjaxController.searchMain(data, (result) => {
        result === null ? [] : result;
        const selectResult = result;
        drawSearchResult(selectResult);
        });
    }
    }, 300);
    if(selectValue.length === 0){
        document.querySelector(".search-data").style.display = 'none'
    }
}

drawSearchResult = (selectResult) =>{
    console.log(haderValue.tmp)
    document.querySelector(".search-data").style.display = 'block'; 
    if(selectResult !== null){
        console.log(selectResult);
        const mList = selectResult.mList;
        const pList = selectResult.pList;
        const tList = selectResult.tList;
        const memberArea = document.querySelector(".member-search")
        const teamArea = document.querySelector(".team-search")
        const plaveArea = document.querySelector(".place-search")

        const memberList = document.createElement("div");
        memberList.style.textAlign = "center";
        const teamList = document.createElement("div");
        teamList.style.textAlign = "center";
        const placeList = document.createElement("div");
        placeList.style.textAlign = "center";
        const notingMsg = "검색 결과가 존재하지 않습니다.";

        if(mList.length === 0){
            memberArea.innerHTML = ""
            memberList.innerHTML = notingMsg;
            memberArea.appendChild(memberList);
            
        }else{
            console.log(mList)
            memberArea.innerHTML = ""
            for(let a of mList){
                let status = false;
                for(let b of  haderValue.tmp){
                    if(a.userNo===b.friendReqUser){
                        status= true;
                        break
                    }
                    else{ 
                        status= false;
                    }
                }     
                if(status===true){
                        const postFriendBTn = document.createElement("button");
                        postFriendBTn.className="btn btn-outline-primary";
                        postFriendBTn.innerText = "친구 프로필!"
                        postFriendBTn.onclick =() =>{
                            location.href = "/final/myPage.me?userNo="+a.userNo
                        }
                        const divtag2 =  document.createElement("div")
                        const spanTag =  document.createElement("span");
                        const spanTag2 =  document.createElement("span");
                        spanTag.innerHTML = "아이디: " + a.userId;
                        spanTag2.innerHTML = "이름 : " + a.userName;
                        divtag2.appendChild(spanTag)
                        divtag2.appendChild(spanTag2)
                        memberList.appendChild(divtag2);
                        memberList.appendChild(postFriendBTn);
                }else{
                        const postFriendBTn = document.createElement("button");
                        postFriendBTn.className="btn btn-outline-primary";
                        postFriendBTn.innerText = "친구요청"
                        postFriendBTn.onclick = () => {sendPostFriend(a.userNo)};
                        const divtag2 =  document.createElement("div")
                        const spanTag =  document.createElement("span");
                        const spanTag2 =  document.createElement("span");
                        spanTag.innerHTML = "아이디: " + a.userId;
                        spanTag2.innerHTML = "이름 : " + a.userName;
                        divtag2.appendChild(spanTag)
                        divtag2.appendChild(spanTag2)
                        memberList.appendChild(divtag2);
                        memberList.appendChild(postFriendBTn);
                    
                }
            }
         
            memberArea.appendChild(memberList);
        }

        if(pList.length === 0){
            plaveArea.innerHTML = ""
            placeList.innerHTML = notingMsg;
            plaveArea.appendChild(placeList);
            
        }else{
            for(let a of pList){
                plaveArea.innerHTML = ""
                let category = checkCategory(a.categoryNum);     
                const selectPlaceBtn = document.createElement("button");
                selectPlaceBtn.innerText = "경기장 보러가기"
                selectPlaceBtn.className="btn btn-outline-primary";
                selectPlaceBtn.onclick = () =>{
                    selectPlace();
                }
              
                const divtag2 =  document.createElement("div")
                const spanTag =  document.createElement("span");
                const spanTag2 =  document.createElement("span");
                spanTag.innerHTML = "경기장 : " + a.fieldName;
                spanTag2.innerHTML = "종목: " + category;
                divtag2.appendChild(spanTag);
                divtag2.appendChild(spanTag2);
                placeList.appendChild(divtag2);
                placeList.appendChild(selectPlaceBtn)
            }
            plaveArea.appendChild(placeList)
        }
        if(tList.length === 0){
            teamArea.innerHTML = ""
            teamList.innerHTML = notingMsg;
            teamArea.appendChild(teamList);   
        }else{
            for(let a of tList){
                teamArea.innerHTML = ""
                let category = checkCategory(a.categoryNum);
                const selectTeamBtn = document.createElement("button")
                selectTeamBtn.innerText = "팀 프로필 보기"
                selectTeamBtn.className="btn btn-outline-primary";
                selectTeamBtn.onclick=()=>{
                    selectTeam();
                }
           
                const divtag2 =  document.createElement("div")
                const spanTag =  document.createElement("span");
                const spanTag2 =  document.createElement("span");
                spanTag.innerHTML = "팀 이름 : " + a.teamName;
                spanTag2.innerHTML = "종목: " + category;
                divtag2.appendChild(spanTag);
                divtag2.appendChild(spanTag2);
                teamList.appendChild(divtag2)
                teamList.appendChild(selectTeamBtn)
            }
            teamArea.appendChild(teamList)
        }
    }   
}

checkCategory = (categoryNum) =>{
    let category;
    if(categoryNum === 1)
    category = "풋살"
    else if(categoryNum === 2)
    category = "야구"
    else
    category = "농구"
    return category;
}


sendPostFriend = (reqUser) =>{
    if(window.confirm("친구 신청을 하겠습니까?")){
        data = {
            friendReqUser  :reqUser
        }
        commonAjaxController.sendFostFreind(data)
    }else{

    }

}

// selectPlace=()=>{
//     console.log("나는 농구가 하고싶다.");
// }

// selectTeam=()=>{
//     console.log("차정석 팀")
// }





     
           









