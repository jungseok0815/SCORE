function replyFunc(replyNo,i){
    console.log(i);
    let replyButton = document.querySelector('#replyReply'+i);
  
    if(replyButton.style.display === "none"){
        replyButton.style.display = 'table-row';
    } else {
        replyButton.style.display ='none';
    }
    data = {
        replyNo
    }
    showReplyReply(data,i)
}

showReplyReply = (data,i) =>{
    replyReviewDetailController.selectReplyReplyAjax(data,i,drewReplyRe)
}

//답글 그려줌
drewReplyRe = (result,i) =>{
    document.querySelector("#replyReply"+i).innerHTML  = "";
    console.log(i)
    if(result.list ==="fail"){
        alert("댓글 등록실패");
        return;
    }
    console.log(result)
    const list = result.list;
    const userNo = result.loginUser;
        console.log(list);
        console.log(userNo);
    const str = ""
    for(let r of list){
        if(list.userNo === userNo){
            //수정버튼 추가
            str = "<div>"
        }else{
            // str = `<tr class="replyReply-content" id="replyReply">`+
            // `<td></td><td class="replyName">`+ r.userName +`</td>`+
            // `<td class="replyContent">` + r.replyReplyContent + `</td>`+
            // `<td class="replyReplyDate">` + r.replyReplyDate + `</td>`+
            // `<td></td>`+
            // `</tr>`
        }
            // document.querySelector("#replyReply"+i).innerHTML += str;
    }
}

//댓글 리스트
selectReply = (rno, fno) => {
    console.log(rno, fno)
    data = {
        fno : fno,
        rno : rno
    }
    replyReviewDetailController.selectReplyListAjax(data,selectReplyList)
}

selectReplyList = (result) => {
    let str = "";
 
    for(let i in result){
        let tmp = result[i];
        str= `<tr class="reply-content-list">`+
                    `<td class="replyName">`+ tmp.replyWriter +`</td>`+
                    `<td class="replyContent" colspan="2">` + tmp.replyContent + `</td>`+
                    `<td class="replyDate">` + tmp.replyDate + `</td>`+
                    `<td class="replyButton" colspan="3"><button class="btnReply" onclick="replyFunc(`+tmp.replyNo+`,`+i+`)">답글달기</button></td>`+
                `</tr>`+

                `<tr class="replyReply-content" id="replyReply`+ i +`">`+
                    `<td></td><td class="replyName">작성자1</td>`+
                    `<td class="replyContent"><input type="text" class="inputReply`+i+`" placeholder="댓글을 입력해주세요."></td>`+
                    `<td class="replyReplyDate">` + tmp.replyDate + `<td>`+
                    `<td colspan="3"><button class="btnInsert" onclick="addReplyRE(`+tmp.replyNo+`,`+i+`)">등록하기</button></td>`+
                `</tr>`;
            
                document.querySelector(".replyTbody").innerHTML += str;
    }
}

//대댓글 등록
addReplyRE = (replyNo,i) =>{
    const replyReplyContent =  document.querySelector('.inputReply'+i).value
    data = {
        replyNo,
        replyReplyContent,
    }
    replyReviewDetailController.insertReplyReplyAjax(data,i,drewReplyRe)


}


//주소 복사
function copyAddress(){
    const textAddress = document.getElementById('stadium-address').textContent;
    const textarea = document.createElement('textarea');
    textarea.textContent = textAddress;
    document.body.append(textarea);
    textarea.select();
    document.execCommand('copy');
    textarea.remove();
}

//지도 그려줌
function mapDraw(fieldArea){
    let container = document.getElementById('mapImage'),
    options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
    };

    // 지도를 생성합니다
    let map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

    // 주소-좌표 변환 객체를 생성합니다
    let geocoder = new kakao.maps.services.Geocoder();

    // 주소로 좌표를 검색합니다
    geocoder.addressSearch(fieldArea, function (result, status) {

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

//주소 지도
function drawMapClick(fieldArea){
    if($("#mapImage").css("display") == "none"){
        $('#mapImage').show();
        $('.contentWrap').hide();
        mapDraw(fieldArea);
    } else{
        $('#mapImage').hide();
        $('.contentWrap').show();
    }
}

//리뷰 게시글 삭제
deleteReview = (rno) =>{
    if(window.confirm("정말 삭제하시겠습니까?")){
        location.href='reviewDelete.pl?rno=' + rno;
    }
}

//사진 미리보기
loadImg = (inputFile) => {

    if(inputFile.files.length == 1){ 
        const reader = new FileReader();
        reader.readAsDataURL(inputFile.files[0]);
        reader.onload = function(ev){
            document.getElementById('file-img').src = ev.target.result;
        }
    } else {
        document.getElementById('file-img').src = null;   
    }
}

