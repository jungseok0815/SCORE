<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/final/resources/css/place/placeReviewDetail.css">
    <script src="resources/js/place/placeReviewDetail.js"></script>
    <script src="resources/js/place/placeAjax/placeAjax.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f9c9e0c47ddbb3c0c58f465de9e58e1a&libraries=services"></script>
    <title>Document</title>
</head>
<body onload="selectReply('${pr.reviewNo}', '${pr.fieldNo}')">
    <jsp:include page="../common/header.jsp" /> 

    <div class="allContent">
        <div class="content-header">
            <div class="contentWrap">
                <c:forEach var="item" items="${reImgList}">
                    <div class="content-img">
                        <img src="${item.reviewChangeName}" class="imgStadium">
                    </div>
                </c:forEach>
            </div>
            <div id="mapImage"></div>

            <div class="contentWrap-info">
                <div class="stadium-info">
                    <p class="stadium-name">${pr.fieldName}</p>
                    <span id="stadium-address">${pr.fieldArea}</span>
                    <a class="address-copy" onclick="copyAddress()">주소 복사</a>
                    <a class="address-map" onclick="drawMapClick(`${pr.fieldArea}`)">지도 보기</a>
                    <div class="star-rating">
                        <c:choose>
                            <c:when test="${pr.starRating eq 1}">
                                ★
                            </c:when>
                            <c:when test="${pr.starRating eq 2}">
                                ★★
                            </c:when>
                            <c:when test="${pr.starRating eq 3}">
                                ★★★
                            </c:when>
                            <c:when test="${pr.starRating eq 4}">
                                ★★★★
                            </c:when>
                            <c:when test="${pr.starRating eq 5}">
                                ★★★★★
                            </c:when>
                        </c:choose>
                    </div>
                    <div class="content-box" style="margin-top: 15px;font-size: 20px;">
                        ${pr.reviewContent}
                    </div>
                    <div class="review-count">
                        조회수 ${pr.reviewCount}
                    </div>
                </div>
            </div>
            <div class="replyLocal">
                <table>
                    <thead>
                        <tr class="replyDiv">
                            <td class="replySpan">댓글(<span id="rcount">0</span>)</td>
                        </tr>
                    </thead>
                    <tbody class="replyTbody">
                    </tbody>
                </table>  
            </div>
        </div>
    </div>

    <jsp:include page="../common/footer.jsp" />
</body>
</html>