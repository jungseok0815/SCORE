function loadTeam(data, callback){
    $.ajax({
        type:"get",
        url:"ReviewListAjax.pl",
        data,
        success: function(result){
            callback(result);
        },
        error:function(){
            console.log("ajax에러");
        }
    })
}
