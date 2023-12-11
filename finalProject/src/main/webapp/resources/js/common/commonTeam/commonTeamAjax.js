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
              console.log(result)    
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
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
}
