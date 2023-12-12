function loadTeam(userNo,categoryNum){
    $.ajax({
        type:"get",
        url:"resMatch.pl",
        data:{userNo:userNo,
            categoryNum:categoryNum},  
        success: function(res){
            console.log("ajax성공");
        },
        error:function(){
            console.log("ajax에러");
        }
    })
}
