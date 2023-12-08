const teamAjaxController = {
    teamList : (data,callback) =>{
        $.ajax({
            url: "offerAjax.tm",
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


    choiceSports : (data,callback) =>{
        $.ajax({
            url: "choiceSportsAjax.tm",
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

