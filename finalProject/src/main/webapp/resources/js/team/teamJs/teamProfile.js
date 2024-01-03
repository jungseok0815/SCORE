init = () => {
    document.querySelector('.overview-tab').className += ' overview-tab-focused';

}

initing = () => {
    console.log("aaa")

    alert("이미 신청중입니다.")
}

inging = () => {
    console.log("aaa")

    alert("지금은 팀원 모집을 받고있지 않습니다.")
}

memberView = () => {
    document.querySelector('.overview-tab').classList.remove('overview-tab-focused');
    document.querySelector('.member-tab').className += ' member-tab-focused';
    document.querySelector('.team-overview').style.display = 'none';
    document.querySelector('.team-member').style.display = 'block';
}

overviewView = () => {
    document.querySelector('.member-tab').classList.remove('member-tab-focused');
    document.querySelector('.overview-tab').className += ' overview-tab-focused';
    document.querySelector('.team-overview').style.display = 'block';
    document.querySelector('.team-member').style.display = 'none';
}

deleteTeamCheck = (tNo) =>{
    console.log(tNo)
    if(window.confirm("팀을 삭제하시겠습니끼?")){
        location.href ='deleteTeam.tm?tNo= '+tNo
    }
   
}

changeTeamGrade = (userNo, grade, teamNo) =>{
    console.log(userNo)
    console.log(grade);
    data = {
        userNo,
        grade,
        teamNo
    }
    teamProfileAjaxController.changeTeamGradeAjax(data,reloadChangeTeamGrade);
}

reloadChangeTeamGrade = (result) =>{
    if(result === "changeTeamGradeOk"){
        alert("등급변경 완료") 
        location.reload();
    }else{
        alert("등급변경 실패")
    }
}

deleteTeamMember = (userNo,teamNo) =>{
    data = {
        userNo,
        teamNo
    }
    if(window.confirm("해당 팀원을 방출하겠습니까?")){
        teamProfileAjaxController.deleteTeamMemberCheckAjax(data,reloaddeleteTeamMember);
    }
}
reloaddeleteTeamMember= (result) =>{
    if(result === "deleteTeamMemberGradeOk"){
        alert("팀원추방 완료") 
        location.reload();
    }else{
        alert("팀원추방 실패")
    }
}
copyToClipboard = (phone) =>{
    navigator.clipboard.writeText(phone)

    // 복사 완료 메시지 (예를 들어, 알림 등으로 표시 가능)
    alert("텍스트가 클립보드에 복사되었습니다.");
}

teamOutside=(teamNo)=>{
    console.log(teamNo);
    location.href = "teamOutside.tm?teamNo="+teamNo;
}


    

   