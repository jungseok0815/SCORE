<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous">
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/5b03f739e9.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/final/resources/css/common/header.css">



</head>
<body>
    <div class="header-body">
        <div class="header">
            <div class="header-left">
                <img class="hambuger-img" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_hamburger.svg" />
                <a href="${pageContext.request.contextPath}" class="header-name">SCORE</a>
            </div>
            <div class="header-right">
                <div class="search-bar">
                    <input type="text" placeholder="검색어 입력">
                    <button><img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"></button>
                </div>
                <div class ="search-bar-icon">
                    <a href=""><img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_mymatch.svg" alt="" class="header-img"></a>
                    <a href="${pageContext.request.contextPath}/loginView.me"><img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_my.svg" alt="" class="header-img"></a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>