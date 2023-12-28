detailViewValue ={
    fieldDate : "",
    startTime : "",
    daysDifference : ""
}
function init(fieldDate, fieldArea,startTime){
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
    
    Kakao.Share.createDefaultButton({
          container: document.querySelector('#kakaotalk-sharing-btn'),
          objectType: 'feed',
          content: {
            title: '운동하고싶을때 Score',
            description: '#언제 #어디서나 #운동 #풋살 #농구 #야구',
            imageUrl:
              'https://images.chosun.com/resizer/XS25tuQ_2KXA2CMPdqBdw7ViWig=/616x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/MSV2XPCK75E7NAYYBMMTMIPZBQ.jpg',
            link: {
              // [내 애플리케이션] > [플랫폼] 에서 등록한 사이트 도메인과 일치해야 함
              mobileWebUrl: 'https://developers.kakao.com',
              webUrl: 'https://developers.kakao.com',
            },
          },
          social: {
            likeCount: 286,
            commentCount: 45,
            sharedCount: 845,
          },
          buttons: [
            {
              title: '웹으로 보기',
              link: {
                mobileWebUrl: 'https://developers.kakao.com',
                webUrl: 'https://developers.kakao.com',
              },
            },
            {
              title: '앱으로 보기',
              link: {
                mobileWebUrl: 'https://developers.kakao.com',
                webUrl: 'https://developers.kakao.com',
              },
            },
          ],
        });
        
        // 현재 날짜 가져오기
        let currentDate = new Date();

        // 연도, 월, 일 추출
        let year = parseInt(fieldDate.substr(0, 4), 10);
        let month = parseInt(fieldDate.substr(4, 2), 10) - 1; // 월은 0부터 시작하므로 1을 빼줌
        let day = parseInt(fieldDate.substr(6, 2), 10);

        // 새로운 Date 객체 생성
        let newDate = new Date(year, month, day);

        // 두 날짜 간의 차이 계산 (밀리초 단위)
        let timeDifference = newDate - currentDate;

        // 밀리초를 일로 변환
        let daysDifference = Math.floor(timeDifference / (1000 * 60 * 60 * 24));

        detailViewValue.fieldDate = fieldDate;
        detailViewValue.startTime = startTime.substr(0, 2) + "00";
        detailViewValue.daysDifference = daysDifference;
        if(daysDifference > 1){
            data = {
                fieldDate : fieldDate,
                fieldArea : fieldArea.slice(0,2),
                todayDate : currentDate
            }
            slowWeatherAjax(data,drawSlowWeather,drawWeatherError)
        }else{
            data = {
                fieldDate : fieldDate,
                fieldArea : fieldArea,
                startTime : startTime
            }
            fastWeatherAjax(data,drawFastWeather,drawWeatherError)
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
                            `<img src="`+tmp.teamChangeName+`" alt="">`+
                            `<label>`+tmp.teamName+`</label>`+
                            `</button></div>`
    }
    document.querySelector('#collapseOne').innerHTML = myTeamListStr;

}
function drawTeamMemberList(res){
    let myTeamMemberListStr = "";
    for(let i = 0; i < res.length; i++){
        myTeamMemberListStr += `<div class="team-member">`+
                                    `<img src=".`+res[i].memberChangeName+`" alt="">`+
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
drawFastWeather = (res) =>{
    let str = "";
    let weather = "";
    const arrItem = (JSON.parse(res.responseText)).response.body.items.item
    const itemValue = arrItem.filter(function(item) {
            return item.fcstDate == detailViewValue.fieldDate && item.fcstTime == detailViewValue.startTime
        });
    for (let tmp of itemValue) {
        if(tmp.category == "SKY"){
            weather += tmp.fcstValue
        }
        if(tmp.category == "PTY"){
            weather += tmp.fcstValue
        }
    }
    for (let tmp of itemValue) {
        if(tmp.category == "TMP"){
            str += `<p style="margin-right: 10px;">`+tmp.fcstValue+`℃</p>`
        }
        if(tmp.category == "POP"){
            switch(weather){
                case "10" :
                case "11" :
                case "12" :
                case "13" :  
                    str += `<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-sun" viewBox="0 0 16 16">
                                <path d="M8 11a3 3 0 1 1 0-6 3 3 0 0 1 0 6zm0 1a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
                            </svg>`
                break;
                case "30" :
                case "40" :
                    str += `<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cloud" viewBox="0 0 16 16">
                                <path d="M4.406 3.342A5.53 5.53 0 0 1 8 2c2.69 0 4.923 2 5.166 4.579C14.758 6.804 16 8.137 16 9.773 16 11.569 14.502 13 12.687 13H3.781C1.708 13 0 11.366 0 9.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383zm.653.757c-.757.653-1.153 1.44-1.153 2.056v.448l-.445.049C2.064 6.805 1 7.952 1 9.318 1 10.785 2.23 12 3.781 12h8.906C13.98 12 15 10.988 15 9.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 4.825 10.328 3 8 3a4.53 4.53 0 0 0-2.941 1.1z"/>
                            </svg>`
                break;
                case "31" :
                case "41" :
                case "33" :
                case "43" :
                    str += `<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cloud-drizzle" viewBox="0 0 16 16">
                                <path d="M4.158 12.025a.5.5 0 0 1 .316.633l-.5 1.5a.5.5 0 0 1-.948-.316l.5-1.5a.5.5 0 0 1 .632-.317zm6 0a.5.5 0 0 1 .316.633l-.5 1.5a.5.5 0 0 1-.948-.316l.5-1.5a.5.5 0 0 1 .632-.317zm-3.5 1.5a.5.5 0 0 1 .316.633l-.5 1.5a.5.5 0 0 1-.948-.316l.5-1.5a.5.5 0 0 1 .632-.317zm6 0a.5.5 0 0 1 .316.633l-.5 1.5a.5.5 0 1 1-.948-.316l.5-1.5a.5.5 0 0 1 .632-.317zm.747-8.498a5.001 5.001 0 0 0-9.499-1.004A3.5 3.5 0 1 0 3.5 11H13a3 3 0 0 0 .405-5.973zM8.5 2a4 4 0 0 1 3.976 3.555.5.5 0 0 0 .5.445H13a2 2 0 0 1 0 4H3.5a2.5 2.5 0 1 1 .605-4.926.5.5 0 0 0 .596-.329A4.002 4.002 0 0 1 8.5 2z"/>
                            </svg>`
                break;
                case "32" :
                case "42" :
                    str += `<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cloud-sleet" viewBox="0 0 16 16">
                                <path d="M13.405 4.027a5.001 5.001 0 0 0-9.499-1.004A3.5 3.5 0 1 0 3.5 10H13a3 3 0 0 0 .405-5.973zM8.5 1a4 4 0 0 1 3.976 3.555.5.5 0 0 0 .5.445H13a2 2 0 0 1 0 4H3.5a2.5 2.5 0 1 1 .605-4.926.5.5 0 0 0 .596-.329A4.002 4.002 0 0 1 8.5 1zM2.375 13.5a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm1.849-2.447a.5.5 0 0 1 .223.67l-.5 1a.5.5 0 1 1-.894-.447l.5-1a.5.5 0 0 1 .67-.223zM6.375 13.5a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm1.849-2.447a.5.5 0 0 1 .223.67l-.5 1a.5.5 0 1 1-.894-.447l.5-1a.5.5 0 0 1 .67-.223zm2.151 2.447a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm1.849-2.447a.5.5 0 0 1 .223.67l-.5 1a.5.5 0 1 1-.894-.447l.5-1a.5.5 0 0 1 .67-.223z"/>
                            </svg>`
                break;
                case "34" :
                case "44" :
                    str += `<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cloud-snow" viewBox="0 0 16 16">
                                <path d="M13.405 4.277a5.001 5.001 0 0 0-9.499-1.004A3.5 3.5 0 1 0 3.5 10.25H13a3 3 0 0 0 .405-5.973zM8.5 1.25a4 4 0 0 1 3.976 3.555.5.5 0 0 0 .5.445H13a2 2 0 0 1-.001 4H3.5a2.5 2.5 0 1 1 .605-4.926.5.5 0 0 0 .596-.329A4.002 4.002 0 0 1 8.5 1.25zM2.625 11.5a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm2.75 2a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm5.5 0a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm-2.75-2a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm5.5 0a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25z"/>
                            </svg>`
                break;
                    
            }
            str += `<p style="margin-left: 10px;">강수확률 `+tmp.fcstValue+`%</p>`
        }
    }
    document.querySelector("#weatherBody").innerHTML = str;

}
drawSlowWeather = (res) =>{
    let str = "";
    let timeVal = "";
    let dayNum = (detailViewValue.daysDifference + 1);
    
    let weatherValue = JSON.parse(res.weatherValue).response.body.items.item[0];
    let temperatureValue = JSON.parse(res.temperatureValue).response.body.items.item[0];
    if (detailViewValue.startTime <= 1200){
        timeVal = "Am";
    }else{
        timeVal = "Pm";
    }

    // 기온
    let temperature = (temperatureValue["taMax" + dayNum]+temperatureValue["taMin" + dayNum])/2
    // 강수확률
    let rainPersent = (weatherValue["rnSt"+dayNum+timeVal])
    // 강수형태
    let rainPorm = (weatherValue["wf"+dayNum+timeVal])
    
    str += `<p style="margin-right: 10px;">`+temperature+`℃</p>`
    switch(rainPorm){
        case "맑음" :
            str += `<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-sun" viewBox="0 0 16 16">
                        <path d="M8 11a3 3 0 1 1 0-6 3 3 0 0 1 0 6zm0 1a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
                    </svg>`
        break;
        case "구름많음" :
        case "흐림" :
            str += `<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cloud" viewBox="0 0 16 16">
                        <path d="M4.406 3.342A5.53 5.53 0 0 1 8 2c2.69 0 4.923 2 5.166 4.579C14.758 6.804 16 8.137 16 9.773 16 11.569 14.502 13 12.687 13H3.781C1.708 13 0 11.366 0 9.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383zm.653.757c-.757.653-1.153 1.44-1.153 2.056v.448l-.445.049C2.064 6.805 1 7.952 1 9.318 1 10.785 2.23 12 3.781 12h8.906C13.98 12 15 10.988 15 9.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 4.825 10.328 3 8 3a4.53 4.53 0 0 0-2.941 1.1z"/>
                    </svg>`
        break;
        case "구름많고 비" :
        case "구름많고 소나기" :
        case "흐리고 비" :
        case "흐리고 소나기" :
            str += `<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cloud-drizzle" viewBox="0 0 16 16">
                        <path d="M4.158 12.025a.5.5 0 0 1 .316.633l-.5 1.5a.5.5 0 0 1-.948-.316l.5-1.5a.5.5 0 0 1 .632-.317zm6 0a.5.5 0 0 1 .316.633l-.5 1.5a.5.5 0 0 1-.948-.316l.5-1.5a.5.5 0 0 1 .632-.317zm-3.5 1.5a.5.5 0 0 1 .316.633l-.5 1.5a.5.5 0 0 1-.948-.316l.5-1.5a.5.5 0 0 1 .632-.317zm6 0a.5.5 0 0 1 .316.633l-.5 1.5a.5.5 0 1 1-.948-.316l.5-1.5a.5.5 0 0 1 .632-.317zm.747-8.498a5.001 5.001 0 0 0-9.499-1.004A3.5 3.5 0 1 0 3.5 11H13a3 3 0 0 0 .405-5.973zM8.5 2a4 4 0 0 1 3.976 3.555.5.5 0 0 0 .5.445H13a2 2 0 0 1 0 4H3.5a2.5 2.5 0 1 1 .605-4.926.5.5 0 0 0 .596-.329A4.002 4.002 0 0 1 8.5 2z"/>
                    </svg>`
        break;
        case "구름많고 비/눈" :
        case "흐리고 비/눈" :
            str += `<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cloud-sleet" viewBox="0 0 16 16">
                        <path d="M13.405 4.027a5.001 5.001 0 0 0-9.499-1.004A3.5 3.5 0 1 0 3.5 10H13a3 3 0 0 0 .405-5.973zM8.5 1a4 4 0 0 1 3.976 3.555.5.5 0 0 0 .5.445H13a2 2 0 0 1 0 4H3.5a2.5 2.5 0 1 1 .605-4.926.5.5 0 0 0 .596-.329A4.002 4.002 0 0 1 8.5 1zM2.375 13.5a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm1.849-2.447a.5.5 0 0 1 .223.67l-.5 1a.5.5 0 1 1-.894-.447l.5-1a.5.5 0 0 1 .67-.223zM6.375 13.5a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm1.849-2.447a.5.5 0 0 1 .223.67l-.5 1a.5.5 0 1 1-.894-.447l.5-1a.5.5 0 0 1 .67-.223zm2.151 2.447a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm1.849-2.447a.5.5 0 0 1 .223.67l-.5 1a.5.5 0 1 1-.894-.447l.5-1a.5.5 0 0 1 .67-.223z"/>
                    </svg>`
        break;
        case "구름많고 눈" :
        case "흐리고 눈" :
            str += `<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cloud-snow" viewBox="0 0 16 16">
                        <path d="M13.405 4.277a5.001 5.001 0 0 0-9.499-1.004A3.5 3.5 0 1 0 3.5 10.25H13a3 3 0 0 0 .405-5.973zM8.5 1.25a4 4 0 0 1 3.976 3.555.5.5 0 0 0 .5.445H13a2 2 0 0 1-.001 4H3.5a2.5 2.5 0 1 1 .605-4.926.5.5 0 0 0 .596-.329A4.002 4.002 0 0 1 8.5 1.25zM2.625 11.5a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm2.75 2a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm5.5 0a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm-2.75-2a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25zm5.5 0a.25.25 0 0 1 .25.25v.57l.501-.287a.25.25 0 0 1 .248.434l-.495.283.495.283a.25.25 0 0 1-.248.434l-.501-.286v.569a.25.25 0 1 1-.5 0v-.57l-.501.287a.25.25 0 0 1-.248-.434l.495-.283-.495-.283a.25.25 0 0 1 .248-.434l.501.286v-.569a.25.25 0 0 1 .25-.25z"/>
                    </svg>`
        break;
            
    }
    str += `<p style="margin-left: 10px;">강수확률 `+rainPersent+`%</p>`
    document.querySelector("#weatherBody").innerHTML = str;
}
drawWeatherError = () =>{
    document.querySelector("#weatherBody").innerHTML = `<p>날씨를 제공하는 지역이 아닙니다.</p>`;
}