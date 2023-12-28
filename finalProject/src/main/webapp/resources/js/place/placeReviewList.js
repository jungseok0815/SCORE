const reviewValue ={
    categoryNum: 4,
    cpage: 1,
}

function imgChangeUpdate(file){
    if(file.files.length == 1){
        const reader = new FileReader();

        reader.readAsDataURL(file.files[0]);

        reader.onload = function(ev){
            document.getElementById('file-img').src = ev.target.result;
        }
    } else {
        document.getElementById('file-img').src = null;
    }
}


searchKeyword = (event) => {
    let condition = document.getElementById("condition").value;
    let keyword = document.querySelector('#search-input').value;

    data = {
        condition: condition,
        keyword: keyword
    };

    searchAjax(data, drawReviewList);
    
};

init = () =>{
    data={
        categoryNum : reviewValue.categoryNum,
        cpage : reviewValue.cpage
    }
    selectReviewList(data)
}
selectReviewList = (data) =>{
    loadTeam(data,drawReviewList)
}
rrrr =(rkqqt) =>{
    reviewValue.cpage = rkqqt
    data={
        categoryNum : reviewValue.categoryNum,
        cpage : reviewValue.cpage
    }
    selectReviewList(data)
}

changeSports = () =>{
    let categoryNum = document.getElementById("categoryNumBox")
    let categoryNumValue = (categoryNum.options[categoryNumBox.selectedIndex].value)
    reviewValue.categoryNum = categoryNumValue
        data={
            categoryNum : reviewValue.categoryNum
            
        }
    loadTeam(data,drawReviewList)
}

function handleClickPageNum(num){
    reviewValue.cpage = num
    handleClickPage()
}

drawReviewList = (result) =>{
    const pi = result.model.pi;
    console.log(pi)
    let str = "";
    let str2 = "";
    for(let i in result.pList){
        let p = result.pList[i]
        console.log(p)
        let star;
        switch(p.starRating){
            case 1 :
                star = `★`
                break;
            case 2 :
                star = `★★`
                break;
            case 3 :
                star = `★★★`
                break;
            case 4 :
                star = `★★★★`
                break;
            case 5 :
                star = `★★★★★`
        }
        str += `<tr onclick="location.href = 'placeReviewDetail.pl?fno=${p.fieldNo}&rno=${p.reviewNo}';">`+
                    `<td>`+p.userName+`</td>`+
                        `<td class="review-name">`+p.fieldName+`</td>`+
                        `<td>`+p.reviewCount+`</a></td>`+
                        `<td>`+p.reviewEnrollDate+`</td>`+
                        `<td class="star-rating">`+
                        star+
                    `</td>`+
                `</tr>`;
    }

    if(pi.currentPage != 1){
        str2 += `<button class="btn btn-light" onclick="handleClickPageNum(`+(pi.currentPage -1)+`)">&lt;</button>`
    }

    for(let j=1; j<=pi.maxPage; j++){
        str2 += `<button class="btn btn-light" onclick="handleClickPageNum(`+j+`)">`+j+`</button>`
    }
    if(pi.currentPage != pi.maxPage){
        str2 += `<button class="btn btn-light" onclick="handleClickPageNum(`+(pi.currentPage +1)+`)">&gt;</button>`
    }

    document.querySelector(".review-list").innerHTML = str;
    document.querySelector('.paging-area').innerHTML = str2;
}