function mainInit(){
    $.ajax({
        type:"post",
        url:"loadList.pl",
        dataType:"json",
        success: function(data){
            console.log("통신성공");
            console.log(data);
        },
        error:function(error){
            console.log(error);
        }
    })
}