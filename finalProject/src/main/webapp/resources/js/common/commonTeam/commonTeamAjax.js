const commonAjaxController ={
    searchMain : (data,callback)=>{
        $.ajax({
            url: "searchMain.cm",
            type: "post",
            data,
            success: (result) => {
              callback(result)    
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    sendFostFreind : (data)=>{
        $.ajax({
            url: "sendPostFriend.me",
            type: "post",
            data,
            success: (result) => {
                if(result === "PostFriendOk"){
                    alert("친구요청 성공")
                }else if(result === "PostFriendFail1"){
                    alert("이미 친구요청을한 친구입니다.")
                }else{
                    alert("이미 친구상태입니다.")
                }
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    selectReqResListAjax :  (callback)=>{
        $.ajax({
            url: "selectReqResList.me",
            type: "post",
            success: (result) => {
                console.log(result)
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
}
