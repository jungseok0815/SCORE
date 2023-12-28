const commonHeaderAjaxController ={
    chattingSelectFriendAjax : (data,callback) =>{
        $.ajax({
            url: "chattingSelectFriend.cm",
            type: "post",
            data,
            success: (result) => {
                result.length > 0 ?  callback(result) : ""
            
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    //나의 팀 리스트를 가져오는 통신
    chattingMyTeamAjax : (callback) =>{
        $.ajax({
            url: "selectMyteam.tm",
            type: "post",
            success: (result) => {
               callback(result)
            
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    //나의 팀에서 검색하는 찾는 통신
    chattingSelectTeamAjax : (data,callback) =>{
        $.ajax({
            url: "chattingSelectTeam.cm",
            type: "post",
            data,
            success: (result) => {
                result.length > 0 ?  callback(result) : ""
            
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    //방을 저장하는 통신
    addChattingRoomAjax : (data,callback) =>{
        $.ajax({
            url: "addChattingRoom.ch",
            type: "post",
            data,
            success: (result) => {
              callback(result)
            },
            error: (err) => {
                console.log("asdasdas")
            }
        })
    },
    // 방 번호를 세션에 저장하는 통신
    saveRoomNoAjax : (data) =>{
        $.ajax({
            url: "saveRoomNoAjax.ch",
            type: "post",
            data ,
            success: (result) => {
              console.log(result);
            },
            error: (err) => {
                console.log("asdasdas")
            }
        })
    },
    //해당 방의 채팅목록을 가져오는 통신
    selectChattingList : (data,callback) =>{
        $.ajax({
            url: "selectChattingList.ch",
            type: "post",
            data ,
            success: (result) => {
                callback(result);
            },
            error: (err) => {
                console.log("asdasdas")
            }
        })
    },
    //유저의 채팅방 목록을 가져오는 통신
    selectChatiingRoomListAjax : (callback) =>{
            $.ajax({
                url: "selectChatiingRoomList.ch",
                type: "post",
                success: (result) => {
                    callback(result);
                },
                error: (err) => {
                    console.log("asdasdas")
                }
            })
        },
    //해당 팀의 팀원을 가져오기 위한 통신
    selectTeamMemberListAjax : (data,callback,teamName) =>{
        $.ajax({
            url: "selectTeamMemberListAjax.ch",
            type: "post",
            data,
            success: (result) => {
                callback(result,teamName,data.teamNo);
            },
            error: (err) => {
                console.log("asdasdas")
            }
        })
    },

 
  
}
