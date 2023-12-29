function loadReviewList(data, callback){
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

function searchAjax(data, callback){
    $.ajax({
        type:"get",
        url:"search.pl",
        data,
        success: function(result){
            callback(result);
        },
        error: function(){
            console.log("ajax에러에러에러");
        }
    })
}
