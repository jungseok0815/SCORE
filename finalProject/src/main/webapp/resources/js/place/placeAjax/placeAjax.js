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
function fastWeatherAjax(data,callback1,callback2){
    $.ajax({
        type:"get",
        url:"fastWeatherAjax.pl",
        data,  
        success: function(res){
            callback1(res)
        },
        error:function(){
            callback2();
        }
    })
}
slowWeatherAjax = (data,callback1,callback2) =>{
    $.ajax({
        type:"get",
        url:"slowWeatherAjax.pl",
        data,  
        success: function(res){
            callback1(res)
        },
        error:function(){
            callback2()
        }
    })
}