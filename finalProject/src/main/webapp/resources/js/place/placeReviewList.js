const reviewValue ={
    categoryNum: 4,
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
        categoryNum : reviewValue.categoryNum
    }
    loadTeam(data,drawReviewList)
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

drawReviewList = (result) =>{
    console.log(result)
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
        }
        str += `<tr onclick="">`+
                    `<td>`+p.userName+`</td>`+
                        `<td class="review-name">`+p.fieldName+`</td>`+
                        `<td>`+p.reviewCount+`</a></td>`+
                        `<td>`+p.reviewEnrollDate+`</td>`+
                        `<td class="star-rating">`+
                        star+
                    `</td>`+
                `</tr>`;
    }
    document.querySelector(".review-list").innerHTML = str;
}