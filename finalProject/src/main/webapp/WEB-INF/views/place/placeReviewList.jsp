<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="/final/resources/css/place/placeReviewList.css">
<script type="text/javascript" src="./resources/js/place/placeReviewList.js"></script>
<script type="text/javascript" src="./resources/js/place/placeAjax/placeReviewAjax.js"></script>
</head>
<body onload="init()">
    <jsp:include page="../common/header.jsp" />

    <div class="outer">
        <div class="wrapper">
            <h3 align="center" style="color: #0a7ffb;">경기장 리뷰</h3>
            <div class="select-view" style= "float: left; margin-bottom: 5px;">
                <select name="categoryNum" id="categoryNumBox" onchange="changeSports()">
                    <option value="4">전체종목</option>
                    <option value="1">축구</option>
                    <option value="2">야구</option>
                    <option value="3">농구</option>
                </select>
            </div>

            <table align="center" class="list-area">      
                <thead style="border-bottom: 1px solid #ddd; border-top: 1px solid #ddd;">
                    <tr id="table-head">
                        <th width="100">작성자</th>
                        <th width="300">구장 이름</th>
                        <th width="50">조회수</th>
                        <th width="130">작성일</th>
                        <th width="130">별점</th>
                    </tr>
                </thead>

                <!-- 리뷰 리스트 ajax불러오는 곳 -->
                <tbody class="review-list">
                </tbody>
            </table>
            <div id="enroll-btn">
                <c:if test="${loginUser.userLevel eq 1 or loginUser.userLevel eq 2}">
                    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        리뷰작성
                    </button>
				</c:if>
            </div>
        </div>
        
        
        <div class="search-bar" align="center">
            <input type="hidden" name="cpage" value="1">
            <select name="condition" class="pl" id="condition">
                <option value="writer">작성자</option>
                <option value="title">구장이름</option>
                <option value="content">내용</option>
            </select>
            <input id="search-input" type="text" placeholder="검색" name="keyword" value="${ keyword }">
            <button type="button" onclick="searchKeyword(event)"><img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" ></button>  
        </div>
      

        <div id="pagingArea">
            <ul class="pagination">
               <c:choose>
                  <c:when test = "${pi.currentPage ne 1 }">
                     <li class="page-item disabled"><a class="page-link" href="#">이전</a></li>
                  </c:when>
                  <c:otherwise>
                     <li class="page-item"><a class="page-link" href="placeReviewList.pl?userNo=${loginUser.userNo}&cpage=${pi.currentPage - 1 }">이전</a></li>
                  </c:otherwise>
               </c:choose>
                  
                <c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage }" >
                     <li class="page-item"><a class="page-link" href="placeReviewList.pl?userNo=${loginUser.userNo}&cpage=${p}">${p}</a></li>
                </c:forEach>
            
                <c:choose>
                  <c:when test = "${pi.currentPage eq pi.maxPage }">
                        <li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
                  </c:when>
                  <c:otherwise>
                     <li class="page-item"><a class="page-link" href="placeReviewList.pl?userNo=${loginUser.userNo}&cpage=${pi.currentPage + 1 }">다음</a></li>
                  </c:otherwise>
               </c:choose>
            </ul>
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
                <form class="mb-3" action="insertReview.pl" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="userNo" value="${loginUser.userNo}">
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
                        <div style="width: 100%;">
                            <select name="fieldNo" id="" style="width: 100%;">
                                <c:forEach var="item" items="${rList}">
                                    <option value="${item.fieldNo}">${item.fieldName}</option>
                                </c:forEach>
                            </select>
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
                                <label class="btn-upload" for="file">
                                    <img src="" id="file-img" onclick="">
                                </label>
                                <input type="file" name="upfile" id="file" onchange="imgChangeUpdate(this)" required>
                            </div>
                        </td>
                    </tr>
                    <div>
                        <textarea name="reviewContent" class="col-auto form-control" type="text" id="reviewContent"
                                  placeholder="경기장 이용 후 느낀점을 적어주세요!"></textarea>
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