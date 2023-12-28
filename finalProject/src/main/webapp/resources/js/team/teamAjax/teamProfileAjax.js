const teamProfileAjaxController = {
    teamMemberList : (data,callback) =>{
        
    },


    teamOverview : (data,callback) =>{
        
    },

    changeTeamGradeAjax : (data,callback) =>{
        $.ajax({
            url: "changeTeamGrade.tm",
            type: "post",
            data,
            success: (result) => {
                callback(result)
             
            },
            error: (err) => {
                console.log("dpdpdpd")
            }
        })
    },
    deleteTeamMemberCheckAjax : (data,callback)=>{
        $.ajax({
            url: "deleteTeamMember.tm",
            type: "post",
            data,
            success: (result) => {
                callback(result)
             
            },
            error: (err) => {
                console.log("dpdpdpd")
            }
        })
    }
}

