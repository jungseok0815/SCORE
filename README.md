# SCORE
> 축구, 농구, 야구를 하는 사람들이 보다 편하게 경기에 참여하고 즐기위한 서비스

## 프로젝트 개요
- 개발 기간: 2023-12-01 ~ 2024-01-04
- 본 프로젝트의 구조를 더 자세히 알고 싶다면?
  - [백엔드 README](./BACK.md)
  - [프론트엔드 README](./FRONT.md)

## 기술 스택
`Front-End` :  <img src="https://img.shields.io/badge/javascript-3178C6?style=flat-square&logo=javascript&logoColor=#F7DF1E"/>
<img src="https://img.shields.io/badge/css3-3178C6?style=flat-square&logo=css3&logoColor=#1572B6"/>
<img src="https://img.shields.io/badge/html5-3178C6?style=flat-square&logo=html5&logoColor=#E34F26"/>
<img src="https://img.shields.io/badge/jquery-FF4154?style=flat-square&logo=jquery&logoColor=##0769AD"/>

`Back-end`<img src="https://img.shields.io/badge/spring-E0234E?style=flat-square&logo=spring&logoColor=#6DB33F">
<img src="https://img.shields.io/badge/springsecurity-3178C6?style=flat-square&logo=springsecurity&logoColor=#6DB33F"/>
<img src="https://img.shields.io/badge/oracle-4479A1?style=flat-square&logo=oracle&logoColor=#F80000">
<img src="https://img.shields.io/badge/apachetomcat-FF4154?style=flat-square&logo=apachetomcat&logoColor=#F8DC75">

`Communication`
<img src="https://img.shields.io/badge/notion-000000?style=flat-square&logo=notion&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=flat-square&logo=github&logoColor=white">

## 프로젝트 구조

## 사용 라이브러리및 API
- 카카오페이 API
- 카카오지도 API
- COOLSMS 문자인증 API
- 다음 주소 API
- 카카오톡 공유 API
- 기상청 날씨 정보 API

## 실행 방법

1. 프로젝트 레포지토리를 클론합니다.

```sh
$ git clone https://github.com/jungseok0815/FinalProject.git
```

2. 프로젝트 실행에 필요한 패키지를 설치합니다.

```sh
$ cd front
$ npm i

$ cd back
$ npm i
```

3. development server을 실행합니다.
```sh
$ npm run dev
# or
$ yarn dev
```

## 주요 기능

### ✏ 축구, 농구, 야구를 하는 사람들이 보다 편하게 경기에 참여하고 즐길수 있어요. 
  <img src="http://localhost:8088/final" height="300">
  <img src="" height="300">
  <img src="" height="300">
  <img src="" height="300">

+ 마이페이지
  + 유저 코드를 입력하여 친구 요청
  + 알림을 통해 친구 요청을 수락하거나 거절
  + 수락 시 공용 일기장 생성
  + 일기장 이름 수정 가능

+ 교환일기
  + 월 별 일기 기록 제공
  + 정확한 감정 분석을 위해 일기 작성은 당일 한 번만 가능 (수정 및 삭제 불가능)
  + 일기 작성 시 자동으로 감정을 분석
  + 일기 작성 당일 자정이 지나는 시점에 기분 전환할 수 있는 활동을 추천
+ 홈
  + 분석된 감정 기록을 캘린더 형태로 제공 (나 & 상대방)

### 📌 추천받은 활동을 포함한 사용자의 일정을 **투두 리스트**로 관리할 수 있어요.   
  <img src="" height="300">
  <img src="" height="300">

+ 일정 관리
  + 추천받은 활동은 자동으로 투두 리스트에 추가
  + 사용자가 직접 투두 리스트 생성, 수정, 삭제 가능
  + 월 별로 일정을 보여 줌
  + 완료 표시 가능

### ⚙ 내 정보를 간편하게 관리할 수 있어요.
  <img src="/" height="300">
  <img src="/" height="300">
  
+ 마이페이지
  + 닉네임, 비밀번호, 일기장 이름 수정 가능
  + 최적화된 활동 추천을 위한 관심 분야 설정 가능
  + 연결 끊기, 회원 탈퇴 가능

## 부가 기능

* 소셜 로그인 (카카오)
* 반응형 웹 디자인
* react-error-boundary 사용하여 폴백 UI로 에러 화면 구성
* 전역 style 정의하여 라이트/다크 모드 구현

## 팀원 소개

| 이름 | 포지션 | Contact |
| --- | --- | --- |
| 최지원 | AI | a1@gmail.com |
| 최지투 | BE | a1@gmail.com |
| 최지삼 | FE | a1@gmail.com |
| 최지사 | FE | a1@gmail.com |
| 최지오 | FE | a1@gmail.com |
