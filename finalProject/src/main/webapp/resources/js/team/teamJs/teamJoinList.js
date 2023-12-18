init = (tno) => {
    console.log(tno)

    data = {
        tno : tno,
    }

    teamJoinAjaxController.teamJoinList(data, drawteamJoinList);
}

drawteamJoinList = (result) =>{
	console.log(result);

    let pi = result.model.pi;
    console.log(list)
    console.log(pi)
    
    let str = "";
    for (let r of list) {
        str += '<div class="all">'
            + '<div class="topWrapper">'
                + '<div class="top_container">'
                    + '<span class="memberListCount"><img src=""  class="top-member-img"/> | 멤버관리</span>'
                + '</div>'
                
                + '<div class="team-list">'
                    + '<div class="team-list-container">'
                        + '<ul>'
                            + '<li class="team-list-item">'
                                + '<div>'
                                    + '<a href="" class="list-link">'
                                       + '<div class="list-img-all">'
                                            + '<img src="' + r.memberChangeName + '" class="list-img"/>'
                                        + '</div>'
                                        + '<div class="list-content">'
                                            + '<div class="list-title">'
                                                + '<span class="memberName">' + r.userName + '</span>'
                                            + '</div>'
                                            + '<span class="list-member">' + r.gender + '·' + r.userLevel + '·' + r.userBirth + '세 ·' + r.city + '</span>'
                                        + '</div>'
                                    + '</a>'
                                + '</div> '
                                + '<div>'
                                    + '<div class="list-member-x">'
                                        + `<a onclick="location.href='refuse.tm?reqNo=` + r.reqNo + '"><img src="./resources/img/team/teamJoinList/x.png" class="list-img-x"/></a>'
                                    + '</div>'
                                + '</div>'
                                + '<div>'
                                    + '<div class="list-text">'
                                        + r.reqContent
                                    + '</div>'
                                + '</div>'
                                + '<div>'
                                    +'<a>'
                                        +'<div class="btnList">'
                                       
                                            +'<button onclick="refuse(' + r.reqNo + ')" class="buttonRe btnFloat btnLightBlue"></button>'
                                           
                                            +`<a onclick="location.href='accept.tm?reqNo=` + r.reqNo + '" class="buttonAc btnFloat2 btnLightBlue2"></a>'
                                        +'</div>'
                                    +'</a>'
                                +'</div>'
                            +'</li>'
                        +'</ul> '
                    +'</div>'
                +'</div>'
            +'</div>'
        +'</div>'
    }
    document.querySelector("#joinTeam").innerHTML = str;
}





// refuse = (reqNo) => {
//     console.log(reqNo)
    
//     data = {
//         reqNo : reqNo,
//     }

//     teamJoinAjaxController.refuseList(data, drawrefuseList);
// }

// drawrefuseList = (result) =>{
//     console.log(result)
//     if(typeof result === 'number' && result > 0){
//         alert("거절 완료") 
//     } else {
//         alert("거절 실패") 
//     }   
// }

