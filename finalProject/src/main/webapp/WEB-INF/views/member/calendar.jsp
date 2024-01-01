<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.10/index.global.min.js'></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="resources/js/member/memberJs/calendar.js"></script>
    <link rel="stylesheet" href="/final/resources/css/member/calendar.css" >
    <script src="resources/js/member/memberAjax/memberAjax.js?ver=5"></script>
  </head>
  <body onload='calendarInit(`${list}`,`${pageContext.request.contextPath}`)'>
    <jsp:include page="../common/header.jsp"/>
    <div>
        <div class="calendar-body">
            <div id='calendar' class="calendar-body-left"></div>
            <div style="width: 40px;"></div>
            <div class="calendar-body-right">
                
            </div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp" />
  </body>
</html>