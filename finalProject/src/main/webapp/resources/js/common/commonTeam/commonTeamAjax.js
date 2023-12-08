const commonAjax ={
    selectMyteamAjax : (num)=>{
        $.ajax({
            url: "selectMyTeam.tm",
            type: "post",
            data : {
                categoryNum : num,
                userNo : '${loginUser.userNo}'
            },
            success: (result) => {
              console.log(result)
               
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
}
