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
const replyReviewDetailController={
    // 댓글 리스트
    selectReplyListAjax: (data, callback) => {
        console.log(data)
        $.ajax({
            url:"rlist.pl",
            data,
            success: function(result){
                console.log(result);
                callback(result)
                
            },
            error : (error) => {
                console.log(error)
            }
        })
    },

    //답글 등록
    insertReplyReplyAjax : (data,i,callback)  => {
        $.ajax({
            url:"addReplyReply.pl",
            data,
            success: function(result){
                  callback(result,i)
            },
            error : (error) => {
                console.log("Asdasdas")
            }
        })
    },
     //답글 불러오기
     selectReplyReplyAjax : (data,i,callback)  => {
        $.ajax({
            url:"selectReplyReply.pl",
            data,
            success: function(result){
               callback(result,i);
            },
            error : (error) => {
                console.log("Asdasdas")
            }
        })
    }
}