const memberAjaxController = {
    getJoinMemeber : (data,callback) =>{
        $.ajax({
            url: "join.me",
            type: "post",
            data,
            success: (result) => {
                result !== "joinfail" ? callback(result) : alert("회원가입 오류발생")  
               
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    getMemberSportInfo : (data,callback)=>{
        console.log(data)
        $.ajax({
            url: "insertSportInfo.me",
            type: "post", 
            data,
            success: (result) => { 
               
                callback(result);
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    getCheckUserID : (data,callback) =>{
        $.ajax({
            url: 'idCheck.me',
            data,
            success: (result) =>{
                
                callback(result)
            },
            error: ()=>{
                console.log("아이디 중복체크 ajax통신 실패");
            }
        })
    },
    getPostFriend : (callback) =>{
        console.log("hihi")
        $.ajax({
            url: "getPostFriend.me",
            type: "post",
            success: (result) => {
                callback(result)
                
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    getAddFriend : (data) =>{
        $.ajax({
            url: "addFriend.me",
            type: "post",
            data,
            success: (result) => {
                result === "addFriendOk" ? selectPostFriend() : alert("에러 발생 다시 시도");
                
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    selectFriendList : (callback) =>{
        $.ajax({
            url: "selectFriendList.me",
            type: "post",
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    deleteFriend : (data) =>{
        $.ajax({
            url: "deleteFriend.me",
            type: "post",
            data,
            success: (result) => {
                result === "deleteFriendOk" ? selectFriendList() : alert("에러 발생 다시 시도");
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    selectMyteamListAjax : (data, callback) =>{
        $.ajax({
            url: "selectMyTeam.me",
            type: "post",
            data,
            success: (result) => {
                callback(result);
            },
            error: (err) => {
                console.log(err)
            }
        })

    },

    selectUserSportInfoAjax : (data, callback) =>{
        $.ajax({
            url: "selectUserSportInfo.me",
            type: "post",
            data,
            success: (result) => {
                callback(result);
            },
            error: (err) => {
                console.log(err)
            }
        })

    }






   
}

