let mainValue = {
    loadFilterInfo : {
        cpage: 1,
        categoryNum: 1,
        area: "서울",
        gender: 3,
        level: "모든레벨",
        date: ""
    }
}

function mainInit(path){
    // 날짜 가져오기
    let today = new Date();
    // 가져온 날짜 요일로 변환
    let dayStr = changeDay(today.getDay());
    // 가져온 날짜를 DB형식으로 변환 ex) 2023-12-07
    let todayFullDay = changeFullDay(today);
    mainValue.loadFilterInfo.date = todayFullDay;
    let str = `<div onclick="changeDate('`+todayFullDay+`')"><p>`+today.getDate()+`</p><span>`+dayStr+`</span></div>`;

    for(let i = 0; i < 6; i++){
        today.setDate(today.getDate()+1);
        dayStr = changeDay(today.getDay())
        let nextFullDay = changeFullDay(today);
        str += `<div onclick="changeDate('`+nextFullDay+`')"><p>`+today.getDate()+`</p><span>`+dayStr+`</span></div>`;
    }
    document.querySelector('.date-container').innerHTML = str;

    mainValue.path = path
    handleClickPage();
}

function changeFullDay(today){
    let dayInt;
    if(today.getDate()<10){
        dayInt = "0"+today.getDate();
    }else{
        dayInt = today.getDate();
    }
    let fullDayStr = (today.getFullYear()+"-"+(today.getMonth() + 1)+"-"+dayInt)
    return fullDayStr;
}

function changeDay(num){
    let dayStr;
    //요일로 변환
    switch(num){
        case 0 :
            dayStr = "일";
            break;
        case 1 :
            dayStr = "월";
            break;
        case 2 :
            dayStr = "화";
            break;
        case 3 :
            dayStr = "수";
            break;
        case 4 :
            dayStr = "목";
            break;
        case 5 :
            dayStr = "금";
            break;
        case 6 :
            dayStr = "토";
            break;
    }
    return dayStr;
}

function handleClickPageNum(num){
    mainValue.loadFilterInfo.cpage = num
    handleClickPage()
}

function handleClickPage(){
    mainApi.getPageList(mainValue.loadFilterInfo, function(res){
        drawPage(res);
    })
}


function drawPage(data){
    const pi = data.model.pi;
            let str ="";
            let str2 ="";
            for (let i in data.model.list){
                const tmp = data.model.list[i];
                let gender;
                let category;
                let btnControll = '<div class="match-status isOpen">'+
                                        '<p>신청가능</p>'+
                                    '</div>';
                for(let j of data.model.resList){
                    if(j.fieldNo == tmp.fieldNo){
                        if((tmp.fieldCount)-(j.fieldCount)<=5){
                            btnControll = '<div class="match-status isHurry">'+
                                                '<p>마감임박</p>'+
                                            '</div>';
                        }else if((tmp.fieldCount)-(j.fieldCount) <=0){
                            btnControll = '<div class="match-status isFull">'+
                                                '<p>마감</p>'+
                                            '</div>';
                        } 
                    }
                }
                switch(tmp.matchGender){
                    case 1: 
                        gender = '☆남자-';
                        break;
                    case 2: 
                        gender = '☆여자-';
                        break;
                    case 3: 
                        gender = '☆남녀모두-';
                        break;
                }
                switch(tmp.categoryNum){
                    case 1: 
                        category = '축구-';
                        break;
                    case 2: 
                        category = '야구-';
                        break;
                    case 3: 
                        category = '농구-';
                        break;
                }
                str +=
                '<ul>'+
                '<li class="match-schedule-item">'+
                    '<a href="'+mainValue.path+'/detail.pl?fno='+tmp.fieldNo+'">'+
                        '<div class="match-time">'+
                            '<p>'+tmp.startTime+'</p>'+
                        '</div>'+
                        '<div class="match-info">'+
                            '<div class="match-title">'+
                                '<h3>'+tmp.fieldName+'</h3>'+
                            '</div>'+
                            '<div class="match-option">'+
                                '<span>'+gender+'</span>'+
                                '<span>'+category+'</span>'+
                                '<span>'+tmp.matchLevel+'</span>'+
                            '</div>'+
                        '</div>'+btnControll +
                        '</div>'+
                    '</a>'+
                '</li>'+
            '</ul>'
            }

            

            if(pi.currentPage != 1){
                str2 += `<button class="btn btn-light" onclick="handleClickPageNum(`+(pi.currentPage -1)+`)">&lt;</button>`
            }

            for(let j=1; j<=pi.maxPage; j++){
                str2 += `<button class="btn btn-light" onclick="handleClickPageNum(`+j+`)">`+j+`</button>`
            }
            if(pi.currentPage != pi.maxPage){
                str2 += `<button class="btn btn-light" onclick="handleClickPageNum(`+(pi.currentPage +1)+`)">&gt;</button>`
            }


            document.querySelector('.match-schedule-container').innerHTML = str;
            document.querySelector('.paging-area').innerHTML = str2;
}



changeSport = (categoryNum) =>{
    mainValue.loadFilterInfo.categoryNum = categoryNum
    handleClickPage();
}
function changeDate(num){
    mainValue.loadFilterInfo.date = num;
    handleClickPage();
}
function changeArea(){
    let areaId = document.getElementById("selectArea")
    let areaValue = (areaId.options[selectArea.selectedIndex].value)
    mainValue.loadFilterInfo.area = areaValue
    handleClickPage();
}
function changeGender(){
    let genderId = document.getElementById("selectGender")
    let genderValue = (genderId.options[selectGender.selectedIndex].value)
    mainValue.loadFilterInfo.gender = genderValue
    handleClickPage();
}
function changeLevel(){
    let levelId = document.getElementById("selectLevel")
    let levelValue = (levelId.options[selectLevel.selectedIndex].value)
    mainValue.loadFilterInfo.level = levelValue
    handleClickPage();
}

function imgChange(file){

    if(file.files.length == 1){
        const reader = new FileReader();

        reader.readAsDataURL(file.files[0]);
        
        reader.onload = function(ev){
            document.getElementById('profile-img').src = ev.target.result;
        }
    } else {
        document.getElementById('profile-img').src = null;
    }
}