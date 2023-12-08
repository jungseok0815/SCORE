const mainApi = {
    getPageList: function(data, callback){
        console.log(data)
        $.ajax({
            type:"get",
            url:"loadList.pl",
            data: data,
            success: function(res){
                callback(res)
            },
            error:function(){
                console.log("에러");
            }
        })
    }
}