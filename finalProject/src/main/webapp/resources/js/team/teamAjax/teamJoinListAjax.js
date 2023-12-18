const teamJoinAjaxController = {
    refuseList : (data,callback) =>{
        $.ajax({
            url: "refuse.tm",
            type: "post",
            data,
            success: (result) => {
              callback(result)
              
            },
            error: (err) => {
                console.log("에러")
            }
        })
    },

    teamJoinList : (data,callback) =>{
        $.ajax({
            url: "joinList.tm",
            type: "post",
            data,
            success: (result) => {
              callback(result)
              
            },
            error: (err) => {
                console.log("에러")
            }
        })
    },
}