init = () => {
    
    $(document).ready(function () {
        $('input.timepicker').timepicker({
            timeFormat: 'HH:mm',
            interval: 30,
            startTime: '00:00',
            dynamic: false,
            dropdown: true,
            scrollbar: true
        });
    });
        
}

loadImg = (inputFile,num) => {

    if(inputFile.files.length == 1){ 
        const reader = new FileReader();
        reader.readAsDataURL(inputFile.files[0]);
        reader.onload = function(ev){
            switch(num){
                case 1: document.getElementById('file-img1').src = ev.target.result; break;
                case 2: document.getElementById('file-img2').src = ev.target.result; break;
                case 3: document.getElementById('file-img3').src = ev.target.result; break;
                case 4: document.getElementById('file-img4').src = ev.target.result;  
            }
            
        }
    } else {
        switch(num){
            case 1: document.getElementById('file-img1').src = null; break;
            case 2: document.getElementById('file-img2').src = null; break;
            case 3: document.getElementById('file-img3').src = null; break;
            case 4: document.getElementById('file-img4').src = null;  
        }  
    }
}

changeSportSelect = () => {
            
    const select = document.querySelector("#sport").value;
    if(select === '2'){
        const drawMatchBs = document.querySelector("#match-type");
        drawMatchBs.innerHTML = "";
        drawMatchBs.innerHTML = "<option value='팀 매치'>팀 매치</option>"+
                                "<option value='용병 매치'>용병 매치</option>"
                                

        const drawShoesBs = document.querySelector("#shoes");
        drawShoesBs.innerHTML = "";
        drawShoesBs.innerHTML = "<option value='상관없음'>상관없음</option>"+
                                "<option value='야구화/스파이크'>야구화/스파이크</option>"
                                

    }else if (select === '3') {
        const drawMatchBk = document.querySelector("#match-type");
        drawMatchBk.innerHTML = "";
        drawMatchBk.innerHTML = "<option value='5vs5'>5vs5</option>"+
                                "<option value='3vs3'>3vs3</option>"
                                

        const drawShoesBk = document.querySelector("#shoes");
        drawShoesBk.innerHTML = "";
        drawShoesBk.innerHTML = "<option value='상관없음'>상관없음</option>"+
                                "<option value='농구화'>농구화</option>"
                                
    }else {
        const drawMatchFt = document.querySelector("#match-type");
        drawMatchFt.innerHTML = "";
        drawMatchFt.innerHTML = "<option value='6vs6 3파전'>6vs6 3파전</option>"+
                                "<option value='5vs5 3파전'>5vs5 3파전</option>"
        const drawShoesFt = document.querySelector("#shoes");
        drawShoesFt.innerHTML = "";
        drawShoesFt.innerHTML = "<option value='상관없음'>상관없음</option>"+
                                "<option value='풋살화/운동화'>풋살화/운동화</option>"
                                
    }
}
function clickImg(num){
    $("#fileImgFile" + num).click();
}
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
            
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById("sample6_address").value = addr;
        }
    }).open();
}