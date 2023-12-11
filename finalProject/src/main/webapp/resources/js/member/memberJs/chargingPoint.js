function charging(){
    
    const checkbox = document.querySelector('#checkbox');

    if(!checkbox.checked){
        alert("결제 서비스 이용 약관, 개인정보 처리 동의를 해주세요")
    } else {
        document.querySelector("#pointForm").submit();
    }
}
