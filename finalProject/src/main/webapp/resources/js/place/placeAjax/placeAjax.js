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
    insertReplyReplyAjax : ()  => {
        
    }
}