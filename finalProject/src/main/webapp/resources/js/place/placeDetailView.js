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
                            `onclick="selectTeamMember(`+tmp.teamNo+`,`+function(res){
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

function drawMap(fieldArea){
     // !! 지도 그리는 부분 !!
     let mapContainer = document.getElementById('fieldMap'), // 지도를 표시할 div 
     mapOption = {
         center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
         level: 3 // 지도의 확대 레벨
     };  
 
     // 지도를 생성합니다    
     let map = new kakao.maps.Map(mapContainer, mapOption); 
 
     // 주소-좌표 변환 객체를 생성합니다
     let geocoder = new kakao.maps.services.Geocoder();
 
     // 주소로 좌표를 검색합니다
     geocoder.addressSearch(fieldArea, function(result, status) {
 
         // 정상적으로 검색이 완료됐으면 
         if (status === kakao.maps.services.Status.OK) {
 
             let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
 
             // 결과값으로 받은 위치를 마커로 표시합니다
             let marker = new kakao.maps.Marker({
                 map: map,
                 position: coords
             });
 
             // 인포윈도우로 장소에 대한 설명을 표시합니다
             let infowindow = new kakao.maps.InfoWindow({
                 content: '<div style="width:150px;text-align:center;">경기장 위치</div>'
             });
             infowindow.open(map, marker);
 
             // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
             map.setCenter(coords);
         } 
     });
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
function drawMapBtn(fieldArea){
	    if($("#fieldMap").css("display") == "none"){
            $('#fieldMap').show();
            $('.slider').hide();
            drawMap(fieldArea);
    	}else{
            $('#fieldMap').hide();
            $('.slider').show();
        }
}

resMatchBtn = (userNo, categoryNum, path) =>{
    if(userNo == ""){
        gotoHome(path)
    }else{
        data = {
            userNo :userNo,
            categoryNum : categoryNum
        }
        loadTeam(data,drawMyTeam)
    }
}

gotoHome = (path) =>{
    alert('로그인 후 이용 가능한 서비스입니다.');
    location.href = path+"/loginView.me";
}