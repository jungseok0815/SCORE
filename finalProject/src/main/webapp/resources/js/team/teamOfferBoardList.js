function offerBoardList(){       
    $.ajax({
             url : "offerBoardList.tm",
             data : {
                 
             },
             type:"post",
             success:function(res){
                 
             },
             error:function(){
                console.log("리스트 불러오기 실패")
             }
         })
  }