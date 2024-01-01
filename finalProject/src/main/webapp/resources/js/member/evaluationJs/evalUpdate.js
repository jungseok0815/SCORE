updateEnal = (sportSmile) =>{
    console.log(sportSmile)
    const sprotInfo = document.querySelectorAll(".check")
    let data = []
    for(let i =0; i<sprotInfo.length; i++){
        let sprotInfoi =  document.querySelectorAll("#sportInfo" + i + ">td > select")
        let sprotInfoj =  document.querySelector("#sportInfo" + i + ">td > input")
        const userNo = document.querySelector("#enalUserNo" + i).value
        const categoryNum = document.querySelector("#enalCategoryNum").value
        const fieldNo = document.querySelector("#enalFieldNo").value
        console.log(fieldNo)
            info ={
                fieldNo : fieldNo,
                categoryNum : categoryNum,
                userNo : userNo,
                sportSmile : sprotInfoi[0].value,
                sportYellow : sprotInfoi[1].value,
                sportRed : sprotInfoi[2].value,
                sportLever : sprotInfoi[3].value,
                sportScore : sprotInfoj.value
        }
        data.push(info)
    }

        const realData=  JSON.stringify(data)
        evaluationAjaxController.test(realData,test2)
        
        console.log(typeof(realData) )
    }
test2 = (result) =>{
    console.log(result)
    const userNo = result.userNo
    const fieldNo = result.fieldNo

    if (result.result === "success") {
        alert("게임 평가 완료");

        data = {
            fieldNo :  fieldNo,
        }

        evaluationAjaxController.fieldUpdate(data,(result) => {
            console.log("성공: " + result)
            console.log("성공: " + userNo)
            
            if (result.result === "success") {
                alert("슈우웃");
                location.href = "/final/myPage.me?userNo=" + userNo; 
            }else{
                alert("실패");
            }
            
        })

    } else{
        alert("게임 평가 실패");
    }
}


delField =() => {
    const fieldNo = document.querySelector("#RealFieldNo").value
    // const userNo = document.querySelector("#RealUserNo").value
    
    console.log("FieldNo:", fieldNo);
    // console.log("userNo:", userNo);

    data = {
        fieldNo :  fieldNo,
        // userNo : userNo,
    }

    evaluationAjaxController.fieldDel(data, deleteField);
}

deleteField = (result) =>{
    console.log("성공: " + result)

    const userNo = result.userNo

    if (result.result === "success") {
        alert("경기장 삭제 완료");
        window.location.href = "/final/myPage.me?userNo=" + userNo; 
    }else{
        alert("경기장 삭제 실패");
    }
}
