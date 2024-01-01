let contextPath = "";
calendarInit = (list,path) =>{
    contextPath = path;
    drawCalendar(list)

    
    memberAjaxController.getAllResDrawAjax(drawDateChoiceResList);
}
drawCalendar = (list) =>{
    list = JSON.parse(list);
    let listArr = [];
    for(let i of list){
        let tmp = {
                    title: '',
                    start: i.fieldDate,
                    }
        listArr.push(tmp)
    }
    let calendarEl = document.getElementById('calendar');
    let calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        dateClick: function(ev) {
            data={
                fieldDate:ev.dateStr
            }
            console.log(data);
            memberAjaxController.getResDrawAjax(data,drawDateChoiceResList);
        },
        events:listArr,
    });
    calendar.render();
}
drawDateChoiceResList =(result)=>{
    let str = "<h5>예약된 경기</h5>";
    if(result.model.list[0] == null){
        console.log("ssss")
        str 
    }
    for(let i in result.model.list){
        let tmp = result.model.list[i];
        let category;
            switch(tmp.categoryNum){
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
        str += `<div class="resListView">`+
                    `<div style="text-align: justify;">`+
                        `<span style="font-size: 20px;">`+tmp.fieldName+category+`</span><br>`+
                        `<span style="font-size: 14px;">`+tmp.fieldDate+` / `+tmp.startTime+`</span>`+
                    `</div>`+
                    `<div>`+
                        `<button class="btn btn-danger" style="margin-top: 10px;" 
                        onclick="location.href='`+contextPath+`/deleteRes.pl?resNo=`+tmp.resNo+`&fieldNo=`+tmp.fieldNo+`'">예약취소</button>`+
                    `</div>`+
                `</div>`
    }



                document.querySelector('.calendar-body-right').innerHTML = str;
}