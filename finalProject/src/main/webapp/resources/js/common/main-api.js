const mainApi = {
    getPageList: function(data, callback){
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