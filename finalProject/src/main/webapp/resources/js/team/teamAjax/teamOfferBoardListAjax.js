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
    }
}

