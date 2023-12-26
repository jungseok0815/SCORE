kakaoPay =() =>{

    const checkbox = document.querySelector('#checkbox');

    if(!checkbox.checked){
        alert("결제 서비스 이용 약관, 개인정보 처리 동의를 해주세요")

        kakaoButton.disabled = true;
    } 


    const value = document.querySelectorAll('input[name="point"]');
    let money;

    for(let i = 0; i < value.length; i++){
        if(value[i].checked === true){
            money = value[i].value
        }
    }
    console.log(money)

    data = {
        point : money
    }

    kakaoAjaxController.kakaoMoney(data,drawKaKaoPay)
}

drawKaKaoPay = (result) => {
    console.log(result);

    var box = result.next_redirect_pc_url;
    // window.open(box);
    location.href = box;
}


payment = () => {

    var accountRadio = document.getElementById("account");
    var cardRadio = document.getElementById("card");
    var kakaoRadio = document.getElementById("kakao");
    var btnCard = document.getElementById("btn-card");
    var btnKaKao = document.getElementById("btn-KaKao");

    if (kakaoRadio.checked) {
        btnCard.style.display = "none"; // 충전 버튼 숨기기
        btnKaKao.style.display = "block"; // 카카오페이 버튼 보이기
    } else {
        btnCard.style.display = "block"; // 충전 버튼 보이기
        btnKaKao.style.display = "none"; // 카카오페이 버튼 숨기기
    }

}
