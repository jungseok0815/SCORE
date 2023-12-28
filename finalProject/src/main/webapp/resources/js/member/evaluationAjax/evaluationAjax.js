const evaluationAjaxController = {
    managerEvaluation : (data,callback) =>{
        $.ajax({
            url: "manager.pl",
            type: "post",
            data,
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    test : (realdata,callback) =>{
        $.ajax({
            url: "evaluationUpdate.pl",
            type: "post",
            data : {
                realdata
            },
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },

    fieldDel : (data,callback) =>{
        $.ajax({
            url: "fieldDel.pl",
            type: "post",
            data,
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
 
}