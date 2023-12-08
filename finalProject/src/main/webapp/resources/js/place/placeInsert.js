init = () => {
    
    $('.timepicker').timepicker({
            timeFormat: 'HH:mm',
            interval: 30,
            startTime: '00:00',
            dynamic: false,
            dropdown: true,
            scrollbar: true
        });
        
}

changeSportSelect = () => {
            
    const select = document.querySelector("#sport").value;
    if(select === '2'){
        const drawMatchBs = document.querySelector("#match-type");
        drawMatchBs.innerHTML = "";
        drawMatchBs.innerHTML = "<option>매치선택</option>"+
                                "<option value='용병 매치'>용병 매치</option>"+
                                "<option value='팀 매치'>팀 매치</option>"

        const drawShoesBs = document.querySelector("#shoes");
        drawShoesBs.innerHTML = "";
        drawShoesBs.innerHTML = "<option>신발정보</option>"+
                                "<option value='야구화/스파이크'>야구화/스파이크</option>"+
                                "<option value='상관없음'>상관없음</option>"

    }else if (select === '3') {
        const drawMatchBk = document.querySelector("#match-type");
        drawMatchBk.innerHTML = "";
        drawMatchBk.innerHTML = "<option>매치선택</option>"+
                                "<option value='3vs3'>3vs3</option>"+
                                "<option value='5vs5'>5vs5</option>"

        const drawShoesBk = document.querySelector("#shoes");
        drawShoesBk.innerHTML = "";
        drawShoesBk.innerHTML = "<option>신발정보</option>"+
                                "<option value='농구화'>농구화</option>"+
                                "<option value='상관없음'>상관없음</option>"
    }else {
        const drawMatchFt = document.querySelector("#match-type");
        drawMatchFt.innerHTML = "";
        drawMatchFt.innerHTML = "<option>매치선택</option>"+
                                "<option value='6vs6 3파전'>6vs6 3파전</option>"+
                                "<option value='5vs5 3파전'>5vs5 3파전</option>"

        const drawShoesFt = document.querySelector("#shoes");
        drawShoesFt.innerHTML = "";
        drawShoesFt.innerHTML = "<option>신발정보</option>"+
                                "<option value='풋살화/운동화'>풋살화/운동화</option>"+
                                "<option value='상관없음'>상관없음</option>"
    }
}