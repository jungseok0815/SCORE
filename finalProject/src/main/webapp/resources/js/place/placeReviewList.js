
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

function selectSports(event){
    location.href="ReviewListAjax.pl"
    event.target.value
}


searchKeyword = (event) => {
    let src = document.querySelector('#search1').value

    if(event.keyCode == 13 || !window.event.keyCode){
        console.log(src);

    }
}
