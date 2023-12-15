
const mypageAjaxController = {
    updateMypageAjax : (data,callback) => {
        $.ajax({
            url : "myPageCheckCategory.me",
            type : "post",
            data ,
            success: (data) => { 
                callback(data)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    selectResListAjax : (data,callback) =>{
        $.ajax({
            url : "selectResList.pl",
            type : "post",
            data ,
            success: (data) => { 
                callback(data)
            },
            error: (err) => {
                console.log(err)
            }
        })
    }
}