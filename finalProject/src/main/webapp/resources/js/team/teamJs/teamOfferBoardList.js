
const teamFilterValue = {
    cpage : 1,
    activityAtea: "all",
    category: 0
}

choicePage = (page) =>{
    teamFilterValue.cpage = page;
    teamAjaxController.teamList(teamFilterValue,drawTeamList)
}

choiceSports =(categoryNum) =>{
    teamFilterValue.cpage = 1;
    teamFilterValue.category = categoryNum;
    teamAjaxController.teamList(teamFilterValue,drawTeamList)
}

choiceCity = () => {
    teamFilterValue.cpage = 1;
    teamFilterValue.activityAtea = document.querySelector('.btnLocal input[name="local"]:checked').value;
    teamAjaxController.teamList(teamFilterValue,drawTeamList)
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
            str2 += '<li class="page-item"><button class="page-link" onclick="choicePage(' + (pi.currentPage - 1 ) + ')">Previous</button></li>'
        }

        for (let i = pi.startPage; i <= pi.endPage; i++) {
            str2 += '<li class="page-item"><button class="page-link" onclick="choicePage('+ i +')">' + i + '</button></li>'
        }

        if(pi.currentPage != pi.maxPage){
            str2 += '<li class="page-item"><button class="page-link" onclick="choicePage('+ (pi.currentPage + 1) +')">Next</button></li>'
        } else {
            str2 += '<li class="page-item disabled"><a class="page-link">Next</a></li>'
        } 

    document.querySelector("#pagingArea ul").innerHTML = str2;
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
            str2 += '<li class="page-item"><button class="page-link" onclick="choicePage(' + (pi.currentPage - 1 ) + ')">Previous</button></li>'
        }

        for (let i = pi.startPage; i <= pi.endPage; i++) {
            str2 += '<li class="page-item"><button class="page-link" onclick="choicePage('+ i +')">' + i + '</button></li>'
        }

        if(pi.currentPage != pi.maxPage){
            str2 += '<li class="page-item"><button class="page-link" onclick="choicePage('+ (pi.currentPage + 1) +')">Next</button></li>'
        } else {
            str2 += '<li class="page-item disabled"><a class="page-link">Next</a></li>'
        } 

    document.querySelector("#pagingArea ul").innerHTML = str2;
}



document.addEventListener('DOMContentLoaded', function() {
    const choiceSportsDivs = document.querySelectorAll('.choice-sports div');

    choiceSportsDivs.forEach(function(div) {
        div.addEventListener('click', function() {
            choiceSportsDivs.forEach(function(otherDiv) {
                otherDiv.classList.remove('clicked');
            });

            div.classList.toggle('clicked');
        });
    });
});