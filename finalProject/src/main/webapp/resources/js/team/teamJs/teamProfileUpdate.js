loadImg = (inputFile) => {

    if(inputFile.files.length == 1){ 
        const reader = new FileReader();
        reader.readAsDataURL(inputFile.files[0]);
        reader.onload = function(ev){
            document.getElementById('update-file').src = ev.target.result;
        }
    } else {
        document.getElementById('update-file').src = null;   
    }
}