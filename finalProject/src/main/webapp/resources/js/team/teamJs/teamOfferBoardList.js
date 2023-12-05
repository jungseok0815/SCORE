
teamList = () =>{
    const checkedArea = document.querySelector('.btnLocal input[name="local"]:checked').value;
    console.log(checkedArea)

     data = {
         activityAtea: checkedArea,
         
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
        str += 
	                    '<div class="team-list-container">'
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
	                                        + '<span class="list-member">' + te.offerAge + te.offerLevel + te.offerGender + '</span>'
	                                    + '</div>'
	                                + '</a>'
	                            + '</li>'
	                        + '</ul>'
	                    + '</div>';
    	
    }
    document.querySelector("#commenttable").innerHTML = str;
    
}

