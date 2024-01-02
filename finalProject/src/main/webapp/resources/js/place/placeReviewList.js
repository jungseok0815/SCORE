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
    loadReviewList(data, drawReviewList)
}

reLoadReviewList = (num) =>{
    reviewValue.cpage = num
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
    loadReviewList(data,drawReviewList)
}


drawReviewList = (result) =>{
    console.log(result);
    const pi = result.pi;
    console.log(pi)
    let str = "";
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
                break;
            default :
                star = ''
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

    // 페이징 바 그려주기
let str2 = "";
    
        if(pi.currentPage == 1){
            str2 += '<li class="page-item disabled"><a class="page-link">이전</a></li>'
        } else {
            str2 += '<li class="page-item"><button class="page-link" onclick="reLoadReviewList(' + (pi.currentPage - 1 ) + ')">이전</button></li>'
        }

        for (let i = pi.startPage; i <= pi.endPage; i++) {
            str2 += '<li class="page-item"><button class="page-link" onclick="reLoadReviewList('+ i +')">' + i + '</button></li>'
        }

        if(pi.currentPage != pi.maxPage){
            str2 += '<li class="page-item"><button class="page-link" onclick="reLoadReviewList('+ (pi.currentPage + 1) +')">다음</button></li>'
        } else {
            str2 += '<li class="page-item disabled"><a class="page-link">다음</a></li>'
        } 

    document.querySelector("#pagingArea ul").innerHTML = str2;
    document.querySelector(".review-list").innerHTML = str;
    
}