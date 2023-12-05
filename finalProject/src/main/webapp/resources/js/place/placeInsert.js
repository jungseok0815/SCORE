changeSportSelect= () => {
            
    const select = document.querySelector("#sport").value;
    if(select === 'baseball'){
        const drawMatchBs = document.querySelector("#match-type");
        drawMatchBs.innerHTML = "";
        drawMatchBs.innerHTML = "<option>매치선택</option>"+
                                "<option value='baseball-match'>용병 매치</option>"+
                                "<option value='baseball-match'>팀 매치</option>"

        const drawShoesBs = document.querySelector("#shoes");
        drawShoesBs.innerHTML = "";
        drawShoesBs.innerHTML = "<option>신발정보</option>"+
                                "<option value='baseball-shoes'>야구화/스파이크</option>"+
                                "<option value='baseball-shoes'>상관없음</option>"

    }else if (select === 'basketball') {
        const drawMatchBk = document.querySelector("#match-type");
        drawMatchBk.innerHTML = "";
        drawMatchBk.innerHTML = "<option>매치선택</option>"+
                                "<option value='basketball-match'>3vs3</option>"+
                                "<option value='basketball-match'>5vs5</option>"

        const drawShoesBk = document.querySelector("#shoes");
        drawShoesBk.innerHTML = "";
        drawShoesBk.innerHTML = "<option>신발정보</option>"+
                                "<option value='basketball-shoes'>농구화</option>"+
                                "<option value='basketball-shoes'>상관없음</option>"
    }else {
        const drawMatchFt = document.querySelector("#match-type");
        drawMatchFt.innerHTML = "";
        drawMatchFt.innerHTML = "<option>매치선택</option>"+
                                "<option value='football-match'>6vs6 3파전</option>"+
                                "<option value='football-match'>5vs5 3파전</option>"

        const drawShoesFt = document.querySelector("#shoes");
        drawShoesFt.innerHTML = "";
        drawShoesFt.innerHTML = "<option>신발정보</option>"+
                                "<option value='football-shoes'>풋살화/운동화</option>"+
                                "<option value='football-shoes'>상관없음</option>"
    }
}