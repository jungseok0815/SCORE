selectPlaceLecer =(userName) =>{
console.log(userName)

    data = {
        userName : userName
    }
    evaluationAjaxController.managerEvaluation(data,drawManager)
}

drawManager = (result) =>{
    console.log(result)

    let str = "";
    for (let i in result.model.list){
        const man = result.model.list[i];
        let category;

        switch(man.categoryNum){
            case 1: 
                category = ' (축구)';
                break;
            case 2: 
                category = ' (야구)';
                break;
            case 3: 
                category = ' (농구)';
                break;
        }
        str += `<div class="resListModal">`+
                `<div style="text-align: justify;">`+
                    `<span style="font-size: 20px;">`+ man.fieldName +`</span><br>`+
                    `<span style="font-size: 14px;">`+" "+ man.fieldDate +` / `+ man.fieldArea +`</span>`+
                `</div>`+
                `<div>`+
                    `<button class="btn btn-danger" style="margin-top: 10px;"`+
                    `onclick="location.href='`+contextPath+`/evaluation.pl?fieldNo=`+ man.fieldNo +`&categoryNum=`+man.categoryNum+`'">평가하러 가기</button>`+
                `</div></div>`
    }
    document.querySelector('.managerBody').innerHTML = str;
}