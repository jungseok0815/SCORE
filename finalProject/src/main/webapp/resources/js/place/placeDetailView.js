function init(){
    let currentSlide = 0;
    const slides = document.querySelectorAll('.slide');
    const slideCount = slides.length;
    showSlide(currentSlide);
    setInterval(nextSlide, 3000); // 3초마다 자동 슬라이드 
    
    function showSlide(n) {
        slides.forEach(slide => slide.style.display = 'none');
        slides[n].style.display = 'block';
    }
    
    function nextSlide() {
        currentSlide = (currentSlide + 1) % slideCount;
        showSlide(currentSlide);
    }
    
    function prevSlide() {
        currentSlide = (currentSlide - 1 + slideCount) % slideCount;
        showSlide(currentSlide);
    }
}
function drawMyTeam(res){
    let myTeamListStr = "";
    for(let i = 0; i < res.myTeamList.length; i++){
        let tmp = res.myTeamList[i];
        myTeamListStr += `<div class="accordion-body choice-team-body">`+
                            `<button class="choice-team"`+
                            `data-bs-target="#exampleModalToggle2" data-bs-toggle="modal"`+
                            `onclick="test2(`+tmp.teamNo+`,`+function(res){
                                drawTeamMemberList(res);
                                }+`)">`+
                            `<img src="./em_K09.png" alt="">`+
                            `<label>`+tmp.teamName+`</label>`+
                            `</button></div>`
    }
    document.querySelector('#collapseOne').innerHTML = myTeamListStr;

}
function drawTeamMemberList(res){
    let myTeamMemberListStr = "";
    for(let i = 0; i < res.length; i++){
        myTeamMemberListStr += `<div class="team-member">`+
                                    `<img src="./person.png" alt="">`+
                                    `<div>`+
                                    `<span>`+res[i].userName+`</span><p>`+res[i].city+`</p>`+
                                   `</div>`+
                                    `<input type="checkbox" name="teamMember" value="`+res[i].userNo+`">`+
                                `</div>`
    }
    document.querySelector('#myteam-member-list').innerHTML = myTeamMemberListStr;
}

function copyText(){
    const text = document.getElementById('copy_text').textContent;
    const textarea = document.createElement('textarea');
    textarea.textContent = text;
    document.body.append(textarea);
    textarea.select();
    document.execCommand('copy');
    textarea.remove();
}