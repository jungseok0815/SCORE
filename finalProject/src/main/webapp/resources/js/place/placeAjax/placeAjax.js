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

    //댓글 등록
    insertReply : (data,callback) =>{
        $.ajax({
            url:"insertReply.pl",
            data,
            success: function(result){
                console.log(result)
                callback(result)
            },
            error : (error) => {
                console.log("Asdasdas")
            }
        })
    },

     //댓글 수정
     upadateReplyAjax : (data,callback)  => {
        $.ajax({
            url:"upadateReply.pl",
            data,
            success: function(result){
                callback(result)
            },
            error : (error) => {
                console.log("Asdasdas")
            }
        })
    },

    //댓글 삭제
    deleteReplyAjax : (data,callback)  => {
        $.ajax({
            url:"deleteReply.pl",
            data,
            success: function(result){
                callback(result)
            },
            error : (error) => {
                console.log("Asdasdas")
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
    },

    //답글 삭제
    deleteReplyReplyAjax : (data,callback) => {
        $.ajax({
            url:"deleteReplyReply.pl",
            data,
            success: function(result){
               callback(result);
            },
            error : (error) => {
                console.log("Asdasdas")
            }
        })
    },
      //댓글 수정
      updateReplyReplyAjax : (data,callback) => {
        $.ajax({
            url:"updateReplyReply.pl",
            data,
            success: function(result){
                callback(result)
            },
            error : (error) => {
                console.log("Asdasdas")
            }
        })
    },
    
}