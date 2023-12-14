function loadImg(inputFile){
    console.log(inputFile)
 

    if(inputFile.files.length == 1) { // 파일이 선택된 경우 => 미리보기 나타나게

        const reader = new FileReader();

        reader.readAsDataURL(inputFile.files[0]);

        reader.onload = function(ev){          
            //ev.target.result => 읽어들인 파일의 고유한 url
            document.getElementById('title-img').src = ev.target.result;
        }

    } else { // 선택된 파일이 취소된 경우 => 미리보기 사라지게
        document.getElementById('title-img').src = null;
    }
}

function chooseFile(){
    $("#file").click();
}