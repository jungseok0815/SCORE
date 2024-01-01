let bodyValue = {
    fno : ""
}

//답글 열기 버튼
function replyFunc(replyNo,i){
    let replyButton = document.querySelector("#replyReply"+i);
    console.log(replyButton.style.display)
    if(replyButton.style.display === 'none' || replyButton.style.display === ''){
        console.log("dddd")
        replyButton.style.display = 'table-row';
        data = {
            replyNo
        }
        showReplyReply(data,i)
    } else {
        console.log("ssss")
        replyButton.style.display ='none';
        const listArr = document.querySelectorAll(".tbody"+i+ " .reply-content-list-te")
        console.log(listArr)
        for(let i = 0; i< listArr.length; i++){
            listArr[i].remove()
        }
    } 
}


showReplyReply = (data,i) =>{
    replyReviewDetailController.selectReplyReplyAjax(data,i,drewReplyRe)
}


//답글 그려줌
drewReplyRe = (result,i) =>{
    document.querySelector(".inputReply"+i).innerHTML = "";
    $(".reply-item" + i).remove();

    if(result.list ==="fail"){
        alert("답글 등록실패");
        return;
    }
    console.log(result)
    const list = result.list;
    const loginNo = result.loginUser;
        console.log("--------------------------")
        console.log(list);
        console.log(loginNo);
   
    const tr = document.querySelector(".inputReply"+i).parentNode.parentNode;
    const listArr = document.querySelectorAll(".reply-content-list-te")
    for(let i = 0; i<listArr.length; i++){
        listArr[i].remove()
    }
    

    for(let j=0; j<list.length; j++){
        const rereplyTr = document.createElement("tr");
        rereplyTr.className = "reply-content-list-te reply-item" + j;

        rereplyTr.innerHTML =  `<td></td><td class="replyName">`+ list[j].userName +`</td>`+
                               `<td class="replyContent" colspan="2">` + list[j].replyReplyContent + `</td>`+
                               `<td class="replyDate">` + list[j].replyReplyDate + `</td>`+
                               `<td colspan="1"></td>`
                               if(list[j].userNo === loginNo ){ 
                                rereplyTr.innerHTML +=
                                    `<td class="replyUpdate" colspan="1"><img src="./resources/img/place/update.png" onclick="drawUpdateReplyReply(`+ list[j].replyReplyNo+`,`+list[j].replyNo+`,`+j+`)" id="replyUpImg"></td>`+
                                    `<td class="replyDelete" colspan="1"><img src="./resources/img/place/delete.png" onclick="delReplyRE(`+ list[j].replyReplyNo+`,`+list[j].replyNo+`)" id="replyDelImg"></td>`
                                }

                               tr.after(rereplyTr);
    }
    
}

//답글 수정
drawUpdateReplyReply = (replyReplyNo,replyNo,j) =>{
    const replyReply =  document.querySelector(".reply-item"+j+" .replyContent")
    const replyReplyContent = replyReply.innerText;
    const textAreaDiv = document.createElement("input");
    textAreaDiv.className = "replyReplyTextArea input" + j
    textAreaDiv.value = replyReplyContent;
    const replyReplyBtn = document.createElement("button");
    replyReplyBtn.className = "replyReplyBtn"
    replyReplyBtn.onclick  = () =>{
        data = {
            replyNo,
            replyReplyNo,
            replyReplyContent : document.querySelector(".reply-item"+ j +" .replyContent .input"+j).value
        }
        document.querySelector(".reply-item0 .replyContent .input0")

        replyReviewDetailController.updateReplyReplyAjax(data, upadateReplySucces);
    }
    replyReply.innerText = ""
    replyReply.appendChild(textAreaDiv)
    replyReply.appendChild(replyReplyBtn)
}




//댓글 수정
drawUpdateReply = (replyNo,j) =>{
    console.log(replyNo)
    
    const reply = document.querySelector(".tbody"+j+" .reply-content-list .replyContent")
    const text =  reply.innerText
    const textareaDiv = document.createElement("input")
    textareaDiv.className = "repluTextArea input"+j
    textareaDiv.value = text
    const updateReplyBtn = document.createElement("button")
    updateReplyBtn.className = "updateReplyBtn"
    updateReplyBtn.onclick = () =>{
        upadateReply(replyNo,document.querySelector(".input"+j).value)
    }
    reply.innerText = ""
    reply.appendChild(textareaDiv)
    reply.appendChild(updateReplyBtn)
}

upadateReply = (replyNo, replyContent) =>{

    console.log(replyNo)
    console.log(replyContent)
    data = {
        replyNo,
        replyContent
    }
    replyReviewDetailController.upadateReplyAjax(data,upadateReplySucces)
}

upadateReplySucces=(result) =>{
    if(result === "Ok"){
        alert("댓글 수정성공")
        location.reload();
    }else{
        alert("수정 실패")
    }
  
}

//댓글 삭제
deleteReply = (replyNo) => {
    console.log(replyNo)
    data = {
        replyNo,
    }
    replyReviewDetailController.deleteReplyAjax(data,deleteReplySucces)
}

deleteReplySucces=(result) =>{
    if(result === "Ok"){
        alert("댓글 삭제성공")
        location.reload();
    }else{
        alert("삭제 실패")
    }
  
}


//댓글 리스트
selectReply = (rno, fno) => {
    console.log(rno, fno)
    bodyValue.fno = fno
    data = {
        fno : fno,
        rno : rno
    }
    replyReviewDetailController.selectReplyListAjax(data,selectReplyList)
}

//댓글 등록
addReply = () =>{
    const replyContent = document.querySelector('.inputReplyInput').value
    let fieldNo = bodyValue.fno
    data = {
        fieldNo,
        replyContent,
    }
    console.log(data)
    replyReviewDetailController.insertReply(data,selectReplyList)
}

//댓글 그려줌
selectReplyList = (result) => {
    document.querySelector(".dbstnwls-qksema").innerHTML = ""
    let str = "";
    let loginUser = result.loginUser;
    console.log(result.rlist)
    console.log("==================")
    console.log(loginUser)
   

    let str2 = `<thead>`+
                 `<tr class ="replyDiv">`+
                    `<th class="replyspan" colspan="6">댓글(<span id ="rcount">`+ result.rlist.length +`</span>)</th>`+
                  `<tr>` +
               `</thead>`
    
     document.querySelector(".dbstnwls-qksema").innerHTML = str2
    for(let i in result.rlist){
        const tbody2 = document.createElement("tbody")
        tbody2.className = "";
        tbody2.className = "tbody"+i;
        let tmp = result.rlist[i];

        str+=`<tr class="reply-content-list">`+
                    `<td class="replyName">`+ tmp.replyWriter +`</td>`+
                    `<td class="replyContent" colspan="2">` + tmp.replyContent + `</td>`+
                    `<td class="replyDate">` + tmp.replyDate + `</td>`+
                    `<td class="replyButton" colspan="1"><img src="./resources/img/place/reply.png" id="replyreImg" onclick="replyFunc(`+tmp.replyNo+`,`+i+`)"></td>`
                    if(tmp.userNo === loginUser.userNo){
                        str +=
                        `<td class="replyUpdate" colspan="1"><img src="./resources/img/place/update.png" onclick="drawUpdateReply(`+tmp.replyNo+','+i+`)" id="replyUpImg"></td>`+
                        `<td class="replyDelete" colspan="1"><img src="./resources/img/place/delete.png" onclick="deleteReply(`+tmp.replyNo+','+i+`)" id="replyDelImg"></td>`;
                    }
            str+= `</tr>`

        str+=`<tr class="replyReply-content" id="replyReply`+ i +`">`+
                `<td></td><td class="replyContent" colspan="2"><input type="text"
                style="width: 650px;
                        height: 70px;
                        border-radius: 10px;
                        margin-top: 20px;
                        margin-bottom: 20px;"
                    class="inputReply`+ i +`" placeholder="댓글을 입력해주세요."></td>`+
                `<td></td><td colspan="3"><button class="btnInsert" onclick="addReplyRE(`+tmp.replyNo+`,`+i+`)">등록하기</button></td>`+
            `</tr>`
        str+= `<tr class="replyReplyBody`+ i +`"></tr>`

        tbody2.innerHTML = str;
        str = ""
      
        document.querySelector(".dbstnwls-qksema").appendChild(tbody2);
    }
   
    console.log(loginUser);
     if(loginUser != null){
         str += `<tr id="replyReply">`+
                     `<td class="replyName">`+ loginUser.userName + `</td>`+
                    `<td class="replyContent" colspan="2"><input type="text" class="inputReplyInput" placeholder="댓글을 입력해주세요."></td>`+
                    `<td></td>`+
                     `<td colspan="3"><button class="btnInsert" onclick="addReply()">등록하기</button></td>`+
                 `</tr>`;
     }

     document.querySelector(".dbstnwls-qksema").innerHTML += str;
}



//답글 등록
addReplyRE = (replyNo,i) =>{
    document.querySelector(".inputReply0").value
    const replyReplyContent =  document.querySelector('.inputReply'+i).value
    data = {
        replyNo,
        replyReplyContent,
    }
    replyReviewDetailController.insertReplyReplyAjax(data,i,drewReplyRe)
     document.querySelector('.inputReply'+i).value = ""


}


//답글 삭제
delReplyRE = (replyReplyNo, replyNo) => {
    console.log(replyReplyNo);
    console.log(replyNo)
    data ={
        replyNo,
        replyReplyNo,
    }

    replyReviewDetailController.deleteReplyReplyAjax(data, deleteReplyReSucces)
}

deleteReplyReSucces=(result) =>{
    if(result === "Ok"){
        alert("답글 삭제성공")
        location.reload();
    }else{
        alert("삭제 실패")
    }
  
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

