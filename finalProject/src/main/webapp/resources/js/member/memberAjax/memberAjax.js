const memberAjaxController = {
    getJoinMemeber : (data,callback) =>{
        $.ajax({
            url: "join.me",
            type: "post",
            data,
            success: (result) => {
                result !== "joinfail" ? callback(result) : alert("회원가입 오류발생")  
               
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    getMemberSportInfo : (data,callback)=>{
        console.log(data)
        $.ajax({
            url: "insertSportInfo.me",
            type: "post", 
            data,
            success: (result) => { 
               
                callback(result);
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    getCheckUserID : (data,callback) =>{
        $.ajax({
            url: 'idCheck.me',
            data,
            success: (result) =>{
                
                callback(result)
            },
            error: ()=>{
                console.log("아이디 중복체크 ajax통신 실패");
            }
        })
    }

   
}

