#frontend 주요 코드리뷰

## 리뷰 댓글, 답글

 ```
	let bodyValue = {
    fno : ""
  }

  #### 댓글 리스트 조회를 위해 ajax로 값 넘겨주는 코드
  selectReply = (rno, fno) => {
      bodyValue.fno = fno
      data = {
          fno : fno,
          rno : rno
      }
      replyReviewDetailController.selectReplyListAjax(data,selectReplyList)
  }

  #### 댓글 수정하는 코드
  drawUpdateReply = (replyNo,j) =>{
      const reply = document.querySelector(".tbody"+j+" .reply-content-list .replyContent")
      const text =  reply.innerText
      const textareaDiv = document.createElement("input")
      textareaDiv.className = "repluTextArea input"+j
      textareaDiv.value = text
      const updateReplyBtn = document.createElement("button")
      updateReplyBtn.className = "updateReplyBtn"
      updateReplyBtn.textContent = "수정하기"
      updateReplyBtn.onclick = () =>{
          upadateReply(replyNo,document.querySelector(".input"+j).value)
      }
      reply.innerText = ""
      reply.appendChild(textareaDiv)
      reply.appendChild(updateReplyBtn)
  }
  
  upadateReply = (replyNo, replyContent) =>{
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
  
  #### 댓글 삭제를 위해 ajax로 값을 넘겨주는 코드
  deleteReply = (replyNo) => {
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
  
  
  #### 댓글 등록하는 코드
  addReply = () =>{
      const replyContent = document.querySelector('.inputReplyInput').value
      let fieldNo = bodyValue.fno
      data = {
          fieldNo,
          replyContent,
      }
      replyReviewDetailController.insertReply(data,selectReplyList)
  }
  
  #### 댓글을 그려주는 코드
  selectReplyList = (result) => {
      document.querySelector(".all-content-reply").innerHTML = ""
      let str = "";
      let loginUser = result.loginUser;
      let str2 = `<thead>`+
                   `<tr class ="replyDiv">`+
                      `<th class="replyspan" colspan="6">댓글(<span id ="rcount">`+ result.rlist.length +`</span>)</th>`+
                    `<tr>` +
                 `</thead>`
      
       document.querySelector(".all-content-reply").innerHTML = str2
      for(let i in result.rlist){
          const tbody2 = document.createElement("tbody")
          tbody2.className = "";
          tbody2.className = "tbody"+i;
          let tmp = result.rlist[i];
  
          str+=`<tr class="reply-content-list">`+
                      `<td class="replyName">`+ tmp.userName +`</td>`+
                      `<td class="replyContent" colspan="2">` + tmp.replyContent + `</td>`+
                      `<td class="replyDate">` + tmp.replyDate + `</td>`+
                      `<td class="replyButton" colspan="1"><img src="./resources/img/place/reply.png" id="replyreImg" onclick="replyFunc(`+tmp.replyNo+`,`+i+`)"></td>`
		      #### 작성자만 수정,삭제 버튼이 보이도록 작성한 코드
                      if(tmp.userNo === loginUser.userNo){
                          str +=
                          `<td class="replyUpdate" colspan="1"><img src="./resources/img/place/update.png" onclick="drawUpdateReply(`+tmp.replyNo+','+i+`)" id="replyUpImg"></td>`+
                          `<td class="replyDelete" colspan="1"><img src="./resources/img/place/delete.png" onclick="deleteReply(`+tmp.replyNo+','+i+`)" id="replyDelImg"></td>`;
                      }
              str+= `</tr>`
  
          str+=`<tr class="replyReply-content" id="replyReply`+ i +`">`+
                  `<td></td><td class="replyContent" colspan="2"><input type="text"
                  style="width: 650px;
                          height: 50px;
                          border-radius: 10px;
                          margin-top: 10px;
                          margin-bottom: 10px;
                          padding: 10px;"
                      class="inputReply`+ i +`" placeholder="댓글을 입력해주세요."></td>`+
                  `<td></td><td colspan="3"><button class="btnInsert" onclick="addReplyRE(`+tmp.replyNo+`,`+i+`)">등록하기</button></td>`+
              `</tr>`
          str+= `<tr class="replyReplyBody`+ i +`"></tr>`
  
          tbody2.innerHTML = str;
          str = ""
        
          document.querySelector(".all-content-reply").appendChild(tbody2);
      }
     #### 로그인한 사람만 답글을 작성할 수 있는 코드
       if(loginUser != null){
           str += `<tr id="replyReply">`+
                       `<td class="replyName">`+ loginUser.userName + `</td>`+
                      `<td class="replyContent" colspan="2"><input type="text" class="inputReplyInput" placeholder="댓글을 입력해주세요."></td>`+
                      `<td></td>`+
                       `<td colspan="3"><button class="btnInsert" onclick="addReply()">등록하기</button></td>`+
                   `</tr>`;
       }
  
       document.querySelector(".all-content-reply").innerHTML += str;
  }
  
  
  
  #### 답글 등록을 위해 ajax로 값을 넘겨주는 코드
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
  
  
  #### 답글 삭제를 위해 ajax로 값을 넘겨주는 코드
  delReplyRE = (replyReplyNo, replyNo) => {
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

 #### 답글 여는 코드
  function replyFunc(replyNo,i){
      let replyButton = document.querySelector("#replyReply"+i);
      if(replyButton.style.display === 'none' || replyButton.style.display === ''){
          replyButton.style.display = 'table-row';
          data = {
              replyNo
          }
          showReplyReply(data,i)
      } else {
          replyButton.style.display ='none';
          const listArr = document.querySelectorAll(".tbody"+i+ " .reply-content-list-te")
          for(let i = 0; i< listArr.length; i++){
              listArr[i].remove()
          }
      } 
  }

  showReplyReply = (data,i) => {
      replyReviewDetailController.selectReplyReplyAjax(data,i,drewReplyRe)
  }
  
  
  #### 답글을 그려주는 코드
  drewReplyRe = (result,i) =>{
      document.querySelector(".inputReply"+i).innerHTML = "";
      $(".reply-item" + i).remove();
  
      if(result.list ==="fail"){
          alert("답글 등록실패");
          return;
      }
      const list = result.list;
      const loginNo = result.loginUser;
      const tr = document.querySelector(".inputReply"+i).parentNode.parentNode;
      const listArr = document.querySelectorAll(".reply-content-list-te")
      for(let i = 0; i<listArr.length; i++){
          listArr[i].remove()
      }
      
  
      for(let j=0; j<list.length; j++){
          const rereplyTr = document.createElement("tr");
          rereplyTr.className = "reply-content-list-te reply-item" + j;
  
          rereplyTr.innerHTML =  `<td></td><td class="replyName">`+ list[j].userName +`</td>`+
                                 `<td class="replyContent">` + list[j].replyReplyContent + `</td>`+
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
  
 #### 답글 수정하는 코드
  drawUpdateReplyReply = (replyReplyNo,replyNo,j) =>{
      const replyReply =  document.querySelector(".reply-item"+j+" .replyContent")
      const replyReplyContent = replyReply.innerText;
      const textAreaDiv = document.createElement("input");
      textAreaDiv.className = "replyReplyTextArea input" + j
      textAreaDiv.value = replyReplyContent;
      const replyReplyBtn = document.createElement("button");
      replyReplyBtn.className = "replyReplyBtn"
      replyReplyBtn.textContent = "수정하기"
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
  

```
## 기상청 공공데이터
 #### 오늘날짜로부터 3일동안의 날씨정보를 그려주는 코드
```
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
```
 #### 오늘날짜로부터 3일~7일의 날씨정보를 그려주는 코드
 ```
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
```
 #### 날씨 예외처리
```
drawWeatherError = () =>{
    document.querySelector("#weatherBody").innerHTML = `<p>날씨를 제공하는 지역이 아닙니다.</p>`;
}
 

