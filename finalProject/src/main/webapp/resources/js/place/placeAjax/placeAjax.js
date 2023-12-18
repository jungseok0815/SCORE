function loadTeam(data,callback){
    $.ajax({
        type:"get",
        url:"resMatch.tm",
        data:data,  
        success: function(res){
            callback(res);
        },
        error:function(){
            console.log("ajax에러");
        }
    })
}
function selectTeamMember(teamNo,callback){
    $.ajax({
        type:"get",
        url:"selectTeamMember.tm",
        data:{teamNo:teamNo},  
        success: function(res){
            callback(res)
        },
        error:function(){
            console.log("ajax에러");
        }
    })
    
}