const kakaoAjaxController = {
    kakaoMoney : (data,callback) =>{   
        $.ajax({
            url: "payPoint.me",
            type: "post",
            data,
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    }
}