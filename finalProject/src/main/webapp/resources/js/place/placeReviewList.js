function imgChangeUpdate(file){
    if(file.files.length == 1){
        const reader = new FileReader();

        reader.readAsDataURL(file.files[0]);

        reader.onload = function(ev){
            document.getElementById('fileImgFile').src = ev.target.result;
        }
    } else {
        document.getElementById('fileImgFile').src = null;
    }
}