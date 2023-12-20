<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/place/placeReviewList.css">
<script type="text/javascript" src="./resources/js/place/placeReviewList.js"></script>

</head>
<body>
    <jsp:include page="../common/header.jsp" />

    <div class="outer">
        <div class="wrapper">
            <h3 align="center" style="color: #0a7ffb;">경기장 리뷰</h3>
            <div class="select-view" style= "float: left; margin-bottom: 5px;">
                <select name=" " id="">
                    <option value="">전체종목</option>
                    <option>축구</option>
                    <option>야구</option>
                    <option>농구</option>
                </select>
            </div>
            <div class="select-view" style= "float: right; margin-bottom: 5px;">
                <select name=" " id="">
                    <option value="">지역</option>
                    <option>서울</option>
                    <option>경상</option>
                    <option>대구</option>
                    <option>대전</option>
                    <option>경기</option>
                    <option>광주</option>
                    <option>부산</option>
                    <option>충청</option>
                    <option>인천</option>
                    <option>전라</option>
                    <option>울산</option>
                    <option>세종</option>
                    <option>강원</option>
                    <option>제주</option>
                </select>
            </div>

            <table align="center" class="list-area">      
                <thead style="border-bottom: 1px solid #ddd; border-top: 1px solid #ddd;">
                    <tr id="table-head">
                        <th width="70">지역</th>
                        <th width="300">구장 이름</th>
                        <th width="100">작성자</th>
                        <th width="50">조회수</th>
                        <th width="130">작성일</th>
                        <th width="130">별점</th>
                    </tr>
                </thead>
                <tbody>
                    <tr onclick="">
                        <td>부산</td>
                        <td class="review-name">구덕운동장</td>
                        <td>금남식</td>
                        <td>40</a></td>
                        <td>2023-12-19</td>
                        <td class="star-rating">★★★</td>
                    </tr>
                    <tr onclick="">
                        <td>경남</td>
                        <td class="review-name">엔씨파크</td>
                        <td>윤구진</td>
                        <td>70</a></td>
                        <td>2023-12-18</td>
                        <td class="star-rating">★★★★★</td>
                    </tr>
                    <tr onclick="">
                        <td>서울</td>
                        <td class="review-name">성남고등학교 대운동장</td>
                        <td>임두현</td>
                        <td>111</a></td>
                        <td>2023-12-17</td>
                        <td class="star-rating">★</td>
                    </tr>
                    <tr onclick="">
                        <td>부산</td>
                        <td class="review-name">구덕운동장</td>
                        <td>금남식</td>
                        <td>40</a></td>
                        <td>2023-12-19</td>
                        <td class="star-rating">★★★</td>
                    </tr>
                    <tr onclick="">
                        <td>경남</td>
                        <td class="review-name">엔씨파크</td>
                        <td>윤구진</td>
                        <td>70</a></td>
                        <td>2023-12-18</td>
                        <td class="star-rating">★★★★★</td>
                    </tr>
                    <tr onclick="">
                        <td>서울</td>
                        <td class="review-name">성남고등학교 대운동장</td>
                        <td>임두현</td>
                        <td>111</a></td>
                        <td>2023-12-17</td>
                        <td class="star-rating">★</td>
                    </tr>
                </tbody>
            </table>
            <div id="enroll-btn">
                    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        리뷰작성
                    </button>
            </div>
        </div>
        
        <div  class="search-bar" align="center">
            <input id="search" type="text" onfocus="" onkeyup="" placeholder="구장 검색">
            <button><img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"></button>
        </div>

        <div class="paging-area" align="center">
            <c:if test="${ pi.currentPage ne 1 }">
                <button class="btn btn-light" onclick="location.href=''">&lt;</button>
            </c:if>

            <c:forEach var="p" begin="${pi.startPage}" end="${ pi.endPage }" >
                <button class="btn btn-light" onclick="location.href=''">${p}</button>
            </c:forEach>
            <c:if test="${ pi.currentPage ne pi.maxPage }">
                <button class="btn btn-light" onclick="location.href=''">&gt;</button>
            </c:if>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">리뷰 작성</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="mb-3" name="myform" id="myform" method="post">
                    <div class="star-area">
                        <p>별점</p>
                        <fieldset class="rate">
                            <input type="radio" id="rating10" name="rating" value="10"><label for="rating10" title="5점"></label>
                            <input type="radio" id="rating9" name="rating" value="9"><label class="half" for="rating9" title="4.5점"></label>
                            <input type="radio" id="rating8" name="rating" value="8"><label for="rating8" title="4점"></label>
                            <input type="radio" id="rating7" name="rating" value="7"><label class="half" for="rating7" title="3.5점"></label>
                            <input type="radio" id="rating6" name="rating" value="6"><label for="rating6" title="3점"></label>
                            <input type="radio" id="rating5" name="rating" value="5"><label class="half" for="rating5" title="2.5점"></label>
                            <input type="radio" id="rating4" name="rating" value="4"><label for="rating4" title="2점"></label>
                            <input type="radio" id="rating3" name="rating" value="3"><label class="half" for="rating3" title="1.5점"></label>
                            <input type="radio" id="rating2" name="rating" value="2"><label for="rating2" title="1점"></label>
                            <input type="radio" id="rating1" name="rating" value="1"><label class="half" for="rating1" title="0.5점"></label>
                        </fieldset>
                    </div>
                    <div class="modal-middle" style="margin-bottom: 5px;">
                        <div style="display: flex;">
                            <select name=" " id="">
                                <option value="">종목</option>
                                <option>축구</option>
                                <option>야구</option>
                                <option>농구</option>
                            </select>
                            <select name=" " id="">
                                <option value="">지역</option>
                                <option>서울</option>
                                <option>경상</option>
                                <option>대구</option>
                                <option>대전</option>
                                <option>경기</option>
                                <option>광주</option>
                                <option>부산</option>
                                <option>충청</option>
                                <option>인천</option>
                                <option>전라</option>
                                <option>울산</option>
                                <option>세종</option>
                                <option>강원</option>
                                <option>제주</option>
                            </select>
                        </div>
                        <div style="width: 100%">
                            <input type="text" placeholder="경기장 이름" style="width: 100%">
                        </div>
                    </div>
                    <tr>
                        <td style="margin-bottom: -10px;" colspan="2">
                            <p>↓아래 상자를 클릭해 사진을 등록해주세요</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="filebox">
                                <label class="btn-upload" for="fileImgFile">
                                    <img src="" id="file-img" onclick="">
                                </label>
                                <input type="file" name="upfile" id="fileImgFile" onchange="imgChangeUpdate(this)" required>
                            </div>
                        </td>
                    </tr>
                    <div>
                        <textarea class="col-auto form-control" type="text" id="reviewContents"
                                  placeholder="경기장 이용 후 느낀점을 적어주세요!"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary">등록</button>
            </div>
        </div>
        </div>
    </div>

    

    <jsp:include page="../common/footer.jsp" />
</body>
</html>