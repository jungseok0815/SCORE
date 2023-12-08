
teamList = (cpage, categoryNum) =>{
    const checkedArea = document.querySelector('.btnLocal input[name="local"]:checked').value;
    console.log(checkedArea)

     data = {
         activityAtea: checkedArea,
         cpage: cpage,
         category: selectedCategory,
     }
     
    teamAjaxController.teamList(data,drawTeamList)
}

drawTeamList = (result) =>{
	console.log(result)
    let list = result.model.list;
    let pi = result.model.pi
    console.log(list)
    console.log(pi)
    
    let str = "";
    for (let te of list) {
        str += '<div class="team-list-container">'
                    + '<ul>'
                        + '<li class="team-list-item">'
                            + `<a onclick="location.href='offerDetailView.tm?tno=` + te.offerNo + `'" class="list-link">`
                                + '<div class="list-img-all">'
                                    + '<img src="./resources/img/team/teamOfferBoardList/arsenal.jpg"  class="list-img"/>'
                                + '</div>'
                                + '<div class="list-content">'
                                    + '<div class="list-title">'
                                        +'<span class="TimeName">' + te.teamName + '</span>'
                                        + '<span class="memberListCount"><img src="./resources/img/team/teamOfferBoardList/memberIcon.png"  class="list-member-img"/>' + te.offerCount + '</span>'
                                        + '<span class="memberPosting">' + te.offerTitle + '</span>'
                                    + '</div>'
                                    + '<span class="list-local">' + te.activityAtea + '</span>'
                                    + '<span class="list-member">' + te.offerAge + '대, ' + te.offerLevel + ', ' + te.offerGender + '</span>'
                                + '</div>'
                            + '</a>'
                        + '</li>'
                    + '</ul>'
                + '</div>';
    }
    document.querySelector("#commenttable").innerHTML = str;
    

    // 페이징 바 그려주기
    let str2 = "";
    
        if(pi.currentPage == 1){
            str2 += '<li class="page-item disabled"><a class="page-link">Previous</a></li>'
        } else {
            str2 += '<li class="page-item"><button class="page-link" onclick="teamList(' + (pi.currentPage - 1 ) + ')">Previous</button></li>'
        }

        for (let i = pi.startPage; i <= pi.endPage; i++) {
            str2 += '<li class="page-item"><button class="page-link" onclick="teamList('+ i +')">' + i + '</button></li>'
        }

        if(pi.currentPage != pi.maxPage){
            str2 += '<li class="page-item"><button class="page-link" onclick="teamList('+ (pi.currentPage + 1) +')">Next</button></li>'
        } else {
            str2 += '<li class="page-item disabled"><a class="page-link">Next</a></li>'
        } 

    document.querySelector("#pagingArea ul").innerHTML = str2;
}


choiceSports =(categoryNum, cpage) =>{
    const checkedArea = document.querySelector('.btnLocal input[name="local"]:checked').value;
    console.log(checkedArea)
    console.log(categoryNum)

    selectedCategory = categoryNum;

    data = {
        activityAtea: checkedArea,
        category: categoryNum,
        cpage: cpage,
    }

    teamAjaxController.choiceSports(data,drawChoiceSports)
}

drawChoiceSports = (result) =>{
    console.log(result)
    let list = result.model.list;
    let pi = result.model.pi;

    let str = "";
    for (let te of list) {
        str += '<div class="team-list-container">'
                    + '<ul>'
                        + '<li class="team-list-item">'
                            + `<a onclick="location.href='offerDetailView.tm?tno=` + te.offerNo + `'" class="list-link">`
                                + '<div class="list-img-all">'
                                    + '<img src="./resources/img/team/teamOfferBoardList/arsenal.jpg"  class="list-img"/>'
                                + '</div>'
                                + '<div class="list-content">'
                                    + '<div class="list-title">'
                                        +'<span class="TimeName">' + te.teamName + '</span>'
                                        + '<span class="memberListCount"><img src="./resources/img/team/teamOfferBoardList/memberIcon.png"  class="list-member-img"/>' + te.offerCount + '</span>'
                                        + '<span class="memberPosting">' + te.offerTitle + '</span>'
                                    + '</div>'
                                    + '<span class="list-local">' + te.activityAtea + '</span>'
                                    + '<span class="list-member">' + te.offerAge + '대, ' + te.offerLevel + ', ' + te.offerGender + '</span>'
                                + '</div>'
                            + '</a>'
                        + '</li>'
                    + '</ul>'
                + '</div>';
    }
    document.querySelector("#commenttable").innerHTML = str;

    // 페이징 바 그려주기
    let str2 = "";
    
        if(pi.currentPage == 1){
            str2 += '<li class="page-item disabled"><a class="page-link">Previous</a></li>'
        } else {
            str2 += '<li class="page-item"><button class="page-link" onclick="teamList(' + (pi.currentPage - 1 ) + ')">Previous</button></li>'
        }

        for (let i = pi.startPage; i <= pi.endPage; i++) {
            str2 += '<li class="page-item"><button class="page-link" onclick="teamList('+ i +')">' + i + '</button></li>'
        }

        if(pi.currentPage != pi.maxPage){
            str2 += '<li class="page-item"><button class="page-link" onclick="teamList('+ (pi.currentPage + 1) +')">Next</button></li>'
        } else {
            str2 += '<li class="page-item disabled"><a class="page-link">Next</a></li>'
        } 

    document.querySelector("#pagingArea ul").innerHTML = str2;
}



