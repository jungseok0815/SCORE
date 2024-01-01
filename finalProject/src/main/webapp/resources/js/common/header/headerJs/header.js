let socket;
showChatting = () =>{
    const chatingDiv =  document.querySelector(".messageDiv")
    if(chatingDiv.style.display === "none"){
        chatingDiv.style.display = "block"
        memberAjaxController.selectFriendList(drawChattingMemberList)
    }else{
        chatingDiv.style.display = "none"
    }
}

//친구리스트 가져오는 Ajax호출
chattingMemberList = () =>{
    memberAjaxController.selectFriendList(drawChattingMemberList)
}
//친구리스트를 가져와서 그려주는 부분
drawChattingMemberList = (friendList) =>{
    document.querySelector(".chatting-infobar").innerHTML = ""
    drawChattingSearchbarFriend(friendList)
    drawCahttingFriendList(friendList)
}
//친구검색 기능을 그려주는 부분
drawChattingSearchbarFriend = () =>{
    const userPart =  document.querySelector(".chatting-infobar")
    const divTag = document.createElement("div");
    const searchPart = document.createElement("input")
    searchPart.className = "chatting-search"
    divTag.className = "chatting-search-div"
    divTag.appendChild(searchPart);
    userPart.appendChild(divTag)
    searchPart.onkeyup = () =>{
       selectChattingFriend(searchPart.value)
    }
}
//친구 검색 Ajax
selectChattingFriend = (value) =>{
    console.log(value)
    data = {
        selectValue : value
    }
    commonHeaderAjaxController.chattingSelectFriendAjax(data,drawCahttingSelectFriendList)
}
//검색후 그려주는 함수
drawCahttingSelectFriendList = (selectFriendList) =>{
    drawCahttingFriendList(selectFriendList)
}
//친구 리스트를 그려주는 함수
drawCahttingFriendList = (friendList) =>{
    const test1 =  document.querySelectorAll(".chatting-friend-list")
    console.log(friendList)
        for(let i =0; i<test1.length; i++){
            test1[i].remove();
        }

   const chattingFriendlistDiv =  document.querySelector(".chatting-infobar")
    for(let i = 0; i<friendList.length; i++){
    //친구들의 프로필
       const chattingFriendList =  document.createElement("div")
       chattingFriendList.className = "chatting-friend-list"
       const chattingFriendProfile =  document.createElement("div")
       chattingFriendProfile.className = "chatting-friend-profile"
       chattingFriendProfile.innerHTML =`<img class ='chatting-profile-img' src =.`+friendList[i].memberChangeName +`/>`
       chattingFriendList.appendChild(chattingFriendProfile)
       

    //친구들의 정보
        const chattingFriendInfo = document.createElement("div")
        chattingFriendInfo.className ="chatting-friend-info"
        chattingFriendInfo.ondblclick = () =>{
            console.log([friendList[i]])
            addChattingRoom([friendList[i].userNo],0)
        
        }
        chattingFriendInfo.innerHTML = friendList[i].userName+`(`+friendList[i].userId+`)`
        chattingFriendList.appendChild(chattingFriendInfo)
        chattingFriendlistDiv.appendChild(chattingFriendList)
        i === friendList.length-1 ?  chattingFriendList.className = "chatting-friend-list chatting-friend-list-botton" : ""
    }
}


//채팅 팀리스트 
chattingTeamList = () =>{
    commonHeaderAjaxController.chattingMyTeamAjax(drawChttingTeamList);
}

drawChttingTeamList = (myTeamList) =>{
    document.querySelector(".chatting-infobar").innerHTML = ""
    drawChattingSearchbarTeam(myTeamList)
    drawCahttingTeamList(myTeamList)
}


//팀검색 input창을 그려주는 부분
drawChattingSearchbarTeam = () =>{
    const userPart =  document.querySelector(".chatting-infobar")
    const divTag = document.createElement("div");
    const searchPart = document.createElement("input")
    searchPart.className = "chatting-search"
    divTag.className = "chatting-search-div"
    divTag.appendChild(searchPart);
    userPart.appendChild(divTag)
    searchPart.onkeyup = () =>{
       selectChattingTeam(searchPart.value)
    }
}


//
selectChattingTeam = (value) =>{
    data = {
        selectValue : value
    }
    commonHeaderAjaxController.chattingSelectTeamAjax(data,drawCahttingTeamList)
}

drawCahttingSelectTeamList = (SelectTeamList) =>{
    drawCahttingTeamList(SelectTeamList)
}

//팀 리스트를 그려주는 함수
drawCahttingTeamList = (teamList) =>{
    console.log(teamList)
    const test1 =  document.querySelectorAll(".chatting-friend-list")
        for(let i =0; i<test1.length; i++){
            test1[i].remove();
        }

   const chattingFriendlistDiv =  document.querySelector(".chatting-infobar")
    for(let i = 0; i<teamList.length; i++){
    //팀 프로필
       const chattingFriendList =  document.createElement("div")
       chattingFriendList.className = "chatting-friend-list"
       const chattingFriendProfile =  document.createElement("div")
       chattingFriendProfile.className = "chatting-friend-profile"
       chattingFriendProfile.innerHTML =`<img class ='chatting-profile-img' src =`+teamList[i].teamChangeName +`/>`
       chattingFriendList.appendChild(chattingFriendProfile)
       

    //팀 정보
        const chattingFriendInfo = document.createElement("div")
        chattingFriendInfo.className ="chatting-friend-info"
        chattingFriendInfo.ondblclick = () =>{
            console.log(teamList[i].teamNo)
            data = {
                teamNo :teamList[i].teamNo
            }
            console.log(teamList[i].teamName)
            commonHeaderAjaxController.selectTeamMemberListAjax(data,drawSelectTeamMemberList,teamList[i].teamName) 
        }
        chattingFriendInfo.innerHTML = teamList[i].teamName
        chattingFriendList.appendChild(chattingFriendInfo)

        chattingFriendlistDiv.appendChild(chattingFriendList)

        i === teamList.length-1 ?  chattingFriendList.className = "chatting-friend-list chatting-friend-list-botton" : ""
     
    }
}   
//팀원정보를 가져와 선택하여 채팅 방을 만드는 함수
drawSelectTeamMemberList = (result,teamName,teamNo) =>{
    console.log(teamName)
    console.log(teamNo)
    const memberList = result.list;
    const loginuser = result.loginUser;
    const teamMemberListbody = document.querySelector(".team-member-list-body")
    teamMemberListbody.innerHTML = ""
    teamMemberListbody.style.display = "block";
    const teamChattingbutton = document.createElement("button");
 
    const teamMemberButtondiv = document.createElement("div");
    const teamNameDiv = document.createElement("div");
    teamNameDiv.className = "team-member-list-title"
    teamNameDiv.innerHTML = teamName
    teamChattingbutton.innerText = "초대"
    const teamMemberdiv = document.createElement("div");
    teamMemberButtondiv.appendChild(teamChattingbutton)
    teamMemberdiv.className = "team-member-list-div"
    teamMemberButtondiv.className = "team-member-button-div"
    teamChattingbutton.className ="btn btn-outline-primary team-member-list-button"
    teamChattingbutton.onclick =() =>{
        const ChattingMember = []
        const checkMemberList =  document.querySelectorAll(".member-team-list input[type='checkbox']")
        for(let i = 0; i<checkMemberList.length; i++){
            if(checkMemberList[i].checked === true){
                ChattingMember.push(checkMemberList[i].value)
            }
        }
        const ChattingMemberArr = ChattingMember.map(value => parseInt(value, 10));
        addChattingRoom(ChattingMemberArr,teamNo)
        teamMemberListbody.style.display = "none";
    }
    for(let i of memberList){
        if(i.userNo !== loginuser.userNo){
            teamMemberdiv.innerHTML += `<div class="member-team-list">`+
                                            `<div class="member-team-list-profile">`+
                                            `<img class="member-team-list-img" src=".`+i.memberChangeName+`">`+
                                            `</div>`+
                                            `<div>`+
                                            `<div>`+i.userName+`</div>`+
                                            `<input type='checkbox' value=`+i.userNo+`>`+
                                            `<div>`+
                                            `</div>`

                                            
        }
    }
    teamMemberListbody.appendChild(teamNameDiv)
    teamMemberListbody.appendChild(teamMemberdiv)
    teamMemberListbody.appendChild(teamMemberButtondiv)
}
    

//채팅리스트를 가져오는 함수
chatiingRoomList = () =>{
    commonHeaderAjaxController.selectChatiingRoomListAjax(drawChattingRoomList)
}




//채팅리스트를 그려주는 함수
drawChattingRoomList = (result) =>{
    let teamArr = []
    const userPart =  document.querySelector(".chatting-infobar")
    const list =result.list;
    const user = result.loginUser
    const message = result.message
    userPart.innerHTML = "";
    console.log(result)
    for(let i =0; i< list.length; i++){
        const divTag = document.createElement("div");
       for(let j =0; j<list[i].length; j++){
            if(list[i].length === 2){
                if(list[i][j].userNo !== user.userNo && list[i][j].teamNo === 0){
                    //친구들의 프로필
                const chattingFriendList =  document.createElement("div")
                chattingFriendList.className = "chatting-chatting-list"
                const chattingFriendProfile =  document.createElement("div")
                chattingFriendProfile.className = "chatting-friend-profile"
                chattingFriendProfile.innerHTML =`<img class ='chatting-profile-img' src =.`+list[i][j].memberChangeName +`/>`
                chattingFriendList.appendChild(chattingFriendProfile)
                

                //친구들의 정보
                const chattingFriendInfo = document.createElement("div")
                chattingFriendInfo.className ="chatting-chatting-info"
                chattingFriendInfo.ondblclick = () =>{
                    addChattingRoom([list[i][j].userNo],0)                  
                }
                chattingFriendInfo.innerHTML = `<div>`+list[i][j].userName+`(`+list[i][j].userId+`)</div>`
                                                +`<div class ="chattinglist-area2">`
                                                + `<div>`+message[i].messageText+`</div>`+
                                                `<div class="message-date">`+message[i].semdDate+`</div>`+
                                                `</div>`
                chattingFriendList.appendChild(chattingFriendInfo)
                userPart.appendChild(chattingFriendList)
                }
            }else{
                //친구들의 프로필
                if(list[i][j].userNo !== user.userNo){
                    teamArr.push(list[i][j].userNo)
                }
                if(j === list[i].length-1){
                    team = teamArr
                    const chattingFriendList =  document.createElement("div")
                    chattingFriendList.className = "chatting-chatting-list"
                    const chattingFriendProfile =  document.createElement("div")
                    chattingFriendProfile.className = "chatting-friend-profile"
                    chattingFriendProfile.innerHTML =`<img class ='chatting-profile-img' src =./`+list[i][j].teamChangeName +`/>`
                    chattingFriendList.appendChild(chattingFriendProfile)
                    
    
                    //친구들의 정보
                    const chattingFriendInfo = document.createElement("div")
                    chattingFriendInfo.className ="chatting-chatting-info"
                    chattingFriendInfo.ondblclick = () =>{
                        addChattingRoom(team,list[i][j].teamNo)                  
                    }
                    chattingFriendInfo.innerHTML = `<div>`+list[i][j].teamName+`(`+list[i].length+`)</div>`
                                                  +`<div class ="chattinglist-area2">`
                                                    + `<div>`+message[i].messageText+`</div>`+
                                                      `<div class="message-date">`+message[i].semdDate+`</div>`
                                                    +`</div>`
                    chattingFriendList.appendChild(chattingFriendInfo)
                    userPart.appendChild(chattingFriendList)
                   
                }
            }
       }
       teamArr = []
    }
}



startChatting = () =>{
    socket = new WebSocket("ws://localhost:8088/final/chatting");
    
    //socket연결 성공시
    socket.onopen = function(){
        console.log("웹소켓 연결ok...");
        
    }

    //socket연결 끊어졌을 시
    socket.onclose = function(){
        console.log("웹소켓 끊어짐...");
    }

    //socket연결 실패했을 시
    socket.onerror = function(){
        console.log("웹소켓 연결 실패...");
        alert("웹소캣 연결 실패");
    }

    socket.onmessage = function(ev){
        const receive = JSON.parse(ev.data);
        console.log(receive);
        drawChartMessage(receive)
    }
}

//채팅방을 만드는 함수
addChattingRoom =(chattingUser,teamNo)=>{
    console.log(chattingUser)
    console.log(teamNo)
    chattingMember = JSON.stringify(chattingUser)
    data = {
        chattingMember,
        teamNo
    }
    commonHeaderAjaxController.addChattingRoomAjax(data,choiceChatting)
}
//채팅방이 이미 있는지 없는지 확인하고 그에 맞는 함수 실행
choiceChatting = (result) =>{
    console.log(result);
    if(result.result  === "alreadyChattingRoom"){
        //채팅창 정보를 그려준뒤에서 실행
        startChatting()
        data = {
            roomNo : result.roomNo
        }
        drawChattingRoom(result)
        commonHeaderAjaxController.selectChattingList(data,drawalreadyChattingList)
    }else if(result === "addChattingRoomFail"){
        alert("방생성성 실패")
    }else{
        startChatting()
        drawChattingRoom(result)
    }
}

//채팅방 그려주는 함수
drawChattingRoom = (chattingUser) =>{
    // console.log(roomNo)
    // data = {
    //     roomNo
    // }
    // commonHeaderAjaxController.saveRoomNoAjax(data)

    const chattingRoom =  document.querySelector(".chatting-infobar")
    chattingRoom.innerHTML = ""
    const chattingRoomDiv = document.createElement("div")
    chattingRoomDiv.className = "chattingRoomDiv";
    const chattingRoominput = document.createElement("textArea")
    chattingRoominput.className = "chattingRoominput"
    chattingRoominput.onkeyup = (ev) =>{
        if(chattingRoominput.value === "\n")
            return;

        ev.keyCode === 13 ?  sendMessageFriend(chattingUser,chattingRoominput.value) : ""
    }
    chattingRoom.appendChild(chattingRoomDiv)
    chattingRoom.appendChild(chattingRoominput)
}
//이미 채팅방이 있다면 해당 채팅을 그려주는 함수
drawalreadyChattingList = (list) =>{

    const chattingList = list.chattingList
    console.log(chattingList)
    const loginUser = list.loginUser;
    for(let i of chattingList){
        if(i.userNo === loginUser.userNo){
            drawChartMessageMe(i.messageText)
        }else{
            console.log(i)
            drawChartMessage(i);

        }
    }


}

//상대방이 보낸 채팅을 그려주는 함수
drawChartMessage = (receive) =>{
    const chattingMessageArea =  document.querySelector(".chattingRoomDiv")
    chattingMessageArea.innerHTML += `<div class = "message-area">`+
                            `<img class ='message-area-img' src =.`+receive.memberChangeName+`/>`+
                            `<div class = "message-area-middle">`+
                            `<div class = "messagge-user-name">`+receive.userName+`</div>`+
                            `<div class = "message-title">`+receive.messageText+`</div>`+
                           `</div>`
 }
 //내가 보낸 채팅을 그려주는 함수 
 drawChartMessageMe = (message) =>{
    const chattingMessageArea =  document.querySelector(".chattingRoomDiv")
    chattingMessageArea.innerHTML += `<div class = "message-area-me">`+
    `<div class = "message-title">`+message+`</div>`+
   `</div>`
 }
//소켓을 통해 메세지 보낸다.
sendMessageFriend = (chattingUser,message) =>{
    console.log(chattingUser)

    const data = {
        // target : chattingUser,
        message
    }
    console.log(JSON.stringify(data))
    socket.send(JSON.stringify(data));
    document.querySelector(".chattingRoominput").value=""
    drawChartMessageMe(message)
}





