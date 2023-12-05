const mainApi = {
    getPageList: function(data, callback){
        $.ajax({
            type:"get",
            url:"loadList.pl",
            data: data,
            success: function(res){
                console.log(res.model.list);
                console.log(res.model.pi); 
                callback(res)
            },
            error:function(){
                console.log("에러");
            }
        })
    }
}