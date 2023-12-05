const pageValue = {}

function mainInit(path){
    pageValue.path = path;
    handleClickPage(1);
}

function handleClickPage(cpage){
    mainApi.getPageList({cpage: cpage}, function(res){
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
                str +=
                '<ul>'+
                '<li class="match-schedule-item">'+
                    '<a href="${pageContext.request.contextPath}/detail.pl?fno='+tmp.fieldNo+'>'+
                        '<div class="match-time">'+
                            '<p>'+tmp.startTime+'</p>'+
                        '</div>'+
                        '<div class="match-info">'+
                            '<div class="match-title">'+
                                '<h3>'+tmp.fieldName+'</h3>'+
                            '</div>'+
                            '<div class="match-option">'+
                                '<span>'+gender+'</span>'+
                                '<span>축구-</span>'+
                                '<span>'+tmp.matchLevel+'</span>'+
                            '</div>'+
                        '</div>'+
                        '<div class="match-schedule-status">'+
                            '<div class="match-status isOpen">'+
                                '<p>신청가능</p>'+
                            '</div>'+
                            // '<div class="match-status isHurry">'+
                            //     '<p>마감임박</p>'+
                            // '</div>'+

                            // '<div class="match-status isFull">'+
                            //     '<p>마감</p>'+
                            // '</div>'+
                        '</div>'+
                    '</a>'+
                '</li>'+
            '</ul>'
            }
            // if(pi.currentPage != 1){
            //     str2 += '<button class="btn btn-light" onclick="location.href='+
            //     "'"+path+"?cpage="+(pi.currentPage -1) +'">&lt;</button>'
            // }
            if(pi.currentPage != 1){
                str2 += `<button class="btn btn-light" onclick="handleClickPage(`+(pi.currentPage -1)+`)">&lt;</button>`
            }

            for(let j=1; j<=pi.maxPage; j++){
                str2 += `<button class="btn btn-light" onclick="handleClickPage(`+j+`)">`+j+`</button>`
            }
            if(pi.currentPage != pi.maxPage){
                str2 += `<button class="btn btn-light" onclick="handleClickPage(`+(pi.currentPage +1)+`)">&gt;</button>`
            }


            document.querySelector('.match-schedule-container').innerHTML = str;
            document.querySelector('.paging-area').innerHTML = str2;
}
function handleSelectPlaceGender(res){
    console.log(res);
}
test1 = (num) =>{
    console.log(num);
}