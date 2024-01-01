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
                    <div class="content-box" style="margin-top: 15px;font-size: 20px; margin-left: 15px">
                        ${pr.reviewContent}
                    </div>
                    <div class="review-count">
                        조회수 ${pr.reviewCount}
                    </div>
                </div>
                <div class="btn-area">
                    <c:if test="${pr.userNo eq loginUser.userNo}">
                        <!-- 로그인이 안 되어 있을 때와 자기가 쓴 글이 아니면 안보이게 -->
                        <button id="modify-btn" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">수정</button>
                        <button id="delete-btn" onclick="deleteReview(`${pr.reviewNo}`)" type="button" class="btn btn-danger">삭제</button>
                    </c:if>
                </div>
            </div>

            <div class="replyLocal">
                <table class="dbstnwls-qksema">
                  
                </table>  
            </div>
        </div>
    </div>

    <jsp:include page="../common/footer.jsp" />

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">리뷰 작성</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="mb-3" action="updateReview.pl" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="userNo" value="${loginUser.userNo}">
                    <input type="hidden" name="reviewNo" value="${pr.reviewNo}">
                    <div class="star-area">
                        <p>별점</p>
                        <fieldset class="rate">
                            <input type="radio" id="rating10" name="starRating" value="5"><label for="rating10" title="5점"></label>
                            <input type="radio" id="rating8" name="starRating" value="4"><label for="rating8" title="4점"></label>
                            <input type="radio" id="rating6" name="starRating" value="3"><label for="rating6" title="3점"></label>
                            <input type="radio" id="rating4" name="starRating" value="2"><label for="rating4" title="2점"></label>
                            <input type="radio" id="rating2" name="starRating" value="1"><label for="rating2" title="1점"></label>
                        </fieldset>
                    </div>
                    <div class="select-myPlace" style="margin-bottom: 5px;">
                        <div style="width: 100%; background-color:rgb(254, 253, 253); text-align: center; font-weight: 700;">
                            <div>
                                ${pr.fieldName}
                            </div>
                        </div>
                    </div>
                    <tr>
                        <td style="margin-bottom: -10px;" colspan="2">
                            <p>↓클릭 후 사진 변경</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="filebox">
                                <label class="btn-upload" for="file">
                                    <div class="btn-upload"><img src="${pr.reviewChangeName}"
                                            alt="" id="file-img"></div>
                                </label>
                                <input type="file" id="file" class="form-control-file border" name="reupfile"
                                    onchange="loadImg(this)">
                                <c:if test="${not empty pr.reviewOriginName}">
                                    <input type="hidden" name="reviewOriginName" value="${pr.reviewOriginName}" />
                                    <input type="hidden" name="reviewChangeName" value="${pr.reviewChangeName}" />
                                </c:if>
                            </div>
                        </td>
                    </tr>
                    <div>
                        <textarea name="reviewContent" class="col-auto form-control" type="text" id="reviewContent"
                                  placeholder="" style="margin-top: 5px;">${pr.reviewContent}</textarea>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                        <button type="submit" type="button" class="btn btn-primary" >등록</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>