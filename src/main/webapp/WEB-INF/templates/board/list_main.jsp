<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='질문과답변' />
<c:url var="homeUrl" value="/" />
<c:url var="logoUrl" value="/images/ball.png" />
<c:url var="writeUrl" value="/board/write/${board.BId}" />


<div class="page-container">
<body>
<table class="notice-table">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>날짜</th>
        <th>조회</th>
    </tr>
    <c:forEach var="item" begin="1" end="10">
        <tr>
            <td>${item}</td>
            <td>제목 ${item}</td>
            <td>내용 ${item}</td>
            <td>user ${item}</td>
            <td><fmt:formatDate type="date" value="${date}" pattern="yyyy.MM.dd" dateStyle="short" timeStyle="short"/></td>
            <td>${item+100}</td>
        </tr>
    </c:forEach>
</table>
        <br>
        <table>
            <tr>
                <td><button class="write-btn" type="button" onclick="location.href='${writeUrl}'">글쓰기</button></td>
            </tr>
        </table>
    </body>
</div>
